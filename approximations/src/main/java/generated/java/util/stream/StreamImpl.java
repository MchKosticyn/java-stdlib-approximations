package generated.java.util.stream;

import generated.runtime.LibSLGlobals;

import java.lang.Comparable;
import java.lang.IllegalArgumentException;
import java.lang.IllegalStateException;
import java.lang.NullPointerException;
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
import java.util.stream.BaseStream;
import java.util.stream.Collector;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import org.usvm.api.SymbolicList;
import runtime.LibSLRuntime;
import stub.java.util.Spliterators_ArraySpliterator;

@Approximate(stub.java.util.stream.StreamLSL.class)
public class StreamImpl extends BaseStreamImpl implements Stream<Object> {

    public Object[] storage;

    public StreamImpl(
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
        if (_action == null) {
            throw new NullPointerException();
        }
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
        if (this.linkedOrConsumed) {
            throw new IllegalStateException();
        }
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
        this.linkedOrConsumed = true;
        return new StreamImpl(resultStorage, filteredLength, this.closeHandlers, false, false);
    }

    @SuppressWarnings("unchecked")
    public <T> Stream<T> map(Function<? super Object, ? extends T> mapper) {
        if (this.linkedOrConsumed) {
            throw new IllegalStateException();
        }
        if (mapper == null) {
            throw new NullPointerException();
        }
        Object[] mappedStorage = new Object[this.length];
        for (int i = 0; i < this.length; i++) {
            mappedStorage[i] = mapper.apply(storage[i]);
        }

        this.linkedOrConsumed = true;
        return (Stream<T>) new StreamImpl(
                mappedStorage,
                this.length,
                this.closeHandlers,
                false,
                false);
    }

    public IntStream mapToInt(ToIntFunction<? super Object> mapper) {
        if (this.linkedOrConsumed) {
            throw new IllegalStateException();
        }
        if (mapper == null) {
            throw new NullPointerException();
        }
        int[] mappedStorage = new int[this.length];
        for (int i = 0; i < this.length; i++) {
            mappedStorage[i] = mapper.applyAsInt(storage[i]);
        }
        this.linkedOrConsumed = true;
        return new IntStreamImpl(mappedStorage, length, closeHandlers, false, false);
    }

    public LongStream mapToLong(ToLongFunction<? super Object> mapper) {
        if (this.linkedOrConsumed) {
            throw new IllegalStateException();
        }
        if (mapper == null) {
            throw new NullPointerException();
        }
        long[] mappedStorage = new long[this.length];
        for (int i = 0; i < this.length; i++) {
            mappedStorage[i] = mapper.applyAsLong(storage[i]);
        }
        this.linkedOrConsumed = true;
        return new LongStreamImpl(mappedStorage, this.length, this.closeHandlers, false, false);
    }

    public DoubleStream mapToDouble(ToDoubleFunction<? super Object> mapper) {
        if (this.linkedOrConsumed) {
            throw new IllegalStateException();
        }
        if (mapper == null) {
            throw new NullPointerException();
        }
        double[] mappedStorage = new double[this.length];
        for (int i = 0; i < this.length; i++) {
            mappedStorage[i] = mapper.applyAsDouble(storage[i]);
        }
        this.linkedOrConsumed = true;
        return new DoubleStreamImpl(mappedStorage, this.length, this.closeHandlers, false, false);
    }

    @SuppressWarnings({"ConstantValue", "unchecked"})
    public <R> Stream<R> flatMap(Function<? super Object, ? extends Stream<? extends R>> mapper) {
        if (this.linkedOrConsumed) {
            throw new IllegalStateException();
        }
        if (mapper == null) {
            throw new NullPointerException();
        }
        Stream<R> result = Engine.makeSymbolic(Stream.class);
        Engine.assume(result != null);
        this.linkedOrConsumed = true;
        return result;
    }

    @SuppressWarnings("ConstantValue")
    public IntStream flatMapToInt(Function mapper) {
        if (this.linkedOrConsumed) {
            throw new IllegalStateException();
        }
        if (mapper == null) {
            throw new NullPointerException();
        }
        IntStream result = Engine.makeSymbolic(IntStream.class);
        Engine.assume(result != null);
        this.linkedOrConsumed = true;
        return result;
    }

    public LongStream flatMapToLong(Function mapper) {
        LongStream result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */
        {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (mapper == null) {
                throw new NullPointerException();
            }
            result = Engine.makeSymbolic(LongStream.class);
            Engine.assume(result != null);
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] StreamAutomaton::flatMapToDouble(Stream, Function) -> DoubleStream
     * Source: java/util/stream/Stream.main.lsl:382
     */
    public DoubleStream flatMapToDouble(Function mapper) {
        DoubleStream result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */
        {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (mapper == null) {
                throw new NullPointerException();
            }
            result = Engine.makeSymbolic(DoubleStream.class);
            Engine.assume(result != null);
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] StreamAutomaton::distinct(Stream) -> Stream
     * Source: java/util/stream/Stream.main.lsl:398
     */
    public Stream distinct() {
        Stream result = null;
        /* body */
        {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            Object[] distinctStorage = null;
            int distinctLength = 0;
            int size = this.length;
            if (size == 0) {
                distinctStorage = new Object[0];
                distinctLength = 0;
            } else {
                Object[] items = this.storage;
                Engine.assume(items != null);
                Engine.assume(items.length != 0);
                Engine.assume(size == items.length);
                int i = 0;
                int j = 0;
                SymbolicList<Object> uniqueItems = Engine.makeSymbolicList();
                LibSLRuntime.Map<Object, Object> visited = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
                for (i = 0; i < size; i++) {
                    Object item = items[i];
                    if (!visited.hasKey(item)) {
                        visited.set(item, LibSLGlobals.SOMETHING);
                        uniqueItems.insert(j, item);
                        j++;
                    }
                }
                ;
                distinctLength = j;
                Engine.assume(distinctLength > 0);
                Engine.assume(distinctLength <= size);
                distinctStorage = new Object[distinctLength];
                for (i = 0; i < distinctLength; i++) {
                    distinctStorage[i] = uniqueItems.get(i);
                }
                ;
            }
            result = (stub.java.util.stream.StreamLSL) ((Object) new StreamImpl((Void) null,
                    /* state = */ StreamImpl.__$lsl_States.Initialized,
                    /* storage = */ distinctStorage,
                    /* length = */ distinctLength,
                    /* closeHandlers = */ this.closeHandlers,
                    /* isParallel = */ false,
                    /* linkedOrConsumed = */ false
            ));
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] StreamAutomaton::sorted(Stream) -> Stream
     * Source: java/util/stream/Stream.main.lsl:468
     */
    public Stream sorted() {
        Stream result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */
        {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (this.length == 0) {
                result = (stub.java.util.stream.StreamLSL) ((Object) new StreamImpl((Void) null,
                        /* state = */ StreamImpl.__$lsl_States.Initialized,
                        /* storage = */ this.storage,
                        /* length = */ this.length,
                        /* closeHandlers = */ this.closeHandlers,
                        /* isParallel = */ false,
                        /* linkedOrConsumed = */ false
                ));
            } else {
                Engine.assume(this.length > 0);
                int outerLimit = this.length - 1;
                int innerLimit = 0;
                int i = 0;
                int j = 0;
                for (i = 0; i < outerLimit; i++) {
                    innerLimit = (this.length - i) - 1;
                    for (j = 0; j < innerLimit; j++) {
                        int idxA = j;
                        int idxB = j + 1;
                        Object a = storage[idxA];
                        Object b = storage[idxB];
                        if (((Comparable) a).compareTo(b) > 0) {
                            storage[idxA] = b;
                            storage[idxB] = a;
                        }
                    }
                    ;
                }
                ;
                result = (stub.java.util.stream.StreamLSL) ((Object) new StreamImpl((Void) null,
                        /* state = */ StreamImpl.__$lsl_States.Initialized,
                        /* storage = */ this.storage,
                        /* length = */ this.length,
                        /* closeHandlers = */ this.closeHandlers,
                        /* isParallel = */ false,
                        /* linkedOrConsumed = */ false
                ));
            }
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] StreamAutomaton::sorted(Stream, Comparator) -> Stream
     * Source: java/util/stream/Stream.main.lsl:531
     */
    public Stream sorted(Comparator comparator) {
        Stream result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */
        {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (this.length == 0) {
                result = (stub.java.util.stream.StreamLSL) ((Object) new StreamImpl((Void) null,
                        /* state = */ StreamImpl.__$lsl_States.Initialized,
                        /* storage = */ this.storage,
                        /* length = */ this.length,
                        /* closeHandlers = */ this.closeHandlers,
                        /* isParallel = */ false,
                        /* linkedOrConsumed = */ false
                ));
            } else {
                int outerLimit = this.length - 1;
                int innerLimit = 0;
                int i = 0;
                int j = 0;
                for (i = 0; i < outerLimit; i++) {
                    innerLimit = (this.length - i) - 1;
                    for (j = 0; j < innerLimit; j++) {
                        int idxA = j;
                        int idxB = j + 1;
                        Object a = storage[idxA];
                        Object b = storage[idxB];
                        if (comparator.compare(a, b) > 0) {
                            storage[idxA] = b;
                            storage[idxB] = a;
                        }
                    }
                    ;
                }
                ;
                result = (stub.java.util.stream.StreamLSL) ((Object) new StreamImpl((Void) null,
                        /* state = */ StreamImpl.__$lsl_States.Initialized,
                        /* storage = */ this.storage,
                        /* length = */ this.length,
                        /* closeHandlers = */ this.closeHandlers,
                        /* isParallel = */ false,
                        /* linkedOrConsumed = */ false
                ));
            }
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] StreamAutomaton::peek(Stream, Consumer) -> Stream
     * Source: java/util/stream/Stream.main.lsl:591
     */
    public Stream peek(Consumer _action) {
        Stream result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */
        {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            _actionApply(_action);
            result = (stub.java.util.stream.StreamLSL) ((Object) new StreamImpl((Void) null,
                    /* state = */ StreamImpl.__$lsl_States.Initialized,
                    /* storage = */ this.storage,
                    /* length = */ this.length,
                    /* closeHandlers = */ this.closeHandlers,
                    /* isParallel = */ false,
                    /* linkedOrConsumed = */ false
            ));
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] StreamAutomaton::limit(Stream, long) -> Stream
     * Source: java/util/stream/Stream.main.lsl:608
     */
    public Stream limit(long maxSize) {
        Stream result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */
        {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (maxSize < 0) {
                throw new IllegalArgumentException();
            }
            if (maxSize == 0) {
                result = (stub.java.util.stream.StreamLSL) ((Object) new StreamImpl((Void) null,
                        /* state = */ StreamImpl.__$lsl_States.Initialized,
                        /* storage = */ this.storage,
                        /* length = */ 0,
                        /* closeHandlers = */ this.closeHandlers,
                        /* isParallel = */ false,
                        /* linkedOrConsumed = */ false
                ));
            } else {
                if (maxSize > this.length) {
                    result = (stub.java.util.stream.StreamLSL) ((Object) new StreamImpl((Void) null,
                            /* state = */ StreamImpl.__$lsl_States.Initialized,
                            /* storage = */ this.storage,
                            /* length = */ this.length,
                            /* closeHandlers = */ this.closeHandlers,
                            /* isParallel = */ false,
                            /* linkedOrConsumed = */ false
                    ));
                } else {
                    int maxSizeInt = ((int) maxSize);
                    Object[] limitStorage = new Object[maxSizeInt];
                    int i = 0;
                    for (i = 0; i < maxSizeInt; i++) {
                        limitStorage[i] = storage[i];
                    }
                    ;
                    result = (stub.java.util.stream.StreamLSL) ((Object) new StreamImpl((Void) null,
                            /* state = */ StreamImpl.__$lsl_States.Initialized,
                            /* storage = */ limitStorage,
                            /* length = */ maxSizeInt,
                            /* closeHandlers = */ this.closeHandlers,
                            /* isParallel = */ false,
                            /* linkedOrConsumed = */ false
                    ));
                }
            }
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] StreamAutomaton::skip(Stream, long) -> Stream
     * Source: java/util/stream/Stream.main.lsl:661
     */
    public Stream skip(long n) {
        Stream result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */
        {
            int offset = ((int) n);
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (offset < 0) {
                throw new IllegalArgumentException();
            }
            if (offset == 0) {
                result = (stub.java.util.stream.StreamLSL) ((Object) new StreamImpl((Void) null,
                        /* state = */ StreamImpl.__$lsl_States.Initialized,
                        /* storage = */ this.storage,
                        /* length = */ this.length,
                        /* closeHandlers = */ this.closeHandlers,
                        /* isParallel = */ false,
                        /* linkedOrConsumed = */ false
                ));
            } else {
                if (offset >= this.length) {
                    Object[] newArray = {};
                    result = (stub.java.util.stream.StreamLSL) ((Object) new StreamImpl((Void) null,
                            /* state = */ StreamImpl.__$lsl_States.Initialized,
                            /* storage = */ newArray,
                            /* length = */ 0,
                            /* closeHandlers = */ this.closeHandlers,
                            /* isParallel = */ false,
                            /* linkedOrConsumed = */ false
                    ));
                } else {
                    int newLength = this.length - offset;
                    Object[] skipStorage = new Object[newLength];
                    int i = 0;
                    int skipIndex = 0;
                    for (i = offset; i < this.length; i++) {
                        skipStorage[skipIndex] = storage[i];
                        skipIndex++;
                    }
                    ;
                    result = (stub.java.util.stream.StreamLSL) ((Object) new StreamImpl((Void) null,
                            /* state = */ StreamImpl.__$lsl_States.Initialized,
                            /* storage = */ skipStorage,
                            /* length = */ newLength,
                            /* closeHandlers = */ this.closeHandlers,
                            /* isParallel = */ false,
                            /* linkedOrConsumed = */ false
                    ));
                }
            }
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] StreamAutomaton::forEach(Stream, Consumer) -> void
     * Source: java/util/stream/Stream.main.lsl:717
     */
    public void forEach(Consumer _action) {
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */
        {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            _actionApply(_action);
            this.linkedOrConsumed = true;
        }
    }

    /**
     * [FUNCTION] StreamAutomaton::forEachOrdered(Stream, Consumer) -> void
     * Source: java/util/stream/Stream.main.lsl:726
     */
    public void forEachOrdered(Consumer _action) {
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */
        {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            _actionApply(_action);
            this.linkedOrConsumed = true;
        }
    }

    /**
     * [FUNCTION] StreamAutomaton::toArray(Stream) -> array<Object>
     * Source: java/util/stream/Stream.main.lsl:735
     */
    public Object[] toArray() {
        Object[] result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */
        {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            result = this.storage;
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] StreamAutomaton::toArray(Stream, IntFunction) -> array<Object>
     * Source: java/util/stream/Stream.main.lsl:744
     */
    public Object[] toArray(IntFunction generator) {
        Object[] result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */
        {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            Object[] generatedArray = ((Object[]) generator.apply(this.length));
            LibSLRuntime.ArrayActions.copy(this.storage, 0, generatedArray, 0, this.length);
            result = generatedArray;
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] StreamAutomaton::reduce(Stream, Object, BinaryOperator) -> Object
     * Source: java/util/stream/Stream.main.lsl:757
     */
    public Object reduce(Object identity, BinaryOperator accumulator) {
        Object result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */
        {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (accumulator == null) {
                throw new NullPointerException();
            }
            result = identity;
            if (this.length != 0) {
                Engine.assume(this.length > 0);
                int i = 0;
                for (i = 0; i < this.length; i++) {
                    result = accumulator.apply(result, storage[i]);
                }
                ;
            }
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] StreamAutomaton::reduce(Stream, BinaryOperator) -> Optional
     * Source: java/util/stream/Stream.main.lsl:786
     */
    public Optional reduce(BinaryOperator accumulator) {
        Optional result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */
        {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (accumulator == null) {
                throw new NullPointerException();
            }
            Object value = null;
            if (this.length == 0) {
                result = Optional.empty();
            } else {
                if (this.length > 0) {
                    value = storage[0];
                    int i = 0;
                    for (i = 1; i < this.length; i++) {
                        value = accumulator.apply(value, storage[i]);
                    }
                    ;
                    result = Optional.ofNullable(value);
                }
            }
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] StreamAutomaton::reduce(Stream, Object, BiFunction, BinaryOperator) -> Object
     * Source: java/util/stream/Stream.main.lsl:822
     */
    public Object reduce(Object identity, BiFunction accumulator, BinaryOperator combiner) {
        Object result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */
        {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (accumulator == null) {
                throw new NullPointerException();
            }
            if (combiner == null) {
                throw new NullPointerException();
            }
            result = identity;
            if (this.length != 0) {
                Engine.assume(this.length > 0);
                int i = 0;
                for (i = 0; i < this.length; i++) {
                    result = accumulator.apply(result, storage[i]);
                }
                ;
            }
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] StreamAutomaton::collect(Stream, Supplier, BiConsumer, BiConsumer) -> Object
     * Source: java/util/stream/Stream.main.lsl:855
     */
    public Object collect(Supplier supplier, BiConsumer accumulator, BiConsumer combiner) {
        Object result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */
        {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (supplier == null) {
                throw new NullPointerException();
            }
            if (accumulator == null) {
                throw new NullPointerException();
            }
            if (combiner == null) {
                throw new NullPointerException();
            }
            result = supplier.get();
            int i = 0;
            for (i = 0; i < this.length; i++) {
                accumulator.accept(result, storage[i]);
            }
            ;
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] StreamAutomaton::collect(Stream, Collector) -> Object
     * Source: java/util/stream/Stream.main.lsl:887
     */
    public Object collect(Collector collector) {
        Object result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */
        {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (collector == null) {
                throw new NullPointerException();
            }
            int i = 0;
            BiConsumer accumulator = collector.accumulator();
            for (i = 0; i < this.length; i++) {
                accumulator.accept(result, storage[i]);
            }
            ;
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] StreamAutomaton::min(Stream, Comparator) -> Optional
     * Source: java/util/stream/Stream.main.lsl:905
     */
    public Optional min(Comparator comparator) {
        Optional result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */
        {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (comparator == null) {
                throw new NullPointerException();
            }
            if (this.length == 0) {
                result = Optional.empty();
            } else {
                Object min = storage[0];
                int i = 0;
                for (i = 1; i < this.length; i++) {
                    if (comparator.compare(min, storage[i]) > 0) {
                        min = storage[i];
                    }
                }
                ;
                result = Optional.ofNullable(min);
            }
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] StreamAutomaton::max(Stream, Comparator) -> Optional
     * Source: java/util/stream/Stream.main.lsl:940
     */
    public Optional max(Comparator comparator) {
        Optional result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */
        {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (comparator == null) {
                throw new NullPointerException();
            }
            if (this.length == 0) {
                result = Optional.empty();
            } else {
                Object max = storage[0];
                int i = 0;
                for (i = 1; i < this.length; i++) {
                    if (comparator.compare(max, storage[i]) < 0) {
                        max = storage[i];
                    }
                }
                ;
                result = Optional.ofNullable(max);
            }
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] StreamAutomaton::count(Stream) -> long
     * Source: java/util/stream/Stream.main.lsl:975
     */
    public long count() {
        long result = 0L;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */
        {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            result = this.length;
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] StreamAutomaton::anyMatch(Stream, Predicate) -> boolean
     * Source: java/util/stream/Stream.main.lsl:984
     */
    public boolean anyMatch(Predicate predicate) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */
        {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (predicate == null) {
                throw new NullPointerException();
            }
            result = false;
            int i = 0;
            while ((i < this.length) && !predicate.test(storage[i])) {
                i++;
            }
            ;
            if (i < this.length) {
                result = true;
            }
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] StreamAutomaton::allMatch(Stream, Predicate) -> boolean
     * Source: java/util/stream/Stream.main.lsl:1012
     */
    public boolean allMatch(Predicate predicate) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */
        {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (predicate == null) {
                throw new NullPointerException();
            }
            result = true;
            if (this.length > 0) {
                result = false;
                int i = 0;
                while ((i < this.length) && predicate.test(storage[i])) {
                    i++;
                }
                ;
                if (i == this.length) {
                    result = true;
                }
            }
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] StreamAutomaton::noneMatch(Stream, Predicate) -> boolean
     * Source: java/util/stream/Stream.main.lsl:1038
     */
    public boolean noneMatch(Predicate predicate) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */
        {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (predicate == null) {
                throw new NullPointerException();
            }
            result = true;
            if (this.length > 0) {
                result = false;
                int i = 0;
                while ((i < this.length) && !predicate.test(storage[i])) {
                    i++;
                }
                ;
                if (i == this.length) {
                    result = true;
                }
            }
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] StreamAutomaton::findFirst(Stream) -> Optional
     * Source: java/util/stream/Stream.main.lsl:1064
     */
    public Optional findFirst() {
        Optional result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */
        {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            result = _findFirst();
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] StreamAutomaton::findAny(Stream) -> Optional
     * Source: java/util/stream/Stream.main.lsl:1073
     */
    public Optional findAny() {
        Optional result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */
        {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            result = _findFirst();
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] StreamAutomaton::iterator(Stream) -> Iterator
     * Source: java/util/stream/Stream.main.lsl:1083
     */
    public Iterator iterator() {
        Iterator result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */
        {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            result = (stub.java.util.stream.StreamLSLIterator) ((Object) new StreamLSLIterator((Void) null,
                    /* state = */ StreamLSLIterator.__$lsl_States.Initialized,
                    /* parent = */ this,
                    /* cursor = */ 0
            ));
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] StreamAutomaton::spliterator(Stream) -> Spliterator
     * Source: java/util/stream/Stream.main.lsl:1097
     */
    public Spliterator spliterator() {
        Spliterator result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */
        {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            result = (Spliterators_ArraySpliterator) ((Object) new generated.java.util.Spliterators_ArraySpliterator((Void) null,
                    /* state = */ generated.java.util.Spliterators_ArraySpliterator.__$lsl_States.Initialized,
                    /* array = */ this.storage,
                    /* index = */ 0,
                    /* fence = */ this.length,
                    /* characteristics = */ LibSLGlobals.SPLITERATOR_ORDERED | LibSLGlobals.SPLITERATOR_SIZED | LibSLGlobals.SPLITERATOR_SUBSIZED
            ));
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] StreamAutomaton::isParallel(Stream) -> boolean
     * Source: java/util/stream/Stream.main.lsl:1113
     */
    public boolean isParallel() {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */
        {
            result = this.isParallel;
        }
        return result;
    }

    /**
     * [FUNCTION] StreamAutomaton::sequential(Stream) -> BaseStream
     * Source: java/util/stream/Stream.main.lsl:1120
     */
    public BaseStream sequential() {
        BaseStream result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */
        {
            this.isParallel = false;
            result = this;
        }
        return result;
    }

    /**
     * [FUNCTION] StreamAutomaton::parallel(Stream) -> BaseStream
     * Source: java/util/stream/Stream.main.lsl:1128
     */
    public BaseStream parallel() {
        BaseStream result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */
        {
            this.isParallel = true;
            result = this;
        }
        return result;
    }

    /**
     * [FUNCTION] StreamAutomaton::unordered(Stream) -> BaseStream
     * Source: java/util/stream/Stream.main.lsl:1136
     */
    public BaseStream unordered() {
        BaseStream result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */
        {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            result = (stub.java.util.stream.StreamLSL) ((Object) new StreamImpl((Void) null,
                    /* state = */ StreamImpl.__$lsl_States.Initialized,
                    /* storage = */ this.storage,
                    /* length = */ this.length,
                    /* closeHandlers = */ this.closeHandlers,
                    /* isParallel = */ false,
                    /* linkedOrConsumed = */ false
            ));
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] StreamAutomaton::onClose(Stream, Runnable) -> BaseStream
     * Source: java/util/stream/Stream.main.lsl:1149
     */
    public BaseStream onClose(Runnable arg0) {
        BaseStream result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */
        {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            int listLength = this.closeHandlers.size();
            this.closeHandlers.insert(listLength, arg0);
            result = this;
        }
        return result;
    }

    /**
     * [FUNCTION] StreamAutomaton::close(Stream) -> void
     * Source: java/util/stream/Stream.main.lsl:1161
     */
    public void close() {
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */
        {
            int listLength = this.closeHandlers.size();
            int i = 0;
            for (i = 0; i < listLength; i++) {
                Runnable currentHandler = ((Runnable) this.closeHandlers.get(i));
                currentHandler.run();
            }
            ;
            this.closeHandlers = Engine.makeSymbolicList();
            this.linkedOrConsumed = true;
        }
    }

    /**
     * [FUNCTION] StreamAutomaton::dropWhile(Stream, Predicate) -> Stream
     * Source: java/util/stream/Stream.main.lsl:1185
     */
    public Stream dropWhile(Predicate predicate) {
        Stream result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */
        {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (predicate == null) {
                throw new NullPointerException();
            }
            if (this.length == 0) {
                Object[] emptyStorage = new Object[0];
                result = (stub.java.util.stream.StreamLSL) ((Object) new StreamImpl((Void) null,
                        /* state = */ StreamImpl.__$lsl_States.Initialized,
                        /* storage = */ emptyStorage,
                        /* length = */ 0,
                        /* closeHandlers = */ this.closeHandlers,
                        /* isParallel = */ false,
                        /* linkedOrConsumed = */ false
                ));
            } else {
                int dropLength = 0;
                int i = 0;
                for (i = 0; i < this.length; i += 1) {
                    if (predicate.test(storage[i])) {
                        dropLength += 1;
                    } else {
                        break;
                    }
                }
                ;
                int newLength = this.length - dropLength;
                Object[] newStorage = new Object[newLength];
                int j = 0;
                for (i = dropLength; i < this.length; i += 1) {
                    newStorage[j] = storage[i];
                    j += 1;
                }
                ;
                result = (stub.java.util.stream.StreamLSL) ((Object) new StreamImpl((Void) null,
                        /* state = */ StreamImpl.__$lsl_States.Initialized,
                        /* storage = */ newStorage,
                        /* length = */ newLength,
                        /* closeHandlers = */ this.closeHandlers,
                        /* isParallel = */ false,
                        /* linkedOrConsumed = */ false
                ));
            }
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] StreamAutomaton::takeWhile(Stream, Predicate) -> Stream
     * Source: java/util/stream/Stream.main.lsl:1247
     */
    public Stream takeWhile(Predicate predicate) {
        Stream result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */
        {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (predicate == null) {
                throw new NullPointerException();
            }
            if (this.length == 0) {
                Object[] emptyStorage = new Object[0];
                result = (stub.java.util.stream.StreamLSL) ((Object) new StreamImpl((Void) null,
                        /* state = */ StreamImpl.__$lsl_States.Initialized,
                        /* storage = */ emptyStorage,
                        /* length = */ 0,
                        /* closeHandlers = */ this.closeHandlers,
                        /* isParallel = */ false,
                        /* linkedOrConsumed = */ false
                ));
            } else {
                int takeLength = 0;
                int i = 0;
                for (i = 0; i < this.length; i += 1) {
                    if (predicate.test(storage[i])) {
                        takeLength += 1;
                    } else {
                        break;
                    }
                }
                ;
                int newLength = takeLength;
                Object[] newStorage = new Object[newLength];
                int j = 0;
                for (i = 0; i < takeLength; i += 1) {
                    newStorage[j] = storage[i];
                    j += 1;
                }
                ;
                result = (stub.java.util.stream.StreamLSL) ((Object) new StreamImpl((Void) null,
                        /* state = */ StreamImpl.__$lsl_States.Initialized,
                        /* storage = */ newStorage,
                        /* length = */ newLength,
                        /* closeHandlers = */ this.closeHandlers,
                        /* isParallel = */ false,
                        /* linkedOrConsumed = */ false
                ));
            }
            this.linkedOrConsumed = true;
        }
        return result;
    }
}
