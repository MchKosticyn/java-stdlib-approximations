package generated.java.util;

import java.lang.ClassCastException;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.String;
import java.lang.UnsupportedOperationException;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

import generated.java.util.stream.StreamImpl;
import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;

@Approximate(stub.java.util.HashMap_EntrySet.class)
public final class HashMap_EntrySet extends AbstractSet<Map.Entry<Object, Object>> {

    public LibSLRuntime.Map<Object, Map.Entry<Object, Object>> storage;

    public AbstractHashMapImpl parent;

    public HashMap_EntrySet(
        LibSLRuntime.Map<Object, Map.Entry<Object, Object>> storage,
        AbstractHashMapImpl parent
    ) {
        this.storage = storage;
        this.parent = parent;
    }

    @SuppressWarnings("unchecked")
    private Map.Entry<Object, Object>[] _mapToEntryArray() {
        int storageSize = this.storage.size();
        Map.Entry<Object, Object>[] result = new Map.Entry[storageSize];
        if (storageSize != 0) {
            LibSLRuntime.Map<Object, Map.Entry<Object, Object>> unseen = this.storage.duplicate();
            for (int i = 0; i < storageSize; i++) {
                Object curKey = unseen.anyKey();
                result[i] = this.storage.get(curKey);
                unseen.remove(curKey);
            }
        }
        return result;
    }

    public boolean add(Map.Entry<Object, Object> e) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(@NotNull Collection c) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.parent.modCount++;
        LibSLRuntime.Map<Object, Map.Entry<Object, Object>> newStorage =
                new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
        this.storage = newStorage;
        this.parent.storage = newStorage;
    }

    @SuppressWarnings("unchecked")
    public boolean contains(Object o) {
        if ((o instanceof Map.Entry)) {
            Map.Entry<Object, Object> oEntry = ((Map.Entry<Object, Object>) o);
            Object key = oEntry.getKey();
            if (this.storage.hasKey(key)) {
                Map.Entry<Object, Object> entry = this.storage.get(key);
                return LibSLRuntime.equals(entry, oEntry);
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public boolean containsAll(Collection<?> c) {
        boolean result = true;
        Iterator<Map.Entry<Object, Object>> iter = ((Iterator<Map.Entry<Object, Object>>) c.iterator());
        while (result && iter.hasNext()) {
            Map.Entry<Object, Object> oEntry = iter.next();
            Object key = oEntry.getKey();
            if (this.storage.hasKey(key)) {
                Map.Entry<Object, Object> entry = this.storage.get(key);
                result = LibSLRuntime.equals(entry, oEntry);
            } else {
                result = false;
            }
        }

        return result;
    }

    @SuppressWarnings("unchecked")
    public boolean equals(Object other) {
        if (other == this)
            return true;

        if (!(other instanceof Set))
            return false;

        Collection<Map.Entry<Object, Object>> c;
        try {
            c = (Collection<Map.Entry<Object, Object>>) other;
        } catch (ClassCastException e) {
            return false;
        }

        if (this.storage.size() != c.size())
            return false;

        try {
            boolean result = true;
            Iterator<Map.Entry<Object, Object>> iter = c.iterator();
            while (result && iter.hasNext()) {
                Map.Entry<Object, Object> oEntry = iter.next();
                Object key = oEntry.getKey();
                if (this.storage.hasKey(key)) {
                    Map.Entry<Object, Object> entry = this.storage.get(key);
                    result = LibSLRuntime.equals(entry, oEntry);
                } else {
                    result = false;
                }
            }
            return result;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public void forEach(Consumer<? super Map.Entry<Object, Object>> userAction) {
        if (userAction == null) {
            throw new NullPointerException();
        }
        int size = this.storage.size();
        if (size <= 0)
            return;

        int expectedModCount = this.parent.modCount;
        LibSLRuntime.Map<Object, Map.Entry<Object, Object>> unseen = this.storage.duplicate();
        for (int i = 0; i < size; i++) {
            Object key = unseen.anyKey();
            Map.Entry<Object, Object> entry = this.storage.get(key);
            userAction.accept(entry);
            unseen.remove(key);
        }
        this.parent._checkForComodification(expectedModCount);
    }

    public int hashCode() {
        return LibSLRuntime.hashCode(this.storage);
    }

    public boolean isEmpty() {
        return this.storage.size() == 0;
    }

    @NotNull
    public Iterator<Map.Entry<Object, Object>> iterator() {
        return new HashMap_EntryIterator(this.parent, this.storage.duplicate(), this.parent.modCount, null);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public Stream parallelStream() {
        Object[] items = _mapToEntryArray();
        return new StreamImpl(items, items.length, Engine.makeSymbolicList(), true, false);
    }

    @SuppressWarnings("unchecked")
    public boolean remove(Object o) {
        if (!(o instanceof Map.Entry))
            return false;

        Map.Entry<Object, Object> oEntry = ((Map.Entry<Object, Object>) o);
        Object key = oEntry.getKey();
        if (this.storage.hasKey(key)) {
            Map.Entry<Object, Object> entry = this.storage.get(key);
            if (LibSLRuntime.equals(entry, oEntry)) {
                this.storage.remove(key);
                this.parent.modCount++;
                return true;
            }
        }

        return false;
    }

    public boolean removeAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException();
        }

        int startStorageSize = this.storage.size();
        int cSize = c.size();
        if (startStorageSize == 0 || cSize == 0)
            return false;

        if (startStorageSize <= cSize) {
            LibSLRuntime.Map<Object, Map.Entry<Object, Object>> unseen = this.storage.duplicate();
            for (int i = 0; i < startStorageSize; i++) {
                Object curKey = unseen.anyKey();
                Map.Entry<Object, Object> entry = this.storage.get(curKey);
                if (c.contains(entry)) {
                    this.storage.remove(curKey);
                    this.parent.modCount++;
                }
                unseen.remove(curKey);
            }

            return startStorageSize != this.storage.size();
        }

        for (Object entry : c) {
            if (!(entry instanceof Map.Entry))
                continue;

            Object curKey = ((Map.Entry<?, ?>) entry).getKey();
            if (this.storage.hasKey(curKey)) {
                if (LibSLRuntime.equals(entry, this.storage.get(curKey))) {
                    this.storage.remove(curKey);
                    this.parent.modCount++;
                }
            }
        }

        return startStorageSize != this.storage.size();
    }

    public boolean removeIf(Predicate<? super Map.Entry<Object, Object>> filter) {
        if (filter == null) {
            throw new NullPointerException();
        }
        int startStorageSize = this.storage.size();
        if (startStorageSize == 0)
            return false;

        LibSLRuntime.Map<Object, Map.Entry<Object, Object>> unseen = this.storage.duplicate();
        for (int i = 0; i < startStorageSize; i++) {
            Object curKey = unseen.anyKey();
            Map.Entry<Object, Object> entry = unseen.get(curKey);
            if (filter.test(entry)) {
                this.storage.remove(curKey);
                this.parent.modCount++;
            }
            unseen.remove(curKey);
        }

        return startStorageSize != this.storage.size();
    }

    @SuppressWarnings("NullableProblems")
    public boolean retainAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException();
        }
        int startStorageSize = this.storage.size();
        int cSize = c.size();
        if (startStorageSize == 0 || cSize == 0)
            return false;

        LibSLRuntime.Map<Object, Map.Entry<Object, Object>> unseen = this.storage.duplicate();
        for (int i = 0; i < startStorageSize; i++) {
            Object curKey = unseen.anyKey();
            Map.Entry<Object, Object> entry = unseen.get(curKey);
            if (!c.contains(entry)) {
                this.storage.remove(curKey);
                this.parent.modCount++;
            }
        }

        return startStorageSize != this.storage.size();
    }

    public int size() {
        return this.storage.size();
    }

    public Spliterator<Map.Entry<Object, Object>> spliterator() {
        return new HashMap_EntrySpliterator(this.parent, _mapToEntryArray(), 0, -1, 0, 0);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public Stream stream() {
        Object[] items = _mapToEntryArray();
        return new StreamImpl(items, items.length, Engine.makeSymbolicList(), false, false);
    }

    @NotNull
    public Object[] toArray() {
        int len = this.storage.size();
        Object[] result = new Object[len];
        if (len == 0)
            return result;

        LibSLRuntime.Map<Object, Map.Entry<Object, Object>> unseen = this.storage.duplicate();
        for (int i = 0; i < len; i++) {
            Object key = unseen.anyKey();
            result[i] = unseen.get(key);
            unseen.remove(key);
        }

        return result;
    }

    @SuppressWarnings({"unchecked", "unused"})
    public Object[] toArray(IntFunction generator) {
        Object[] unused = ((Object[]) generator.apply(0));
        int len = this.storage.size();
        Object[] result = new Object[len];
        if (len == 0)
            return result;

        LibSLRuntime.Map<Object, Map.Entry<Object, Object>> unseen = this.storage.duplicate();
        for (int i = 0; i < len; i++) {
            Object key = unseen.anyKey();
            result[i] = unseen.get(key);
            unseen.remove(key);
        }

        return result;
    }

    @NotNull
    @SuppressWarnings("unchecked")
    public Object[] toArray(Object[] array) {
        int aLen = array.length;
        int len = this.storage.size();
        if (aLen < len) {
            array = new Object[len];
        }
        if (len == 0)
            return array;

        LibSLRuntime.Map<Object, Map.Entry<Object, Object>> unseen = this.storage.duplicate();
        for (int i = 0; i < len; i++) {
            Object key = unseen.anyKey();
            array[i] = unseen.get(key);
            unseen.remove(key);
        }
        if (aLen > len) {
            array[len] = null;
        }

        return array;
    }

    public String toString() {
        int size = this.storage.size();
        if (size == 0)
            return "[]";

        String result = "[";
        int lastIndex = size - 1;
        LibSLRuntime.Map<Object, Map.Entry<Object, Object>> unseen = this.storage.duplicate();
        for (int i = 0; i < size; i++) {
            Object key = unseen.anyKey();
            Map.Entry<Object, Object> entry = unseen.get(key);
            Object value = entry.getValue();
            result = result.concat(LibSLRuntime.toString(key).concat("=").concat(LibSLRuntime.toString(value)));
            if (i != lastIndex) {
                result = result.concat(", ");
            }
            unseen.remove(key);
        }

        return result.concat("]");
    }
}
