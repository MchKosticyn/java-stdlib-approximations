// Generated by the LibSL translator.  DO NOT EDIT!
// sources:
//  - java/util/stream/DoubleStream.lsl:49
//  - java/util/stream/DoubleStream.Spliterator.lsl:19
//
package generated.java.util.stream;

import generated.runtime.LibSLGlobals;
import java.lang.IllegalStateException;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.SuppressWarnings;
import java.lang.Void;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;

/**
 * DoubleStreamSpliteratorAutomaton for DoubleStreamLSLSpliterator ~> java.util.stream.DoubleStreamLSLSpliterator
 */
@SuppressWarnings({"all", "unchecked"})
@Approximate(stub.java.util.stream.DoubleStreamLSLSpliterator.class)
public class DoubleStreamLSLSpliterator implements LibSLRuntime.Automaton, Spliterator.OfDouble {
    static {
        Engine.assume(true);
    }

    public DoubleStreamLSL parent;

    public int characteristics;

    public int fence;

    public int index;

    @LibSLRuntime.AutomatonConstructor
    public DoubleStreamLSLSpliterator(Void __$lsl_token, final byte p0, final DoubleStreamLSL p1,
            final int p2, final int p3, final int p4) {
        this.parent = p1;
        this.characteristics = p2;
        this.fence = p3;
        this.index = p4;
    }

    @LibSLRuntime.AutomatonConstructor
    public DoubleStreamLSLSpliterator(final Void __$lsl_token) {
        this(__$lsl_token, __$lsl_States.Initialized, null, 0, 0, 0);
    }

    /**
     * [SUBROUTINE] DoubleStreamSpliteratorAutomaton::_getFence() -> int
     * Source: java/util/stream/DoubleStream.Spliterator.lsl:60
     */
    private int _getFence() {
        int result = 0;
        /* body */ {
            if (this.fence < 0) {
                Engine.assume(this.parent != null);
                this.fence = ((DoubleStreamLSL) ((Object) this.parent)).length;
            }
            result = this.fence;
        }
        return result;
    }

    /**
     * [SUBROUTINE] DoubleStreamSpliteratorAutomaton::_hasCharacteristics(int) -> boolean
     * Source: java/util/stream/DoubleStream.Spliterator.lsl:72
     */
    private boolean _hasCharacteristics(int _characteristics) {
        boolean result = false;
        /* body */ {
            result = (this.characteristics & _characteristics) == _characteristics;
        }
        return result;
    }

    /**
     * [FUNCTION] DoubleStreamSpliteratorAutomaton::characteristics(DoubleStreamLSLSpliterator) -> int
     * Source: java/util/stream/DoubleStream.Spliterator.lsl:80
     */
    public int characteristics() {
        int result = 0;
        /* body */ {
            result = this.characteristics;
        }
        return result;
    }

    /**
     * [FUNCTION] DoubleStreamSpliteratorAutomaton::trySplit(DoubleStreamLSLSpliterator) -> Spliterator_OfDouble
     * Source: java/util/stream/DoubleStream.Spliterator.lsl:86
     */
    public Spliterator.OfDouble trySplit() {
        Spliterator.OfDouble result = null;
        /* body */ {
            final int hi = _getFence();
            final int lo = this.index;
            final int mid = (lo + hi) >>> 1;
            if (lo >= mid) {
                result = null;
            } else {
                result = (stub.java.util.stream.DoubleStreamLSLSpliterator) ((Object) new DoubleStreamLSLSpliterator((Void) null, 
                    /* state = */ DoubleStreamLSLSpliterator.__$lsl_States.Initialized, 
                    /* parent = */ this.parent, 
                    /* characteristics = */ this.characteristics, 
                    /* fence = */ mid, 
                    /* index = */ lo
                ));
            }
            this.index = mid;
        }
        return result;
    }

    /**
     * [FUNCTION] DoubleStreamSpliteratorAutomaton::forEachRemaining(DoubleStreamLSLSpliterator, DoubleConsumer) -> void
     * Source: java/util/stream/DoubleStream.Spliterator.lsl:106
     */
    public void forEachRemaining(DoubleConsumer _action) {
        /* body */ {
            if (_action == null) {
                throw new NullPointerException();
            }
            Engine.assume(this.parent != null);
            final double[] a = ((DoubleStreamLSL) ((Object) this.parent)).storage;
            int hi = this.fence;
            int i = this.index;
            this.index = hi;
            for (i = i; i < hi; i += 1) {
                final double item = a[i];
                _action.accept(item);
            }
            ;
        }
    }

    /**
     * [FUNCTION] DoubleStreamSpliteratorAutomaton::forEachRemaining(DoubleStreamLSLSpliterator, Consumer) -> void
     * Source: java/util/stream/DoubleStream.Spliterator.lsl:132
     */
    public void forEachRemaining(Consumer _action) {
        /* body */ {
            if (_action == null) {
                throw new NullPointerException();
            }
            Engine.assume(this.parent != null);
            final double[] a = ((DoubleStreamLSL) ((Object) this.parent)).storage;
            int hi = this.fence;
            int i = this.index;
            this.index = hi;
            for (i = i; i < hi; i += 1) {
                final double item = a[i];
                _action.accept(item);
            }
            ;
        }
    }

    /**
     * [FUNCTION] DoubleStreamSpliteratorAutomaton::tryAdvance(DoubleStreamLSLSpliterator, DoubleConsumer) -> boolean
     * Source: java/util/stream/DoubleStream.Spliterator.lsl:158
     */
    public boolean tryAdvance(DoubleConsumer _action) {
        boolean result = false;
        /* body */ {
            if (_action == null) {
                throw new NullPointerException();
            }
            final int hi = _getFence();
            final int i = this.index;
            if (i < hi) {
                Engine.assume(this.parent != null);
                this.index = i + 1;
                final double[] parentStorage = ((DoubleStreamLSL) ((Object) this.parent)).storage;
                final double item = parentStorage[i];
                _action.accept(item);
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }

    /**
     * [FUNCTION] DoubleStreamSpliteratorAutomaton::tryAdvance(DoubleStreamLSLSpliterator, Consumer) -> boolean
     * Source: java/util/stream/DoubleStream.Spliterator.lsl:185
     */
    public boolean tryAdvance(Consumer _action) {
        boolean result = false;
        /* body */ {
            if (_action == null) {
                throw new NullPointerException();
            }
            final int hi = _getFence();
            final int i = this.index;
            if (i < hi) {
                Engine.assume(this.parent != null);
                this.index = i + 1;
                final double[] parentStorage = ((DoubleStreamLSL) ((Object) this.parent)).storage;
                final double item = parentStorage[i];
                _action.accept(item);
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }

    /**
     * [FUNCTION] DoubleStreamSpliteratorAutomaton::estimateSize(DoubleStreamLSLSpliterator) -> long
     * Source: java/util/stream/DoubleStream.Spliterator.lsl:212
     */
    public long estimateSize() {
        long result = 0L;
        /* body */ {
            result = _getFence() - this.index;
        }
        return result;
    }

    /**
     * [FUNCTION] DoubleStreamSpliteratorAutomaton::getComparator(DoubleStreamLSLSpliterator) -> Comparator
     * Source: java/util/stream/DoubleStream.Spliterator.lsl:218
     */
    public Comparator getComparator() {
        Comparator result = null;
        /* body */ {
            if (_hasCharacteristics(LibSLGlobals.SPLITERATOR_SORTED)) {
                result = null;
            } else {
                throw new IllegalStateException();
            }
        }
        return result;
    }

    /**
     * [FUNCTION] DoubleStreamSpliteratorAutomaton::getExactSizeIfKnown(DoubleStreamLSLSpliterator) -> long
     * Source: java/util/stream/DoubleStream.Spliterator.lsl:227
     */
    public long getExactSizeIfKnown() {
        long result = 0L;
        /* body */ {
            result = _getFence() - this.index;
        }
        return result;
    }

    /**
     * [FUNCTION] DoubleStreamSpliteratorAutomaton::hasCharacteristics(DoubleStreamLSLSpliterator, int) -> boolean
     * Source: java/util/stream/DoubleStream.Spliterator.lsl:233
     */
    public boolean hasCharacteristics(int _characteristics) {
        boolean result = false;
        /* body */ {
            result = _hasCharacteristics(_characteristics);
        }
        return result;
    }

    public static final class __$lsl_States {
        public static final byte Initialized = (byte) 0;
    }

    @Approximate(DoubleStreamLSLSpliterator.class)
    public static final class __hook {
        private __hook(Void o1, Void o2) {
            Engine.assume(false);
        }
    }
}
