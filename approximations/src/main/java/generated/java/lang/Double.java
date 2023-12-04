// Generated by the LibSL translator.  DO NOT EDIT!
// sources:
//  - java/lang/Double.lsl:36
//  - java/lang/Double.main.lsl:18
//
package generated.java.lang;

import java.lang.Class;
import java.lang.Comparable;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.Void;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;

/**
 * DoubleAutomaton for LSLDouble ~> java.lang.Double
 */
@SuppressWarnings({"all", "unchecked"})
@Approximate(java.lang.Double.class)
public final class Double implements LibSLRuntime.Automaton, Comparable<Double> {
    private static final long serialVersionUID = -9172774392245257468L;

    public static final int BYTES = 8;

    public static final int SIZE = 64;

    public static final int MAX_EXPONENT = 1023;

    public static final int MIN_EXPONENT = -1022;

    public static final double MAX_VALUE = 1.7976931348623157E308;

    public static final double MIN_VALUE = 4.9E-324;

    public static final double MIN_NORMAL = 2.2250738585072014E-308;

    public static final double POSITIVE_INFINITY = 1.0d / 0.0d;

    public static final double NEGATIVE_INFINITY = -1.0d / 0.0d;

    public static final double NaN = 0.0d / 0.0d;

    public static final Class TYPE = java.lang.Double.class;

    static {
        Engine.assume(true);
    }

    private byte __$lsl_state = __$lsl_States.Allocated;

    public double value;

    @LibSLRuntime.AutomatonConstructor
    public Double(Void __$lsl_token, final byte p0, final double p1) {
        this.__$lsl_state = p0;
        this.value = p1;
    }

    @LibSLRuntime.AutomatonConstructor
    public Double(final Void __$lsl_token) {
        this(__$lsl_token, __$lsl_States.Allocated, 0.0d);
    }

    /**
     * [CONSTRUCTOR] DoubleAutomaton::Double(LSLDouble, double) -> LSLDouble
     * Source: java/lang/Double.main.lsl:124
     */
    public Double(double v) {
        this((Void) null);
        Engine.assume(this.__$lsl_state == __$lsl_States.Allocated);
        /* body */ {
            this.value = v;
        }
        this.__$lsl_state = __$lsl_States.Initialized;
    }

    /**
     * [SUBROUTINE] DoubleAutomaton::_getRawBits(double) -> long
     * Source: java/lang/Double.main.lsl:73
     */
    private static long _getRawBits(double v) {
        long result = 0L;
        /* body */ {
            if (v != v) {
                result = 9221120237041090560L;
            } else {
                if ((1.0d / v) == NEGATIVE_INFINITY) {
                    result = -9223372036854775808L;
                } else {
                    if (v == 0.0d) {
                        result = 0L;
                    } else {
                        if (v == POSITIVE_INFINITY) {
                            result = 9218868437227405312L;
                        } else {
                            if (v == NEGATIVE_INFINITY) {
                                result = -4503599627370496L;
                            } else {
                                result = Engine.makeSymbolicLong();
                                Engine.assume(result != 9221120237041090560L);
                                Engine.assume(result != -9223372036854775808L);
                                Engine.assume(result != 0L);
                                Engine.assume(result != 9218868437227405312L);
                                Engine.assume(result != -4503599627370496L);
                                if (v < 0.0d) {
                                    Engine.assume(result < 0L);
                                } else {
                                    Engine.assume(result > 0L);
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * [SUBROUTINE] DoubleAutomaton::_parse(String) -> double
     * Source: java/lang/Double.main.lsl:104
     */
    private static double _parse(String str) throws java.lang.NumberFormatException {
        double result = 0.0d;
        /* body */ {
            if (str == null) {
                throw new NullPointerException();
            }
            LibSLRuntime.todo();
        }
        return result;
    }

    /**
     * [FUNCTION] DoubleAutomaton::compare(double, double) -> int
     * Source: java/lang/Double.main.lsl:132
     */
    public static int compare(double a, double b) {
        int result = 0;
        // WARNING: no state checks in static context
        /* body */ {
            if ((a == b) || (a != a) || (b != b)) {
                result = 0;
            } else {
                if (a < b) {
                    result = -1;
                } else {
                    result = 1;
                }
            }
        }
        // WARNING: no state transitions in static context
        return result;
    }

    /**
     * [FUNCTION] DoubleAutomaton::doubleToLongBits(double) -> long
     * Source: java/lang/Double.main.lsl:149
     */
    public static long doubleToLongBits(double value) {
        long result = 0L;
        // WARNING: no state checks in static context
        /* body */ {
            result = _getRawBits(value);
        }
        // WARNING: no state transitions in static context
        return result;
    }

    /**
     * [FUNCTION] DoubleAutomaton::doubleToRawLongBits(double) -> long
     * Source: java/lang/Double.main.lsl:155
     */
    public static long doubleToRawLongBits(double value) {
        long result = 0L;
        // WARNING: no state checks in static context
        /* body */ {
            result = _getRawBits(value);
        }
        // WARNING: no state transitions in static context
        return result;
    }

    /**
     * [FUNCTION] DoubleAutomaton::hashCode(double) -> int
     * Source: java/lang/Double.main.lsl:161
     */
    public static int hashCode(double value) {
        int result = 0;
        // WARNING: no state checks in static context
        /* body */ {
            result = ((int) _getRawBits(value));
        }
        // WARNING: no state transitions in static context
        return result;
    }

    /**
     * [FUNCTION] DoubleAutomaton::isFinite(double) -> boolean
     * Source: java/lang/Double.main.lsl:167
     */
    public static boolean isFinite(double d) {
        boolean result = false;
        // WARNING: no state checks in static context
        /* body */ {
            if (d <= 0.0d) {
                d = 0.0d - d;
            }
            result = d <= MAX_VALUE;
        }
        // WARNING: no state transitions in static context
        return result;
    }

    /**
     * [FUNCTION] DoubleAutomaton::isInfinite(double) -> boolean
     * Source: java/lang/Double.main.lsl:177
     */
    public static boolean isInfinite(double v) {
        boolean result = false;
        // WARNING: no state checks in static context
        /* body */ {
            result = (v == POSITIVE_INFINITY) || (v == NEGATIVE_INFINITY);
        }
        // WARNING: no state transitions in static context
        return result;
    }

    /**
     * [FUNCTION] DoubleAutomaton::isNaN(double) -> boolean
     * Source: java/lang/Double.main.lsl:184
     */
    public static boolean isNaN(double v) {
        boolean result = false;
        // WARNING: no state checks in static context
        /* body */ {
            result = v != v;
        }
        // WARNING: no state transitions in static context
        return result;
    }

    /**
     * [FUNCTION] DoubleAutomaton::longBitsToDouble(long) -> double
     * Source: java/lang/Double.main.lsl:190
     */
    public static double longBitsToDouble(long value) {
        double result = 0.0d;
        // WARNING: no state checks in static context
        /* body */ {
            if (value == 9221120237041090560L) {
                result = NaN;
            } else {
                if (value == -9223372036854775808L) {
                    result = -0.0d;
                } else {
                    if (value == 0L) {
                        result = 0.0d;
                    } else {
                        if (value == 9218868437227405312L) {
                            result = POSITIVE_INFINITY;
                        } else {
                            if (value == -4503599627370496L) {
                                result = NEGATIVE_INFINITY;
                            } else {
                                result = Engine.makeSymbolicDouble();
                                Engine.assume(result != 0.0d);
                                Engine.assume(result == result);
                                Engine.assume(result != POSITIVE_INFINITY);
                                Engine.assume(result != NEGATIVE_INFINITY);
                                if (value < 0L) {
                                    Engine.assume(result < 0.0d);
                                } else {
                                    Engine.assume(result > 0.0d);
                                }
                            }
                        }
                    }
                }
            }
        }
        // WARNING: no state transitions in static context
        return result;
    }

    /**
     * [FUNCTION] DoubleAutomaton::max(double, double) -> double
     * Source: java/lang/Double.main.lsl:220
     */
    public static double max(double a, double b) {
        double result = 0.0d;
        // WARNING: no state checks in static context
        /* body */ {
            if (a != a) {
                result = a;
            } else {
                if ((a == 0.0d) && (b == 0.0d) && ((1.0d / a) == NEGATIVE_INFINITY)) {
                    result = b;
                } else {
                    if (a >= b) {
                        result = a;
                    } else {
                        result = b;
                    }
                }
            }
        }
        // WARNING: no state transitions in static context
        return result;
    }

    /**
     * [FUNCTION] DoubleAutomaton::min(double, double) -> double
     * Source: java/lang/Double.main.lsl:233
     */
    public static double min(double a, double b) {
        double result = 0.0d;
        // WARNING: no state checks in static context
        /* body */ {
            if (a != a) {
                result = a;
            } else {
                if ((a == 0.0d) && (b == 0.0d) && ((1.0d / b) == NEGATIVE_INFINITY)) {
                    result = b;
                } else {
                    if (a <= b) {
                        result = a;
                    } else {
                        result = b;
                    }
                }
            }
        }
        // WARNING: no state transitions in static context
        return result;
    }

    /**
     * [FUNCTION] DoubleAutomaton::sum(double, double) -> double
     * Source: java/lang/Double.main.lsl:254
     */
    public static double sum(double a, double b) {
        double result = 0.0d;
        // WARNING: no state checks in static context
        /* body */ {
            result = a + b;
        }
        // WARNING: no state transitions in static context
        return result;
    }

    /**
     * [FUNCTION] DoubleAutomaton::toHexString(double) -> String
     * Source: java/lang/Double.main.lsl:260
     */
    public static String toHexString(double d) {
        String result = null;
        // WARNING: no state checks in static context
        /* body */ {
            if (d != d) {
                result = "NaN";
            } else {
                if (d == POSITIVE_INFINITY) {
                    result = "Infinity";
                } else {
                    if (d == NEGATIVE_INFINITY) {
                        result = "-Infinity";
                    } else {
                        if ((1.0d / d) == NEGATIVE_INFINITY) {
                            result = "-0x0.0p0";
                        } else {
                            if (d == 0.0f) {
                                result = "0x0.0p0";
                            } else {
                                if (d == 1.0f) {
                                    result = "0x1.0p0";
                                } else {
                                    if (d == -1.0f) {
                                        result = "-0x1.0p0";
                                    } else {
                                        result = Engine.makeSymbolic(String.class);
                                        Engine.assume(result != null);
                                        final int len = result.length();
                                        Engine.assume(len >= 7);
                                        Engine.assume(len <= 22);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        // WARNING: no state transitions in static context
        return result;
    }

    /**
     * [FUNCTION] DoubleAutomaton::toString(double) -> String
     * Source: java/lang/Double.main.lsl:281
     */
    public static String toString(double d) {
        String result = null;
        // WARNING: no state checks in static context
        /* body */ {
            result = LibSLRuntime.toString(d);
        }
        // WARNING: no state transitions in static context
        return result;
    }

    /**
     * [FUNCTION] DoubleAutomaton::valueOf(double) -> Double
     * Source: java/lang/Double.main.lsl:297
     */
    public static java.lang.Double valueOf(double d) {
        java.lang.Double result = null;
        // WARNING: no state checks in static context
        /* body */ {
            result = (java.lang.Double) ((Object) new Double((Void) null, 
                /* state = */ Double.__$lsl_States.Initialized, 
                /* value = */ d
            ));
        }
        // WARNING: no state transitions in static context
        return result;
    }

    /**
     * [FUNCTION] DoubleAutomaton::byteValue(LSLDouble) -> byte
     * Source: java/lang/Double.main.lsl:307
     */
    public byte byteValue() {
        byte result = ((byte) 0);
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = ((byte) this.value);
        }
        return result;
    }

    /**
     * [FUNCTION] DoubleAutomaton::compareTo(LSLDouble, LSLDouble) -> int
     * Source: java/lang/Double.main.lsl:313
     */
    public int compareTo(Double anotherDouble) {
        int result = 0;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            final double a = this.value;
            final double b = ((Double) ((Object) anotherDouble)).value;
            if ((a == b) || (a != a) || (b != b)) {
                result = 0;
            } else {
                if (a < b) {
                    result = -1;
                } else {
                    result = 1;
                }
            }
        }
        return result;
    }

    /**
     * [FUNCTION] DoubleAutomaton::doubleValue(LSLDouble) -> double
     * Source: java/lang/Double.main.lsl:333
     */
    public double doubleValue() {
        double result = 0.0d;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = this.value;
        }
        return result;
    }

    /**
     * [FUNCTION] DoubleAutomaton::equals(LSLDouble, Object) -> boolean
     * Source: java/lang/Double.main.lsl:339
     */
    public boolean equals(Object obj) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (obj instanceof java.lang.Double) {
                result = this.value == ((Double) ((Object) obj)).value;
            } else {
                result = false;
            }
        }
        return result;
    }

    /**
     * [FUNCTION] DoubleAutomaton::floatValue(LSLDouble) -> float
     * Source: java/lang/Double.main.lsl:348
     */
    public float floatValue() {
        float result = 0.0f;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = ((float) this.value);
        }
        return result;
    }

    /**
     * [FUNCTION] DoubleAutomaton::hashCode(LSLDouble) -> int
     * Source: java/lang/Double.main.lsl:354
     */
    public int hashCode() {
        int result = 0;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = ((int) _getRawBits(this.value));
        }
        return result;
    }

    /**
     * [FUNCTION] DoubleAutomaton::intValue(LSLDouble) -> int
     * Source: java/lang/Double.main.lsl:360
     */
    public int intValue() {
        int result = 0;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = ((int) this.value);
        }
        return result;
    }

    /**
     * [FUNCTION] DoubleAutomaton::isInfinite(LSLDouble) -> boolean
     * Source: java/lang/Double.main.lsl:366
     */
    public boolean isInfinite() {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = (this.value == POSITIVE_INFINITY) || (this.value == NEGATIVE_INFINITY);
        }
        return result;
    }

    /**
     * [FUNCTION] DoubleAutomaton::isNaN(LSLDouble) -> boolean
     * Source: java/lang/Double.main.lsl:373
     */
    public boolean isNaN() {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = this.value != this.value;
        }
        return result;
    }

    /**
     * [FUNCTION] DoubleAutomaton::longValue(LSLDouble) -> long
     * Source: java/lang/Double.main.lsl:379
     */
    public long longValue() {
        long result = 0L;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = ((long) this.value);
        }
        return result;
    }

    /**
     * [FUNCTION] DoubleAutomaton::shortValue(LSLDouble) -> short
     * Source: java/lang/Double.main.lsl:385
     */
    public short shortValue() {
        short result = ((short) 0);
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = ((short) this.value);
        }
        return result;
    }

    /**
     * [FUNCTION] DoubleAutomaton::toString(LSLDouble) -> String
     * Source: java/lang/Double.main.lsl:391
     */
    public String toString() {
        String result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = LibSLRuntime.toString(this.value);
        }
        return result;
    }

    public static final class __$lsl_States {
        public static final byte Allocated = (byte) 0;

        public static final byte Initialized = (byte) 1;
    }

    @Approximate(Double.class)
    public static final class __hook {
        private __hook(Void o1, Void o2) {
            Engine.assume(false);
        }
    }
}
