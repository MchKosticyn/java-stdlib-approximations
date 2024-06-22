package generated.java.util;

import java.io.Serial;
import java.lang.Object;
import java.lang.String;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;
import org.usvm.api.SymbolicList;
import runtime.LibSLRuntime;

@Approximate(java.util.LinkedList.class)
public class LinkedListImpl extends AbstractListImpl implements Deque<Object> {

    @Serial
    private static final long serialVersionUID = 876323262645176354L;

    static {
        Engine.assume(true);
    }

    @SuppressWarnings("unused")
    public LinkedListImpl(SymbolicList<Object> storage, int modCount) {
        super(storage, modCount);
    }

    @SuppressWarnings("unused")
    public LinkedListImpl() {
        super();
    }

    @SuppressWarnings("unused")
    public LinkedListImpl(Collection<?> c) {
        super(c);
    }

    private Object _unlinkFirst() {
        if (!_isValidIndex(0)) {
            throw new NoSuchElementException();
        }

        return _deleteElement(0);
    }

    private Object _getFirstElement() {
        if (!_isValidIndex(0)) {
            throw new NoSuchElementException();
        }

        return _get(0);
    }

    public boolean add(Object e) {
        return super.add(e);
    }

    public void add(int index, Object element) {
        super.add(index, element);
    }

    public boolean addAll(@NotNull Collection c) {
        return super.addAll(c);
    }

    public boolean addAll(int index, @NotNull Collection c) {
        return super.addAll(index, c);
    }

    public void addFirst(Object e) {
        _addElement(0, e);
    }

    public void addLast(Object e) {
        _addElement(storage.size(), e);
    }

    public void clear() {
        super.clear();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean contains(Object o) {
        return super.contains(o);
    }

    @SuppressWarnings("SlowListContainsAll")
    public boolean containsAll(@NotNull Collection<?> c) {
        return super.containsAll(c);
    }

    @NotNull
    public Iterator<Object> descendingIterator() {
        return new LinkedList_DescendingIterator(this, this.storage.size(), this.modCount, -1);
    }

    public Object element() {
        return _getFirstElement();
    }

    public boolean equals(Object o) {
        return o.getClass() == java.util.LinkedList.class && super.equals(o);
    }

    public void forEach(Consumer<? super Object> _action) {
        super.forEach(_action);
    }

    public Object get(int index) {
        return super.get(index);
    }

    public Object getFirst() {
        return _getFirstElement();
    }

    public Object getLast() {
        return super.get(this.storage.size() - 1);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public int indexOf(Object o) {
        return super.indexOf(o);
    }

    public boolean isEmpty() {
        return super.isEmpty();
    }

    @NotNull
    public Iterator<Object> iterator() {
        return super.iterator();
    }

    public int lastIndexOf(Object o) {
        return super.lastIndexOf(o);
    }

    @NotNull
    public ListIterator<Object> listIterator() {
        return super.listIterator();
    }

    @NotNull
    public ListIterator<Object> listIterator(int index) {
        return super.listIterator(index);
    }

    public boolean offer(Object e) {
        return add(e);
    }

    public boolean offerFirst(Object e) {
        addFirst(e);
        return true;
    }

    public boolean offerLast(Object e) {
        addLast(e);
        return true;
    }

    public Stream<Object> parallelStream() {
        return super.parallelStream();
    }

    public Object peek() {
        if (this.storage.size() == 0)
            return null;

        return _get(0);
    }

    public Object peekFirst() {
        return peek();
    }

    public Object peekLast() {
        int size = this.storage.size();
        if (size == 0)
            return null;

        return _get(size - 1);
    }

    public Object poll() {
        if (this.storage.size() == 0)
            return null;

        return _deleteElement(0);
    }

    public Object pollFirst() {
        return poll();
    }

    public Object pollLast() {
        int size = this.storage.size();
        if (size == 0)
            return null;

        return _deleteElement(size - 1);
    }

    public Object pop() {
        return _unlinkFirst();
    }

    public void push(Object e) {
        _addElement(0, e);
    }

    public Object remove() {
        return _unlinkFirst();
    }

    public boolean remove(Object o) {
        return super.remove(o);
    }

    public Object remove(int index) {
        return super.remove(index);
    }

    public boolean removeAll(@NotNull Collection<?> c) {
        return super.removeAll(c);
    }

    public Object removeFirst() {
        return remove();
    }

    public boolean removeFirstOccurrence(Object o) {
        return remove(o);
    }

    public boolean removeIf(Predicate<? super Object> filter) {
        return super.removeIf(filter);
    }

    public Object removeLast() {
        int size = this.storage.size();
        if (size == 0) {
            throw new NoSuchElementException();
        }

        return _deleteElement(size - 1);
    }

    public boolean removeLastOccurrence(Object o) {
        int size = this.storage.size();
        if (size == 0)
            return false;

        Engine.assume(size > 0);
        int index;
        for (index = size - 1; index >= 0; index--) {
            Object item = this.storage.get(index);
            if (LibSLRuntime.equals(item, o)) {
                break;
            }
        }

        if (index != -1) {
            this.storage.remove(index);
            this.modCount++;
            return true;
        }

        return false;
    }

    public void replaceAll(UnaryOperator<Object> op) {
        super.replaceAll(op);
    }

    public boolean retainAll(@NotNull Collection c) {
        return super.retainAll(c);
    }

    public Object set(int index, Object element) {
        return super.set(index, element);
    }

    public int size() {
        return super.size();
    }

    public void sort(Comparator<? super Object> c) {
        super.sort(c);
    }

    public Spliterator<Object> spliterator() {
        return super.spliterator();
    }

    public Stream<Object> stream() {
        return super.stream();
    }

    @NotNull
    public List<Object> subList(int fromIndex, int toIndex) {
        return super.subList(fromIndex, toIndex);
    }

    @NotNull
    public Object[] toArray() {
        return super.toArray();
    }

    @SuppressWarnings("unchecked")
    public Object[] toArray(IntFunction generator) {
        return super.toArray(generator);
    }

    @NotNull
    @SuppressWarnings("unchecked")
    public Object[] toArray(Object[] a) {
        return super.toArray(a);
    }

    public String toString() {
        return super.toString();
    }
}
