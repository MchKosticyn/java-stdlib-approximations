package generated.java.util;

import generated.java.util.stream.StreamStubImpl;
import generated.runtime.LibSLGlobals;

import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.String;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;

@Approximate(java.util.AbstractSet.class)
public class AbstractSetImpl implements Set<Object>, Cloneable, Serializable {

    public LibSLRuntime.Map<Object, Object> storage;

    public transient int modCount;

    public AbstractSetImpl(LibSLRuntime.Map<Object, Object> storage, int modCount) {
        this.storage = storage;
        this.modCount = modCount;
    }

    public AbstractSetImpl() {
        this(new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>()), 0);
    }

    @SuppressWarnings("unused")
    public AbstractSetImpl(Collection<?> c) {
        this();
        _addAllElements(c);
    }

    @SuppressWarnings("unused")
    public AbstractSetImpl(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException();
        }
        this.storage = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
        this.modCount = 0;
    }

    @SuppressWarnings("unused")
    public AbstractSetImpl(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException();
        }
        if ((loadFactor <= 0) || (loadFactor != loadFactor)) {
            throw new IllegalArgumentException();
        }
        this.storage = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
        this.modCount = 0;
    }

    @SuppressWarnings("unused")
    public AbstractSetImpl(int initialCapacity, float loadFactor, boolean dummy) {
        LibSLRuntime.error("Private constructor call");
    }

    public void _checkForModification(int expectedModCount) {
        if (this.modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean _addAllElements(Collection<?> c) {
        int lengthBeforeAdd = this.storage.size();
        for (Object key : c) {
            if (!this.storage.hasKey(key)) {
                this.storage.set(key, LibSLGlobals.SOMETHING);
            }
        }

        if (lengthBeforeAdd != this.storage.size()) {
            this.modCount++;
            return true;
        }

        return false;
    }

    public Stream<Object> _makeStream(boolean parallel) {
        LibSLRuntime.Map<Object, Object> unseen = this.storage.duplicate();
        int count = unseen.size();
        Object[] items = new Object[count];
        for (int i = 0; i < count; i++) {
            Object key = unseen.anyKey();
            unseen.remove(key);
            items[i] = key;
        }

        return new StreamStubImpl(items, count, Engine.makeSymbolicList(), parallel, false);
    }

    public boolean add(Object obj) {
        this.modCount++;
        boolean hasKey = this.storage.hasKey(obj);
        if (hasKey)
            return false;

        this.storage.set(obj, LibSLGlobals.SOMETHING);
        return true;
    }

    public void clear() {
        this.storage = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
        this.modCount++;
    }

    public Object clone() throws CloneNotSupportedException {
        AbstractSetImpl clonedSet = (AbstractSetImpl) super.clone();
        clonedSet.modCount = 0;
        clonedSet.storage = this.storage.duplicate();
        return clonedSet;
    }

    public boolean contains(Object obj) {
        if (this.storage.size() == 0)
            return false;

        return this.storage.hasKey(obj);
    }

    public boolean isEmpty() {
        return this.storage.size() == 0;
    }

    @NotNull
    public Iterator<Object> iterator() {
        LibSLRuntime.Map<Object, Object> unseenKeys = this.storage.duplicate();
        return new HashSet_KeyIterator(this.modCount, unseenKeys, this, 0, 0, false);
    }

    public boolean remove(Object obj) {
        if (this.storage.hasKey(obj)) {
            this.storage.remove(obj);
            this.modCount++;
            return true;
        }

        return false;
    }

    public int size() {
        return this.storage.size();
    }

    public Spliterator<Object> spliterator() {
        Object[] keysStorageArray = new Object[this.storage.size()];
        LibSLRuntime.Map<Object, Object> unseenKeys = this.storage.duplicate();
        int size = this.storage.size();
        for (int i = 0; i < size; i++) {
            Object key = unseenKeys.anyKey();
            unseenKeys.remove(key);
            keysStorageArray[i] = key;
        }
        return new HashSet_KeySpliterator(keysStorageArray, 0, -1, 0, this.modCount, this);
    }

    public boolean equals(Object other) {
        if (other == this)
            return true;

        if (!(other instanceof Set))
            return false;

        int expectedModCount = this.modCount;
        AbstractSetImpl otherSet = (AbstractSetImpl) other;
        int otherExpectedModCount = otherSet.modCount;
        LibSLRuntime.Map<Object, Object> otherStorage = otherSet.storage;

        if (this.storage.size() != otherStorage.size())
            return false;

        boolean result = LibSLRuntime.equals(this.storage, otherStorage);
        otherSet._checkForModification(otherExpectedModCount);
        this._checkForModification(expectedModCount);

        return result;
    }

    public int hashCode() {
        return LibSLRuntime.hashCode(this.storage);
    }

    @SuppressWarnings("ConstantValue")
    public boolean removeAll(@NotNull Collection<?> c) {
        if (c == null) {
            throw new NullPointerException();
        }

        int expectedModCount = this.modCount;
        int otherSize = c.size();
        int lengthBeforeRemoving = this.storage.size();
        if (this.storage.size() > otherSize) {
            for (Object key : c) {
                if (this.storage.hasKey(key)) {
                    this.storage.remove(key);
                }
            }
        } else {
            LibSLRuntime.Map<Object, Object> unseenKeys = this.storage.duplicate();
            int i = 0;
            while (i < lengthBeforeRemoving) {
                Object key = unseenKeys.anyKey();
                unseenKeys.remove(key);
                if (c.contains(key)) {
                    this.storage.remove(key);
                }
                i++;
            }
        }
        _checkForModification(expectedModCount);
        this.modCount++;
        return lengthBeforeRemoving != this.storage.size();
    }

    @NotNull
    public Object[] toArray() {
        int len = this.storage.size();
        Object[] result = new Object[len];
        int expectedModCount = this.modCount;
        LibSLRuntime.Map<Object, Object> unseenKeys = this.storage.duplicate();
        for (int i = 0; i < len; i++) {
            Object key = unseenKeys.anyKey();
            unseenKeys.remove(key);
            result[i] = key;
        }
        _checkForModification(expectedModCount);

        return result;
    }

    @NotNull
    @SuppressWarnings("unchecked")
    public Object[] toArray(Object[] array) {
        int expectedModCount = this.modCount;
        int aLen = array.length;
        int len = this.storage.size();
        LibSLRuntime.Map<Object, Object> unseenKeys = this.storage.duplicate();
        if (aLen < len) {
            array = new Object[len];
        }
        for (int i = 0; i < len; i++) {
            Object key = unseenKeys.anyKey();
            unseenKeys.remove(key);
            array[i] = key;
        }
        if (aLen > len) {
            array[len] = null;
        }
        _checkForModification(expectedModCount);

        return array;
    }

    @SuppressWarnings({"unchecked", "unused"})
    public Object[] toArray(IntFunction generator) {
        if (generator == null) {
            throw new NullPointerException();
        }
        Object[] unused = ((Object[]) generator.apply(0));
        int len = this.storage.size();
        Object[] result = new Object[len];
        int expectedModCount = this.modCount;
        LibSLRuntime.Map<Object, Object> unseenKeys = this.storage.duplicate();
        for (int i = 0; i < len; i++) {
            Object key = unseenKeys.anyKey();
            unseenKeys.remove(key);
            result[i] = key;
        }
        _checkForModification(expectedModCount);
        return result;
    }

    public boolean containsAll(Collection<?> c) {
        for (Object key : c) {
            if (!this.storage.hasKey(key))
                return false;
        }

        return true;
    }

    public boolean addAll(@NotNull Collection<?> c) {
        return _addAllElements(c);
    }

    @SuppressWarnings("ConstantValue")
    public boolean retainAll(@NotNull Collection<?> c) {
        if (c == null) {
            throw new NullPointerException();
        }
        int lengthBeforeAdd = this.storage.size();
        LibSLRuntime.Map<Object, Object> unseenKeys = this.storage.duplicate();
        int i = 0;
        while (i < lengthBeforeAdd) {
            Object key = unseenKeys.anyKey();
            unseenKeys.remove(key);
            if (!c.contains(key)) {
                this.storage.remove(key);
            }
            i++;
        }
        if (lengthBeforeAdd != this.storage.size()) {
            this.modCount++;
            return true;
        }

        return false;
    }

    public boolean removeIf(Predicate<? super Object> filter) {
        if (filter == null) {
            throw new NullPointerException();
        }
        int lengthBeforeAdd = this.storage.size();
        int expectedModCount = this.modCount;
        LibSLRuntime.Map<Object, Object> unseenKeys = this.storage.duplicate();
        int i = 0;
        while (i < lengthBeforeAdd) {
            Object key = unseenKeys.anyKey();
            unseenKeys.remove(key);
            if (filter.test(key)) {
                this.storage.remove(key);
            }
            i++;
        }
        _checkForModification(expectedModCount);
        if (lengthBeforeAdd != this.storage.size()) {
            this.modCount++;
            return true;
        }

        return false;
    }

    public void forEach(Consumer<? super Object> userAction) {
        if (userAction == null) {
            throw new NullPointerException();
        }
        int count = this.storage.size();
        int expectedModCount = this.modCount;
        LibSLRuntime.Map<Object, Object> unseenKeys = this.storage.duplicate();
        int i = 0;
        while (i < count) {
            Object key = unseenKeys.anyKey();
            unseenKeys.remove(key);
            userAction.accept(key);
            i++;
        }
        _checkForModification(expectedModCount);
    }

    public Stream<Object> stream() {
        return _makeStream(false);
    }

    public Stream<Object> parallelStream() {
        return _makeStream(true);
    }

    public String toString() {
        LibSLRuntime.Map<Object, Object> items = this.storage;
        int count = items.size();
        if (count == 0)
            return "[]";

        Engine.assume(count > 0);
        String result = "[";
        LibSLRuntime.Map<Object, Object> unseen = items.duplicate();
        while (count != 0) {
            Object key = unseen.anyKey();
            unseen.remove(key);
            result = result.concat(LibSLRuntime.toString(key));
            if (count > 1)
                result = result.concat(", ");
            count--;
        }

        return result.concat("]");
    }
}
