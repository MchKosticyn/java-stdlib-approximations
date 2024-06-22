package generated.java.util;

import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;

import java.io.Serializable;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

@SuppressWarnings("NullableProblems")
@Approximate(java.util.AbstractMap.class)
public class AbstractHashMapImpl implements Map<Object, Object>, Cloneable, Serializable {

    public LibSLRuntime.Map<Object, Map.Entry<Object, Object>> storage;

    public transient int modCount;

    public AbstractHashMapImpl(LibSLRuntime.Map<Object, Map.Entry<Object, Object>> storage, int modCount) {
        this.storage = storage;
        this.modCount = modCount;
    }

    public AbstractHashMapImpl() {
        this(new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>()), 0);
    }

    public AbstractHashMapImpl(Map<Object, Object> m) {
        this();
        Set<Entry<Object, Object>> entrySet = m.entrySet();
        for (Entry<Object, Object> oEntry : entrySet) {
            Object key = oEntry.getKey();
            Object value = oEntry.getValue();
            Entry<Object, Object> entry;
            if (this.storage.hasKey(key)) {
                entry = this.storage.get(key);
                entry.setValue(value);
            } else {
                entry = new AbstractMap_SimpleEntry(key, value);
                this.storage.set(key, entry);
            }
            this.modCount++;
        }
    }

    public AbstractHashMapImpl(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException();
        }
        this.storage = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
        this.modCount = 0;
    }

    public AbstractHashMapImpl(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException();
        }
        if ((loadFactor <= 0) || (loadFactor != loadFactor)) {
            throw new IllegalArgumentException();
        }
        this.storage = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
        this.modCount = 0;
    }

    public void _checkForComodification(int expectedModCount) {
        if (this.modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        this.modCount++;
        this.storage = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
    }

    public Object clone() throws CloneNotSupportedException {
        AbstractHashMapImpl clonedMap = (AbstractHashMapImpl) super.clone();
        clonedMap.storage = this.storage.duplicate();
        clonedMap.modCount = 0;
        return clonedMap;
    }

    @SuppressWarnings("unchecked")
    public Object compute(Object key, BiFunction remappingFunction) {
        if (remappingFunction == null) {
            throw new NullPointerException();
        }
        Object oldValue = null;
        Map.Entry<Object, Object> entry = null;
        if (this.storage.hasKey(key)) {
            entry = this.storage.get(key);
            oldValue = entry.getValue();
        }
        int expectedModCount = this.modCount;
        Object newValue = remappingFunction.apply(key, oldValue);
        _checkForComodification(expectedModCount);
        if (newValue == null) {
            this.storage.remove(key);
        } else {
            if (entry != null) {
                entry.setValue(newValue);
            } else {
                entry = new AbstractMap_SimpleEntry(key, newValue);
                this.storage.set(key, entry);
            }
        }

        return newValue;
    }

    @SuppressWarnings("unchecked")
    public Object computeIfAbsent(Object key, Function mappingFunction) {
        if (mappingFunction == null) {
            throw new NullPointerException();
        }
        Object oldValue = null;
        Map.Entry<Object, Object> entry = null;
        if (this.storage.hasKey(key)) {
            entry = this.storage.get(key);
            oldValue = entry.getValue();
        }

        if (oldValue != null)
            return oldValue;

        int expectedModCount = this.modCount;
        Object newValue = mappingFunction.apply(key);
        _checkForComodification(expectedModCount);
        if (newValue != null) {
            if (entry != null) {
                entry.setValue(newValue);
            } else {
                entry = new AbstractMap_SimpleEntry(key, newValue);
                this.storage.set(key, entry);
            }
        }

        return newValue;
    }

    @SuppressWarnings({"ConstantValue", "unchecked"})
    public Object computeIfPresent(Object key, BiFunction remappingFunction) {
        if (remappingFunction == null) {
            throw new NullPointerException();
        }
        Object oldValue = null;
        Map.Entry<Object, Object> entry = null;
        if (this.storage.hasKey(key)) {
            entry = this.storage.get(key);
            oldValue = entry.getValue();
        }
        if (oldValue == null)
            return oldValue;

        int expectedModCount = this.modCount;
        Object newValue = remappingFunction.apply(key, oldValue);
        _checkForComodification(expectedModCount);
        if (newValue == null) {
            this.storage.remove(key);
        } else {
            if (entry != null) {
                entry.setValue(newValue);
            } else {
                entry = new AbstractMap_SimpleEntry(key, newValue);
                this.storage.set(key, entry);
            }
        }

        return newValue;
    }

    public boolean containsKey(Object key) {
        return this.storage.size() != 0 && this.storage.hasKey(key);
    }

    public boolean containsValue(Object value) {
        int storageSize = this.storage.size();
        if (storageSize == 0)
            return false;

        LibSLRuntime.Map<Object, Map.Entry<Object, Object>> unseen = this.storage.duplicate();
        while (storageSize != 0) {
            Object curKey = unseen.anyKey();
            Map.Entry<Object, Object> entry = this.storage.get(curKey);
            Object curValue = entry.getValue();
            if (LibSLRuntime.equals(curValue, value)) {
                return true;
            }
            unseen.remove(curKey);
            storageSize--;
        }

        return false;
    }

    public Set<Map.Entry<Object, Object>> entrySet() {
        return new HashMap_EntrySet(this.storage, this);
    }

    @SuppressWarnings("unchecked")
    public boolean equals(Object other) {
        if (other == this)
            return true;

        if (!(other instanceof Map))
            return false;

        Map<Object, Object> m = ((Map<Object, Object>) other);
        int thisLength = this.storage.size();
        if (thisLength != m.size())
            return false;

        try {
            LibSLRuntime.Map<Object, Map.Entry<Object, Object>> unseen = this.storage.duplicate();
            while (thisLength != 0) {
                Object key = unseen.anyKey();
                Map.Entry<Object, Object> entry = this.storage.get(key);
                Object value = entry.getValue();
                if (value == null && m.get(key) != null)
                    return false;
                if (value == null && !m.containsKey(key))
                    return false;
                if (value != null && !LibSLRuntime.equals(value, m.get(key)))
                    return false;

                unseen.remove(key);
                thisLength--;
            }
        } catch (ClassCastException | NullPointerException e) {
            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    public void forEach(BiConsumer userAction) {
        if (userAction == null) {
            throw new NullPointerException();
        }
        int storageSize = this.storage.size();
        if (storageSize > 0) {
            int expectedModCount = this.modCount;
            LibSLRuntime.Map<Object, Map.Entry<Object, Object>> unseen = this.storage.duplicate();
            for (int i = 0; i < storageSize; i++) {
                Object curKey = unseen.anyKey();
                Map.Entry<Object, Object> entry = this.storage.get(curKey);
                Object curValue = entry.getValue();
                userAction.accept(curKey, curValue);
                unseen.remove(curKey);
            }
            _checkForComodification(expectedModCount);
        }
    }

    public Object get(Object key) {
        if (this.storage.hasKey(key)) {
            Map.Entry<Object, Object> entry = this.storage.get(key);
            return entry.getValue();
        }

        return null;
    }

    public Object getOrDefault(Object key, Object defaultValue) {
        if (this.storage.hasKey(key)) {
            Map.Entry<Object, Object> entry = this.storage.get(key);
            return entry.getValue();
        }

        return defaultValue;
    }

    public int hashCode() {
        return LibSLRuntime.hashCode(this.storage);
    }

    public boolean isEmpty() {
        return this.storage.size() == 0;
    }

    public Set<Object> keySet() {
        return new HashMap_KeySet(this.storage, this);
    }

    @SuppressWarnings("unchecked")
    public Object merge(Object key, Object value, BiFunction remappingFunction) {
        if (value == null) {
            throw new NullPointerException();
        }

        if (remappingFunction == null) {
            throw new NullPointerException();
        }

        if (this.storage.hasKey(key)) {
            Map.Entry<Object, Object> entry = this.storage.get(key);
            Object oldValue = entry.getValue();
            Object result;
            if (oldValue == null) {
                result = value;
            } else {
                int expectedModCount = this.modCount;
                result = remappingFunction.apply(oldValue, value);
                _checkForComodification(expectedModCount);
            }
            if (result == null) {
                this.storage.remove(key);
            } else {
                entry.setValue(result);
            }
            return result;
        }

        Map.Entry<Object, Object> entry = new AbstractMap_SimpleEntry(key, value);
        this.storage.set(key, entry);
        this.modCount++;
        return value;
    }

    public Object put(Object key, Object value) {
        this.modCount++;
        if (this.storage.hasKey(key)) {
            Map.Entry<Object, Object> entry = this.storage.get(key);
            Object result = entry.getValue();
            entry.setValue(value);
            return result;
        }

        Map.Entry<Object, Object> entry = new AbstractMap_SimpleEntry(key, value);
        this.storage.set(key, entry);

        return null;
    }

    @SuppressWarnings("unchecked")
    public void putAll(Map m) {
        if (m == null) {
            throw new NullPointerException();
        }

        Set<Map.Entry<Object, Object>> entrySet = ((Set<Map.Entry<Object, Object>>) m.entrySet());
        for (Entry<Object, Object> oEntry : entrySet) {
            Object key = oEntry.getKey();
            Object value = oEntry.getValue();
            if (this.storage.hasKey(key)) {
                Entry<Object, Object> entry = this.storage.get(key);
                entry.setValue(value);
            } else {
                Entry<Object, Object> entry = new AbstractMap_SimpleEntry(key, value);
                this.storage.set(key, entry);
            }
            this.modCount++;
        }
    }

    public Object putIfAbsent(Object key, Object value) {
        if (this.storage.hasKey(key)) {
            Map.Entry<Object, Object> entry = this.storage.get(key);
            return entry.getValue();
        }

        Map.Entry<Object, Object> entry = new AbstractMap_SimpleEntry(key, value);
        this.storage.set(key, entry);
        this.modCount++;

        return null;
    }

    public Object remove(Object key) {
        if (this.storage.hasKey(key)) {
            Map.Entry<Object, Object> entry = this.storage.get(key);
            Object result = entry.getValue();
            this.storage.remove(key);
            this.modCount++;
            return result;
        }

        return null;
    }

    public boolean remove(Object key, Object value) {
        if (this.storage.hasKey(key)) {
            Map.Entry<Object, Object> entry = this.storage.get(key);
            Object curValue = entry.getValue();
            if (LibSLRuntime.equals(curValue, value)) {
                this.storage.remove(key);
                this.modCount++;
                return true;
            }
        }

        return false;
    }

    public Object replace(Object key, Object value) {
        if (this.storage.hasKey(key)) {
            Map.Entry<Object, Object> entry = this.storage.get(key);
            Object result = entry.getValue();
            entry.setValue(value);
            return result;
        }

        return null;
    }

    public boolean replace(Object key, Object oldValue, Object newValue) {
        if (this.storage.hasKey(key)) {
            Map.Entry<Object, Object> entry = this.storage.get(key);
            Object curValue = entry.getValue();
            if (LibSLRuntime.equals(curValue, oldValue)) {
                entry.setValue(newValue);
                return true;
            }
        }

        return false;
    }

    @SuppressWarnings("unchecked")
    public void replaceAll(BiFunction function) {
        if (function == null) {
            throw new NullPointerException();
        }

        int size = this.storage.size();
        if (size > 0) {
            int expectedModCount = this.modCount;
            LibSLRuntime.Map<Object, Map.Entry<Object, Object>> unseen = this.storage.duplicate();
            for (int i = 0; i < size; i++) {
                Object key = unseen.anyKey();
                Map.Entry<Object, Object> entry = this.storage.get(key);
                entry.setValue(function.apply(key, entry.getValue()));
                unseen.remove(key);
            }
            _checkForComodification(expectedModCount);
        }
    }

    public int size() {
        return this.storage.size();
    }

    public String toString() {
        int count = this.storage.size();
        if (count == 0) {
            return "{}";
        }

        String result = "{";
        LibSLRuntime.Map<Object, Map.Entry<Object, Object>> unseen = this.storage.duplicate();
        count = unseen.size();
        Engine.assume(count > 0);
        while (count != 0) {
            Object key = unseen.anyKey();
            Map.Entry<Object, Object> entry = unseen.get(key);
            unseen.remove(key);
            result = result.concat(LibSLRuntime.toString(entry));
            count--;
            if (count != 0) {
                result = result.concat(", ");
            }
        }

        return result.concat("}");
    }

    public Collection<Object> values() {
        return new HashMap_Values(this.storage, this);
    }

}
