// Generated by the LibSL translator.  DO NOT EDIT!
// source: ?
//
package generated.java.util;

import generated.runtime.LibSLGlobals;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Runnable;
import java.lang.String;
import java.lang.Void;
import java.util.NoSuchElementException;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleSupplier;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;

/**
 * OptionalDoubleAutomaton for LSLOptionalDouble ~> java.util.OptionalDouble
 */
@Approximate(java.util.OptionalDouble.class)
public final class OptionalDouble implements LibSLRuntime.Automaton {
    static {
        Engine.assume(true);
    }

    private byte __$lsl_state = __$lsl_States.Allocated;

    public double value;

    public boolean present;

    @LibSLRuntime.AutomatonConstructor
    public OptionalDouble(Void __$lsl_token, final byte p0, final double p1, final boolean p2) {
        this.__$lsl_state = p0;
        this.value = p1;
        this.present = p2;
    }

    @LibSLRuntime.AutomatonConstructor
    public OptionalDouble(final Void __$lsl_token) {
        this(__$lsl_token, __$lsl_States.Allocated, 0.0d, false);
    }

    /**
     * [CONSTRUCTOR] OptionalDoubleAutomaton::LSLOptionalDouble(LSLOptionalDouble) -> LSLOptionalDouble
     */
    private OptionalDouble() {
        this((Void) null);
        Engine.assume(this.__$lsl_state == __$lsl_States.Allocated);
        /* body */ {
            LibSLRuntime.not_implemented(/* this method can be called using reflection only */);
        }
        this.__$lsl_state = __$lsl_States.Initialized;
    }

    /**
     * [CONSTRUCTOR] OptionalDoubleAutomaton::LSLOptionalDouble(LSLOptionalDouble, double) -> LSLOptionalDouble
     */
    private OptionalDouble(double x) {
        this((Void) null);
        Engine.assume(this.__$lsl_state == __$lsl_States.Allocated);
        /* body */ {
            LibSLRuntime.not_implemented(/* this method can be called using reflection only */);
        }
        this.__$lsl_state = __$lsl_States.Initialized;
    }

    /**
     * [FUNCTION] OptionalDoubleAutomaton::empty() -> LSLOptionalDouble
     */
    public static OptionalDouble empty() {
        OptionalDouble result = null;
        // WARNING: no state checks in static context
        /* body */ {
            result = LibSLGlobals.EMPTY_OPTIONAL_DOUBLE;
        }
        // WARNING: no state transitions in static context
        return result;
    }

    /**
     * [FUNCTION] OptionalDoubleAutomaton::of(double) -> LSLOptionalDouble
     */
    public static OptionalDouble of(double x) {
        OptionalDouble result = null;
        // WARNING: no state checks in static context
        /* body */ {
            result = new OptionalDouble((Void) null, 
            /* state = */ OptionalDouble.__$lsl_States.Initialized, 
            /* value = */ x, 
            /* present = */ true);
        }
        // WARNING: no state transitions in static context
        return result;
    }

    /**
     * [FUNCTION] OptionalDoubleAutomaton::equals(LSLOptionalDouble, Object) -> boolean
     */
    public boolean equals(Object other) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (other == this) {
                result = true;
            } else {
                final boolean isSameType = Engine.typeEquals(this, other);
                if (isSameType) {
                    final double otherValue = ((OptionalDouble) other).value;
                    final boolean otherPresent = ((OptionalDouble) other).present;
                    if (this.present && otherPresent) {
                        result = LibSLRuntime.equals(this.value, otherValue);
                    } else {
                        result = this.present == otherPresent;
                    }
                } else {
                    result = false;
                }
            }
        }
        return result;
    }

    /**
     * [FUNCTION] OptionalDoubleAutomaton::getAsDouble(LSLOptionalDouble) -> double
     */
    public double getAsDouble() {
        double result = 0.0d;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (!this.present) {
                throw new NoSuchElementException("No value present");
            }
            result = this.value;
        }
        return result;
    }

    /**
     * [FUNCTION] OptionalDoubleAutomaton::hashCode(LSLOptionalDouble) -> int
     */
    public int hashCode() {
        int result = 0;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (this.present) {
                result = LibSLRuntime.hashCode(this.value);
            } else {
                result = 0;
            }
        }
        return result;
    }

    /**
     * [FUNCTION] OptionalDoubleAutomaton::ifPresent(LSLOptionalDouble, DoubleConsumer) -> void
     */
    public void ifPresent(DoubleConsumer consumer) {
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (this.present) {
                if (consumer == null) {
                    throw new NullPointerException();
                }
                consumer.accept(this.value);
            }
        }
    }

    /**
     * [FUNCTION] OptionalDoubleAutomaton::ifPresentOrElse(LSLOptionalDouble, DoubleConsumer, Runnable) -> void
     */
    public void ifPresentOrElse(DoubleConsumer consumer, Runnable emptyAction) {
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (this.present) {
                if (consumer == null) {
                    throw new NullPointerException();
                }
                consumer.accept(this.value);
            } else {
                if (emptyAction == null) {
                    throw new NullPointerException();
                }
                emptyAction.run();
            }
        }
    }

    /**
     * [FUNCTION] OptionalDoubleAutomaton::isEmpty(LSLOptionalDouble) -> boolean
     */
    public boolean isEmpty() {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = !this.present;
        }
        return result;
    }

    /**
     * [FUNCTION] OptionalDoubleAutomaton::isPresent(LSLOptionalDouble) -> boolean
     */
    public boolean isPresent() {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = this.present;
        }
        return result;
    }

    /**
     * [FUNCTION] OptionalDoubleAutomaton::orElse(LSLOptionalDouble, double) -> double
     */
    public double orElse(double other) {
        double result = 0.0d;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (this.present) {
                result = this.value;
            } else {
                result = other;
            }
        }
        return result;
    }

    /**
     * [FUNCTION] OptionalDoubleAutomaton::orElseGet(LSLOptionalDouble, DoubleSupplier) -> double
     */
    public double orElseGet(DoubleSupplier supplier) {
        double result = 0.0d;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (supplier == null) {
                throw new NullPointerException();
            }
            if (this.present) {
                result = this.value;
            } else {
                result = supplier.getAsDouble();
            }
        }
        return result;
    }

    /**
     * [FUNCTION] OptionalDoubleAutomaton::orElseThrow(LSLOptionalDouble) -> double
     */
    public double orElseThrow() {
        double result = 0.0d;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (!this.present) {
                throw new NoSuchElementException("No value present");
            }
            result = this.value;
        }
        return result;
    }

    /**
     * [FUNCTION] OptionalDoubleAutomaton::orElseThrow(LSLOptionalDouble, Supplier) -> double
     */
    public double orElseThrow(Supplier exceptionSupplier) throws java.lang.Throwable {
        double result = 0.0d;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (exceptionSupplier == null) {
                throw new NullPointerException();
            }
            if (!this.present) {
                final Object exception = exceptionSupplier.get();
                throw ((Throwable) exception);
            } else {
                result = this.value;
            }
        }
        return result;
    }

    /**
     * [FUNCTION] OptionalDoubleAutomaton::stream(LSLOptionalDouble) -> DoubleStream
     */
    public DoubleStream stream() {
        DoubleStream result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = Engine.makeSymbolic(DoubleStream.class);
            Engine.assume(result != null);
        }
        return result;
    }

    /**
     * [FUNCTION] OptionalDoubleAutomaton::toString(LSLOptionalDouble) -> String
     */
    public String toString() {
        String result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (this.present) {
                final String valueStr = LibSLRuntime.toString(this.value);
                result = "OptionalDouble[".concat(valueStr).concat("]");
            } else {
                result = "OptionalDouble.empty";
            }
        }
        return result;
    }

    public static final class __$lsl_States {
        public static final byte Allocated = (byte) 0;

        public static final byte Initialized = (byte) 1;
    }

    @Approximate(OptionalDouble.class)
    public static final class __hook {
        private __hook(Void o1, Void o2) {
            Engine.assume(false);
        }
    }
}
