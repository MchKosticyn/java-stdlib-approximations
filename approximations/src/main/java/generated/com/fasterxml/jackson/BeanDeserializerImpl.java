package generated.com.fasterxml.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.BeanDeserializer;
import com.fasterxml.jackson.databind.deser.BeanDeserializerBase;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.std.ObjectArrayDeserializer;
import generated.org.springframework.boot.SpringApplicationImpl;
import generated.org.springframework.boot.SymbolicValueFactory;
import generated.org.springframework.boot.pinnedValues.PinnedValueSource;
import generated.org.springframework.boot.resolvers.ResolverUtils;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;

import java.io.IOException;
import java.io.Serial;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static generated.org.springframework.boot.pinnedValues.PinnedValueStorage.writePinnedValue;

@Approximate(BeanDeserializer.class)
public class BeanDeserializerImpl extends BeanDeserializer {

    @Serial
    private static final long serialVersionUID = 1L;

    protected BeanDeserializerImpl(BeanDeserializerBase src) {
        super(src);
    }

    public final static int MAX_DEPTH = 1;
    public final static int MAX_LENGTH = 1;

    private boolean isPrimitive(JavaType type) {
        return ResolverUtils.isPrimitiveOrWrapper(type.getRawClass());
    }

    private boolean isCollection(JavaType type) {
        return type.isArrayType() || type.isArrayType();
    }

    private void _writeToState(Object root) {
        writePinnedValue(PinnedValueSource.REQUEST_BODY, root);
    }

    public static boolean _concreteDeserialization() {
        // Returns false with JcApproximations inside interesting methods
        return true;
    }

    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException
    {
        if (_concreteDeserialization())
            return deserializeReal(p, ctxt);

        Class<?> clazz = _valueInstantiator.getValueClass();

        Object result;

        if (ResolverUtils.isPrimitiveOrWrapper(clazz)) {
            result = SymbolicValueFactory.createSymbolic(clazz, true);
            _writeToState(result);
            return result;
        }

        return deserializeFromObject(p, ctxt);
    }

    public List<Object> symbolicDeserialize(JsonParser p, DeserializationContext ctxt, int depth) throws IOException {
        if (depth > MAX_DEPTH)
            return Arrays.asList(null, null);

        Object bean = null;
        Object beanCopy = null;

        List<SettableBeanProperty> alreadySetProperties = new ArrayList<>();

        if (_valueInstantiator.canCreateUsingDefault()) {
            bean = _valueInstantiator.createUsingDefault(ctxt);
            beanCopy = _valueInstantiator.createUsingDefault(ctxt);
        }

        if (_valueInstantiator.canCreateFromObjectWith()) {
            Collection<SettableBeanProperty> properties = _propertyBasedCreator.properties();

            int propertyCount = properties.size();
            Object[] beanConstructorArguments = new Object[propertyCount];
            Object[] copyConstructorArguments = new Object[propertyCount];

            alreadySetProperties.addAll(properties);

            for (SettableBeanProperty property : properties) {
                List<Object> valueAndCopy = generateSymbolicPropertyValue(property, p, ctxt, depth);
                int index = property.getCreatorIndex();
                beanConstructorArguments[index] = valueAndCopy.get(0);
                copyConstructorArguments[index] = valueAndCopy.get(1);
            }

            bean = _valueInstantiator.createFromObjectWith(ctxt, beanConstructorArguments);
            beanCopy = _valueInstantiator.createFromObjectWith(ctxt, copyConstructorArguments);
        }

        if (bean == null) {
            SpringApplicationImpl._println(String.format("Warning! Could not instantiate bean of type %s. %b %b",
                    _valueInstantiator.getValueClass().toString(),
                    _valueInstantiator.canCreateUsingDefault(),
                    _valueInstantiator.canCreateFromObjectWith()
            ));
            Engine.assume(false);
        }

        for (SettableBeanProperty property : _beanProperties) {
            if (alreadySetProperties.contains(property))
                continue;

            List<Object> valueAndCopy = generateSymbolicPropertyValue(property, p, ctxt, depth);

            property.set(bean, valueAndCopy.get(0));
            property.set(beanCopy, valueAndCopy.get(1));
        }

        return Arrays.asList(bean, beanCopy);
    }

    private List<Object> generateSymbolicPropertyValue(
            SettableBeanProperty property,
            JsonParser p,
            DeserializationContext ctxt,
            int depth
    ) throws IOException {

        if (isPrimitive(property.getType())) {
            Object value = SymbolicValueFactory.createSymbolic(property.getType().getRawClass(), false);
            Engine.assume(value != null);
            return Arrays.asList(value, value);
        }

        JsonDeserializer<Object> valueDeserializer = property.getValueDeserializer();
        JavaType propertyType = property.getType();

        if (isCollection(propertyType)) {
            return generateSymbolicCollectionPropertyValue(propertyType, valueDeserializer, p, ctxt, depth);
        }

        if (valueDeserializer instanceof BeanDeserializer) {
            return ((BeanDeserializerImpl)valueDeserializer).symbolicDeserialize(p, ctxt, depth + 1);
        }

        SpringApplicationImpl._println("Warning! Generating symbolic JSON property value did not hit any case");

        return Arrays.asList(null, null);
    }

    private List<Object> generateSymbolicCollectionPropertyValue(
            JavaType propertyType,
            JsonDeserializer<Object> deserializer,
            JsonParser p,
            DeserializationContext ctxt,
            int depth
    ) throws IOException {
        int length = MAX_LENGTH;

        if (propertyType.isArrayType()) {
            JavaType componentType = propertyType.getContentType();
            Object[] array = new Object[length];
            Object[] arrayCopy = new Object[length];

            if (isPrimitive(componentType)) {
                // Array of primitives, allocate and fill now
                Object value = SymbolicValueFactory.createSymbolic(propertyType.getRawClass(), false);
                Engine.assume(value != null);

                for (int i = 0; i < length; i++) {
                    array[i] = value;
                    arrayCopy[i] = value;
                }
            } else {
                // Array of non-primitive, go into inner deserializer
                List<Object> valueAndCopy = Arrays.asList(null, null);

                if (!(deserializer instanceof ObjectArrayDeserializer)) {
                    SpringApplicationImpl._println("Warning! Object array deserializer was not of an ObjectArrayDeserializer class!");
                    return Arrays.asList(null, null);
                }

                ObjectArrayDeserializer objectArrayDeserializer = (ObjectArrayDeserializer)deserializer;
                JsonDeserializer<Object> contentDeserializer = objectArrayDeserializer.getContentDeserializer();

                if (isCollection(componentType)) {
                    for (int i = 0; i < length; i++) {
                        valueAndCopy = generateSymbolicCollectionPropertyValue(componentType, contentDeserializer, p, ctxt, depth + 1);
                        array[i] = valueAndCopy.get(0);
                        arrayCopy[i] = valueAndCopy.get(1);
                    }
                    return Arrays.asList(array, arrayCopy);
                }

                for (int i = 0; i < length; i++) {
                    valueAndCopy = ((BeanDeserializerImpl)contentDeserializer).symbolicDeserialize(p, ctxt, depth +1);
                    array[i] = valueAndCopy.get(0);
                    arrayCopy[i] = valueAndCopy.get(1);
                }
                return Arrays.asList(array, arrayCopy);
            }
        }

        return Arrays.asList(null, null);
    }

    public Object deserializeFromObject(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (_concreteDeserialization())
            return deserializeFromObjectReal(p, ctxt);

        List<Object> beanAndCopy = symbolicDeserialize(p, ctxt, 0);
        _writeToState(beanAndCopy.get(1));
        return beanAndCopy.get(0);
    }

    // Real implementation for technical use in some spring methods
    public Object deserializeReal(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (p.isExpectedStartObjectToken()) {
            if (this._vanillaProcessing) {
                return this.vanillaDeserialize(p, ctxt, p.nextToken());
            } else {
                p.nextToken();
                return this._objectIdReader != null ? this.deserializeWithObjectId(p, ctxt) : this.deserializeFromObject(p, ctxt);
            }
        } else {
            return this._deserializeOther(p, ctxt, p.currentToken());
        }
    }

    private final Object vanillaDeserialize(JsonParser p, DeserializationContext ctxt, JsonToken t) throws IOException {
        Object bean = this._valueInstantiator.createUsingDefault(ctxt);
        if (p.hasTokenId(5)) {
            p.assignCurrentValue(bean);
            String propName = p.currentName();

            do {
                p.nextToken();
                SettableBeanProperty prop = this._beanProperties.find(propName);
                if (prop != null) {
                    try {
                        prop.deserializeAndSet(p, ctxt, bean);
                    } catch (Exception var8) {
                        Exception e = var8;
                        this.wrapAndThrow(e, bean, propName, ctxt);
                    }
                } else {
                    this.handleUnknownVanilla(p, ctxt, bean, propName);
                }
            } while((propName = p.nextFieldName()) != null);
        }

        return bean;
    }

    public Object deserializeFromObjectReal(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (this._objectIdReader != null && this._objectIdReader.maySerializeAsObject() && p.hasTokenId(5) && this._objectIdReader.isValidReferencePropertyName(p.currentName(), p)) {
            return this.deserializeFromObjectId(p, ctxt);
        } else {
            Object bean;
            if (this._nonStandardCreation) {
                if (this._unwrappedPropertyHandler != null) {
                    return this.deserializeWithUnwrapped(p, ctxt);
                } else if (this._externalTypeIdHandler != null) {
                    return this.deserializeWithExternalTypeId(p, ctxt);
                } else {
                    bean = this.deserializeFromObjectUsingNonDefault(p, ctxt);
                    return bean;
                }
            } else {
                bean = this._valueInstantiator.createUsingDefault(ctxt);
                p.assignCurrentValue(bean);
                if (p.canReadObjectId()) {
                    Object id = p.getObjectId();
                    if (id != null) {
                        this._handleTypedObjectId(p, ctxt, bean, id);
                    }
                } else if (this._objectIdReader != null && p.hasTokenId(2) && ctxt.isEnabled(DeserializationFeature.FAIL_ON_UNRESOLVED_OBJECT_IDS)) {
                    ctxt.reportUnresolvedObjectId(this._objectIdReader, bean);
                }

                if (this._injectables != null) {
                    this.injectValues(ctxt, bean);
                }

                if (this._needViewProcesing) {
                    Class<?> view = ctxt.getActiveView();
                    if (view != null) {
                        return this.deserializeWithView(p, ctxt, bean, view);
                    }
                }

                if (p.hasTokenId(5)) {
                    String propName = p.currentName();

                    do {
                        p.nextToken();
                        SettableBeanProperty prop = this._beanProperties.find(propName);
                        if (prop != null) {
                            try {
                                prop.deserializeAndSet(p, ctxt, bean);
                            } catch (Exception var7) {
                                Exception e = var7;
                                this.wrapAndThrow(e, bean, propName, ctxt);
                            }
                        } else {
                            this.handleUnknownVanilla(p, ctxt, bean, propName);
                        }
                    } while((propName = p.nextFieldName()) != null);
                }

                return bean;
            }
        }
    }
}
