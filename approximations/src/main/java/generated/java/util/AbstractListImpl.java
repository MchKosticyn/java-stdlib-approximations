package generated.java.util;

import java.io.Serializable;
import java.lang.Cloneable;
import java.lang.Comparable;
import java.lang.IllegalArgumentException;
import java.lang.IndexOutOfBoundsException;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.String;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import generated.java.util.stream.StreamStubImpl;
import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;
import org.usvm.api.SymbolicList;
import runtime.LibSLRuntime;
import stub.java.util.SubListStub;

@Approximate(java.util.AbstractList.class)
public class AbstractListImpl implements List<Object>, Cloneable, Serializable {

    public SymbolicList<Object> storage;

    public transient int modCount;

    public AbstractListImpl(SymbolicList<Object> storage, int modCount) {
        this.storage = storage;
        this.modCount = modCount;
    }

    public AbstractListImpl() {
        this(Engine.makeSymbolicList(), 0);
    }

    @SuppressWarnings("unused")
    public AbstractListImpl(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException();
        }
        this.storage = Engine.makeSymbolicList();
        this.modCount = 0;
        _addAllElements(0, c);
    }

    @SuppressWarnings("unused")
    public AbstractListImpl(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException();
        }
        this.storage = Engine.makeSymbolicList();
        this.modCount = 0;
    }

    public boolean _isValidIndex(int index, int length) {
        return index >= 0 && index < length;
    }

    public boolean _isValidIndex(int index) {
        return _isValidIndex(index, storage.size());
    }

    public void _checkValidIndex(int index, int length) {
        if (!_isValidIndex(index, length)) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void _checkValidIndex(int index) {
        _checkValidIndex(index, storage.size());
    }

    public boolean _isValidAddIndex(int index) {
        return index >= 0 && index <= storage.size();
    }

    public void _checkValidAddIndex(int index) {
        if (!_isValidAddIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
    }

    @SuppressWarnings("DataFlowIssue")
    public boolean _addAllElements(int index, Collection<?> c) {
        int oldLength = this.storage.size();
        if (c instanceof List) {
            SymbolicList<Object> otherStorage = ((AbstractListImpl) c).storage;
            Engine.assume(otherStorage != null);
            int otherLength = otherStorage.size();
            Engine.assume(otherLength >= 0);
            for (int i = 0; i < otherLength; i++) {
                Object item = otherStorage.get(i);
                this.storage.insert(index, item);
                index++;
            }
        } else {
            for (Object item : c) {
                this.storage.insert(index, item);
                index++;
            }
        }

        this.modCount++;
        return oldLength != this.storage.size();
    }

    public boolean _checkedAddAllElements(int index, Collection<?> c) {
        _checkValidAddIndex(index);
        return _addAllElements(index, c);
    }

    public void _subListRangeCheck(int fromIndex, int toIndex, int size) {
        if (fromIndex < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (toIndex > size) {
            throw new IndexOutOfBoundsException();
        }
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException();
        }
    }

    public void _checkForModification(int expectedModCount) {
        if (this.modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }

    public Object _deleteElement(int index) {
        Object result = this.storage.get(index);
        this.storage.remove(index);
        this.modCount++;
        return result;
    }

    public Object _checkedDeleteElement(int index) {
        _checkValidIndex(index);
        return _deleteElement(index);
    }

    public void _addElement(int index, Object element) {
        this.storage.insert(index, element);
        this.modCount++;
    }

    public void _checkedAddElement(int index, Object element) {
        _checkValidAddIndex(index);
        _addElement(index, element);
    }

    public Object _setElement(int index, Object element) {
        Object oldValue = this.storage.get(index);
        this.storage.set(index, element);
        return oldValue;
    }

    public Object _checkedSetElement(int index, Object element) {
        _checkValidIndex(index);
        return _setElement(index, element);
    }

    public Object _get(int index) {
        return this.storage.get(index);
    }

    public Object _checkedGet(int index) {
        _checkValidIndex(index);
        return this.storage.get(index);
    }

    public void _replaceAllRange(UnaryOperator<Object> op, int i, int end) {
        int expectedModCount = this.modCount;
        while ((this.modCount == expectedModCount) && (i < end)) {
            Object oldItem = this.storage.get(i);
            Object newItem = op.apply(oldItem);
            this.storage.set(i, newItem);
            i++;
        }
        _checkForModification(expectedModCount);
    }

    public boolean _removeIf(Predicate<Object> filter, int start, int end) {
        if (filter == null) {
            throw new NullPointerException();
        }
        int oldLength = this.storage.size();
        int expectedModCount = this.modCount;
        Engine.assume(start <= end);
        for (int i = end - 1; i > start; i--) {
            Object item = this.storage.get(i);
            if (filter.test(item)) {
                this.storage.remove(i);
            }
        }
        _checkForModification(expectedModCount);
        return oldLength != this.storage.size();
    }

    @SuppressWarnings("DataFlowIssue")
    public boolean _equalsRange(List<Object> other, int from, int to) {
        if (other instanceof SubListStub) {
            SubListStubImpl otherSubList = (SubListStubImpl) other;
            AbstractListImpl otherRoot = otherSubList.root;
            SymbolicList<Object> otherStorage = otherRoot.storage;
            if (to != otherSubList.length)
                return false;

            boolean result = true;
            int i = from;
            while (result && (i < to)) {
                Object a = otherStorage.get(i);
                Object b = this.storage.get(i);
                result = LibSLRuntime.equals(a, b);
                i++;
            }
            return result;
        }

        if (other instanceof List) {
            SymbolicList<Object> otherStorage = ((AbstractListImpl) other).storage;
            if (to != otherStorage.size())
                return false;

            boolean result = true;
            int i = from;
            while (result && (i < to)) {
                Object a = otherStorage.get(i);
                Object b = this.storage.get(i);
                result = LibSLRuntime.equals(a, b);
                i++;
            }
            return result;
        }

        Iterator<Object> iter = other.iterator();
        boolean result = true;
        int i = from;
        while (result && (i < to) && iter.hasNext()) {
            Object a = iter.next();
            Object b = this.storage.get(i);
            result = LibSLRuntime.equals(a, b);
            i++;
        }

        return result && !iter.hasNext();
    }

    private Stream<Object> _makeStream(boolean parallel) {
        int count = this.storage.size();
        Object[] items = new Object[count];
        for (int i = 0; i < count; i++) {
            items[i] = this.storage.get(i);
        }

        return new StreamStubImpl(items, count, Engine.makeSymbolicList(), parallel, false);
    }

    @SuppressWarnings({"ConstantValue"})
    public boolean _batchRemove(Collection<?> c, boolean complement, int start, int end) {
        if (c == null) {
            throw new NullPointerException();
        }
        int oldLength = this.storage.size();
        if ((oldLength == 0) || (start >= end))
            return false;

        int otherLength = c.size();
        if (otherLength == 0) {
            if (!complement)
                return false;

            this.storage = Engine.makeSymbolicList();
            this.modCount++;
            return true;
        }

        Engine.assume(otherLength > 0);
        start--;
        end--;
        if (c instanceof List) {
            SymbolicList<Object> otherStorage = ((AbstractListImpl) c).storage;
            Engine.assume(otherStorage != null);
            boolean changed = false;
            for (int i = end; i > start; i--) {
                Object item = this.storage.get(i);
                int storageSize = this.storage.size();
                if ((LibSLRuntime.ListActions.find(otherStorage, item, 0, storageSize) == -1) == complement) {
                    _checkedDeleteElement(i);
                    changed = true;
                }
            }
            return changed;
        }

        boolean changed = false;
        for (int i = end; i > start; i--) {
            Object item = this.storage.get(i);
            if (c.contains(item) != complement) {
                _checkedDeleteElement(i);
                changed = true;
            }
        }

        return changed;
    }

    @SuppressWarnings("unchecked")
    public void _do_sort(int start, int end, Comparator<Object> c) {
        if (start >= end) {
            this.modCount++;
            return;
        }
        int expectedModCount = this.modCount;
        Engine.assume(start >= 0);
        Engine.assume(end > 0);
        int outerLimit = end - 1;
        for (int i = start; i < outerLimit; i++) {
            int innerLimit = (end - i) - 1;
            for (int j = start; j < innerLimit; j++) {
                int idxB = j + 1;
                Object a = this.storage.get(j);
                Object b = this.storage.get(idxB);
                if (c != null && c.compare(a, b) > 0 || c == null && ((Comparable<Object>) a).compareTo(b) > 0) {
                    this.storage.set(j, b);
                    this.storage.set(idxB, a);
                }
            }
        }
        _checkForModification(expectedModCount);
    }

    public boolean add(Object e) {
        this.storage.insert(this.storage.size(), e);
        this.modCount++;
        return true;
    }

    public void add(int index, Object element) {
        _checkedAddElement(index, element);
    }

    public boolean addAll(@NotNull Collection<?> c) {
        return _addAllElements(this.storage.size(), c);
    }

    public boolean addAll(int index, @NotNull Collection<?> c) {
        return _checkedAddAllElements(index, c);
    }

    public void clear() {
        this.storage = Engine.makeSymbolicList();
        this.modCount++;
    }

    public Object clone() throws CloneNotSupportedException {
        AbstractListImpl clonedList = (AbstractListImpl) super.clone();
        SymbolicList<Object> storageCopy = Engine.makeSymbolicList();
        this.storage.copy(storageCopy, 0, 0, this.storage.size());
        clonedList.storage = storageCopy;
        clonedList.modCount = 0;
        return clonedList;
    }

    public boolean contains(Object o) {
        return LibSLRuntime.ListActions.find(this.storage, o, 0, this.storage.size()) != -1;
    }

    @SuppressWarnings("DataFlowIssue")
    public boolean containsAll(@NotNull Collection<?> c) {
        if (c instanceof List) {
            SymbolicList<Object> otherStorage = ((AbstractListImpl) c).storage;
            Engine.assume(otherStorage != null);
            int otherLength = otherStorage.size();
            Engine.assume(otherLength >= 0);
            boolean result = true;
            int i = 0;
            while (result && (i < otherLength)) {
                Object item = otherStorage.get(i);
                result = LibSLRuntime.ListActions.find(this.storage, item, 0, this.storage.size()) != -1;
                i++;
            }
            return result;
        }

        boolean result = true;
        Iterator<?> iter = c.iterator();
        while (result && iter.hasNext()) {
            Object item = iter.next();
            result = LibSLRuntime.ListActions.find(this.storage, item, 0, this.storage.size()) != -1;
        }

        return result;
    }

    @SuppressWarnings("unused")
    public void ensureCapacity(int minCapacity) {
        this.modCount++;
    }

    public boolean equals(Object other) {
        if (other == this)
            return true;

        if (other instanceof List) {
            AbstractListImpl otherList = (AbstractListImpl) other;
            int expectedModCount = this.modCount;
            int otherExpectedModCount = otherList.modCount;
            SymbolicList<Object> otherStorage = otherList.storage;
            int size = this.storage.size();
            int otherSize = otherStorage.size();
            boolean result = size == otherSize && LibSLRuntime.equals(this.storage, otherStorage);
            otherList._checkForModification(otherExpectedModCount);
            _checkForModification(expectedModCount);
            return result;
        }

        return false;
    }

    public void forEach(Consumer<? super Object> _action) {
        if (_action == null) {
            throw new NullPointerException();
        }
        int expectedModCount = this.modCount;
        int i = 0;
        while ((this.modCount == expectedModCount) && (i < this.storage.size())) {
            Object item = this.storage.get(i);
            _action.accept(item);
            i++;
        }
        _checkForModification(expectedModCount);
    }

    public Object get(int index) {
        return _checkedGet(index);
    }

    public int hashCode() {
        return LibSLRuntime.hashCode(this.storage);
    }

    public int indexOf(Object o) {
        return LibSLRuntime.ListActions.find(this.storage, o, 0, this.storage.size());
    }

    public boolean isEmpty() {
        return this.storage.size() == 0;
    }

    @NotNull
    public Iterator<Object> iterator() {
        return new ListIteratorStubImpl(this, 0, this.modCount, -1);
    }

    public int lastIndexOf(Object o) {
        int size = this.storage.size();
        if (size != 0) {
            Engine.assume(size > 0);
            SymbolicList<Object> items = this.storage;
            for (int i = size - 1; i > -1; i--) {
                Object e = items.get(i);
                if (LibSLRuntime.equals(o, e)) {
                    return i;
                }
            }
        }
        return -1;
    }

    @NotNull
    public ListIterator<Object> listIterator() {
        return new ListIteratorStubImpl(this, 0, this.modCount, -1);
    }

    @NotNull
    public ListIterator<Object> listIterator(int index) {
        _checkValidIndex(index);
        return new ListIteratorStubImpl(this, index, this.modCount, -1);
    }

    public Stream<Object> parallelStream() {
        return _makeStream(true);
    }

    public boolean remove(Object o) {
        int index = LibSLRuntime.ListActions.find(this.storage, o, 0, this.storage.size());
        if (index != -1) {
            _deleteElement(index);
            return true;
        }

        return false;
    }

    public Object remove(int index) {
        return _checkedDeleteElement(index);
    }

    public boolean removeAll(@NotNull Collection<?> c) {
        return _batchRemove(c, false, 0, this.storage.size());
    }

    public boolean removeIf(Predicate<Object> filter) {
        return _removeIf(filter, 0, this.storage.size());
    }

    public void replaceAll(UnaryOperator<Object> op) {
        if (op == null) {
            throw new NullPointerException();
        }
        _replaceAllRange(op, 0, this.storage.size());
        this.modCount++;
    }

    public boolean retainAll(@NotNull Collection c) {
        return _batchRemove(c, true, 0, this.storage.size());
    }

    public Object set(int index, Object element) {
        return _checkedSetElement(index, element);
    }

    public int size() {
        return this.storage.size();
    }

    public void sort(Comparator<? super Object> c) {
        _do_sort(0, this.storage.size(), c);
    }

    public Spliterator<Object> spliterator() {
        return new SpliteratorStubImpl(this, 0, -1, 0);
    }

    public Stream<Object> stream() {
        return _makeStream(false);
    }

    @NotNull
    public List<Object> subList(int fromIndex, int toIndex) {
        _subListRangeCheck(fromIndex, toIndex, this.storage.size());
        return new SubListStubImpl(this, null, fromIndex, toIndex - fromIndex, this.modCount);
    }

    @NotNull
    public Object[] toArray() {
        int len = this.storage.size();
        Object[] result = new Object[len];
        for (int i = 0; i < len; i++) {
            result[i] = this.storage.get(i);
        }
        return result;
    }

    @SuppressWarnings({"unchecked", "unused"})
    public Object[] toArray(IntFunction generator) {
        Object[] unused = ((Object[]) generator.apply(0));
        int len = this.storage.size();
        Object[] result = new Object[len];
        for (int i = 0; i < len; i++) {
            result[i] = this.storage.get(i);
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
        for (int i = 0; i < len; i++) {
            array[i] = this.storage.get(i);
        }
        if (aLen > len) {
            array[len] = null;
        }
        return array;
    }

    public String toString() {
        return LibSLRuntime.toString(this.storage);
    }

    @SuppressWarnings("unused")
    public void trimToSize() {
        this.modCount++;
    }
}
