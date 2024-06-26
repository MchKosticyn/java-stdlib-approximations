package generated.java.util.stream;

import generated.runtime.LibSLGlobals;

import java.lang.Comparable;
import java.lang.IllegalArgumentException;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Runnable;
import java.util.*;
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

import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;
import org.usvm.api.SymbolicList;
import runtime.LibSLRuntime;
import stub.java.util.ArraySpliterator;
import stub.java.util.stream.StreamStub;

@Approximate(StreamStub.class)
public class StreamStubImpl extends BaseStreamImpl implements Stream<Object> {

    public Object[] storage;

    public StreamStubImpl(
        Object[] storage,
        int length,
        SymbolicList<Runnable> handlers,
        boolean isParallel,
        boolean linkedOrConsumed
    ) {
        super(length, handlers, isParallel, linkedOrConsumed);
        this.storage = storage;
    }

    private void _actionApply(Consumer<Object> _action) {
        if (_action == null)
            throw new NullPointerException();

        for (int i = 0; i < this.length; i++) {
            _action.accept(storage[i]);
        }
    }

    private Optional<Object> _findFirst() {
        if (this.length == 0)
            return Optional.empty();

        Object first = storage[0];
        return Optional.ofNullable(first);
    }

    public Stream<Object> filter(Predicate<? super Object> predicate) {
        super.evaluate();

        if (predicate == null) {
            throw new NullPointerException();
        }
        Object[] filteredStorage = new Object[this.length];
        int filteredLength = 0;
        for (int i = 0; i < this.length; i++) {
            if (predicate.test(storage[i])) {
                filteredStorage[filteredLength] = storage[i];
                filteredLength++;
            }
        }

        Engine.assume(filteredLength <= this.length);
        Object[] resultStorage = new Object[filteredLength];
        LibSLRuntime.ArrayActions.copy(filteredStorage, 0, resultStorage, 0, filteredLength);
        return new StreamStubImpl(resultStorage, filteredLength, this.closeHandlers, false, false);
    }

    @SuppressWarnings("unchecked")
    public <T> Stream<T> map(Function<? super Object, ? extends T> mapper) {
        super.evaluate();

        if (mapper == null)
            throw new NullPointerException();

        Object[] mappedStorage = new Object[this.length];
        for (int i = 0; i < this.length; i++) {
            mappedStorage[i] = mapper.apply(storage[i]);
        }

        return (Stream<T>) new StreamStubImpl(mappedStorage, this.length, this.closeHandlers, false, false);
    }

    public IntStream mapToInt(ToIntFunction<? super Object> mapper) {
        super.evaluate();

        if (mapper == null)
            throw new NullPointerException();

        int[] mappedStorage = new int[this.length];
        for (int i = 0; i < this.length; i++) {
            mappedStorage[i] = mapper.applyAsInt(storage[i]);
        }

        return new IntStreamImpl(mappedStorage, length, closeHandlers, false, false);
    }

    public LongStream mapToLong(ToLongFunction<? super Object> mapper) {
        super.evaluate();

        if (mapper == null)
            throw new NullPointerException();

        long[] mappedStorage = new long[this.length];
        for (int i = 0; i < this.length; i++) {
            mappedStorage[i] = mapper.applyAsLong(storage[i]);
        }

        return new LongStreamImpl(mappedStorage, this.length, this.closeHandlers, false, false);
    }

    public DoubleStream mapToDouble(ToDoubleFunction<? super Object> mapper) {
        super.evaluate();

        if (mapper == null)
            throw new NullPointerException();

        double[] mappedStorage = new double[this.length];
        for (int i = 0; i < this.length; i++) {
            mappedStorage[i] = mapper.applyAsDouble(storage[i]);
        }

        return new DoubleStreamImpl(mappedStorage, this.length, this.closeHandlers, false, false);
    }

    @SuppressWarnings({"ConstantValue", "unchecked"})
    public <R> Stream<R> flatMap(Function<? super Object, ? extends Stream<? extends R>> mapper) {
        super.evaluate();

        if (mapper == null)
            throw new NullPointerException();

        Stream<R> result = Engine.makeSymbolic(Stream.class);
        Engine.assume(result != null);
        return result;
    }

    @SuppressWarnings("ConstantValue")
    public IntStream flatMapToInt(Function mapper) {
        super.evaluate();

        if (mapper == null)
            throw new NullPointerException();

        IntStream result = Engine.makeSymbolic(IntStream.class);
        Engine.assume(result != null);
        return result;
    }

    @SuppressWarnings("ConstantValue")
    public LongStream flatMapToLong(Function mapper) {
        super.evaluate();

        if (mapper == null)
            throw new NullPointerException();

        LongStream result = Engine.makeSymbolic(LongStream.class);
        Engine.assume(result != null);
        return result;
    }

    @SuppressWarnings("ConstantValue")
    public DoubleStream flatMapToDouble(Function mapper) {
        super.evaluate();

        if (mapper == null)
            throw new NullPointerException();

        DoubleStream result = Engine.makeSymbolic(DoubleStream.class);
        Engine.assume(result != null);
        return result;
    }

    @SuppressWarnings("DataFlowIssue")
    public StreamStubImpl distinct() {
        super.evaluate();

        Object[] distinctStorage;
        int distinctLength = 0;
        int size = this.length;
        if (size == 0) {
            distinctStorage = new Object[0];
        } else {
            Object[] items = this.storage;
            Engine.assume(items != null);
            Engine.assume(items.length != 0);
            Engine.assume(size == items.length);
            SymbolicList<Object> uniqueItems = Engine.makeSymbolicList();
            LibSLRuntime.Map<Object, Object> visited = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
            for (int i = 0; i < size; i++) {
                Object item = items[i];
                if (!visited.hasKey(item)) {
                    visited.set(item, LibSLGlobals.SOMETHING);
                    uniqueItems.insert(distinctLength, item);
                    distinctLength++;
                }
            }

            Engine.assume(distinctLength > 0);
            Engine.assume(distinctLength <= size);
            distinctStorage = new Object[distinctLength];
            for (int i = 0; i < distinctLength; i++) {
                Object item = uniqueItems.get(i);
                Engine.assume(item != null);
                distinctStorage[i] = item;
            }
        }
        return new StreamStubImpl(distinctStorage, distinctLength, this.closeHandlers, false, false);
    }

    @SuppressWarnings("unchecked")
    public StreamStubImpl sorted() {
        super.evaluate();

        if (this.length == 0)
            return new StreamStubImpl(this.storage, 0, this.closeHandlers, false, false);

        Engine.assume(this.length > 0);
        int outerLimit = this.length - 1;
        for (int i = 0; i < outerLimit; i++) {
            int innerLimit = this.length - i - 1;
            for (int j = 0; j < innerLimit; j++) {
                int idxB = j + 1;
                Comparable<Object> a = (Comparable<Object>) storage[j];
                Object b = storage[idxB];
                if (a.compareTo(b) > 0) {
                    storage[j] = b;
                    storage[idxB] = a;
                }
            }
        }

        return new StreamStubImpl(this.storage, this.length, this.closeHandlers, false, false);
    }

    public StreamStubImpl sorted(Comparator<? super Object> comparator) {
        super.evaluate();

        if (this.length == 0)
            return new StreamStubImpl(this.storage, this.length, this.closeHandlers, false, false);

        int outerLimit = this.length - 1;
        for (int i = 0; i < outerLimit; i++) {
            int innerLimit = this.length - i - 1;
            for (int j = 0; j < innerLimit; j++) {
                int idxB = j + 1;
                Object a = storage[j];
                Object b = storage[idxB];
                if (comparator.compare(a, b) > 0) {
                    storage[j] = b;
                    storage[idxB] = a;
                }
            }
        }

        return new StreamStubImpl(this.storage, this.length, this.closeHandlers, false, false);
    }

    public StreamStubImpl peek(Consumer<? super Object> _action) {
        super.evaluate();

        _actionApply(_action);

        return new StreamStubImpl(this.storage, this.length, this.closeHandlers, false, false);
    }

    public StreamStubImpl limit(long maxSize) {
        super.evaluate();

        int maxSizeInt = (int) maxSize;

        if (maxSizeInt < 0)
            throw new IllegalArgumentException();

        if (maxSizeInt == 0)
            return new StreamStubImpl(this.storage, 0, this.closeHandlers, false, false);

        if (maxSizeInt > this.length)
            return new StreamStubImpl(this.storage, this.length, this.closeHandlers, false, false);

        Object[] limitStorage = new Object[maxSizeInt];
        LibSLRuntime.ArrayActions.copy(this.storage, 0, limitStorage, 0, maxSizeInt);
        return new StreamStubImpl(limitStorage, maxSizeInt, this.closeHandlers, false, false);
    }

    public StreamStubImpl skip(long n) {
        super.evaluate();

        int offset = (int) n;

        if (offset < 0)
            throw new IllegalArgumentException();

        if (offset == 0)
            return new StreamStubImpl(this.storage, this.length, this.closeHandlers, false, false);

        if (offset >= this.length)
            return new StreamStubImpl(new Object[0], 0, this.closeHandlers, false, false);


        int newLength = this.length - offset;
        Object[] skipStorage = new Object[newLength];
        int skipIndex = 0;
        for (int i = offset; i < this.length; i++) {
            skipStorage[skipIndex] = storage[i];
            skipIndex++;
        }

        return new StreamStubImpl(skipStorage, newLength, this.closeHandlers, false, false);
    }

    public void forEach(Consumer<? super Object> _action) {
        super.evaluate();
        _actionApply(_action);
    }

    public void forEachOrdered(Consumer<? super Object> _action) {
        forEach(_action);
    }

    @NotNull
    public Object[] toArray() {
        super.evaluate();

        return this.storage;
    }

    @NotNull
    @SuppressWarnings("unchecked")
    public Object[] toArray(IntFunction generator) {
        super.evaluate();
        // TODO: use generator? #Valya
        Object[] generatedArray = ((Object[]) generator.apply(this.length));
        LibSLRuntime.ArrayActions.copy(this.storage, 0, generatedArray, 0, this.length);
        return generatedArray;
    }

    public Object reduce(Object identity, BinaryOperator<Object> accumulator) {
        super.evaluate();

        if (accumulator == null)
            throw new NullPointerException();

        Object result = identity;
        if (this.length != 0) {
            Engine.assume(this.length > 0);
            for (int i = 0; i < this.length; i++) {
                result = accumulator.apply(result, storage[i]);
            }
        }

        return result;
    }

    @NotNull
    public Optional<Object> reduce(BinaryOperator<Object> accumulator) {
        super.evaluate();

        if (accumulator == null)
            throw new NullPointerException();

        if (this.length == 0)
            return Optional.empty();

        Engine.assume(this.length > 0);
        Object value = storage[0];
        for (int i = 1; i < this.length; i++) {
            value = accumulator.apply(value, storage[i]);
        }

        return Optional.of(value);
    }

    @SuppressWarnings("unchecked")
    public Object reduce(Object identity, BiFunction accumulator, BinaryOperator combiner) {
        super.evaluate();

        if (accumulator == null)
            throw new NullPointerException();

        if (combiner == null)
            throw new NullPointerException();

        if (this.length == 0)
            return identity;

        Object result = identity;
        Engine.assume(this.length > 0);
        for (int i = 0; i < this.length; i++) {
            result = accumulator.apply(result, storage[i]);
        }

        return result;
    }

    private <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super Object> accumulator) {
        // TODO: use combiner? #Valya
        R result = supplier.get();
        for (int i = 0; i < this.length; i++) {
            accumulator.accept(result, storage[i]);
        }

        return result;
    }

    public <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super Object> accumulator, BiConsumer<R, R> combiner) {
        super.evaluate();

        if (supplier == null)
            throw new NullPointerException();

        if (accumulator == null)
            throw new NullPointerException();

        if (combiner == null)
            throw new NullPointerException();

        return collect(supplier, accumulator);
    }

    public <R, A> R collect(Collector<? super Object, A, R> collector) {
        super.evaluate();

        if (collector == null)
            throw new NullPointerException();

        return collector.finisher().apply(collect(collector.supplier(), collector.accumulator()));
    }

    @NotNull
    public Optional<Object> min(Comparator<? super Object> comparator) {
        super.evaluate();

        if (comparator == null)
            throw new NullPointerException();

        if (this.length == 0)
            return Optional.empty();

        Object min = storage[0];
        for (int i = 1; i < this.length; i++) {
            if (comparator.compare(min, storage[i]) > 0)
                min = storage[i];
        }

        return Optional.ofNullable(min);
    }

    @NotNull
    public Optional<Object> max(Comparator<? super Object> comparator) {
        super.evaluate();

        if (comparator == null)
            throw new NullPointerException();

        if (this.length == 0)
            return Optional.empty();

        Object max = storage[0];
        for (int i = 1; i < this.length; i++) {
            if (comparator.compare(max, storage[i]) < 0) {
                max = storage[i];
            }
        }

        return Optional.ofNullable(max);
    }

    public long count() {
        super.evaluate();

        return this.length;
    }

    public boolean anyMatch(Predicate<? super Object> predicate) {
        super.evaluate();

        if (predicate == null)
            throw new NullPointerException();

        int i = 0;
        while (i < this.length && !predicate.test(storage[i])) {
            i++;
        }

        return i < this.length;
    }

    public boolean allMatch(Predicate<? super Object> predicate) {
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

    public boolean noneMatch(Predicate<? super Object> predicate) {
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

    @NotNull
    public Optional<Object> findFirst() {
        super.evaluate();
        return  _findFirst();
    }

    @NotNull
    public Optional<Object> findAny() {
        return findFirst();
    }

    @NotNull
    public Iterator<Object> iterator() {
        super.evaluate();
        return new StreamStubIteratorImpl(this, 0);
    }

    @NotNull
    public Spliterator<Object> spliterator() {
        super.evaluate();
        int characteristics = LibSLGlobals.SPLITERATOR_ORDERED | LibSLGlobals.SPLITERATOR_SIZED | LibSLGlobals.SPLITERATOR_SUBSIZED;
        return new ArraySpliterator(this.storage, 0, this.length, characteristics);
    }

    public boolean isParallel() {
        return this.isParallel;
    }

    @NotNull
    public StreamStubImpl sequential() {
        return (StreamStubImpl) super.sequential();
    }

    @NotNull
    public StreamStubImpl parallel() {
        return (StreamStubImpl) super.parallel();
    }

    @NotNull
    public StreamStubImpl unordered() {
        super.evaluate();
        return new StreamStubImpl(this.storage, this.length, this.closeHandlers, false, false);
    }

    @NotNull
    public StreamStubImpl onClose(@NotNull Runnable handler) {
        return (StreamStubImpl) super.onClose(handler);
    }

    public void close() {
        super.close();
    }

    public StreamStubImpl dropWhile(Predicate<? super Object> predicate) {
        super.evaluate();

        if (predicate == null)
            throw new NullPointerException();

        if (this.length == 0)
            return new StreamStubImpl(new Object[0], 0, this.closeHandlers, false, false);

        Engine.assume(this.length > 0);
        int dropLength = 0;
        while (dropLength < this.length && predicate.test(storage[dropLength])) {
            dropLength++;
        }

        if (dropLength == 0)
            return new StreamStubImpl(this.storage, this.length, this.closeHandlers, false, false);

        int newLength = this.length - dropLength;
        Object[] newStorage = new Object[newLength];
        LibSLRuntime.ArrayActions.copy(storage, dropLength, newStorage, 0, newLength);
        return new StreamStubImpl(newStorage, newLength, this.closeHandlers, false, false);
    }

    public StreamStubImpl takeWhile(Predicate<? super Object> predicate) {
        super.evaluate();

        if (predicate == null)
            throw new NullPointerException();

        if (this.length == 0)
            return new StreamStubImpl(new Object[0], 0, this.closeHandlers, false, false);

        Engine.assume(this.length > 0);
        int takeLength = 0;
        while (takeLength < this.length && predicate.test(storage[takeLength])) {
            takeLength++;
        }

        if (takeLength == this.length)
            return new StreamStubImpl(this.storage, this.length, this.closeHandlers, false, false);

        Object[] newStorage = new Object[takeLength];
        LibSLRuntime.ArrayActions.copy(storage, 0, newStorage, 0, takeLength);

        return new StreamStubImpl(newStorage, takeLength, this.closeHandlers, false, false);
    }
}
