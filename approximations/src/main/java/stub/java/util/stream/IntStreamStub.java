package stub.java.util.stream;

import java.lang.LinkageError;
import java.lang.Object;
import java.lang.Runnable;
import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.jetbrains.annotations.NotNull;

public class IntStreamStub extends BaseStreamStub implements IntStream {

    @NotNull
    public IntStreamStub filter(@NotNull IntPredicate predicate) {
        throw new LinkageError();
    }

    @NotNull
    public IntStreamStub map(@NotNull IntUnaryOperator mapper) {
        throw new LinkageError();
    }

    @NotNull
    @SuppressWarnings("unchecked")
    public Stream<Object> mapToObj(@NotNull IntFunction mapper) {
        throw new LinkageError();
    }

    @NotNull
    public LongStream mapToLong(@NotNull IntToLongFunction mapper) {
        throw new LinkageError();
    }

    @NotNull
    public DoubleStream mapToDouble(@NotNull IntToDoubleFunction mapper) {
        throw new LinkageError();
    }

    @NotNull
    public IntStreamStub flatMap(@NotNull IntFunction mapper) {
        throw new LinkageError();
    }

    @NotNull
    public IntStreamStub sorted() {
        throw new LinkageError();
    }

    @NotNull
    public IntStreamStub distinct() {
        throw new LinkageError();
    }

    @NotNull
    public IntStreamStub peek(@NotNull IntConsumer _action) {
        throw new LinkageError();
    }

    @NotNull
    public IntStreamStub limit(long maxSize) {
        throw new LinkageError();
    }

    @NotNull
    public IntStreamStub skip(long n) {
        throw new LinkageError();
    }

    public void forEach(IntConsumer _action) {
        throw new LinkageError();
    }

    public void forEachOrdered(IntConsumer _action) {
        throw new LinkageError();
    }

    public int[] toArray() {
        throw new LinkageError();
    }

    public int reduce(int identity, IntBinaryOperator accumulator) {
        throw new LinkageError();
    }

    public OptionalInt reduce(IntBinaryOperator accumulator) {
        throw new LinkageError();
    }

    @SuppressWarnings("unchecked")
    public Object collect(Supplier supplier, ObjIntConsumer accumulator, BiConsumer combiner) {
        throw new LinkageError();
    }

    public OptionalInt min() {
        throw new LinkageError();
    }

    public OptionalInt max() {
        throw new LinkageError();
    }

    public long count() {
        throw new LinkageError();
    }

    public boolean anyMatch(IntPredicate predicate) {
        throw new LinkageError();
    }

    public boolean allMatch(IntPredicate predicate) {
        throw new LinkageError();
    }

    public boolean noneMatch(IntPredicate predicate) {
        throw new LinkageError();
    }

    public OptionalInt findFirst() {
        throw new LinkageError();
    }

    public OptionalInt findAny() {
        throw new LinkageError();
    }

    @NotNull
    public PrimitiveIterator.OfInt iterator() {
        throw new LinkageError();
    }

    @NotNull
    public Spliterator.OfInt spliterator() {
        throw new LinkageError();
    }

    public boolean isParallel() {
        throw new LinkageError();
    }

    @NotNull
    public IntStreamStub sequential() {
        throw new LinkageError();
    }

    @NotNull
    public IntStreamStub parallel() {
        throw new LinkageError();
    }

    @NotNull
    public IntStreamStub unordered() {
        throw new LinkageError();
    }

    @NotNull
    public IntStreamStub onClose(@NotNull Runnable closeHandler) {
        throw new LinkageError();
    }

    public void close() {
        throw new LinkageError();
    }

    @NotNull
    public IntStreamStub dropWhile(@NotNull IntPredicate predicate) {
        throw new LinkageError();
    }

    @NotNull
    public IntStreamStub takeWhile(@NotNull IntPredicate predicate) {
        throw new LinkageError();
    }

    public LongStream asLongStream() {
        throw new LinkageError();
    }

    public DoubleStream asDoubleStream() {
        throw new LinkageError();
    }

    public int sum() {
        throw new LinkageError();
    }

    public OptionalDouble average() {
        throw new LinkageError();
    }

    public IntSummaryStatistics summaryStatistics() {
        throw new LinkageError();
    }

    public Stream<Integer> boxed() {
        throw new LinkageError();
    }
}
