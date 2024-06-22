package stub.java.util.stream;

import org.jetbrains.annotations.NotNull;

import java.lang.LinkageError;
import java.lang.Object;
import java.lang.Runnable;
import java.lang.Void;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collector;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamLSL implements Stream<Object> {

    @SuppressWarnings("unused")
    private StreamLSL(Void a, Void b) {
        super();
    }

    public Stream<Object> filter(Predicate predicate) {
        throw new LinkageError();
    }

    public <T> Stream<T> map(Function<? super Object, ? extends T> mapper) {
        throw new LinkageError();
    }

    public IntStream mapToInt(ToIntFunction mapper) {
        throw new LinkageError();
    }

    public LongStream mapToLong(ToLongFunction mapper) {
        throw new LinkageError();
    }

    public DoubleStream mapToDouble(ToDoubleFunction mapper) {
        throw new LinkageError();
    }

    public <T> Stream<T> flatMap(Function<? super Object, ? extends Stream<? extends T>> mapper) {
        throw new LinkageError();
    }

    public IntStream flatMapToInt(Function mapper) {
        throw new LinkageError();
    }

    public LongStream flatMapToLong(Function mapper) {
        throw new LinkageError();
    }

    public DoubleStream flatMapToDouble(Function mapper) {
        throw new LinkageError();
    }

    public Stream<Object> distinct() {
        throw new LinkageError();
    }

    public Stream<Object> sorted() {
        throw new LinkageError();
    }

    public Stream<Object> sorted(Comparator<? super Object> comparator) {
        throw new LinkageError();
    }

    public Stream<Object> peek(Consumer _action) {
        throw new LinkageError();
    }

    public Stream<Object> limit(long maxSize) {
        throw new LinkageError();
    }

    public Stream<Object> skip(long n) {
        throw new LinkageError();
    }

    public void forEach(Consumer _action) {
        throw new LinkageError();
    }

    public void forEachOrdered(Consumer _action) {
        throw new LinkageError();
    }

    @NotNull
    public Object[] toArray() {
        throw new LinkageError();
    }

    @SuppressWarnings("unchecked")
    @NotNull
    public Object[] toArray(IntFunction generator) {
        throw new LinkageError();
    }

    public Object reduce(Object identity, BinaryOperator accumulator) {
        throw new LinkageError();
    }

    @NotNull
    public Optional<Object> reduce(BinaryOperator accumulator) {
        throw new LinkageError();
    }

    @SuppressWarnings("unchecked")
    public Object reduce(Object identity, BiFunction accumulator, BinaryOperator combiner) {
        throw new LinkageError();
    }

    @SuppressWarnings("unchecked")
    public Object collect(Supplier supplier, BiConsumer accumulator, BiConsumer combiner) {
        throw new LinkageError();
    }

    @SuppressWarnings("unchecked")
    public Object collect(Collector collector) {
        throw new LinkageError();
    }

    @NotNull
    public Optional<Object> min(Comparator comparator) {
        throw new LinkageError();
    }

    @NotNull
    public Optional<Object> max(Comparator comparator) {
        throw new LinkageError();
    }

    public long count() {
        throw new LinkageError();
    }

    public boolean anyMatch(Predicate predicate) {
        throw new LinkageError();
    }

    public boolean allMatch(Predicate predicate) {
        throw new LinkageError();
    }

    public boolean noneMatch(Predicate predicate) {
        throw new LinkageError();
    }

    @NotNull
    public Optional<Object> findFirst() {
        throw new LinkageError();
    }

    @NotNull
    public Optional<Object> findAny() {
        throw new LinkageError();
    }

    @NotNull
    public Iterator<Object> iterator() {
        throw new LinkageError();
    }

    @NotNull
    public Spliterator<Object> spliterator() {
        throw new LinkageError();
    }

    public boolean isParallel() {
        throw new LinkageError();
    }

    @NotNull
    public Stream<Object> sequential() {
        throw new LinkageError();
    }

    @NotNull
    public Stream<Object> parallel() {
        throw new LinkageError();
    }

    @NotNull
    public Stream<Object> unordered() {
        throw new LinkageError();
    }

    @NotNull
    public Stream<Object> onClose(@NotNull Runnable unused) {
        throw new LinkageError();
    }

    public void close() {
        throw new LinkageError();
    }

    public Stream<Object> dropWhile(Predicate predicate) {
        throw new LinkageError();
    }

    public Stream<Object> takeWhile(Predicate predicate) {
        throw new LinkageError();
    }
}
