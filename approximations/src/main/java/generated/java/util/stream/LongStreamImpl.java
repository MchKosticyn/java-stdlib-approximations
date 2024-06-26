package generated.java.util.stream;

import generated.runtime.LibSLGlobals;
import java.lang.IllegalArgumentException;
import java.lang.Long;
import java.lang.NullPointerException;
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
import java.util.stream.LongStream;
import java.util.stream.Stream;
import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;
import org.usvm.api.SymbolicList;
import runtime.LibSLRuntime;
import stub.java.util.Spliterators_LongArraySpliterator;
import stub.java.util.stream.*;

@Approximate(LongStreamStub.class)
public class LongStreamImpl extends BaseStreamImpl implements LongStream {

    public long[] storage;

    public LongStreamImpl(
        long[] storage,
        int length,
        SymbolicList<Runnable> closeHandlers,
        boolean isParallel,
        boolean linkedOrConsumed
    ) {
        super(length, closeHandlers, isParallel, linkedOrConsumed);
        this.storage = storage;
    }

    private void _actionApply(LongConsumer _action) {
        if (_action == null)
            throw new NullPointerException();

        for (int i = 0; i < this.length; i++) {
            _action.accept(storage[i]);
        }
    }

    private OptionalLong _findFirst() {
        if (this.length == 0)
            return OptionalLong.empty();

        long first = storage[0];
        return OptionalLong.of(first);
    }

    private long _sum() {
        if (this.length == 0)
            return 0;

        long result = 0;
        Engine.assume(this.length > 0);
        for (int i = 0; i < this.length; i++) {
            result += storage[i];
        }

        return result;
    }

    @NotNull
    @SuppressWarnings("ConstantValue")
    public LongStreamImpl filter(@NotNull LongPredicate predicate) {
        super.evaluate();

        if (predicate == null)
            throw new NullPointerException();

        long[] filteredStorage = new long[this.length];
        int filteredLength = 0;
        for (int i = 0; i < this.length; i++) {
            if (predicate.test(storage[i])) {
                filteredStorage[filteredLength] = storage[i];
                filteredLength++;
            }
        }

        Engine.assume(filteredLength <= this.length);
        long[] resultStorage = new long[filteredLength];
        LibSLRuntime.ArrayActions.copy(filteredStorage, 0, resultStorage, 0, filteredLength);
        return new LongStreamImpl(resultStorage, filteredLength, this.closeHandlers, false, false);
    }

    @NotNull
    @SuppressWarnings("ConstantValue")
    public LongStreamImpl map(@NotNull LongUnaryOperator mapper) {
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
    @SuppressWarnings("unchecked")
    public StreamStubImpl mapToObj(@NotNull LongFunction mapper) {
        super.evaluate();

        Object[] objStorage = new Object[this.length];
        for (int i = 0; i < this.length; i++) {
            objStorage[i] = mapper.apply(storage[i]);
        }

        return new StreamStubImpl(objStorage, this.length, this.closeHandlers, false, false);
    }

    @NotNull
    @SuppressWarnings("ConstantValue")
    public IntStreamImpl mapToInt(@NotNull LongToIntFunction mapper) {
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
    @SuppressWarnings("ConstantValue")
    public DoubleStreamImpl mapToDouble(@NotNull LongToDoubleFunction mapper) {
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
    public LongStream flatMap(@NotNull LongFunction mapper) {
        // TODO: dummy approximation
        super.evaluate();

        if (mapper == null)
            throw new NullPointerException();

        LongStream result = Engine.makeSymbolic(LongStream.class);
        Engine.assume(result != null);
        return result;
    }

    @NotNull
    public LongStreamImpl sorted() {
        super.evaluate();
        if (this.length == 0)
            return new LongStreamImpl(this.storage, 0, this.closeHandlers, false, false);

        Engine.assume(this.length > 0);
        int outerLimit = this.length - 1;
        for (int i = 0; i < outerLimit; i++) {
            int innerLimit = this.length - i - 1;
            for (int j = 0; j < innerLimit; j++) {
                int idxB = j + 1;
                long a = storage[j];
                long b = storage[idxB];
                if (a > b) {
                    storage[j] = b;
                    storage[idxB] = a;
                }
            }
        }

        return new LongStreamImpl(this.storage, this.length, this.closeHandlers, false, false);
    }

    @NotNull
    @SuppressWarnings("DataFlowIssue")
    public LongStreamImpl distinct() {
        super.evaluate();

        long[] distinctStorage;
        int distinctLength = 0;
        int size = this.length;
        if (size == 0) {
            distinctStorage = new long[0];
        } else {
            long[] items = this.storage;
            Engine.assume(items != null);
            Engine.assume(items.length != 0);
            Engine.assume(size == items.length);
            SymbolicList<Long> uniqueItems = Engine.makeSymbolicList();
            LibSLRuntime.Map<Long, Object> visited = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
            for (int i = 0; i < size; i++) {
                long item = items[i];
                if (!visited.hasKey(item)) {
                    visited.set(item, LibSLGlobals.SOMETHING);
                    uniqueItems.insert(distinctLength, item);
                    distinctLength++;
                }
            }

            Engine.assume(distinctLength > 0);
            Engine.assume(distinctLength <= size);
            distinctStorage = new long[distinctLength];
            for (int i = 0; i < distinctLength; i++) {
                Long item = uniqueItems.get(i);
                Engine.assume(item != null);
                distinctStorage[i] = item;
            }
        }
        return new LongStreamImpl(distinctStorage, distinctLength, this.closeHandlers, false, false);
    }

    @NotNull
    public LongStreamImpl peek(@NotNull LongConsumer _action) {
        super.evaluate();

        _actionApply(_action);
        return new LongStreamImpl(this.storage, this.length, this.closeHandlers, false, false);
    }

    @NotNull
    public LongStreamImpl limit(long maxSize) {
        super.evaluate();

        int maxSizeInt = (int) maxSize;
        if (maxSizeInt < 0)
            throw new IllegalArgumentException();

        if (maxSizeInt == 0)
            return new LongStreamImpl(this.storage, 0, this.closeHandlers, false, false);

        if (maxSizeInt > this.length)
            return new LongStreamImpl(this.storage, this.length, this.closeHandlers, false, false);

        long[] limitStorage = new long[maxSizeInt];
        LibSLRuntime.ArrayActions.copy(this.storage, 0, limitStorage, 0, maxSizeInt);
        return new LongStreamImpl(limitStorage, maxSizeInt, this.closeHandlers, false, false);
    }

    @NotNull
    public LongStreamImpl skip(long n) {
        super.evaluate();

        int offset = (int) n;
        if (offset < 0)
            throw new IllegalArgumentException();

        if (offset == 0)
            return new LongStreamImpl(this.storage, this.length, this.closeHandlers, false, false);

        if (offset >= this.length)
            return new LongStreamImpl(new long[0], 0, this.closeHandlers, false, false);

        int newLength = this.length - offset;
        long[] skipStorage = new long[newLength];
        LibSLRuntime.ArrayActions.copy(storage, offset, skipStorage, 0, newLength);

        return new LongStreamImpl(skipStorage, newLength, this.closeHandlers, false, false);
    }

    public void forEach(LongConsumer _action) {
        super.evaluate();
        _actionApply(_action);
    }

    public void forEachOrdered(LongConsumer _action) {
        forEach(_action);
    }

    public long[] toArray() {
        super.evaluate();
        return this.storage;
    }

    public long reduce(long identity, LongBinaryOperator accumulator) {
        super.evaluate();

        if (accumulator == null)
            throw new NullPointerException();

        long result = identity;
        if (this.length != 0) {
            Engine.assume(this.length > 0);
            for (int i = 0; i < this.length; i++) {
                result = accumulator.applyAsLong(result, storage[i]);
            }
        }

        return result;
    }

    public OptionalLong reduce(LongBinaryOperator accumulator) {
        super.evaluate();

        if (accumulator == null)
            throw new NullPointerException();

        if (this.length == 0)
            return OptionalLong.empty();

        Engine.assume(this.length > 0);
        long value = storage[0];
        for (int i = 1; i < this.length; i++) {
            value = accumulator.applyAsLong(value, storage[i]);
        }

        return OptionalLong.of(value);
    }

    @SuppressWarnings("unchecked")
    public Object collect(Supplier supplier, ObjLongConsumer accumulator, BiConsumer combiner) {
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

    public OptionalLong min() {
        super.evaluate();

        if (this.length == 0)
            return OptionalLong.empty();

        long min = storage[0];
        for (int i = 1; i < this.length; i++) {
            if (min > storage[i])
                min = storage[i];
        }
        return OptionalLong.of(min);
    }

    public OptionalLong max() {
        super.evaluate();
        if (this.length == 0)
            return OptionalLong.empty();

        long max = storage[0];
        for (int i = 1; i < this.length; i++) {
            if (max < storage[i])
                max = storage[i];
        }
        return OptionalLong.of(max);
    }

    public long count() {
        return super.count();
    }

    public boolean anyMatch(LongPredicate predicate) {
        super.evaluate();

        if (predicate == null)
            throw new NullPointerException();

        int i = 0;
        while (i < this.length && !predicate.test(storage[i])) {
            i++;
        }

        return i < this.length;
    }

    public boolean allMatch(LongPredicate predicate) {
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

    public boolean noneMatch(LongPredicate predicate) {
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

    public OptionalLong findFirst() {
        super.evaluate();
        return _findFirst();
    }

    public OptionalLong findAny() {
        return findFirst();
    }

    @NotNull
    public PrimitiveIterator.OfLong iterator() {
        super.evaluate();
        return new LongStreamStubIteratorImpl(this, 0);
    }

    @NotNull
    public Spliterator.OfLong spliterator() {
        super.evaluate();
        return new Spliterators_LongArraySpliterator(this.storage, 0, this.length, spliteratorCharacteristics);
    }

    public boolean isParallel() {
        return super.isParallel();
    }

    @NotNull
    public LongStreamImpl sequential() {
        return (LongStreamImpl) super.sequential();
    }

    @NotNull
    public LongStreamImpl parallel() {
        return (LongStreamImpl) super.parallel();
    }

    @NotNull
    public LongStreamImpl unordered() {
        super.evaluate();
        return new LongStreamImpl(this.storage, this.length, this.closeHandlers, false, false);
    }

    @NotNull
    public LongStreamImpl onClose(@NotNull Runnable closeHandler) {
        return (LongStreamImpl) super.onClose(closeHandler);
    }

    public void close() {
        super.close();
    }

    @NotNull
    @SuppressWarnings("ConstantValue")
    public LongStreamImpl dropWhile(@NotNull LongPredicate predicate) {
        super.evaluate();

        if (predicate == null)
            throw new NullPointerException();

        if (this.length == 0)
            return new LongStreamImpl(new long[0], 0, this.closeHandlers, false, false);

        Engine.assume(this.length > 0);
        int dropLength = 0;
        while (dropLength < this.length && predicate.test(storage[dropLength])) {
            dropLength++;
        }

        if (dropLength == 0)
            return new LongStreamImpl(this.storage, this.length, this.closeHandlers, false, false);

        int newLength = this.length - dropLength;
        long[] newStorage = new long[newLength];
        LibSLRuntime.ArrayActions.copy(storage, dropLength, newStorage, 0, newLength);
        return new LongStreamImpl(newStorage, newLength, this.closeHandlers, false, false);
    }

    @NotNull
    @SuppressWarnings("ConstantValue")
    public LongStreamImpl takeWhile(@NotNull LongPredicate predicate) {
        super.evaluate();

        if (predicate == null)
            throw new NullPointerException();

        if (this.length == 0)
            return new LongStreamImpl(new long[0], 0, this.closeHandlers, false, false);

        Engine.assume(this.length > 0);
        int takeLength = 0;
        while (takeLength < this.length && predicate.test(storage[takeLength])) {
            takeLength++;
        }

        if (takeLength == this.length)
            return new LongStreamImpl(this.storage, this.length, this.closeHandlers, false, false);

        long[] newStorage = new long[takeLength];
        LibSLRuntime.ArrayActions.copy(storage, 0, newStorage, 0, takeLength);

        return new LongStreamImpl(newStorage, takeLength, this.closeHandlers, false, false);
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

    public long sum() {
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

    public LongSummaryStatistics summaryStatistics() {
        super.evaluate();

        LongSummaryStatistics result = new LongSummaryStatistics();
        for (int i = 0; i < this.length; i++) {
            result.accept(storage[i]);
        }

        return result;
    }

    @SuppressWarnings("unchecked")
    public Stream<Long> boxed() {
        super.evaluate();

        Long[] longArray = new Long[this.length];

        for (int i = 0; i < this.length; i++) {
            longArray[i] = storage[i];
        }

        StreamStubImpl stream = new StreamStubImpl(longArray, this.length, this.closeHandlers, false, false);
        return (Stream<Long>) (Object) stream;
    }
}
