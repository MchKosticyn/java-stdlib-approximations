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

@Approximate(stub.java.util.HashMap_Values.class)
public class HashMap_Values extends AbstractCollection<Object> {

    public LibSLRuntime.Map<Object, Map.Entry<Object, Object>> storage;

    public AbstractHashMapImpl parent;

    public HashMap_Values(LibSLRuntime.Map<Object, Map.Entry<Object, Object>> storage, AbstractHashMapImpl parent) {
        this.storage = storage;
        this.parent = parent;
    }

    private Object[] _mapToValuesArray() {
        int size = this.storage.size();
        Object[] result = new Object[size];
        if (size == 0)
            return result;

        LibSLRuntime.Map<Object, Map.Entry<Object, Object>> unseen = this.storage.duplicate();
        for (int i = 0; i < size; i++) {
            Object curKey = unseen.anyKey();
            Map.Entry<Object, Object> entry = unseen.get(curKey);
            result[i] = entry.getValue();
            unseen.remove(curKey);
        }

        return result;
    }

    @SuppressWarnings("RedundantMethodOverride")
    public boolean add(Object e) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(@NotNull Collection c) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.parent.modCount++;
        LibSLRuntime.Map<Object, Map.Entry<Object, Object>> newStorage =
                new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
        this.parent.storage = newStorage;
        this.storage = newStorage;
    }

    public boolean contains(Object value) {
        int size = this.storage.size();
        if (size == 0)
            return false;

        LibSLRuntime.Map<Object, Map.Entry<Object, Object>> unseen = this.storage.duplicate();
        boolean result = false;
        while (!result && size != 0) {
            Object key = unseen.anyKey();
            Map.Entry<Object, Object> entry = unseen.get(key);
            Object curValue = entry.getValue();
            if (LibSLRuntime.equals(curValue, value)) {
                result = true;
            }
            unseen.remove(key);
            size--;
        }

        return result;
    }

    @SuppressWarnings("NonStrictComparisonCanBeEquality")
    public boolean containsAll(@NotNull Collection<?> c) {
        // TODO: refactor
        int thisSize = this.storage.size();
        if (thisSize == 0 || c == this)
            return true;

        Engine.assume(thisSize > 0);
        int otherSize = c.size();
        if (otherSize <= 0)
            return true;

        Object[] thisValues = new Object[thisSize];
        LibSLRuntime.Map<Object, Map.Entry<Object, Object>> unseen = this.storage.duplicate();
        for (int i = 0; i < thisSize; i++) {
            Object key = unseen.anyKey();
            Map.Entry<Object, Object> entry = unseen.get(key);
            thisValues[i] = entry.getValue();
            unseen.remove(key);
        }

        boolean result = true;
        Iterator<?> iter = c.iterator();
        while (result && iter.hasNext()) {
            Object value = iter.next();
            result = false;
            int i = 0;
            while ((!result) && (i != thisSize)) {
                result = LibSLRuntime.equals(thisValues[i], value);
                i++;
            }
        }

        return result;
    }

    public void forEach(Consumer<? super Object> userAction) {
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
            Map.Entry<Object, Object> entry = unseen.get(key);
            userAction.accept(entry.getValue());
            unseen.remove(key);
        }
        this.parent._checkForComodification(expectedModCount);
    }

    public boolean isEmpty() {
        return this.storage.size() == 0;
    }

    @NotNull
    public Iterator<Object> iterator() {
        return new HashMap_ValueIterator(this.parent, this.storage.duplicate(), this.parent.modCount, null);
    }

    public Stream<Object> parallelStream() {
        Object[] items = _mapToValuesArray();
        return new StreamImpl(items, items.length, Engine.makeSymbolicList(), true, false);
    }

    public boolean remove(Object value) {
        LibSLRuntime.Map<Object, Map.Entry<Object, Object>> unseen = this.storage.duplicate();
        int thisSize = this.storage.size();
        boolean result = false;
        while (!result && thisSize != 0) {
            Object curKey = unseen.anyKey();
            Map.Entry<Object, Object> entry = unseen.get(curKey);
            Object curValue = entry.getValue();
            if (LibSLRuntime.equals(value, curValue)) {
                this.storage.remove(curKey);
                result = true;
                this.parent.modCount++;
            }
            unseen.remove(curKey);
            thisSize--;
        }

        return result;
    }

    @SuppressWarnings("ConstantValue")
    public boolean removeAll(@NotNull Collection<?> c) {
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
            Object curValue = entry.getValue();
            if (c.contains(curValue)) {
                this.storage.remove(curKey);
                this.parent.modCount++;
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
        for (int i = 0; i < startStorageSize; i++) {
            Object curKey = unseen.anyKey();
            Map.Entry<Object, Object> entry = unseen.get(curKey);
            Object curValue = entry.getValue();
            if (filter.test(curValue)) {
                this.storage.remove(curKey);
                this.parent.modCount++;
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
        for (int i = 0; i < startStorageSize; i++) {
            Object curKey = unseen.anyKey();
            Map.Entry<Object, Object> entry = unseen.get(curKey);
            Object curValue = entry.getValue();
            if (!c.contains(curValue)) {
                this.storage.remove(curKey);
                this.parent.modCount++;
            }
            unseen.remove(curKey);
        }

        return startStorageSize != this.storage.size();
    }

    public int size() {
        return this.storage.size();
    }

    public Spliterator<Object> spliterator() {
        return new HashMap_ValueSpliterator(_mapToValuesArray(), this.parent, 0, -1, 0, 0);
    }

    public Stream<Object> stream() {
        Object[] items = _mapToValuesArray();
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
            Map.Entry<Object, Object> entry = unseen.get(key);
            result[i] = entry.getValue();
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
            Map.Entry<Object, Object> entry = unseen.get(key);
            result[i] = entry.getValue();
            unseen.remove(key);
        }
        return result;
    }

    @NotNull
    @SuppressWarnings("unchecked")
    public Object[] toArray(Object[] array) {
        int aLen = array.length;
        int len = this.storage.size();
        if (aLen < len)
            array = new Object[len];
        if (len == 0)
            return array;

        LibSLRuntime.Map<Object, Map.Entry<Object, Object>> unseen = this.storage.duplicate();
        for (int i = 0; i < len; i++) {
            Object key = unseen.anyKey();
            Map.Entry<Object, Object> entry = unseen.get(key);
            array[i] = entry.getValue();
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
            result = result.concat(LibSLRuntime.toString(entry.getValue()));
            if (i != lastIndex) {
                result = result.concat(", ");
            }
            unseen.remove(key);
        }

        return result.concat("]");
    }
}
