package generated.org.springframework.boot.databind;

import generated.org.springframework.boot.pinnedValues.PinnedValueSource;
import generated.org.springframework.boot.pinnedValues.PinnedValueStorage;
import jakarta.persistence.Index;
import jakarta.servlet.ServletRequest;
import org.jacodb.approximation.annotation.Approximate;
import org.springframework.beans.CachedIntrospectionResults;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.core.ResolvableType;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.usvm.api.Engine;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Approximate(ServletRequestDataBinder.class)
public class ServletRequestDataBinderImpl extends ServletRequestDataBinder {

    private static final int MAX_ITERATION = 10;
    private static final int MAX_ARRAY_INDEX = 10;
    
    public ServletRequestDataBinderImpl(Object target) {
        super(target);
    }

    public void bind(ServletRequest request) {
        if (!this.shouldNotBindPropertyValues()) {
            MutablePropertyValues mpvs = generateMutablePropertyValues(
                    "", 
                    Objects.requireNonNull(getTargetType()).getRawClass(),
                    0
            );
            this.addBindValues(mpvs, request);
            this.doBind(mpvs);
        }
    }
    
    private PropertyDetail getProperties() {
        
    }
    
    private MutablePropertyValues generateMutablePropertyValues(String prefix, Class<?> clazz, int iteration) {
        MutablePropertyValues mpvs = new MutablePropertyValues();
        
        if (clazz.isPrimitive() || clazz == String.class) {
            Object value = PinnedValueStorage.getPinnedValue(PinnedValueSource.REQUEST_PARAM, prefix, clazz);
            mpvs.add(prefix, value);
        }
        
        if (clazz.isArray() || List.class.isAssignableFrom(clazz) || Iterable.class.isAssignableFrom(clazz)) {
            for (int i = 0; i < MAX_ARRAY_INDEX; i++) {
                if (Engine.makeSymbolicBoolean()) break;
                String newPrefix = String.format("%s[%d]", prefix, i);
                Class<?> elementType = tryGetElementType();
                mpvs.addPropertyValues(generateMutablePropertyValues(newPrefix, elementType, iteration + 1));
            }
        }
        
        for (PropertyDetails property : getProperties(clazz)) {
            
        }
        
        return mpvs;
    }

    private static class PropertyDetail {
        PropertyDetail(String propertyName, GenericAwareType propertyType) {

        }
    }

    private static class GenericAwareType {
        PropertyDetail(Class<?> clazz, Class<?> ...generics) {

        }
    }
}
