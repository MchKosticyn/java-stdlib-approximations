package generated.java.util.stream;

import generated.runtime.LibSLGlobals;
import java.lang.IllegalArgumentException;
import java.lang.IllegalStateException;
import java.lang.Long;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Runnable;
import java.lang.Void;
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
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import org.usvm.api.SymbolicList;
import runtime.LibSLRuntime;
import stub.java.util.Spliterators_LongArraySpliterator;

@Approximate(stub.java.util.stream.LongStreamLSL.class)
public class LongStreamImpl implements LongStream {

    public long[] storage;

    public transient int length;

    public SymbolicList<Runnable> closeHandlers;

    public boolean isParallel;

    public boolean linkedOrConsumed;

    public LongStreamImpl(
        long[] storage,
        int length,
        SymbolicList<Runnable> handlers,
        boolean isParallel,
        boolean linkedOrConsumed
    ) {
        this.storage = storage;
        this.length = length;
        this.closeHandlers = handlers;
        this.isParallel = isParallel;
        this.linkedOrConsumed = linkedOrConsumed;
    }

    /**
     * [SUBROUTINE] LongStreamAutomaton::_actionApply(LongConsumer) -> void
     * Source: java/util/stream/LongStream.main.lsl:117
     */
    private void _actionApply(LongConsumer _action) {
        /* body */ {
            if (_action == null) {
                throw new NullPointerException();
            }
            int i = 0;
            for (i = 0; i < this.length; i++) {
                _action.accept(storage[i]);
            }
            ;
        }
    }

    /**
     * [SUBROUTINE] LongStreamAutomaton::_findFirst() -> OptionalLong
     * Source: java/util/stream/LongStream.main.lsl:136
     */
    private OptionalLong _findFirst() {
        OptionalLong result = null;
        /* body */ {
            if (this.length == 0) {
                result = OptionalLong.empty();
            } else {
                long first = storage[0];
                result = OptionalLong.of(first);
            }
        }
        return result;
    }

    /**
     * [SUBROUTINE] LongStreamAutomaton::_sum() -> long
     * Source: java/util/stream/LongStream.main.lsl:150
     */
    private long _sum() {
        long result = 0L;
        /* body */ {
            result = 0;
            if (this.length != 0) {
                int i = 0;
                for (i = 0; i < this.length; i++) {
                    result += storage[i];
                }
                ;
            }
        }
        return result;
    }

    /**
     * [FUNCTION] LongStreamAutomaton::filter(LongStream, LongPredicate) -> LongStream
     * Source: java/util/stream/LongStream.main.lsl:172
     */
    public LongStream filter(LongPredicate predicate) {
        LongStream result = null;
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (predicate == null) {
                throw new NullPointerException();
            }
            long[] filteredStorage = new long[this.length];
            int filteredLength = 0;
            int i = 0;
            for (i = 0; i < this.length; i++) {
                if (predicate.test(storage[i])) {
                    filteredStorage[filteredLength] = storage[i];
                    filteredLength++;
                }
            }
            ;
            Engine.assume(filteredLength <= this.length);
            long[] resultStorage = new long[filteredLength];
            LibSLRuntime.ArrayActions.copy(filteredStorage, 0, resultStorage, 0, filteredLength);
            result = (stub.java.util.stream.LongStreamLSL) ((Object) new LongStreamImpl((Void) null,
                /* state = */ LongStreamImpl.__$lsl_States.Initialized,
                /* storage = */ resultStorage,
                /* length = */ filteredLength,
                /* closeHandlers = */ this.closeHandlers,
                /* isParallel = */ false,
                /* linkedOrConsumed = */ false
            ));
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] LongStreamAutomaton::map(LongStream, LongUnaryOperator) -> LongStream
     * Source: java/util/stream/LongStream.main.lsl:213
     */
    public LongStream map(LongUnaryOperator mapper) {
        LongStream result = null;
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (mapper == null) {
                throw new NullPointerException();
            }
            long[] mappedStorage = new long[this.length];
            int i = 0;
            for (i = 0; i < this.length; i++) {
                mappedStorage[i] = mapper.applyAsLong(storage[i]);
            }
            ;
            result = (stub.java.util.stream.LongStreamLSL) ((Object) new LongStreamImpl((Void) null,
                /* state = */ LongStreamImpl.__$lsl_States.Initialized,
                /* storage = */ mappedStorage,
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
     * [FUNCTION] LongStreamAutomaton::mapToObj(LongStream, LongFunction) -> Stream
     * Source: java/util/stream/LongStream.main.lsl:244
     */
    public Stream mapToObj(LongFunction mapper) {
        Stream result = null;
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            Object[] objStorage = new Object[this.length];
            int i = 0;
            for (i = 0; i < this.length; i++) {
                objStorage[i] = mapper.apply(storage[i]);
            }
            ;
            result = (stub.java.util.stream.StreamLSL) ((Object) new StreamImpl((Void) null,
                /* state = */ StreamImpl.__$lsl_States.Initialized,
                /* storage = */ objStorage,
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
     * [FUNCTION] LongStreamAutomaton::mapToInt(LongStream, LongToIntFunction) -> IntStream
     * Source: java/util/stream/LongStream.main.lsl:273
     */
    public IntStream mapToInt(LongToIntFunction mapper) {
        IntStream result = null;
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (mapper == null) {
                throw new NullPointerException();
            }
            int[] mappedStorage = new int[this.length];
            int i = 0;
            for (i = 0; i < this.length; i++) {
                mappedStorage[i] = mapper.applyAsInt(storage[i]);
            }
            ;
            result = (stub.java.util.stream.IntStreamLSL) ((Object) new IntStreamImpl((Void) null,
                /* state = */ IntStreamImpl.__$lsl_States.Initialized,
                /* storage = */ mappedStorage,
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
     * [FUNCTION] LongStreamAutomaton::mapToDouble(LongStream, LongToDoubleFunction) -> DoubleStream
     * Source: java/util/stream/LongStream.main.lsl:304
     */
    public DoubleStream mapToDouble(LongToDoubleFunction mapper) {
        DoubleStream result = null;
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (mapper == null) {
                throw new NullPointerException();
            }
            double[] mappedStorage = new double[this.length];
            int i = 0;
            for (i = 0; i < this.length; i++) {
                mappedStorage[i] = mapper.applyAsDouble(storage[i]);
            }
            ;
            result = (stub.java.util.stream.DoubleStreamLSL) ((Object) new DoubleStreamImpl((Void) null,
                /* state = */ DoubleStreamImpl.__$lsl_States.Initialized,
                /* storage = */ mappedStorage,
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
     * [FUNCTION] LongStreamAutomaton::flatMap(LongStream, LongFunction) -> LongStream
     * Source: java/util/stream/LongStream.main.lsl:335
     */
    public LongStream flatMap(LongFunction mapper) {
        LongStream result = null;
        /* body */ {
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
     * [FUNCTION] LongStreamAutomaton::sorted(LongStream) -> LongStream
     * Source: java/util/stream/LongStream.main.lsl:351
     */
    public LongStream sorted() {
        LongStream result = null;
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (this.length == 0) {
                result = (stub.java.util.stream.LongStreamLSL) ((Object) new LongStreamImpl((Void) null,
                    /* state = */ LongStreamImpl.__$lsl_States.Initialized,
                    /* storage = */ this.storage,
                    /* length = */ 0,
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
                        long a = storage[idxA];
                        long b = storage[idxB];
                        if (a > b) {
                            storage[idxA] = b;
                            storage[idxB] = a;
                        }
                    }
                    ;
                }
                ;
                result = (stub.java.util.stream.LongStreamLSL) ((Object) new LongStreamImpl((Void) null,
                    /* state = */ LongStreamImpl.__$lsl_States.Initialized,
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
     * [FUNCTION] LongStreamAutomaton::distinct(LongStream) -> LongStream
     * Source: java/util/stream/LongStream.main.lsl:414
     */
    public LongStream distinct() {
        LongStream result = null;
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            long[] distinctStorage = null;
            int distinctLength = 0;
            int size = this.length;
            if (size == 0) {
                distinctStorage = new long[0];
                distinctLength = 0;
            } else {
                long[] items = this.storage;
                Engine.assume(items != null);
                Engine.assume(items.length != 0);
                Engine.assume(size == items.length);
                int i = 0;
                int j = 0;
                SymbolicList<Long> uniqueItems = Engine.makeSymbolicList();
                LibSLRuntime.Map<Long, Object> visited = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
                for (i = 0; i < size; i++) {
                    long item = items[i];
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
                distinctStorage = new long[distinctLength];
                for (i = 0; i < distinctLength; i++) {
                    Long item = uniqueItems.get(i);
                    Engine.assume(item != null);
                    distinctStorage[i] = ((long) item);
                }
                ;
            }
            result = (stub.java.util.stream.LongStreamLSL) ((Object) new LongStreamImpl((Void) null,
                /* state = */ LongStreamImpl.__$lsl_States.Initialized,
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
     * [FUNCTION] LongStreamAutomaton::peek(Stream, LongConsumer) -> LongStream
     * Source: java/util/stream/LongStream.main.lsl:486
     */
    public LongStream peek(LongConsumer _action) {
        LongStream result = null;
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            _actionApply(_action);
            result = (stub.java.util.stream.LongStreamLSL) ((Object) new LongStreamImpl((Void) null,
                /* state = */ LongStreamImpl.__$lsl_States.Initialized,
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
     * [FUNCTION] LongStreamAutomaton::limit(LongStream, long) -> LongStream
     * Source: java/util/stream/LongStream.main.lsl:502
     */
    public LongStream limit(long maxSize) {
        LongStream result = null;
        /* body */ {
            int maxSizeInt = ((int) maxSize);
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (maxSizeInt < 0) {
                throw new IllegalArgumentException();
            }
            if (maxSizeInt == 0) {
                result = (stub.java.util.stream.LongStreamLSL) ((Object) new LongStreamImpl((Void) null,
                    /* state = */ LongStreamImpl.__$lsl_States.Initialized,
                    /* storage = */ this.storage,
                    /* length = */ 0,
                    /* closeHandlers = */ this.closeHandlers,
                    /* isParallel = */ false,
                    /* linkedOrConsumed = */ false
                ));
            } else {
                if (maxSizeInt > this.length) {
                    result = (stub.java.util.stream.LongStreamLSL) ((Object) new LongStreamImpl((Void) null,
                        /* state = */ LongStreamImpl.__$lsl_States.Initialized,
                        /* storage = */ this.storage,
                        /* length = */ this.length,
                        /* closeHandlers = */ this.closeHandlers,
                        /* isParallel = */ false,
                        /* linkedOrConsumed = */ false
                    ));
                } else {
                    long[] limitStorage = new long[maxSizeInt];
                    LibSLRuntime.ArrayActions.copy(this.storage, 0, limitStorage, 0, maxSizeInt);
                    result = (stub.java.util.stream.LongStreamLSL) ((Object) new LongStreamImpl((Void) null,
                        /* state = */ LongStreamImpl.__$lsl_States.Initialized,
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
     * [FUNCTION] LongStreamAutomaton::skip(LongStream, long) -> LongStream
     * Source: java/util/stream/LongStream.main.lsl:544
     */
    public LongStream skip(long n) {
        LongStream result = null;
        /* body */ {
            int offset = ((int) n);
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (offset < 0) {
                throw new IllegalArgumentException();
            }
            if (offset == 0) {
                result = (stub.java.util.stream.LongStreamLSL) ((Object) new LongStreamImpl((Void) null,
                    /* state = */ LongStreamImpl.__$lsl_States.Initialized,
                    /* storage = */ this.storage,
                    /* length = */ this.length,
                    /* closeHandlers = */ this.closeHandlers,
                    /* isParallel = */ false,
                    /* linkedOrConsumed = */ false
                ));
            } else {
                if (offset >= this.length) {
                    long[] newArray = {};
                    result = (stub.java.util.stream.LongStreamLSL) ((Object) new LongStreamImpl((Void) null,
                        /* state = */ LongStreamImpl.__$lsl_States.Initialized,
                        /* storage = */ newArray,
                        /* length = */ 0,
                        /* closeHandlers = */ this.closeHandlers,
                        /* isParallel = */ false,
                        /* linkedOrConsumed = */ false
                    ));
                } else {
                    int newLength = this.length - offset;
                    long[] skipStorage = new long[newLength];
                    int i = 0;
                    int skipIndex = 0;
                    for (i = offset; i < this.length; i++) {
                        skipStorage[skipIndex] = storage[i];
                        skipIndex++;
                    }
                    ;
                    result = (stub.java.util.stream.LongStreamLSL) ((Object) new LongStreamImpl((Void) null,
                        /* state = */ LongStreamImpl.__$lsl_States.Initialized,
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
     * [FUNCTION] LongStreamAutomaton::forEach(LongStream, LongConsumer) -> void
     * Source: java/util/stream/LongStream.main.lsl:600
     */
    public void forEach(LongConsumer _action) {
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            _actionApply(_action);
            this.linkedOrConsumed = true;
        }
    }

    /**
     * [FUNCTION] LongStreamAutomaton::forEachOrdered(LongStream, LongConsumer) -> void
     * Source: java/util/stream/LongStream.main.lsl:609
     */
    public void forEachOrdered(LongConsumer _action) {
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            _actionApply(_action);
            this.linkedOrConsumed = true;
        }
    }

    /**
     * [FUNCTION] LongStreamAutomaton::toArray(LongStream) -> array<long>
     * Source: java/util/stream/LongStream.main.lsl:618
     */
    public long[] toArray() {
        long[] result = null;
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            result = this.storage;
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] LongStreamAutomaton::reduce(LongStream, long, LongBinaryOperator) -> long
     * Source: java/util/stream/LongStream.main.lsl:627
     */
    public long reduce(long identity, LongBinaryOperator accumulator) {
        long result = 0L;
        /* body */ {
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
                    result = accumulator.applyAsLong(result, storage[i]);
                }
                ;
            }
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] LongStreamAutomaton::reduce(LongStream, LongBinaryOperator) -> OptionalLong
     * Source: java/util/stream/LongStream.main.lsl:656
     */
    public OptionalLong reduce(LongBinaryOperator accumulator) {
        OptionalLong result = null;
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (accumulator == null) {
                throw new NullPointerException();
            }
            if (this.length == 0) {
                result = OptionalLong.empty();
            } else {
                if (this.length > 0) {
                    long value = storage[0];
                    int i = 0;
                    for (i = 1; i < this.length; i++) {
                        value = accumulator.applyAsLong(value, storage[i]);
                    }
                    ;
                    result = OptionalLong.of(value);
                }
            }
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] LongStreamAutomaton::collect(LongStream, Supplier, ObjLongConsumer, BiConsumer) -> Object
     * Source: java/util/stream/LongStream.main.lsl:690
     */
    public Object collect(Supplier supplier, ObjLongConsumer accumulator, BiConsumer combiner) {
        Object result = null;
        /* body */ {
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
     * [FUNCTION] LongStreamAutomaton::min(LongStream) -> OptionalLong
     * Source: java/util/stream/LongStream.main.lsl:722
     */
    public OptionalLong min() {
        OptionalLong result = null;
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (this.length == 0) {
                result = OptionalLong.empty();
            } else {
                long min = storage[0];
                int i = 0;
                for (i = 1; i < this.length; i++) {
                    if (min > storage[i]) {
                        min = storage[i];
                    }
                }
                ;
                result = OptionalLong.of(min);
            }
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] LongStreamAutomaton::max(IntStream) -> OptionalLong
     * Source: java/util/stream/LongStream.main.lsl:754
     */
    public OptionalLong max() {
        OptionalLong result = null;
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (this.length == 0) {
                result = OptionalLong.empty();
            } else {
                long max = storage[0];
                int i = 0;
                for (i = 1; i < this.length; i++) {
                    if (max < storage[i]) {
                        max = storage[i];
                    }
                }
                ;
                result = OptionalLong.of(max);
            }
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] LongStreamAutomaton::count(LongStream) -> long
     * Source: java/util/stream/LongStream.main.lsl:786
     */
    public long count() {
        long result = 0L;
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            result = this.length;
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] LongStreamAutomaton::anyMatch(LongStream, LongPredicate) -> boolean
     * Source: java/util/stream/LongStream.main.lsl:795
     */
    public boolean anyMatch(LongPredicate predicate) {
        boolean result = false;
        /* body */ {
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
     * [FUNCTION] LongStreamAutomaton::allMatch(LongStream, LongPredicate) -> boolean
     * Source: java/util/stream/LongStream.main.lsl:823
     */
    public boolean allMatch(LongPredicate predicate) {
        boolean result = false;
        /* body */ {
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
     * [FUNCTION] LongStreamAutomaton::noneMatch(LongStream, LongPredicate) -> boolean
     * Source: java/util/stream/LongStream.main.lsl:849
     */
    public boolean noneMatch(LongPredicate predicate) {
        boolean result = false;
        /* body */ {
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
     * [FUNCTION] LongStreamAutomaton::findFirst(LongStream) -> OptionalLong
     * Source: java/util/stream/LongStream.main.lsl:875
     */
    public OptionalLong findFirst() {
        OptionalLong result = null;
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            result = _findFirst();
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] LongStreamAutomaton::findAny(LongStream) -> OptionalLong
     * Source: java/util/stream/LongStream.main.lsl:884
     */
    public OptionalLong findAny() {
        OptionalLong result = null;
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            result = _findFirst();
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] LongStreamAutomaton::iterator(LongStream) -> PrimitiveIterator_OfLong
     * Source: java/util/stream/LongStream.main.lsl:893
     */
    public PrimitiveIterator.OfLong iterator() {
        PrimitiveIterator.OfLong result = null;
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            result = (stub.java.util.stream.LongStreamLSLIterator) ((Object) new LongStreamLSLIterator((Void) null,
                /* state = */ LongStreamLSLIterator.__$lsl_States.Initialized,
                /* parent = */ this,
                /* cursor = */ 0
            ));
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] LongStreamAutomaton::spliterator(LongStream) -> Spliterator_OfLong
     * Source: java/util/stream/LongStream.main.lsl:907
     */
    public Spliterator.OfLong spliterator() {
        Spliterator.OfLong result = null;
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            result = (Spliterators_LongArraySpliterator) ((Object) new generated.java.util.Spliterators_LongArraySpliterator((Void) null,
                /* state = */ generated.java.util.Spliterators_LongArraySpliterator.__$lsl_States.Initialized,
                /* array = */ this.storage,
                /* index = */ 0,
                /* fence = */ this.length,
                /* characteristics = */ LibSLGlobals.SPLITERATOR_ORDERED | LibSLGlobals.SPLITERATOR_IMMUTABLE | LibSLGlobals.SPLITERATOR_SIZED | LibSLGlobals.SPLITERATOR_SUBSIZED
            ));
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] LongStreamAutomaton::isParallel(LongStream) -> boolean
     * Source: java/util/stream/LongStream.main.lsl:923
     */
    public boolean isParallel() {
        boolean result = false;
        /* body */ {
            result = this.isParallel;
        }
        return result;
    }

    /**
     * [FUNCTION] LongStreamAutomaton::sequential(LongStream) -> LongStream
     * Source: java/util/stream/LongStream.main.lsl:929
     */
    public LongStream sequential() {
        LongStream result = null;
        /* body */ {
            this.isParallel = false;
            result = this;
        }
        return result;
    }

    /**
     * [FUNCTION] LongStreamAutomaton::parallel(LongStream) -> LongStream
     * Source: java/util/stream/LongStream.main.lsl:936
     */
    public LongStream parallel() {
        LongStream result = null;
        /* body */ {
            this.isParallel = true;
            result = this;
        }
        return result;
    }

    /**
     * [FUNCTION] LongStreamAutomaton::unordered(LongStream) -> LongStream
     * Source: java/util/stream/LongStream.main.lsl:943
     */
    public LongStream unordered() {
        LongStream result = null;
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            result = (stub.java.util.stream.LongStreamLSL) ((Object) new LongStreamImpl((Void) null,
                /* state = */ LongStreamImpl.__$lsl_States.Initialized,
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
     * [FUNCTION] LongStreamAutomaton::onClose(LongStream, Runnable) -> LongStream
     * Source: java/util/stream/LongStream.main.lsl:956
     */
    public LongStream onClose(Runnable closeHandler) {
        LongStream result = null;
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            int listLength = this.closeHandlers.size();
            this.closeHandlers.insert(listLength, closeHandler);
            result = this;
        }
        return result;
    }

    /**
     * [FUNCTION] LongStreamAutomaton::close(LongStream) -> void
     * Source: java/util/stream/LongStream.main.lsl:968
     */
    public void close() {
        /* body */ {
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
     * [FUNCTION] LongStreamAutomaton::dropWhile(LongStream, LongPredicate) -> LongStream
     * Source: java/util/stream/LongStream.main.lsl:992
     */
    public LongStream dropWhile(LongPredicate predicate) {
        LongStream result = null;
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (predicate == null) {
                throw new NullPointerException();
            }
            if (this.length == 0) {
                long[] emptyStorage = new long[0];
                result = (stub.java.util.stream.LongStreamLSL) ((Object) new LongStreamImpl((Void) null,
                    /* state = */ LongStreamImpl.__$lsl_States.Initialized,
                    /* storage = */ emptyStorage,
                    /* length = */ 0,
                    /* closeHandlers = */ this.closeHandlers,
                    /* isParallel = */ false,
                    /* linkedOrConsumed = */ false
                ));
            } else {
                Engine.assume(this.length > 0);
                int dropLength = 0;
                int i = 0;
                while ((i < this.length) && predicate.test(storage[i])) {
                    dropLength++;
                    i++;
                }
                ;
                if (dropLength == 0) {
                    result = (stub.java.util.stream.LongStreamLSL) ((Object) new LongStreamImpl((Void) null,
                        /* state = */ LongStreamImpl.__$lsl_States.Initialized,
                        /* storage = */ this.storage,
                        /* length = */ this.length,
                        /* closeHandlers = */ this.closeHandlers,
                        /* isParallel = */ false,
                        /* linkedOrConsumed = */ false
                    ));
                } else {
                    int newLength = this.length - dropLength;
                    long[] newStorage = new long[newLength];
                    int j = dropLength;
                    i = dropLength;
                    while (i < this.length) {
                        newStorage[j] = storage[i];
                        j++;
                        i++;
                    }
                    ;
                    result = (stub.java.util.stream.LongStreamLSL) ((Object) new LongStreamImpl((Void) null,
                        /* state = */ LongStreamImpl.__$lsl_States.Initialized,
                        /* storage = */ newStorage,
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
     * [FUNCTION] LongStreamAutomaton::takeWhile(LongStream, LongPredicate) -> LongStream
     * Source: java/util/stream/LongStream.main.lsl:1067
     */
    public LongStream takeWhile(LongPredicate predicate) {
        LongStream result = null;
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (predicate == null) {
                throw new NullPointerException();
            }
            if (this.length == 0) {
                long[] emptyStorage = new long[0];
                result = (stub.java.util.stream.LongStreamLSL) ((Object) new LongStreamImpl((Void) null,
                    /* state = */ LongStreamImpl.__$lsl_States.Initialized,
                    /* storage = */ emptyStorage,
                    /* length = */ 0,
                    /* closeHandlers = */ this.closeHandlers,
                    /* isParallel = */ false,
                    /* linkedOrConsumed = */ false
                ));
            } else {
                Engine.assume(this.length > 0);
                int takeLength = 0;
                int i = 0;
                while ((i < this.length) && predicate.test(storage[i])) {
                    takeLength++;
                    i++;
                }
                ;
                if (takeLength == this.length) {
                    result = (stub.java.util.stream.LongStreamLSL) ((Object) new LongStreamImpl((Void) null,
                        /* state = */ LongStreamImpl.__$lsl_States.Initialized,
                        /* storage = */ this.storage,
                        /* length = */ this.length,
                        /* closeHandlers = */ this.closeHandlers,
                        /* isParallel = */ false,
                        /* linkedOrConsumed = */ false
                    ));
                } else {
                    int newLength = takeLength;
                    long[] newStorage = new long[newLength];
                    int j = 0;
                    i = 0;
                    while (i < takeLength) {
                        newStorage[j] = storage[i];
                        j++;
                        i++;
                    }
                    ;
                    result = (stub.java.util.stream.LongStreamLSL) ((Object) new LongStreamImpl((Void) null,
                        /* state = */ LongStreamImpl.__$lsl_States.Initialized,
                        /* storage = */ newStorage,
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
     * [FUNCTION] LongStreamAutomaton::asDoubleStream(LongStream) -> DoubleStream
     * Source: java/util/stream/LongStream.main.lsl:1142
     */
    public DoubleStream asDoubleStream() {
        DoubleStream result = null;
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (this.length == 0) {
                double[] emptyArray = {};
                result = (stub.java.util.stream.DoubleStreamLSL) ((Object) new DoubleStreamImpl((Void) null,
                    /* state = */ DoubleStreamImpl.__$lsl_States.Initialized,
                    /* storage = */ emptyArray,
                    /* length = */ 0,
                    /* closeHandlers = */ this.closeHandlers,
                    /* isParallel = */ false,
                    /* linkedOrConsumed = */ false
                ));
            } else {
                Engine.assume(this.length > 0);
                double[] newStorage = new double[this.length];
                int i = 0;
                for (i = 0; i < this.length; i += 1) {
                    newStorage[i] = ((double) storage[i]);
                }
                ;
                result = (stub.java.util.stream.DoubleStreamLSL) ((Object) new DoubleStreamImpl((Void) null,
                    /* state = */ DoubleStreamImpl.__$lsl_States.Initialized,
                    /* storage = */ newStorage,
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
     * [FUNCTION] LongStreamAutomaton::sum(LongStream) -> long
     * Source: java/util/stream/LongStream.main.lsl:1184
     */
    public long sum() {
        long result = 0L;
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            result = _sum();
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] LongStreamAutomaton::average(LongStream) -> OptionalDouble
     * Source: java/util/stream/LongStream.main.lsl:1194
     */
    public OptionalDouble average() {
        OptionalDouble result = null;
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (this.length == 0) {
                result = OptionalDouble.empty();
            } else {
                double curSum = _sum();
                double divisionResult = curSum / this.length;
                result = OptionalDouble.of(divisionResult);
            }
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] LongStreamAutomaton::summaryStatistics(LongStream) -> LongSummaryStatistics
     * Source: java/util/stream/LongStream.main.lsl:1213
     */
    public LongSummaryStatistics summaryStatistics() {
        LongSummaryStatistics result = null;
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            result = new LongSummaryStatistics();
            int i = 0;
            for (i = 0; i < this.length; i += 1) {
                result.accept(storage[i]);
            }
            ;
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] LongStreamAutomaton::boxed(LongStream) -> Stream
     * Source: java/util/stream/LongStream.main.lsl:1234
     */
    public Stream boxed() {
        Stream result = null;
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            Long[] longArray = new Long[this.length];
            int i = 0;
            for (i = 0; i < this.length; i += 1) {
                longArray[i] = storage[i];
            }
            ;
            result = (stub.java.util.stream.StreamLSL) ((Object) new StreamImpl((Void) null,
                /* state = */ StreamImpl.__$lsl_States.Initialized,
                /* storage = */ longArray,
                /* length = */ this.length,
                /* closeHandlers = */ this.closeHandlers,
                /* isParallel = */ false,
                /* linkedOrConsumed = */ false
            ));
            this.linkedOrConsumed = true;
        }
        return result;
    }
}
