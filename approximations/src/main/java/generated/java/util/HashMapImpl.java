package generated.java.util;

import java.io.Serial;
import java.lang.Object;
import java.lang.String;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;

@Approximate(java.util.HashMap.class)
public class HashMapImpl extends AbstractHashMapImpl {

    @Serial
    private static final long serialVersionUID = 362498820763181265L;

    static {
        Engine.assume(true);
    }

    public HashMapImpl(LibSLRuntime.Map<Object, Map.Entry<Object, Object>> storage, int modCount) {
        super(storage, modCount);
    }

    @SuppressWarnings("unused")
    public HashMapImpl() {
        super();
    }

    public HashMapImpl(Map<Object, Object> m) {
        super(m);
    }

    @SuppressWarnings("unused")
    public HashMapImpl(int initialCapacity) {
        super(initialCapacity);
    }

    @SuppressWarnings("unused")
    public HashMapImpl(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    public void clear() {
        super.clear();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Object compute(Object key, @NotNull BiFunction remappingFunction) {
        return super.compute(key, remappingFunction);
    }

    public Object computeIfAbsent(Object key, @NotNull Function mappingFunction) {
        return super.computeIfAbsent(key, mappingFunction);
    }

    public Object computeIfPresent(Object key, @NotNull BiFunction remappingFunction) {
        return super.computeIfPresent(key, remappingFunction);
    }

    public boolean containsKey(Object key) {
        return super.containsKey(key);
    }

    public boolean containsValue(Object value) {
        return super.containsValue(value);
    }

    @NotNull
    public Set<Map.Entry<Object, Object>> entrySet() {
        return super.entrySet();
    }

    public boolean equals(Object other) {
        return other.getClass() == java.util.HashMap.class && super.equals(other);
    }

    public void forEach(BiConsumer userAction) {
        super.forEach(userAction);
    }

    public Object get(Object key) {
        return super.get(key);
    }

    public Object getOrDefault(Object key, Object defaultValue) {
        return super.getOrDefault(key, defaultValue);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean isEmpty() {
        return super.isEmpty();
    }

    @NotNull
    public Set<Object> keySet() {
        return super.keySet();
    }

    public Object merge(Object key, @NotNull Object value, @NotNull BiFunction remappingFunction) {
        return super.merge(key, value, remappingFunction);
    }

    public Object put(Object key, Object value) {
        return super.put(key, value);
    }

    public void putAll(@NotNull Map m) {
        super.putAll(m);
    }

    public Object putIfAbsent(Object key, Object value) {
        return super.putIfAbsent(key, value);
    }

    public Object remove(Object key) {
        return super.remove(key);
    }

    public boolean remove(Object key, Object value) {
        return super.remove(key, value);
    }

    public Object replace(Object key, Object value) {
        return super.replace(key, value);
    }

    public boolean replace(Object key, Object oldValue, Object newValue) {
        return super.replace(key, oldValue, newValue);
    }

    public void replaceAll(BiFunction function) {
        super.replaceAll(function);
    }

    public int size() {
        return super.size();
    }

    public String toString() {
        return super.toString();
    }

    @NotNull
    public Collection<Object> values() {
        return super.values();
    }
}
