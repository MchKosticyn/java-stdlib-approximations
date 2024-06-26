package generated.java.util.stream;

import generated.runtime.LibSLGlobals;
import java.lang.Double;
import java.lang.IllegalArgumentException;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Runnable;
import java.util.DoubleSummaryStatistics;
import java.util.OptionalDouble;
import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;
import org.usvm.api.SymbolicList;
import runtime.LibSLRuntime;
import stub.java.util.Spliterators_DoubleArraySpliterator;
import stub.java.util.stream.*;
import generated.java.lang.DoubleImpl;

@Approximate(DoubleStreamStub.class)
public class DoubleStreamImpl extends BaseStreamImpl implements DoubleStream {

    public double[] storage;

    public DoubleStreamImpl(
        double[] storage,
        int length,
        SymbolicList<Runnable> closeHandlers,
        boolean isParallel,
        boolean linkedOrConsumed
    ) {
        super(length, closeHandlers, isParallel, linkedOrConsumed);
        this.storage = storage;
    }

    private void _actionApply(DoubleConsumer _action) {
        if (_action == null)
            throw new NullPointerException();

        for (int i = 0; i < this.length; i++) {
            _action.accept(storage[i]);
        }
    }

    private OptionalDouble _findFirst() {
        if (this.length == 0)
            return OptionalDouble.empty();

        double first = storage[0];
        return OptionalDouble.of(first);
    }

    private double _sum() {
        if (this.length == 0)
            return 0;

        double result = 0;
        boolean anyNaN = false;
        boolean anyPositiveInfinity = false;
        boolean anyNegativeInfinity = false;
        for (int i = 0; i < this.length; i++) {
            double element = storage[i];
            result += element;
            if (element != element)
                anyNaN = true;
            if (element == DoubleImpl.POSITIVE_INFINITY)
                anyPositiveInfinity = true;
            if (element == DoubleImpl.NEGATIVE_INFINITY)
                anyNegativeInfinity = true;
        }
        if (anyNaN)
            return DoubleImpl.NaN;

        if (anyPositiveInfinity && anyNegativeInfinity)
            return DoubleImpl.NaN;

        if (anyPositiveInfinity && (result == DoubleImpl.NEGATIVE_INFINITY))
            return DoubleImpl.NaN;

        if (anyNegativeInfinity && (result == DoubleImpl.POSITIVE_INFINITY))
            return DoubleImpl.NaN;

        return result;
    }

    @NotNull
    @SuppressWarnings("ConstantValue")
    public DoubleStreamImpl filter(@NotNull DoublePredicate predicate) {
        super.evaluate();

        if (predicate == null)
            throw new NullPointerException();

        double[] filteredStorage = new double[this.length];
        int filteredLength = 0;
        for (int i = 0; i < this.length; i++) {
            if (predicate.test(storage[i])) {
                filteredStorage[filteredLength] = storage[i];
                filteredLength++;
            }
        }

        Engine.assume(filteredLength <= this.length);
        double[] resultStorage = new double[filteredLength];
        LibSLRuntime.ArrayActions.copy(filteredStorage, 0, resultStorage, 0, filteredLength);
        return new DoubleStreamImpl(resultStorage, filteredLength, this.closeHandlers, false, false);
    }

    @NotNull
    @SuppressWarnings("ConstantValue")
    public DoubleStreamImpl map(@NotNull DoubleUnaryOperator mapper) {
        super.evaluate();

        if (mapper == null)
            throw new NullPointerException();

        double[] mappedStorage = new double[this.length];
        for (int i = 0; i < this.length; i++) {
            mappedStorage[i] = mapper.applyAsDouble(storage[i]);
        }

        return new DoubleStreamImpl(mappedStorage, this.length, this.closeHandlers, false, false);
    }

    @NotNull
    @SuppressWarnings("unchecked")
    public StreamStubImpl mapToObj(@NotNull DoubleFunction mapper) {
        super.evaluate();

        Object[] objStorage = new Object[this.length];
        for (int i = 0; i < this.length; i++) {
            objStorage[i] = mapper.apply(storage[i]);
        }

        return new StreamStubImpl(objStorage, this.length, this.closeHandlers, false, false);
    }

    @NotNull
    @SuppressWarnings("ConstantValue")
    public LongStreamImpl mapToLong(@NotNull DoubleToLongFunction mapper) {
        super.evaluate();

        if (mapper == null)
            throw new NullPointerException();

        long[] mappedStorage = new long[this.length];
        for (int i = 0; i < this.length; i++) {
            mappedStorage[i] = mapper.applyAsLong(storage[i]);
        }

        return new LongStreamImpl(mappedStorage, this.length, this.closeHandlers, false, false);
    }

    @NotNull
    @SuppressWarnings("ConstantValue")
    public IntStreamImpl mapToInt(@NotNull DoubleToIntFunction mapper) {
        super.evaluate();

        if (mapper == null)
            throw new NullPointerException();

        int[] mappedStorage = new int[this.length];
        for (int i = 0; i < this.length; i++) {
            mappedStorage[i] = mapper.applyAsInt(storage[i]);
        }

        return new IntStreamImpl(mappedStorage, this.length, this.closeHandlers, false, false);
    }

    @SuppressWarnings("ConstantValue")
    public DoubleStream flatMap(@NotNull DoubleFunction mapper) {
        // TODO: dummy approximation
        super.evaluate();

        if (mapper == null)
            throw new NullPointerException();

        DoubleStream result = Engine.makeSymbolic(DoubleStream.class);
        Engine.assume(result != null);
        return result;
    }

    @NotNull
    public DoubleStreamImpl sorted() {
        super.evaluate();

        if (this.length == 0)
            return new DoubleStreamImpl(this.storage, 0, this.closeHandlers, false, false);

        Engine.assume(this.length > 0);
        int outerLimit = this.length - 1;
        for (int i = 0; i < outerLimit; i++) {
            int innerLimit = this.length - i - 1;
            for (int j = 0; j < innerLimit; j++) {
                int idxB = j + 1;
                double a = storage[j];
                double b = storage[idxB];
                if (a > b) {
                    storage[j] = b;
                    storage[idxB] = a;
                }
            }
        }

        return new DoubleStreamImpl(this.storage, this.length, this.closeHandlers, false, false);
    }

    @NotNull
    @SuppressWarnings("DataFlowIssue")
    public DoubleStreamImpl distinct() {
        super.evaluate();

        double[] distinctStorage;
        int distinctLength = 0;
        int size = this.length;
        if (size == 0) {
            distinctStorage = new double[0];
        } else {
            double[] items = this.storage;
            Engine.assume(items != null);
            Engine.assume(items.length != 0);
            Engine.assume(size == items.length);
            SymbolicList<Double> uniqueItems = Engine.makeSymbolicList();
            LibSLRuntime.Map<Double, Object> visited = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
            for (int i = 0; i < size; i++) {
                double item = items[i];
                if (!visited.hasKey(item)) {
                    visited.set(item, LibSLGlobals.SOMETHING);
                    uniqueItems.insert(distinctLength, item);
                    distinctLength++;
                }
            }

            Engine.assume(distinctLength > 0);
            Engine.assume(distinctLength <= size);
            distinctStorage = new double[distinctLength];
            for (int i = 0; i < distinctLength; i++) {
                Double item = uniqueItems.get(i);
                Engine.assume(item != null);
                distinctStorage[i] = item;
            }
        }
        return new DoubleStreamImpl(distinctStorage, distinctLength, this.closeHandlers, false, false);
    }

    @NotNull
    public DoubleStreamImpl peek(@NotNull DoubleConsumer _action) {
        super.evaluate();

        _actionApply(_action);
        return new DoubleStreamImpl(this.storage, this.length, this.closeHandlers, false, false);
    }

    @NotNull
    public DoubleStreamImpl limit(long maxSize) {
        super.evaluate();

        int maxSizeInt = (int) maxSize;

        if (maxSizeInt < 0)
            throw new IllegalArgumentException();

        if (maxSizeInt == 0)
            return new DoubleStreamImpl(this.storage, 0, this.closeHandlers, false, false);

        if (maxSizeInt > this.length)
            return new DoubleStreamImpl(this.storage, this.length, this.closeHandlers, false, false);

        double[] limitStorage = new double[maxSizeInt];
        LibSLRuntime.ArrayActions.copy(this.storage, 0, limitStorage, 0, maxSizeInt);
        return new DoubleStreamImpl(limitStorage, maxSizeInt, this.closeHandlers, false, false);
    }

    @NotNull
    public DoubleStreamImpl skip(long n) {
        super.evaluate();

        int offset = (int) n;

        if (offset < 0)
            throw new IllegalArgumentException();

        if (offset == 0)
            return new DoubleStreamImpl(this.storage, this.length, this.closeHandlers, false, false);

        if (offset >= this.length) {
            double[] newArray = {};
            return new DoubleStreamImpl(newArray, 0, this.closeHandlers, false, false);
        }

        int newLength = this.length - offset;
        double[] skipStorage = new double[newLength];
        int skipIndex = 0;
        for (int i = offset; i < this.length; i++) {
            skipStorage[skipIndex] = storage[i];
            skipIndex++;
        }

        return new DoubleStreamImpl(skipStorage, newLength, this.closeHandlers, false, false);
    }

    public void forEach(DoubleConsumer _action) {
        super.evaluate();
        _actionApply(_action);
    }

    public void forEachOrdered(DoubleConsumer _action) {
        forEach(_action);
    }

    public double[] toArray() {
        super.evaluate();

        // TODO: copy array?
        return this.storage;
    }

    public double reduce(double identity, DoubleBinaryOperator accumulator) {
        super.evaluate();

        if (accumulator == null)
            throw new NullPointerException();

        double result = identity;
        if (this.length != 0) {
            Engine.assume(this.length > 0);
            for (int i = 0; i < this.length; i++) {
                result = accumulator.applyAsDouble(result, storage[i]);
            }
        }

        return result;
    }

    public OptionalDouble reduce(DoubleBinaryOperator accumulator) {
        super.evaluate();

        if (accumulator == null)
            throw new NullPointerException();

        if (this.length == 0)
            return OptionalDouble.empty();

        Engine.assume(this.length > 0);
        double value = storage[0];
        for (int i = 1; i < this.length; i++) {
            value = accumulator.applyAsDouble(value, storage[i]);
        }

        return OptionalDouble.of(value);
    }

    @SuppressWarnings("unchecked")
    public Object collect(Supplier supplier, ObjDoubleConsumer accumulator, BiConsumer combiner) {
        super.evaluate();

        if (supplier == null)
            throw new NullPointerException();

        if (accumulator == null)
            throw new NullPointerException();

        if (combiner == null)
            throw new NullPointerException();

        Object result = supplier.get();
        for (int i = 0; i < this.length; i++) {
            accumulator.accept(result, storage[i]);
        }

        return result;
    }

    public OptionalDouble min() {
        super.evaluate();

        if (this.length == 0)
            return OptionalDouble.empty();

        double min = storage[0];
        for (int i = 1; i < this.length; i++) {
            if (min > storage[i])
                min = storage[i];
        }

        return OptionalDouble.of(min);
    }

    public OptionalDouble max() {
        super.evaluate();

        if (this.length == 0)
            return OptionalDouble.empty();

        double max = storage[0];
        for (int i = 1; i < this.length; i++) {
            if (max < storage[i])
                max = storage[i];
        }

        return OptionalDouble.of(max);
    }

    public long count() {
        return super.count();
    }

    public boolean anyMatch(DoublePredicate predicate) {
        super.evaluate();

        if (predicate == null)
            throw new NullPointerException();

        int i = 0;
        while (i < this.length && !predicate.test(storage[i])) {
            i++;
        }

        return i < this.length;
    }

    public boolean allMatch(DoublePredicate predicate) {
        super.evaluate();

        if (predicate == null)
            throw new NullPointerException();

        if (this.length == 0)
            return true;

        Engine.assume(this.length > 0);
        int i = 0;
        while (i < this.length && predicate.test(storage[i])) {
            i++;
        }

        return i == this.length;
    }

    public boolean noneMatch(DoublePredicate predicate) {
        super.evaluate();

        if (predicate == null)
            throw new NullPointerException();

        if (this.length == 0)
            return true;

        Engine.assume(this.length > 0);

        int i = 0;
        while (i < this.length && !predicate.test(storage[i])) {
            i++;
        }

        return i == this.length;
    }

    public OptionalDouble findFirst() {
        super.evaluate();

        return _findFirst();
    }

    public OptionalDouble findAny() {
        return findFirst();
    }

    @NotNull
    public PrimitiveIterator.OfDouble iterator() {
        super.evaluate();

        return new DoubleStreamStubIteratorImpl(this, 0);
    }

    @NotNull
    public Spliterator.OfDouble spliterator() {
        super.evaluate();

        return new Spliterators_DoubleArraySpliterator(this.storage, 0, this.length, spliteratorCharacteristics);
    }

    public boolean isParallel() {
        return super.isParallel();
    }

    @NotNull
    public DoubleStreamImpl sequential() {
        return (DoubleStreamImpl) super.sequential();
    }

    @NotNull
    public DoubleStreamImpl parallel() {
        return (DoubleStreamImpl) super.parallel();
    }

    @NotNull
    public DoubleStreamImpl unordered() {
        super.evaluate();

        return new DoubleStreamImpl(this.storage, this.length, this.closeHandlers, false, false);
    }

    @NotNull
    public DoubleStreamImpl onClose(@NotNull Runnable closeHandler) {
        return (DoubleStreamImpl) super.onClose(closeHandler);
    }

    public void close() {
        super.close();
    }

    @SuppressWarnings("ConstantValue")
    @NotNull
    public DoubleStreamImpl dropWhile(@NotNull DoublePredicate predicate) {
        super.evaluate();

        if (predicate == null)
            throw new NullPointerException();

        if (this.length == 0)
            return new DoubleStreamImpl(new double[0], 0, this.closeHandlers, false, false);

        Engine.assume(this.length > 0);
        int dropLength = 0;
        while (dropLength < this.length && predicate.test(storage[dropLength])) {
            dropLength++;
        }

        if (dropLength == 0)
            return new DoubleStreamImpl(this.storage, this.length, this.closeHandlers, false, false);

        int newLength = this.length - dropLength;
        double[] newStorage = new double[newLength];
        LibSLRuntime.ArrayActions.copy(storage, dropLength, newStorage, 0, newLength);
        return new DoubleStreamImpl(newStorage, newLength, this.closeHandlers, false, false);
    }

    @NotNull
    @SuppressWarnings("ConstantValue")
    public DoubleStreamImpl takeWhile(@NotNull DoublePredicate predicate) {
        super.evaluate();

        if (predicate == null)
            throw new NullPointerException();

        if (this.length == 0)
            return new DoubleStreamImpl(new double[0], 0, this.closeHandlers, false, false);

        Engine.assume(this.length > 0);
        int takeLength = 0;
        while (takeLength < this.length && predicate.test(storage[takeLength])) {
            takeLength++;
        }

        if (takeLength == this.length)
            return new DoubleStreamImpl(this.storage, this.length, this.closeHandlers, false, false);

        double[] newStorage = new double[takeLength];
        LibSLRuntime.ArrayActions.copy(storage, 0, newStorage, 0, takeLength);

        return new DoubleStreamImpl(newStorage, takeLength, this.closeHandlers, false, false);
    }

    public double sum() {
        super.evaluate();

        return _sum();
    }

    public OptionalDouble average() {
        super.evaluate();

        if (this.length == 0)
            return OptionalDouble.empty();

        double curSum = _sum();
        double divisionResult = curSum / this.length;
        return OptionalDouble.of(divisionResult);
    }

    public DoubleSummaryStatistics summaryStatistics() {
        super.evaluate();

        DoubleSummaryStatistics result = new DoubleSummaryStatistics();
        for (int i = 0; i < this.length; i++) {
            result.accept(storage[i]);
        }

        return result;
    }

    @SuppressWarnings("unchecked")
    public Stream<Double> boxed() {
        super.evaluate();

        Double[] doubleArray = new Double[this.length];
        for (int i = 0; i < this.length; i++) {
            doubleArray[i] = storage[i];
        }
        StreamStubImpl stream = new StreamStubImpl(doubleArray, this.length, this.closeHandlers, false, false);
        return (Stream<Double>) (Object) stream;
    }
}
