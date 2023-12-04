// Generated by the LibSL translator.  DO NOT EDIT!
// sources:
//  - java/util/OptionalInt.lsl:37
//  - java/util/OptionalInt.automata.lsl:29
//
package generated.java.util;

import generated.runtime.LibSLGlobals;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Runnable;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.Void;
import java.util.NoSuchElementException;
import java.util.function.IntConsumer;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;

/**
 * OptionalIntAutomaton for LSLOptionalInt ~> java.util.OptionalInt
 */
@SuppressWarnings({"all", "unchecked"})
@Approximate(java.util.OptionalInt.class)
public final class OptionalInt implements LibSLRuntime.Automaton {
    static {
        Engine.assume(true);
    }

    private byte __$lsl_state = __$lsl_States.Allocated;

    public int value;

    public boolean present;

    @LibSLRuntime.AutomatonConstructor
    public OptionalInt(Void __$lsl_token, final byte p0, final int p1, final boolean p2) {
        this.__$lsl_state = p0;
        this.value = p1;
        this.present = p2;
    }

    @LibSLRuntime.AutomatonConstructor
    public OptionalInt(final Void __$lsl_token) {
        this(__$lsl_token, __$lsl_States.Allocated, 0, false);
    }

    /**
     * [CONSTRUCTOR] OptionalIntAutomaton::LSLOptionalInt(LSLOptionalInt) -> LSLOptionalInt
     * Source: java/util/OptionalInt.automata.lsl:79
     */
    private OptionalInt() {
        this((Void) null);
        Engine.assume(this.__$lsl_state == __$lsl_States.Allocated);
        /* body */ {
            LibSLRuntime.not_implemented(/* this method can be called using reflection only */);
        }
        this.__$lsl_state = __$lsl_States.Initialized;
    }

    /**
     * [CONSTRUCTOR] OptionalIntAutomaton::LSLOptionalInt(LSLOptionalInt, int) -> LSLOptionalInt
     * Source: java/util/OptionalInt.automata.lsl:85
     */
    private OptionalInt(int x) {
        this((Void) null);
        Engine.assume(this.__$lsl_state == __$lsl_States.Allocated);
        /* body */ {
            LibSLRuntime.not_implemented(/* this method can be called using reflection only */);
        }
        this.__$lsl_state = __$lsl_States.Initialized;
    }

    /**
     * [FUNCTION] OptionalIntAutomaton::empty() -> OptionalInt
     * Source: java/util/OptionalInt.automata.lsl:93
     */
    public static java.util.OptionalInt empty() {
        java.util.OptionalInt result = null;
        // WARNING: no state checks in static context
        /* body */ {
            result = LibSLGlobals.EMPTY_OPTIONAL_INT;
        }
        // WARNING: no state transitions in static context
        return result;
    }

    /**
     * [FUNCTION] OptionalIntAutomaton::of(int) -> OptionalInt
     * Source: java/util/OptionalInt.automata.lsl:99
     */
    public static java.util.OptionalInt of(int x) {
        java.util.OptionalInt result = null;
        // WARNING: no state checks in static context
        /* body */ {
            result = (java.util.OptionalInt) ((Object) new OptionalInt((Void) null, 
                /* state = */ OptionalInt.__$lsl_States.Initialized, 
                /* value = */ x, 
                /* present = */ true
            ));
        }
        // WARNING: no state transitions in static context
        return result;
    }

    /**
     * [FUNCTION] OptionalIntAutomaton::equals(LSLOptionalInt, Object) -> boolean
     * Source: java/util/OptionalInt.automata.lsl:110
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
                    final int otherValue = ((OptionalInt) ((Object) other)).value;
                    final boolean otherPresent = ((OptionalInt) ((Object) other)).present;
                    if (this.present && otherPresent) {
                        result = this.value == otherValue;
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
     * [FUNCTION] OptionalIntAutomaton::getAsInt(LSLOptionalInt) -> int
     * Source: java/util/OptionalInt.automata.lsl:138
     */
    public int getAsInt() {
        int result = 0;
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
     * [FUNCTION] OptionalIntAutomaton::hashCode(LSLOptionalInt) -> int
     * Source: java/util/OptionalInt.automata.lsl:147
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
     * [FUNCTION] OptionalIntAutomaton::ifPresent(LSLOptionalInt, IntConsumer) -> void
     * Source: java/util/OptionalInt.automata.lsl:157
     */
    public void ifPresent(IntConsumer consumer) {
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
     * [FUNCTION] OptionalIntAutomaton::ifPresentOrElse(LSLOptionalInt, IntConsumer, Runnable) -> void
     * Source: java/util/OptionalInt.automata.lsl:171
     */
    public void ifPresentOrElse(IntConsumer consumer, Runnable emptyAction) {
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
     * [FUNCTION] OptionalIntAutomaton::isEmpty(LSLOptionalInt) -> boolean
     * Source: java/util/OptionalInt.automata.lsl:193
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
     * [FUNCTION] OptionalIntAutomaton::isPresent(LSLOptionalInt) -> boolean
     * Source: java/util/OptionalInt.automata.lsl:199
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
     * [FUNCTION] OptionalIntAutomaton::orElse(LSLOptionalInt, int) -> int
     * Source: java/util/OptionalInt.automata.lsl:205
     */
    public int orElse(int other) {
        int result = 0;
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
     * [FUNCTION] OptionalIntAutomaton::orElseGet(LSLOptionalInt, IntSupplier) -> int
     * Source: java/util/OptionalInt.automata.lsl:214
     */
    public int orElseGet(IntSupplier supplier) {
        int result = 0;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (supplier == null) {
                throw new NullPointerException();
            }
            if (this.present) {
                result = this.value;
            } else {
                result = supplier.getAsInt();
            }
        }
        return result;
    }

    /**
     * [FUNCTION] OptionalIntAutomaton::orElseThrow(LSLOptionalInt) -> int
     * Source: java/util/OptionalInt.automata.lsl:228
     */
    public int orElseThrow() {
        int result = 0;
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
     * [FUNCTION] OptionalIntAutomaton::orElseThrow(LSLOptionalInt, Supplier) -> int
     * Source: java/util/OptionalInt.automata.lsl:239
     */
    public int orElseThrow(Supplier exceptionSupplier) throws java.lang.Throwable {
        int result = 0;
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
     * [FUNCTION] OptionalIntAutomaton::stream(LSLOptionalInt) -> IntStream
     * Source: java/util/OptionalInt.automata.lsl:260
     */
    public IntStream stream() {
        IntStream result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = Engine.makeSymbolic(IntStream.class);
            Engine.assume(result != null);
        }
        return result;
    }

    /**
     * [FUNCTION] OptionalIntAutomaton::toString(LSLOptionalInt) -> String
     * Source: java/util/OptionalInt.automata.lsl:268
     */
    public String toString() {
        String result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (this.present) {
                final String valueStr = LibSLRuntime.toString(this.value);
                result = "OptionalInt[".concat(valueStr).concat("]");
            } else {
                result = "OptionalInt.empty";
            }
        }
        return result;
    }

    public static final class __$lsl_States {
        public static final byte Allocated = (byte) 0;

        public static final byte Initialized = (byte) 1;
    }

    @Approximate(OptionalInt.class)
    public static final class __hook {
        private __hook(Void o1, Void o2) {
            Engine.assume(false);
        }
    }
}
