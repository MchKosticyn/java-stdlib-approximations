package generated.java.util;

import java.io.Serial;
import java.lang.Object;
import java.lang.String;
import java.util.*;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;
import org.usvm.api.SymbolicList;

@SuppressWarnings("unused")
@Approximate(java.util.ArrayList.class)
public class ArrayListImpl extends AbstractListImpl implements RandomAccess {

    @Serial
    private static final long serialVersionUID = 8683452581122892189L;

    static {
        Engine.assume(true);
    }

    @SuppressWarnings("unused")
    public ArrayListImpl(SymbolicList<Object> storage, int modCount) {
        super(storage, modCount);
    }

    @SuppressWarnings("unused")
    public ArrayListImpl() {
        super();
    }

    @SuppressWarnings("unused")
    public ArrayListImpl(Collection<?> c) {
        super(c);
    }

    @SuppressWarnings("unused")
    public ArrayListImpl(int initialCapacity) {
        super(initialCapacity);
    }

    public boolean add(Object e) {
        return super.add(e);
    }

    public void add(int index, Object element) {
        super.add(index, element);
    }

    public boolean addAll(@NotNull Collection<?> c) {
        return super.addAll(c);
    }

    public boolean addAll(int index, @NotNull Collection<?> c) {
        return super.addAll(index, c);
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

    public void ensureCapacity(int minCapacity) {
        super.ensureCapacity(minCapacity);
    }

    public boolean equals(Object other) {
        return other.getClass() == java.util.ArrayList.class && super.equals(other);
    }

    public void forEach(Consumer<? super Object> _action) {
        super.forEach(_action);
    }

    public Object get(int index) {
        return super.get(index);
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

    public Stream<Object> parallelStream() {
        return super.parallelStream();
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

    public boolean removeIf(Predicate<Object> filter) {
        return super.removeIf(filter);
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

    public Object[] toArray(IntFunction generator) {
        return super.toArray(generator);
    }

    @NotNull
    public Object[] toArray(Object[] array) {
        return super.toArray(array);
    }

    public String toString() {
        return super.toString();
    }

    public void trimToSize() {
        super.trimToSize();
    }
}
