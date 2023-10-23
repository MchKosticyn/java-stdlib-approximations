// Generated by the LibSL translator.  DO NOT EDIT!
// source: ?
//
package generated.java.lang;

import generated.runtime.LibSLGlobals;
import generated.runtime.utils.SymbolicInputStream;
import java.io.Console;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.String;
import java.lang.Void;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;

/**
 * SystemAutomaton for LSLSystem ~> java.lang.System
 */
@Approximate(java.lang.System.class)
public final class System implements LibSLRuntime.Automaton {
    private static Console ioConsole = null;

    public static InputStream in = null;

    public static PrintStream out = null;

    public static PrintStream err = null;

    private static final long NANOTIME_BEGINNING_OF_TIME = 1000L;

    private static final long NANOTIME_WARP_MAX = 1000L;

    static {
        /* SystemAutomaton::__clinit__() */ {
            final InputStream newInput = new SymbolicInputStream((Void) null, 
            /* state = */ SymbolicInputStream.__$lsl_States.Initialized, 
            /* maxSize = */ 1000, 
            /* supportMarks = */ false, 
            /* dataSize = */ -1, 
            /* data = */ null, 
            /* closed = */ false, 
            /* pos = */ 0, 
            /* markPos = */ -1, 
            /* markLimit = */ 0);
            in = new java.io.BufferedInputStream(newInput);
            LibSLRuntime.todo();
            LibSLRuntime.todo();
        }
    }

    @LibSLRuntime.AutomatonConstructor
    public System(Void __$lsl_token, final byte p0) {
    }

    @LibSLRuntime.AutomatonConstructor
    public System(final Void __$lsl_token) {
        this(__$lsl_token, __$lsl_States.Initialized);
    }

    /**
     * [CONSTRUCTOR] SystemAutomaton::LSLSystem(LSLSystem) -> LSLSystem
     */
    private System() {
        this((Void) null);
        /* body */ {
        }
    }

    /**
     * [FUNCTION] SystemAutomaton::console() -> Console
     */
    public static Console console() {
        Console result = null;
        /* body */ {
            result = ioConsole;
        }
        return result;
    }

    /**
     * [FUNCTION] SystemAutomaton::exit(int) -> void
     */
    public static void exit(int status) {
        /* body */ {
            LibSLRuntime.error("Unexpected shutdown");
        }
    }

    /**
     * [FUNCTION] SystemAutomaton::gc() -> void
     */
    public static void gc() {
        /* body */ {
        }
    }

    /**
     * [FUNCTION] SystemAutomaton::getenv(String) -> String
     */
    public static String getenv(String name) {
        String result = null;
        /* body */ {
            result = Engine.makeSymbolic(String.class);
            Engine.assume(result != null);
        }
        return result;
    }

    /**
     * [FUNCTION] SystemAutomaton::identityHashCode(Object) -> int
     */
    public static int identityHashCode(Object x) {
        int result = 0;
        /* body */ {
            result = Engine.makeSymbolicInt();
        }
        return result;
    }

    /**
     * [FUNCTION] SystemAutomaton::lineSeparator() -> String
     */
    public static String lineSeparator() {
        String result = null;
        /* body */ {
            if (LibSLGlobals.SYSTEM_IS_WINDOWS) {
                result = "\r\n";
            } else {
                result = "\n";
            }
        }
        return result;
    }

    /**
     * [FUNCTION] SystemAutomaton::setErr(PrintStream) -> void
     */
    public static void setErr(PrintStream stream) {
        /* body */ {
            if (stream == null) {
                throw new NullPointerException();
            }
            err = stream;
        }
    }

    /**
     * [FUNCTION] SystemAutomaton::setIn(InputStream) -> void
     */
    public static void setIn(InputStream stream) {
        /* body */ {
            if (stream == null) {
                throw new NullPointerException();
            }
            in = stream;
        }
    }

    /**
     * [FUNCTION] SystemAutomaton::setOut(PrintStream) -> void
     */
    public static void setOut(PrintStream stream) {
        /* body */ {
            if (stream == null) {
                throw new NullPointerException();
            }
            out = stream;
        }
    }

    public static final class __$lsl_States {
        public static final byte Initialized = (byte) 0;
    }

    @Approximate(System.class)
    public static final class __hook {
        private __hook(Void o1, Void o2) {
            Engine.assume(false);
        }
    }
}
