package generated.java.util.stream;

import generated.runtime.LibSLGlobals;
import java.lang.IllegalArgumentException;
import java.lang.IllegalStateException;
import java.lang.Integer;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Runnable;
import java.lang.Void;
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
import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;
import org.usvm.api.SymbolicList;
import runtime.LibSLRuntime;
import stub.java.util.Spliterators_IntArraySpliterator;

@Approximate(stub.java.util.stream.IntStreamLSL.class)
public class IntStreamImpl implements IntStream {

    public int[] storage;

    public transient int length;

    public SymbolicList<Runnable> closeHandlers;

    public boolean isParallel;

    public boolean linkedOrConsumed;

    public IntStreamImpl(
        int[] storage,
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

    private void _actionApply(IntConsumer _action) {
        if (_action == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < this.length; i++) {
            _action.accept(storage[i]);
        }
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
    public IntStream filter(@NotNull IntPredicate predicate) {
        if (this.linkedOrConsumed) {
            throw new IllegalStateException();
        }
        if (predicate == null) {
            throw new NullPointerException();
        }
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
        this.linkedOrConsumed = true;
        return new IntStreamImpl(resultStorage, filteredLength, this.closeHandlers, false, false);
    }

    @NotNull
    public IntStream map(@NotNull IntUnaryOperator mapper) {
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
        return new IntStreamImpl(mappedStorage, this.length, this.closeHandlers, false, false);
    }

    @NotNull
    public Stream<Object> mapToObj(@NotNull IntFunction mapper) {
        if (this.linkedOrConsumed) {
            throw new IllegalStateException();
        }
        Object[] objStorage = new Object[this.length];

        for (int i = 0; i < this.length; i++) {
            objStorage[i] = mapper.apply(storage[i]);
        }

        this.linkedOrConsumed = true;
        return new StreamImpl(objStorage, this.length, this.closeHandlers, false, false);
    }

    @NotNull
    public LongStream mapToLong(@NotNull IntToLongFunction mapper) {
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

    /**
     * [FUNCTION] IntStreamAutomaton::mapToDouble(IntStream, IntToDoubleFunction) -> DoubleStream
     * Source: java/util/stream/IntStream.main.lsl:304
     */
    public DoubleStream mapToDouble(IntToDoubleFunction mapper) {
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
     * [FUNCTION] IntStreamAutomaton::flatMap(IntStream, IntFunction) -> IntStream
     * Source: java/util/stream/IntStream.main.lsl:335
     */
    public IntStream flatMap(IntFunction mapper) {
        IntStream result = null;
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (mapper == null) {
                throw new NullPointerException();
            }
            result = Engine.makeSymbolic(IntStream.class);
            Engine.assume(result != null);
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] IntStreamAutomaton::sorted(IntStream) -> IntStream
     * Source: java/util/stream/IntStream.main.lsl:351
     */
    public IntStream sorted() {
        IntStream result = null;
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (this.length == 0) {
                result = (stub.java.util.stream.IntStreamLSL) ((Object) new IntStreamImpl((Void) null,
                    /* state = */ IntStreamImpl.__$lsl_States.Initialized,
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
                        int a = storage[idxA];
                        int b = storage[idxB];
                        if (a > b) {
                            storage[idxA] = b;
                            storage[idxB] = a;
                        }
                    }
                    ;
                }
                ;
                result = (stub.java.util.stream.IntStreamLSL) ((Object) new IntStreamImpl((Void) null,
                    /* state = */ IntStreamImpl.__$lsl_States.Initialized,
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
     * [FUNCTION] IntStreamAutomaton::distinct(IntStream) -> IntStream
     * Source: java/util/stream/IntStream.main.lsl:414
     */
    public IntStream distinct() {
        IntStream result = null;
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            int[] distinctStorage = null;
            int distinctLength = 0;
            int size = this.length;
            if (size == 0) {
                distinctStorage = new int[0];
                distinctLength = 0;
            } else {
                int[] items = this.storage;
                Engine.assume(items != null);
                Engine.assume(items.length != 0);
                Engine.assume(size == items.length);
                int i = 0;
                int j = 0;
                SymbolicList<Integer> uniqueItems = Engine.makeSymbolicList();
                LibSLRuntime.Map<Integer, Object> visited = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
                for (i = 0; i < size; i++) {
                    int item = items[i];
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
                distinctStorage = new int[distinctLength];
                for (i = 0; i < distinctLength; i++) {
                    Integer item = uniqueItems.get(i);
                    Engine.assume(item != null);
                    distinctStorage[i] = ((int) item);
                }
                ;
            }
            result = (stub.java.util.stream.IntStreamLSL) ((Object) new IntStreamImpl((Void) null,
                /* state = */ IntStreamImpl.__$lsl_States.Initialized,
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
     * [FUNCTION] IntStreamAutomaton::peek(IntStream, IntConsumer) -> IntStream
     * Source: java/util/stream/IntStream.main.lsl:486
     */
    public IntStream peek(IntConsumer _action) {
        IntStream result = null;
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            _actionApply(_action);
            result = (stub.java.util.stream.IntStreamLSL) ((Object) new IntStreamImpl((Void) null,
                /* state = */ IntStreamImpl.__$lsl_States.Initialized,
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
     * [FUNCTION] IntStreamAutomaton::limit(IntStream, long) -> IntStream
     * Source: java/util/stream/IntStream.main.lsl:502
     */
    public IntStream limit(long maxSize) {
        IntStream result = null;
        /* body */ {
            int maxSizeInt = ((int) maxSize);
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (maxSizeInt < 0) {
                throw new IllegalArgumentException();
            }
            if (maxSizeInt == 0) {
                result = (stub.java.util.stream.IntStreamLSL) ((Object) new IntStreamImpl((Void) null,
                    /* state = */ IntStreamImpl.__$lsl_States.Initialized,
                    /* storage = */ this.storage,
                    /* length = */ 0,
                    /* closeHandlers = */ this.closeHandlers,
                    /* isParallel = */ false,
                    /* linkedOrConsumed = */ false
                ));
            } else {
                if (maxSizeInt > this.length) {
                    result = (stub.java.util.stream.IntStreamLSL) ((Object) new IntStreamImpl((Void) null,
                        /* state = */ IntStreamImpl.__$lsl_States.Initialized,
                        /* storage = */ this.storage,
                        /* length = */ this.length,
                        /* closeHandlers = */ this.closeHandlers,
                        /* isParallel = */ false,
                        /* linkedOrConsumed = */ false
                    ));
                } else {
                    int[] limitStorage = new int[maxSizeInt];
                    LibSLRuntime.ArrayActions.copy(this.storage, 0, limitStorage, 0, maxSizeInt);
                    result = (stub.java.util.stream.IntStreamLSL) ((Object) new IntStreamImpl((Void) null,
                        /* state = */ IntStreamImpl.__$lsl_States.Initialized,
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
     * [FUNCTION] IntStreamAutomaton::skip(IntStream, long) -> IntStream
     * Source: java/util/stream/IntStream.main.lsl:544
     */
    public IntStream skip(long n) {
        IntStream result = null;
        /* body */ {
            int offset = ((int) n);
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (offset < 0) {
                throw new IllegalArgumentException();
            }
            if (offset == 0) {
                result = (stub.java.util.stream.IntStreamLSL) ((Object) new IntStreamImpl((Void) null,
                    /* state = */ IntStreamImpl.__$lsl_States.Initialized,
                    /* storage = */ this.storage,
                    /* length = */ this.length,
                    /* closeHandlers = */ this.closeHandlers,
                    /* isParallel = */ false,
                    /* linkedOrConsumed = */ false
                ));
            } else {
                if (offset >= this.length) {
                    int[] newArray = {};
                    result = (stub.java.util.stream.IntStreamLSL) ((Object) new IntStreamImpl((Void) null,
                        /* state = */ IntStreamImpl.__$lsl_States.Initialized,
                        /* storage = */ newArray,
                        /* length = */ 0,
                        /* closeHandlers = */ this.closeHandlers,
                        /* isParallel = */ false,
                        /* linkedOrConsumed = */ false
                    ));
                } else {
                    int newLength = this.length - offset;
                    int[] skipStorage = new int[newLength];
                    int i = 0;
                    int skipIndex = 0;
                    for (i = offset; i < this.length; i++) {
                        skipStorage[skipIndex] = storage[i];
                        skipIndex++;
                    }
                    ;
                    result = (stub.java.util.stream.IntStreamLSL) ((Object) new IntStreamImpl((Void) null,
                        /* state = */ IntStreamImpl.__$lsl_States.Initialized,
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
     * [FUNCTION] IntStreamAutomaton::forEach(IntStream, IntConsumer) -> void
     * Source: java/util/stream/IntStream.main.lsl:599
     */
    public void forEach(IntConsumer _action) {
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            _actionApply(_action);
            this.linkedOrConsumed = true;
        }
    }

    /**
     * [FUNCTION] IntStreamAutomaton::forEachOrdered(IntStream, IntConsumer) -> void
     * Source: java/util/stream/IntStream.main.lsl:608
     */
    public void forEachOrdered(IntConsumer _action) {
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            _actionApply(_action);
            this.linkedOrConsumed = true;
        }
    }

    /**
     * [FUNCTION] IntStreamAutomaton::toArray(IntStream) -> array<int>
     * Source: java/util/stream/IntStream.main.lsl:617
     */
    public int[] toArray() {
        int[] result = null;
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
     * [FUNCTION] IntStreamAutomaton::reduce(IntStream, int, IntBinaryOperator) -> int
     * Source: java/util/stream/IntStream.main.lsl:626
     */
    public int reduce(int identity, IntBinaryOperator accumulator) {
        int result = 0;
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
                    result = accumulator.applyAsInt(result, storage[i]);
                }
                ;
            }
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] IntStreamAutomaton::reduce(IntStream, IntBinaryOperator) -> OptionalInt
     * Source: java/util/stream/IntStream.main.lsl:655
     */
    public OptionalInt reduce(IntBinaryOperator accumulator) {
        OptionalInt result = null;
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (accumulator == null) {
                throw new NullPointerException();
            }
            if (this.length == 0) {
                result = OptionalInt.empty();
            } else {
                if (this.length > 0) {
                    int value = storage[0];
                    int i = 0;
                    for (i = 1; i < this.length; i++) {
                        value = accumulator.applyAsInt(value, storage[i]);
                    }
                    ;
                    result = OptionalInt.of(value);
                }
            }
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] IntStreamAutomaton::collect(IntStream, Supplier, ObjIntConsumer, BiConsumer) -> Object
     * Source: java/util/stream/IntStream.main.lsl:689
     */
    public Object collect(Supplier supplier, ObjIntConsumer accumulator, BiConsumer combiner) {
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
     * [FUNCTION] IntStreamAutomaton::min(IntStream) -> OptionalInt
     * Source: java/util/stream/IntStream.main.lsl:721
     */
    public OptionalInt min() {
        OptionalInt result = null;
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (this.length == 0) {
                result = OptionalInt.empty();
            } else {
                int min = storage[0];
                int i = 0;
                for (i = 1; i < this.length; i++) {
                    if (min > storage[i]) {
                        min = storage[i];
                    }
                }
                ;
                result = OptionalInt.of(min);
            }
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] IntStreamAutomaton::max(IntStream) -> OptionalInt
     * Source: java/util/stream/IntStream.main.lsl:753
     */
    public OptionalInt max() {
        OptionalInt result = null;
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (this.length == 0) {
                result = OptionalInt.empty();
            } else {
                int max = storage[0];
                int i = 0;
                for (i = 1; i < this.length; i++) {
                    if (max < storage[i]) {
                        max = storage[i];
                    }
                }
                ;
                result = OptionalInt.of(max);
            }
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] IntStreamAutomaton::count(IntStream) -> long
     * Source: java/util/stream/IntStream.main.lsl:785
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
     * [FUNCTION] IntStreamAutomaton::anyMatch(IntStream, IntPredicate) -> boolean
     * Source: java/util/stream/IntStream.main.lsl:794
     */
    public boolean anyMatch(IntPredicate predicate) {
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
     * [FUNCTION] IntStreamAutomaton::allMatch(IntStream, IntPredicate) -> boolean
     * Source: java/util/stream/IntStream.main.lsl:822
     */
    public boolean allMatch(IntPredicate predicate) {
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
     * [FUNCTION] IntStreamAutomaton::noneMatch(IntStream, IntPredicate) -> boolean
     * Source: java/util/stream/IntStream.main.lsl:848
     */
    public boolean noneMatch(IntPredicate predicate) {
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
     * [FUNCTION] IntStreamAutomaton::findFirst(IntStream) -> OptionalInt
     * Source: java/util/stream/IntStream.main.lsl:874
     */
    public OptionalInt findFirst() {
        OptionalInt result = null;
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
     * [FUNCTION] IntStreamAutomaton::findAny(IntStream) -> OptionalInt
     * Source: java/util/stream/IntStream.main.lsl:883
     */
    public OptionalInt findAny() {
        OptionalInt result = null;
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
     * [FUNCTION] IntStreamAutomaton::iterator(IntStream) -> PrimitiveIterator_OfInt
     * Source: java/util/stream/IntStream.main.lsl:892
     */
    public PrimitiveIterator.OfInt iterator() {
        PrimitiveIterator.OfInt result = null;
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            result = (stub.java.util.stream.IntStreamLSLIterator) ((Object) new IntStreamLSLIterator((Void) null,
                /* state = */ IntStreamLSLIterator.__$lsl_States.Initialized,
                /* parent = */ this,
                /* cursor = */ 0
            ));
            this.linkedOrConsumed = true;
        }
        return result;
    }

    /**
     * [FUNCTION] IntStreamAutomaton::spliterator(IntStream) -> Spliterator_OfInt
     * Source: java/util/stream/IntStream.main.lsl:906
     */
    public Spliterator.OfInt spliterator() {
        Spliterator.OfInt result = null;
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            result = (Spliterators_IntArraySpliterator) ((Object) new generated.java.util.Spliterators_IntArraySpliterator((Void) null,
                /* state = */ generated.java.util.Spliterators_IntArraySpliterator.__$lsl_States.Initialized,
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
     * [FUNCTION] IntStreamAutomaton::isParallel(IntStream) -> boolean
     * Source: java/util/stream/IntStream.main.lsl:922
     */
    public boolean isParallel() {
        boolean result = false;
        /* body */ {
            result = this.isParallel;
        }
        return result;
    }

    /**
     * [FUNCTION] IntStreamAutomaton::sequential(IntStream) -> IntStream
     * Source: java/util/stream/IntStream.main.lsl:928
     */
    public IntStream sequential() {
        IntStream result = null;
        /* body */ {
            this.isParallel = false;
            result = this;
        }
        return result;
    }

    /**
     * [FUNCTION] IntStreamAutomaton::parallel(IntStream) -> IntStream
     * Source: java/util/stream/IntStream.main.lsl:935
     */
    public IntStream parallel() {
        IntStream result = null;
        /* body */ {
            this.isParallel = true;
            result = this;
        }
        return result;
    }

    /**
     * [FUNCTION] IntStreamAutomaton::unordered(IntStream) -> IntStream
     * Source: java/util/stream/IntStream.main.lsl:942
     */
    public IntStream unordered() {
        IntStream result = null;
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            result = (stub.java.util.stream.IntStreamLSL) ((Object) new IntStreamImpl((Void) null,
                /* state = */ IntStreamImpl.__$lsl_States.Initialized,
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
     * [FUNCTION] IntStreamAutomaton::onClose(IntStream, Runnable) -> IntStream
     * Source: java/util/stream/IntStream.main.lsl:955
     */
    public IntStream onClose(Runnable closeHandler) {
        IntStream result = null;
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
     * [FUNCTION] IntStreamAutomaton::close(IntStream) -> void
     * Source: java/util/stream/IntStream.main.lsl:967
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
     * [FUNCTION] IntStreamAutomaton::dropWhile(IntStream, IntPredicate) -> IntStream
     * Source: java/util/stream/IntStream.main.lsl:991
     */
    public IntStream dropWhile(IntPredicate predicate) {
        IntStream result = null;
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (predicate == null) {
                throw new NullPointerException();
            }
            if (this.length == 0) {
                int[] emptyStorage = new int[0];
                result = (stub.java.util.stream.IntStreamLSL) ((Object) new IntStreamImpl((Void) null,
                    /* state = */ IntStreamImpl.__$lsl_States.Initialized,
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
                    result = (stub.java.util.stream.IntStreamLSL) ((Object) new IntStreamImpl((Void) null,
                        /* state = */ IntStreamImpl.__$lsl_States.Initialized,
                        /* storage = */ this.storage,
                        /* length = */ this.length,
                        /* closeHandlers = */ this.closeHandlers,
                        /* isParallel = */ false,
                        /* linkedOrConsumed = */ false
                    ));
                } else {
                    int newLength = this.length - dropLength;
                    int[] newStorage = new int[newLength];
                    int j = dropLength;
                    i = dropLength;
                    while (i < this.length) {
                        newStorage[j] = storage[i];
                        j++;
                        i++;
                    }
                    ;
                    result = (stub.java.util.stream.IntStreamLSL) ((Object) new IntStreamImpl((Void) null,
                        /* state = */ IntStreamImpl.__$lsl_States.Initialized,
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
     * [FUNCTION] IntStreamAutomaton::takeWhile(IntStream, IntPredicate) -> IntStream
     * Source: java/util/stream/IntStream.main.lsl:1066
     */
    public IntStream takeWhile(IntPredicate predicate) {
        IntStream result = null;
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (predicate == null) {
                throw new NullPointerException();
            }
            if (this.length == 0) {
                int[] emptyStorage = new int[0];
                result = (stub.java.util.stream.IntStreamLSL) ((Object) new IntStreamImpl((Void) null,
                    /* state = */ IntStreamImpl.__$lsl_States.Initialized,
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
                    takeLength += 1;
                    i += 1;
                }
                ;
                if (takeLength == this.length) {
                    result = (stub.java.util.stream.IntStreamLSL) ((Object) new IntStreamImpl((Void) null,
                        /* state = */ IntStreamImpl.__$lsl_States.Initialized,
                        /* storage = */ this.storage,
                        /* length = */ this.length,
                        /* closeHandlers = */ this.closeHandlers,
                        /* isParallel = */ false,
                        /* linkedOrConsumed = */ false
                    ));
                } else {
                    int newLength = takeLength;
                    int[] newStorage = new int[newLength];
                    int j = 0;
                    i = 0;
                    while (i < takeLength) {
                        newStorage[j] = storage[i];
                        j += 1;
                        i += 1;
                    }
                    ;
                    result = (stub.java.util.stream.IntStreamLSL) ((Object) new IntStreamImpl((Void) null,
                        /* state = */ IntStreamImpl.__$lsl_States.Initialized,
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
     * [FUNCTION] IntStreamAutomaton::asLongStream(IntStream) -> LongStream
     * Source: java/util/stream/IntStream.main.lsl:1141
     */
    public LongStream asLongStream() {
        LongStream result = null;
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            if (this.length == 0) {
                long[] emptyArray = {};
                result = (stub.java.util.stream.LongStreamLSL) ((Object) new LongStreamImpl((Void) null,
                    /* state = */ LongStreamImpl.__$lsl_States.Initialized,
                    /* storage = */ emptyArray,
                    /* length = */ 0,
                    /* closeHandlers = */ this.closeHandlers,
                    /* isParallel = */ false,
                    /* linkedOrConsumed = */ false
                ));
            } else {
                Engine.assume(this.length > 0);
                long[] newStorage = new long[this.length];
                int i = 0;
                for (i = 0; i < this.length; i += 1) {
                    newStorage[i] = ((long) storage[i]);
                }
                ;
                result = (stub.java.util.stream.LongStreamLSL) ((Object) new LongStreamImpl((Void) null,
                    /* state = */ LongStreamImpl.__$lsl_States.Initialized,
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
     * [FUNCTION] IntStreamAutomaton::asDoubleStream(IntStream) -> DoubleStream
     * Source: java/util/stream/IntStream.main.lsl:1183
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
     * [FUNCTION] IntStreamAutomaton::sum(IntStream) -> int
     * Source: java/util/stream/IntStream.main.lsl:1225
     */
    public int sum() {
        int result = 0;
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
     * [FUNCTION] IntStreamAutomaton::average(IntStream) -> OptionalDouble
     * Source: java/util/stream/IntStream.main.lsl:1235
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
     * [FUNCTION] IntStreamAutomaton::summaryStatistics(IntStream) -> IntSummaryStatistics
     * Source: java/util/stream/IntStream.main.lsl:1254
     */
    public IntSummaryStatistics summaryStatistics() {
        IntSummaryStatistics result = null;
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            result = new IntSummaryStatistics();
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
     * [FUNCTION] IntStreamAutomaton::boxed(IntStream) -> Stream
     * Source: java/util/stream/IntStream.main.lsl:1275
     */
    public Stream boxed() {
        Stream result = null;
        /* body */ {
            if (this.linkedOrConsumed) {
                throw new IllegalStateException();
            }
            Integer[] integerArray = new Integer[this.length];
            int i = 0;
            for (i = 0; i < this.length; i += 1) {
                integerArray[i] = storage[i];
            }
            ;
            result = (stub.java.util.stream.StreamLSL) ((Object) new StreamImpl((Void) null,
                /* state = */ StreamImpl.__$lsl_States.Initialized,
                /* storage = */ integerArray,
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
