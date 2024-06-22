package generated.java.util;

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

@Approximate(stub.java.util.HashMap_KeySet.class)
public final class HashMap_KeySet extends AbstractSet<Object> {

    public LibSLRuntime.Map<Object, Map.Entry<Object, Object>> storage;

    public AbstractHashMapImpl parent;

    public HashMap_KeySet(LibSLRuntime.Map<Object, Map.Entry<Object, Object>> storage, AbstractHashMapImpl parent) {
        this.storage = storage;
        this.parent = parent;
    }

    @SuppressWarnings("unused")
    private HashMap_KeySet(AbstractHashMapImpl _this) {
        LibSLRuntime.error("Private constructor call");
    }

    private Object[] _mapToKeysArray() {
        int storageSize = this.storage.size();
        Object[] result = new Object[storageSize];
        LibSLRuntime.Map<Object, Map.Entry<Object, Object>> unseen = this.storage.duplicate();
        for (int i = 0; i < storageSize; i++) {
            Object curKey = unseen.anyKey();
            result[i] = curKey;
            unseen.remove(curKey);
        }
        return result;
    }

    public boolean add(Object e) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(@NotNull Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.parent.modCount++;
        LibSLRuntime.Map<Object, Map.Entry<Object, Object>> newStorage =
                new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
        this.storage = newStorage;
        this.parent.storage = newStorage;
    }

    public boolean contains(Object key) {
        if (this.storage.size() == 0)
            return false;

        return this.storage.hasKey(key);
    }

    public boolean containsAll(Collection<?> c) {
        boolean result = true;
        Iterator<?> iter = c.iterator();
        while (result && iter.hasNext()) {
            Object item = iter.next();
            result = this.storage.hasKey(item);
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public boolean equals(Object other) {
        if (other == this)
            return true;

        if (!(other instanceof Set))
            return false;

        Collection<Object> c = ((Collection<Object>) other);
        int cLength = c.size();
        int thisLength = this.storage.size();
        if (thisLength != cLength)
            return false;

        try {
            boolean result = true;
            Iterator<Object> iter = c.iterator();
            while (result && iter.hasNext()) {
                Object item = iter.next();
                result = this.storage.hasKey(item);
            }
            return result;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public void forEach(Consumer<? super Object> userAction) {
        if (userAction == null) {
            throw new NullPointerException();
        }
        int storageSize = this.storage.size();
        if (storageSize <= 0)
            return;

        LibSLRuntime.Map<Object, Map.Entry<Object, Object>> unseen = this.storage.duplicate();
        int expectedModCount = this.parent.modCount;
        for (int i = 0; i < storageSize; i++) {
            Object curKey = unseen.anyKey();
            userAction.accept(curKey);
            unseen.remove(curKey);
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
    public Iterator<Object> iterator() {
        return new HashMap_KeyIterator(this.parent, this.storage.duplicate(), this.parent.modCount, null);
    }

    public Stream<Object> parallelStream() {
        Object[] items = _mapToKeysArray();
        return new StreamImpl(_mapToKeysArray(), items.length, Engine.makeSymbolicList(), true, false);
    }

    public boolean remove(Object key) {
        if (this.storage.hasKey(key)) {
            this.storage.remove(key);
            this.parent.modCount += 1;
            return true;
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

        if (startStorageSize > cSize) {
            for (Object oKey : c) {
                if (this.storage.hasKey(oKey)) {
                    this.storage.remove(oKey);
                    this.parent.modCount += 1;
                }
            }

            return startStorageSize != this.storage.size();
        }

        LibSLRuntime.Map<Object, Map.Entry<Object, Object>> unseen = this.storage.duplicate();
        for (int i = 0; i < startStorageSize; i += 1) {
            Object curKey = unseen.anyKey();
            if (c.contains(curKey)) {
                this.storage.remove(curKey);
                this.parent.modCount += 1;
            }
            unseen.remove(curKey);
        }

        return startStorageSize != this.storage.size();
    }

    public boolean removeIf(Predicate<? super Object> filter) {
        if (filter == null) {
            throw new NullPointerException();
        }

        int startStorageSize = this.storage.size();
        if (startStorageSize == 0)
            return false;

        LibSLRuntime.Map<Object, Map.Entry<Object, Object>> unseen = this.storage.duplicate();
        for (int i = 0; i < startStorageSize; i += 1) {
            Object curKey = unseen.anyKey();
            if (filter.test(curKey)) {
                this.storage.remove(curKey);
                this.parent.modCount += 1;
            }
            unseen.remove(curKey);
        }

        return startStorageSize != this.storage.size();
    }

    @SuppressWarnings("ConstantValue")
    public boolean retainAll(@NotNull Collection<?> c) {
        if (c == null) {
            throw new NullPointerException();
        }

        int startStorageSize = this.storage.size();
        int cSize = c.size();
        if (startStorageSize == 0 || cSize == 0)
            return false;

        LibSLRuntime.Map<Object, Map.Entry<Object, Object>> unseen = this.storage.duplicate();
        for (int i = 0; i < startStorageSize; i += 1) {
            Object curKey = unseen.anyKey();
            if (!c.contains(curKey)) {
                this.storage.remove(curKey);
                this.parent.modCount += 1;
            }
            unseen.remove(curKey);
        }

        return startStorageSize != this.storage.size();
    }

    public int size() {
        return this.storage.size();
    }

    public Spliterator<Object> spliterator() {
        return new HashMap_KeySpliterator(_mapToKeysArray(), this.parent, 0, -1, 0, 0);
    }

    public Stream<Object> stream() {
        Object[] items = _mapToKeysArray();
        return new StreamImpl(items, items.length, Engine.makeSymbolicList(), false, false);
    }

    @NotNull
    public Object[] toArray() {
        int len = this.storage.size();
        Object[] result = new Object[len];
        if (len == 0)
            return result;

        LibSLRuntime.Map<Object, Map.Entry<Object, Object>> unseen = this.storage.duplicate();
        for (int i = 0; i < len; i += 1) {
            Object curKey = unseen.anyKey();
            result[i] = curKey;
            unseen.remove(curKey);
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
        for (int i = 0; i < len; i += 1) {
            Object curKey = unseen.anyKey();
            result[i] = curKey;
            unseen.remove(curKey);
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
        for (int i = 0; i < len; i += 1) {
            Object curKey = unseen.anyKey();
            array[i] = curKey;
            unseen.remove(curKey);
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
        LibSLRuntime.Map<Object, Map.Entry<Object, Object>> unseen = this.storage.duplicate();
        for (int i = 0; i < size; i += 1) {
            Object key = unseen.anyKey();
            result = result.concat(LibSLRuntime.toString(key));
            if (i != size - 1) {
                result = result.concat(", ");
            }
            unseen.remove(key);
        }

        return result.concat("]");
    }
}
