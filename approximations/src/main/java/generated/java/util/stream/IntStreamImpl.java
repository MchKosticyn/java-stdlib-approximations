package generated.java.util.stream;

import generated.java.util.Spliterators_IntArraySpliterator;
import generated.runtime.LibSLGlobals;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.NullPointerException;
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
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;
import org.usvm.api.SymbolicList;
import runtime.LibSLRuntime;
import stub.java.util.stream.*;

@Approximate(IntStreamStub.class)
public class IntStreamImpl extends BaseStreamImpl implements IntStream {

    public int[] storage;

    public IntStreamImpl(
        int[] storage,
        int length,
        SymbolicList<Runnable> closeHandlers,
        boolean isParallel,
        boolean linkedOrConsumed
    ) {
        super(length, closeHandlers, isParallel, linkedOrConsumed);
        this.storage = storage;
    }

    private void _actionApply(IntConsumer _action) {
        if (_action == null)
            throw new NullPointerException();

        for (int i = 0; i < this.length; i++)
            _action.accept(storage[i]);
    }

    private OptionalInt _findFirst() {
        if (this.length == 0)
            return OptionalInt.empty();

        int first = storage[0];
        return OptionalInt.of(first);
    }

    private int _sum() {
        int result = 0;
        for (int i = 0; i < this.length; i++) {
            result += storage[i];
        }
        return result;
    }

    @NotNull
    @SuppressWarnings("ConstantValue")
    public IntStreamImpl filter(@NotNull IntPredicate predicate) {
        super.evaluate();

        if (predicate == null)
            throw new NullPointerException();

        int[] filteredStorage = new int[this.length];
        int filteredLength = 0;
        for (int i = 0; i < this.length; i++) {
            if (predicate.test(storage[i])) {
                filteredStorage[filteredLength] = storage[i];
                filteredLength++;
            }
        }

        Engine.assume(filteredLength <= this.length);
        int[] resultStorage = new int[filteredLength];
        LibSLRuntime.ArrayActions.copy(filteredStorage, 0, resultStorage, 0, filteredLength);
        return new IntStreamImpl(resultStorage, filteredLength, this.closeHandlers, false, false);
    }

    @NotNull
    @SuppressWarnings("ConstantValue")
    public IntStreamImpl map(@NotNull IntUnaryOperator mapper) {
        super.evaluate();

        if (mapper == null)
            throw new NullPointerException();

        int[] mappedStorage = new int[this.length];

        for (int i = 0; i < this.length; i++) {
            mappedStorage[i] = mapper.applyAsInt(storage[i]);
        }

        return new IntStreamImpl(mappedStorage, this.length, this.closeHandlers, false, false);
    }

    @NotNull
    @SuppressWarnings("unchecked")
    public StreamStubImpl mapToObj(@NotNull IntFunction mapper) {
        super.evaluate();

        Object[] objStorage = new Object[this.length];

        for (int i = 0; i < this.length; i++) {
            objStorage[i] = mapper.apply(storage[i]);
        }

        return new StreamStubImpl(objStorage, this.length, this.closeHandlers, false, false);
    }

    @NotNull
    @SuppressWarnings("ConstantValue")
    public LongStreamImpl mapToLong(@NotNull IntToLongFunction mapper) {
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
    public DoubleStreamImpl mapToDouble(@NotNull IntToDoubleFunction mapper) {
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
    @SuppressWarnings({"ConstantValue", "DataFlowIssue"})
    public IntStream flatMap(@NotNull IntFunction mapper) {
        // TODO: dummy approximation
        super.evaluate();

        if (mapper == null)
            throw new NullPointerException();

        IntStream result = Engine.makeSymbolic(IntStream.class);
        Engine.assume(result != null);
        return result;
    }

    @NotNull
    public IntStreamImpl sorted() {
        super.evaluate();

        if (this.length == 0)
            return new IntStreamImpl(this.storage, 0, this.closeHandlers, false, false);

        Engine.assume(this.length > 0);
        int outerLimit = this.length - 1;
        for (int i = 0; i < outerLimit; i++) {
            int innerLimit = this.length - i - 1;
            for (int j = 0; j < innerLimit; j++) {
                int idxB = j + 1;
                int a = storage[j];
                int b = storage[idxB];
                if (a > b) {
                    storage[j] = b;
                    storage[idxB] = a;
                }
            }
        }

        return new IntStreamImpl(this.storage, this.length, this.closeHandlers, false, false);
    }

    @NotNull
    @SuppressWarnings("DataFlowIssue")
    public IntStreamImpl distinct() {
        super.evaluate();

        int[] distinctStorage;
        int distinctLength = 0;
        int size = this.length;
        if (size == 0) {
            distinctStorage = new int[0];
        } else {
            int[] items = this.storage;
            Engine.assume(items != null);
            Engine.assume(items.length != 0);
            Engine.assume(size == items.length);
            SymbolicList<Integer> uniqueItems = Engine.makeSymbolicList();
            LibSLRuntime.Map<Integer, Object> visited = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
            for (int i = 0; i < size; i++) {
                int item = items[i];
                if (!visited.hasKey(item)) {
                    visited.set(item, LibSLGlobals.SOMETHING);
                    uniqueItems.insert(distinctLength, item);
                    distinctLength++;
                }
            }

            Engine.assume(distinctLength > 0);
            Engine.assume(distinctLength <= size);
            distinctStorage = new int[distinctLength];
            for (int i = 0; i < distinctLength; i++) {
                Integer item = uniqueItems.get(i);
                Engine.assume(item != null);
                distinctStorage[i] = item;
            }
        }
        return new IntStreamImpl(distinctStorage, distinctLength, this.closeHandlers, false, false);
    }

    @NotNull
    public IntStreamImpl peek(@NotNull IntConsumer _action) {
        super.evaluate();

        _actionApply(_action);
        return new IntStreamImpl(this.storage, this.length, this.closeHandlers, false, false);
    }

    @NotNull
    public IntStreamImpl limit(long maxSize) {
        super.evaluate();

        int maxSizeInt = (int) maxSize;

        if (maxSizeInt < 0)
            throw new IllegalArgumentException();

        if (maxSizeInt == 0)
            return new IntStreamImpl(this.storage, 0, this.closeHandlers, false, false);

        if (maxSizeInt > this.length)
            return new IntStreamImpl(this.storage, this.length, this.closeHandlers, false, false);

        int[] limitStorage = new int[maxSizeInt];
        LibSLRuntime.ArrayActions.copy(this.storage, 0, limitStorage, 0, maxSizeInt);
        return new IntStreamImpl(limitStorage, maxSizeInt, this.closeHandlers, false, false);
    }

    @NotNull
    public IntStreamImpl skip(long n) {
        super.evaluate();

        int offset = (int) n;

        if (offset < 0)
            throw new IllegalArgumentException();

        if (offset == 0)
            return new IntStreamImpl(this.storage, this.length, this.closeHandlers, false, false);

        if (offset >= this.length)
            return new IntStreamImpl(new int[0], 0, this.closeHandlers, false, false);

        int newLength = this.length - offset;
        int[] skipStorage = new int[newLength];
        LibSLRuntime.ArrayActions.copy(storage, offset, skipStorage, 0, newLength);
        return new IntStreamImpl(skipStorage, newLength, this.closeHandlers, false, false);
    }

    public void forEach(IntConsumer _action) {
        super.evaluate();
        _actionApply(_action);
    }

    public void forEachOrdered(IntConsumer _action) {
        forEach(_action);
    }

    public int[] toArray() {
        super.evaluate();
        return this.storage;
    }

    public int reduce(int identity, IntBinaryOperator accumulator) {
        super.evaluate();

        if (accumulator == null)
            throw new NullPointerException();

        int result = identity;
        if (this.length != 0) {
            Engine.assume(this.length > 0);
            for (int i = 0; i < this.length; i++) {
                result = accumulator.applyAsInt(result, storage[i]);
            }
        }
        return result;
    }

    public OptionalInt reduce(IntBinaryOperator accumulator) {
        super.evaluate();

        if (accumulator == null)
            throw new NullPointerException();

        if (this.length == 0)
            return OptionalInt.empty();

        Engine.assume(this.length > 0);

        int value = storage[0];
        for (int i = 1; i < this.length; i++) {
            value = accumulator.applyAsInt(value, storage[i]);
        }

        return OptionalInt.of(value);
    }

    @SuppressWarnings("unchecked")
    public Object collect(Supplier supplier, ObjIntConsumer accumulator, BiConsumer combiner) {
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

    public OptionalInt min() {
        super.evaluate();

        if (this.length == 0)
            return OptionalInt.empty();

        int min = storage[0];
        for (int i = 1; i < this.length; i++) {
            if (min > storage[i])
                min = storage[i];
        }

        return OptionalInt.of(min);
    }

    public OptionalInt max() {
        super.evaluate();

        if (this.length == 0)
            return OptionalInt.empty();

        int max = storage[0];
        for (int i = 1; i < this.length; i++) {
            if (max < storage[i])
                max = storage[i];
        }

        return OptionalInt.of(max);
    }

    public long count() {
        return super.count();
    }

    public boolean anyMatch(IntPredicate predicate) {
        super.evaluate();

        if (predicate == null)
            throw new NullPointerException();

        int i = 0;
        while (i < this.length && !predicate.test(storage[i])) {
            i++;
        }

        return i < this.length;
    }

    public boolean allMatch(IntPredicate predicate) {
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

    public boolean noneMatch(IntPredicate predicate) {
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

    public OptionalInt findFirst() {
        super.evaluate();
        return _findFirst();
    }

    public OptionalInt findAny() {
        return findFirst();
    }

    @NotNull
    public PrimitiveIterator.OfInt iterator() {
        super.evaluate();
        return new IntStreamStubIteratorImpl(this, 0);
    }

    @NotNull
    public Spliterator.OfInt spliterator() {
        super.evaluate();

        return new Spliterators_IntArraySpliterator(this.storage, 0, this.length, spliteratorCharacteristics);
    }

    public boolean isParallel() {
        return super.isParallel();
    }

    @NotNull
    public IntStreamImpl sequential() {
        return (IntStreamImpl) super.sequential();
    }

    @NotNull
    public IntStreamImpl parallel() {
        return (IntStreamImpl) super.parallel();
    }

    @NotNull
    public IntStreamImpl unordered() {
        super.evaluate();
        return new IntStreamImpl(this.storage, this.length, this.closeHandlers, false, false);
    }

    @NotNull
    public IntStreamImpl onClose(@NotNull Runnable closeHandler) {
        return (IntStreamImpl) super.onClose(closeHandler);
    }

    public void close() {
        super.close();
    }

    @NotNull
    @SuppressWarnings("ConstantValue")
    public IntStreamImpl dropWhile(@NotNull IntPredicate predicate) {
        super.evaluate();

        if (predicate == null)
            throw new NullPointerException();

        if (this.length == 0)
            return new IntStreamImpl(new int[0], 0, this.closeHandlers, false, false);

        Engine.assume(this.length > 0);
        int dropLength = 0;
        while (dropLength < this.length && predicate.test(storage[dropLength])) {
            dropLength++;
        }

        if (dropLength == 0)
            return new IntStreamImpl(this.storage, this.length, this.closeHandlers, false, false);

        int newLength = this.length - dropLength;
        int[] newStorage = new int[newLength];
        LibSLRuntime.ArrayActions.copy(storage, dropLength, newStorage, 0, newLength);
        return new IntStreamImpl(newStorage, newLength, this.closeHandlers, false, false);
    }

    @NotNull
    @SuppressWarnings("ConstantValue")
    public IntStreamImpl takeWhile(@NotNull IntPredicate predicate) {
        super.evaluate();

        if (predicate == null)
            throw new NullPointerException();

        if (this.length == 0)
            return new IntStreamImpl(new int[0], 0, this.closeHandlers, false, false);

        Engine.assume(this.length > 0);
        int takeLength = 0;
        while (takeLength < this.length && predicate.test(storage[takeLength])) {
            takeLength++;
        }

        if (takeLength == this.length)
            return new IntStreamImpl(this.storage, this.length, this.closeHandlers, false, false);

        int[] newStorage = new int[takeLength];
        LibSLRuntime.ArrayActions.copy(storage, 0, newStorage, 0, takeLength);

        return new IntStreamImpl(newStorage, takeLength, this.closeHandlers, false, false);
    }

    public LongStreamImpl asLongStream() {
        super.evaluate();

        if (this.length == 0)
            return new LongStreamImpl(new long[0], 0, this.closeHandlers, false, false);

        Engine.assume(this.length > 0);
        long[] newStorage = new long[this.length];
        LibSLRuntime.ArrayActions.copy(storage, 0, newStorage, 0, this.length);
        return new LongStreamImpl(newStorage, this.length, this.closeHandlers, false, false);
    }

    public DoubleStreamImpl asDoubleStream() {
        super.evaluate();

        if (this.length == 0)
            return new DoubleStreamImpl(new double[0], 0, this.closeHandlers, false, false);

        Engine.assume(this.length > 0);
        double[] newStorage = new double[this.length];
        LibSLRuntime.ArrayActions.copy(storage, 0, newStorage, 0, this.length);
        return new DoubleStreamImpl(newStorage, this.length, this.closeHandlers, false, false);
    }

    public int sum() {
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

    public IntSummaryStatistics summaryStatistics() {
        super.evaluate();

        IntSummaryStatistics result = new IntSummaryStatistics();
        for (int i = 0; i < this.length; i++) {
            result.accept(storage[i]);
        }

        return result;
    }

    @SuppressWarnings("unchecked")
    public Stream<Integer> boxed() {
        super.evaluate();

        Integer[] integerArray = new Integer[this.length];
        for (int i = 0; i < this.length; i++) {
            integerArray[i] = storage[i];
        }

        StreamStubImpl stream = new StreamStubImpl(integerArray, this.length, this.closeHandlers, false, false);
        return (Stream<Integer>) (Object) stream;
    }
}
