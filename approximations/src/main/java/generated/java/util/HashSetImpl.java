package generated.java.util;

import java.io.Serial;
import java.lang.Object;
import java.lang.String;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;

@Approximate(java.util.HashSet.class)
public class HashSetImpl extends AbstractSetImpl {

    @Serial
    private static final long serialVersionUID = -5024744406713321676L;

    static {
        Engine.assume(true);
    }

    @SuppressWarnings("unused")
    public HashSetImpl(LibSLRuntime.Map<Object, Object> storage, int modCount) {
        super(storage, modCount);
    }

    public HashSetImpl() {
        super();
    }

    @SuppressWarnings("unused")
    public HashSetImpl(Collection<?> c) {
        super(c);
    }

    @SuppressWarnings("unused")
    public HashSetImpl(int initialCapacity) {
        super(initialCapacity);
    }

    @SuppressWarnings("unused")
    public HashSetImpl(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    @SuppressWarnings("unused")
    private HashSetImpl(int initialCapacity, float loadFactor, boolean dummy) {
        super(initialCapacity, loadFactor, dummy);
    }

    public boolean add(Object obj) {
        return super.add(obj);
    }

    public void clear() {
        super.clear();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean contains(Object obj) {
        return super.contains(obj);
    }

    public boolean isEmpty() {
        return super.isEmpty();
    }

    @NotNull
    public Iterator<Object> iterator() {
        return super.iterator();
    }

    public boolean remove(Object obj) {
        return super.remove(obj);
    }

    public int size() {
        return super.size();
    }

    public Spliterator<Object> spliterator() {
        return super.spliterator();
    }

    public boolean equals(Object other) {
        return other.getClass() == java.util.HashSet.class && super.equals(other);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean removeAll(@NotNull Collection<?> c) {
        return super.removeAll(c);
    }

    @NotNull
    public Object[] toArray() {
        return super.toArray();
    }

    @NotNull
    public Object[] toArray(Object[] a) {
        return super.toArray(a);
    }

    public Object[] toArray(IntFunction generator) {
        return super.toArray(generator);
    }

    public boolean containsAll(Collection<?> c) {
        return super.containsAll(c);
    }

    public boolean addAll(@NotNull Collection<?> c) {
        return super.addAll(c);
    }

    public boolean retainAll(@NotNull Collection<?> c) {
        return super.retainAll(c);
    }

    public boolean removeIf(Predicate<? super Object> filter) {
        return super.removeIf(filter);
    }

    public void forEach(Consumer<? super Object> userAction) {
        super.forEach(userAction);
    }

    public Stream<Object> stream() {
        return super.stream();
    }

    public Stream<Object> parallelStream() {
        return super.parallelStream();
    }

    public String toString() {
        return super.toString();
    }
}
