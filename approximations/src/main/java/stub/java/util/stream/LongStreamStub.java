package stub.java.util.stream;

import org.jetbrains.annotations.NotNull;

import java.lang.LinkageError;
import java.lang.Object;
import java.lang.Runnable;
import java.util.LongSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalLong;
import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class LongStreamStub extends BaseStreamStub implements LongStream {

    @NotNull
    public LongStreamStub filter(@NotNull LongPredicate predicate) {
        throw new LinkageError();
    }

    @NotNull
    public LongStreamStub map(@NotNull LongUnaryOperator mapper) {
        throw new LinkageError();
    }

    @NotNull
    @SuppressWarnings("unchecked")
    public Stream<Object> mapToObj(@NotNull LongFunction mapper) {
        throw new LinkageError();
    }

    @NotNull
    public IntStream mapToInt(@NotNull LongToIntFunction mapper) {
        throw new LinkageError();
    }

    @NotNull
    public DoubleStream mapToDouble(@NotNull LongToDoubleFunction mapper) {
        throw new LinkageError();
    }

    @NotNull
    public LongStreamStub flatMap(@NotNull LongFunction mapper) {
        throw new LinkageError();
    }

    @NotNull
    public LongStreamStub sorted() {
        throw new LinkageError();
    }

    @NotNull
    public LongStreamStub distinct() {
        throw new LinkageError();
    }

    @NotNull
    public LongStreamStub peek(@NotNull LongConsumer _action) {
        throw new LinkageError();
    }

    @NotNull
    public LongStreamStub limit(long maxSize) {
        throw new LinkageError();
    }

    @NotNull
    public LongStreamStub skip(long n) {
        throw new LinkageError();
    }

    public void forEach(LongConsumer _action) {
        throw new LinkageError();
    }

    public void forEachOrdered(LongConsumer _action) {
        throw new LinkageError();
    }

    public long[] toArray() {
        throw new LinkageError();
    }

    public long reduce(long identity, LongBinaryOperator accumulator) {
        throw new LinkageError();
    }

    public OptionalLong reduce(LongBinaryOperator accumulator) {
        throw new LinkageError();
    }

    @SuppressWarnings("unchecked")
    public Object collect(Supplier supplier, ObjLongConsumer accumulator, BiConsumer combiner) {
        throw new LinkageError();
    }

    public OptionalLong min() {
        throw new LinkageError();
    }

    public OptionalLong max() {
        throw new LinkageError();
    }

    public long count() {
        throw new LinkageError();
    }

    public boolean anyMatch(LongPredicate predicate) {
        throw new LinkageError();
    }

    public boolean allMatch(LongPredicate predicate) {
        throw new LinkageError();
    }

    public boolean noneMatch(LongPredicate predicate) {
        throw new LinkageError();
    }

    public OptionalLong findFirst() {
        throw new LinkageError();
    }

    public OptionalLong findAny() {
        throw new LinkageError();
    }

    @NotNull
    public PrimitiveIterator.OfLong iterator() {
        throw new LinkageError();
    }

    @NotNull
    public Spliterator.OfLong spliterator() {
        throw new LinkageError();
    }

    public boolean isParallel() {
        throw new LinkageError();
    }

    @NotNull
    public LongStreamStub sequential() {
        throw new LinkageError();
    }

    @NotNull
    public LongStreamStub parallel() {
        throw new LinkageError();
    }

    @NotNull
    public LongStreamStub unordered() {
        throw new LinkageError();
    }

    @NotNull
    public LongStreamStub onClose(@NotNull Runnable closeHandler) {
        throw new LinkageError();
    }

    public void close() {
        throw new LinkageError();
    }

    @NotNull
    public LongStreamStub dropWhile(@NotNull LongPredicate predicate) {
        throw new LinkageError();
    }

    @NotNull
    public LongStreamStub takeWhile(@NotNull LongPredicate predicate) {
        throw new LinkageError();
    }

    public DoubleStream asDoubleStream() {
        throw new LinkageError();
    }

    public long sum() {
        throw new LinkageError();
    }

    public OptionalDouble average() {
        throw new LinkageError();
    }

    public LongSummaryStatistics summaryStatistics() {
        throw new LinkageError();
    }

    public Stream<Long> boxed() {
        throw new LinkageError();
    }
}
