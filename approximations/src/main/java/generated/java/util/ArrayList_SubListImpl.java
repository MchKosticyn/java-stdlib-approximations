package generated.java.util;

import java.lang.Object;
import java.lang.String;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import generated.java.util.stream.StreamImpl;
import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;
import org.usvm.api.SymbolicList;
import runtime.LibSLRuntime;

@Approximate(stub.java.util.ArrayList_SubList.class)
public final class ArrayList_SubListImpl implements List<Object>, RandomAccess {

    public AbstractListImpl root;

    public ArrayList_SubListImpl parentList;

    public int offset;

    public int length;

    public int modCount;

    public ArrayList_SubListImpl(AbstractListImpl root, ArrayList_SubListImpl parent, int offset, int length, int modCount) {
        Engine.assume(root != null);
        this.root = root;
        this.parentList = parent;
        this.offset = offset;
        this.length = length;
        this.modCount = modCount;
    }

    @SuppressWarnings("unused")
    public ArrayList_SubListImpl(AbstractListImpl root, int fromIndex, int toIndex) {
        this(root, null, fromIndex, toIndex - fromIndex, 0);
    }

    @SuppressWarnings("unused")
    private ArrayList_SubListImpl(ArrayList_SubListImpl parent, int fromIndex, int toIndex) {
        this(null, parent, fromIndex, toIndex - fromIndex, 0);
    }

    private boolean _addAllElements(int index, Collection<?> c) {
        Engine.assume(root != null);
        int effectiveIndex = this.offset + index;
        this.root._checkValidIndex(effectiveIndex);
        int collectionSize = c.size();
        if (collectionSize == 0)
            return false;

        this.root._checkForComodification(this.modCount);
        this.root._addAllElements(effectiveIndex, c);
        _updateSizeAndModCount(collectionSize);
        return true;
    }

    public void _updateSizeAndModCount(int sizeChange) {
        Engine.assume(root != null);
        this.length += sizeChange;
        this.modCount = this.root.modCount;
        ArrayList_SubListImpl aList = this.parentList;
        while (aList != null) {
            aList.length += sizeChange;
            aList.modCount = this.modCount;
            aList = aList.parentList;
        }
    }

    private int _indexOfElement(Object o) {
        Engine.assume(root != null);
        this.root._checkForComodification(this.modCount);
        SymbolicList<Object> parentStorage = this.root.storage;
        int index = LibSLRuntime.ListActions.find(parentStorage, o, this.offset, this.offset + this.length);
        if (index != -1) {
            return index - this.offset;
        }

        return -1;
    }

    private Stream<Object> _makeStream(boolean parallel) {
        Engine.assume(root != null);
        this.root._checkForComodification(this.modCount);
        SymbolicList<Object> parentStorage = this.root.storage;
        int count = this.length;
        Object[] items = new Object[count];
        for (int i = 0; i < count; i++) {
            items[i] = parentStorage.get(this.offset + i);
        }

        return new StreamImpl(items, count, Engine.makeSymbolicList(), parallel, false);
    }

    private boolean _batchRemove(Collection<?> c, boolean complement) {
        Engine.assume(root != null);
        this.root._checkForComodification(this.modCount);
        if (this.length != 0) {
            int oldRootLength = this.root.storage.size();
            if (this.root._batchRemove(c, complement, this.offset, this.offset + this.length)) {
                int newRootLength = this.root.storage.size();
                _updateSizeAndModCount(newRootLength - oldRootLength);
                return true;
            }
        }

        return false;
    }

    public boolean add(Object e) {
        Engine.assume(root != null);
        this.root._checkForComodification(this.modCount);
        int effectiveIndex = this.offset + this.length;
        this.root._checkedAddElement(effectiveIndex, e);
        _updateSizeAndModCount(1);
        return true;
    }

    public void add(int index, Object element) {
        Engine.assume(root != null);
        this.root._checkForComodification(this.modCount);
        int effectiveIndex = this.offset + index;
        this.root._checkedAddElement(effectiveIndex, element);
        _updateSizeAndModCount(1);
    }

    public boolean addAll(@NotNull Collection c) {
        return _addAllElements(this.length, c);
    }

    public boolean addAll(int index, @NotNull Collection c) {
        return _addAllElements(index, c);
    }

    public void clear() {
        Engine.assume(root != null);
        this.root._checkForComodification(this.modCount);
        int size = this.length;
        if (size != 0) {
            Engine.assume(size > 0);
            int end = this.offset - 1;
            int start = end + size;
            SymbolicList<Object> rootStorage = this.root.storage;
            for (int i = start; i > end; i--) {
                rootStorage.remove(i);
            }
            this.root.modCount++;
            _updateSizeAndModCount(-size);
        }
    }

    public boolean contains(Object o) {
        return _indexOfElement(o) != -1;
    }

    public boolean containsAll(Collection<?> c) {
        if (c.isEmpty())
            return true;

        Engine.assume(root != null);
        SymbolicList<Object> rootStorage = this.root.storage;
        int end = this.offset + this.length;
        if ((c != null && c.getClass() == stub.java.util.ArrayList_SubList.class)) {
            ArrayList_SubListImpl otherSubList = (ArrayList_SubListImpl) c;
            AbstractListImpl otherRoot = otherSubList.root;
            Engine.assume(otherRoot != null);
            SymbolicList<Object> otherStorage = otherRoot.storage;
            int otherOffset = otherSubList.offset;
            int otherEnd = otherOffset + otherSubList.length;
            Engine.assume(otherStorage != null);
            Engine.assume(otherOffset >= 0);
            Engine.assume(otherEnd >= 0);
            int i = otherOffset;
            boolean result = true;
            while (result && (i < otherEnd)) {
                Object item = otherStorage.get(i);
                result = LibSLRuntime.ListActions.find(rootStorage, item, this.offset, end) != -1;
                i++;
            }
            return result;
        }

        Iterator<?> iter = c.iterator();
        boolean result = true;
        while (result && iter.hasNext()) {
            Object item = iter.next();
            result = LibSLRuntime.ListActions.find(rootStorage, item, this.offset, end) != -1;
        }
        return result;
    }

    @SuppressWarnings("DataFlowIssue")
    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (o != null && o.getClass() == stub.java.util.ArrayList_SubList.class) {
            Engine.assume(root != null);
            ArrayList_SubListImpl other = (ArrayList_SubListImpl) o;
            int otherLength = other.length;
            Engine.assume(otherLength >= 0);
            if (this.length == otherLength) {
                boolean result = this.root._equalsRange(other, this.offset, this.offset + this.length);
                this.root._checkForComodification(this.modCount);
                return result;
            }
        }

        return false;
    }

    public void forEach(Consumer<Object> _action) {
        if (this.length != 0) {
            Engine.assume(root != null);
            Engine.assume(this.length > 0);
            SymbolicList<Object> rootStorage = this.root.storage;
            int expectedModCount = this.root.modCount;
            this.modCount = expectedModCount;
            int i = this.offset;
            int end = this.offset + this.length;
            while ((i < end) && (this.root.modCount == expectedModCount)) {
                Object item = rootStorage.get(i);
                _action.accept(item);
                i++;
            }
            this.root._checkForComodification(expectedModCount);
        }
    }

    public Object get(int index) {
        Engine.assume(root != null);
        this.root._checkValidIndex(index, this.length);
        this.root._checkForComodification(this.modCount);
        int effectiveIndex = this.offset + index;

        return this.root.storage.get(effectiveIndex);
    }

    public int hashCode() {
        int result = 1;
        if (this.length != 0) {
            Engine.assume(root != null);
            Engine.assume(this.length > 0);
            SymbolicList<Object> rootStorage = this.root.storage;
            int end = this.offset + this.length;
            for (int i = this.offset; i < end; i++) {
                Object item = rootStorage.get(i);
                result = (31 * result) + LibSLRuntime.hashCode(item);
            }
            this.root._checkForComodification(this.modCount);
        }
        return result;
    }

    public int indexOf(Object o) {
        return _indexOfElement(o);
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    @NotNull
    public Iterator<Object> iterator() {
        return new ArrayList_SubList$ListIterator(this.root, this, 0, this.modCount, this.offset, this.length, -1);
    }

    public int lastIndexOf(Object o) {
        Engine.assume(root != null);
        this.root._checkForComodification(this.modCount);
        if (this.length == 0)
            return -1;

        Engine.assume(this.length > 0);
        int end = this.offset + this.length;
        SymbolicList<Object> rootStorage = this.root.storage;
        int result = LibSLRuntime.ListActions.find(rootStorage, o, this.offset, end);
        if (result != -1) {
            int nextIndex = result + 1;
            if (nextIndex < end) {
                int rightIndex = LibSLRuntime.ListActions.find(rootStorage, o, nextIndex, end);
                Engine.assume(rightIndex == -1);
            }
            result -= this.offset;
        }
        return result;
    }

    @NotNull
    public ListIterator<Object> listIterator() {
        return new ArrayList_SubList$ListIterator(this.root, this, 0, this.modCount, this.offset, this.length, -1);
    }

    @NotNull
    public ListIterator<Object> listIterator(int index) {
        return new ArrayList_SubList$ListIterator(this.root, this, index, this.modCount, this.offset, this.length, -1);
    }

    public Stream<Object> parallelStream() {
        return _makeStream(true);
    }

    public boolean remove(Object o) {
        Engine.assume(root != null);
        int end = this.offset + this.length;
        SymbolicList<Object> rootStorage = this.root.storage;
        int index = LibSLRuntime.ListActions.find(rootStorage, o, this.offset, end);
        if (index != -1) {
            this.root._checkForComodification(this.modCount);
            this.root._checkedDeleteElement(index);
            _updateSizeAndModCount(-1);
            return true;
        }
        return false;
    }

    public Object remove(int index) {
        Engine.assume(root != null);
        this.root._checkValidIndex(index, this.length);
        this.root._checkForComodification(this.modCount);
        int effectiveIndex = this.offset + index;
        Object result = this.root._checkedDeleteElement(effectiveIndex);
        _updateSizeAndModCount(-1);
        return result;
    }

    public boolean removeAll(@NotNull Collection<?> c) {
        return _batchRemove(c, false);
    }

    public boolean removeIf(Predicate filter) {
        Engine.assume(root != null);
        this.root._checkForComodification(this.modCount);
        int size = this.length;
        if (size != 0) {
            int oldRootLength = this.root.storage.size();
            if (this.root._removeIf(filter, this.offset, this.offset + this.length)) {
                int newRootLength = this.root.storage.size();
                _updateSizeAndModCount(newRootLength - oldRootLength);
                return true;
            }
        }

        return false;
    }

    public void replaceAll(UnaryOperator<Object> operator) {
        Engine.assume(root != null);
        this.root._replaceAllRange(operator, this.offset, this.offset + this.length);
    }

    public boolean retainAll(@NotNull Collection<?> c) {
        return _batchRemove(c, true);
    }

    public Object set(int index, Object element) {
        Engine.assume(root != null);
        this.root._checkValidIndex(index, this.length);
        this.root._checkForComodification(this.modCount);
        SymbolicList<Object> parentStorage = this.root.storage;
        int effectiveIndex = this.offset + index;
        Object oldValue = parentStorage.get(effectiveIndex);
        parentStorage.set(effectiveIndex, element);
        return oldValue;
    }

    public int size() {
        Engine.assume(root != null);
        this.root._checkForComodification(this.modCount);
        return this.length;
    }
    public void sort(Comparator<? super Object> c) {
        Engine.assume(root != null);
        this.root._do_sort(this.offset, this.offset + this.length, c);
        this.modCount = this.root.modCount;
    }
    public Spliterator<Object> spliterator() {
        return new ArrayList_SubList$Spliterator(this.root, this, 0, -1, 0);
    }

    public Stream<Object> stream() {
        return _makeStream(false);
    }

    @NotNull
    public List<Object> subList(int fromIndex, int toIndex) {
        Engine.assume(root != null);
        this.root._subListRangeCheck(fromIndex, toIndex, this.length);
        return new ArrayList_SubListImpl(this.root, this, this.offset + fromIndex, toIndex - fromIndex, this.modCount);
    }

    @NotNull
    public Object[] toArray() {
        Engine.assume(root != null);
        this.root._checkForComodification(this.modCount);
        Object[] result = new Object[this.length];
        SymbolicList<Object> rootStorage = this.root.storage;
        int end = this.offset + this.length;
        int j = 0;
        for (int i = this.offset; i < end; i++) {
            result[j] = rootStorage.get(i);
            j++;
        }

        return result;
    }

    @SuppressWarnings({"unused", "unchecked"})
    public Object[] toArray(IntFunction generator) {
        Object[] unused = ((Object[]) generator.apply(0));
        Engine.assume(root != null);
        this.root._checkForComodification(this.modCount);
        Object[] result = new Object[this.length];
        SymbolicList<Object> rootStorage = this.root.storage;
        int end = this.offset + this.length;
        int j = 0;
        for (int i = this.offset; i < end; i++) {
            result[j] = rootStorage.get(i);
            j++;
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    @NotNull
    public Object[] toArray(Object[] array) {
        Engine.assume(root != null);
        this.root._checkForComodification(this.modCount);
        int aSize = array.length;
        if (aSize < this.length) {
            array = new Object[this.length];
        }
        SymbolicList<Object> rootStorage = this.root.storage;
        int end = this.offset + this.length;
        int j = 0;
        for (int i = this.offset; i < end; i++) {
            array[j] = rootStorage.get(i);
            j++;
        }
        if (aSize > this.length) {
            array[this.length] = null;
        }

        return array;
    }

    public String toString() {
        if (this.length == 0)
            return "[]";

        String result = "[";
        Engine.assume(root != null);
        SymbolicList<Object> rootStorage = this.root.storage;
        int end = this.offset + this.length;
        int counter = this.length;
        for (int i = this.offset; i < end; i++) {
            Object item = rootStorage.get(i);
            result = result.concat(LibSLRuntime.toString(item));
            counter--;
            if (counter != 0) {
                result = result.concat(", ");
            }
        }

        return result.concat("]");
    }
}
