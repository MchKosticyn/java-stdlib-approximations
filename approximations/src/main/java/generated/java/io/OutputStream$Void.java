// Generated by the LibSL translator.  DO NOT EDIT!
// source: ?
//
package generated.java.io;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.IndexOutOfBoundsException;
import java.lang.NullPointerException;
import java.lang.Void;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;

/**
 * VoidOutputStreamAutomaton for VoidOutputStream ~> java.io.OutputStream$Void
 */
@Approximate(stub.java.io.OutputStream$Void.class)
public final class OutputStream$Void extends OutputStream implements LibSLRuntime.Automaton {
    static {
        Engine.assume(true);
    }

    public volatile boolean closed;

    @LibSLRuntime.AutomatonConstructor
    public OutputStream$Void(Void __$lsl_token, final byte p0, final boolean p1) {
        this.closed = p1;
    }

    @LibSLRuntime.AutomatonConstructor
    public OutputStream$Void(final Void __$lsl_token) {
        this(__$lsl_token, __$lsl_States.Initialized, false);
    }

    /**
     * [SUBROUTINE] VoidOutputStreamAutomaton::_checkFromIndexSize(int, int, int) -> void
     */
    private void _checkFromIndexSize(int fromIndex, int size, int length) {
        /* body */ {
            if (((length | fromIndex | size) < 0) || (size > (length - fromIndex))) {
                throw new IndexOutOfBoundsException("Range [%s, %<s + %s) out of bounds for length %s");
            }
        }
    }

    /**
     * [FUNCTION] VoidOutputStreamAutomaton::close(VoidOutputStream) -> void
     */
    public void close() {
        /* body */ {
            this.closed = true;
        }
    }

    /**
     * [FUNCTION] VoidOutputStreamAutomaton::flush(VoidOutputStream) -> void
     */
    public void flush() throws java.io.IOException {
        /* body */ {
        }
    }

    /**
     * [FUNCTION] VoidOutputStreamAutomaton::write(VoidOutputStream, array<byte>) -> void
     */
    public void write(byte[] b) throws java.io.IOException {
        /* body */ {
            if (b == null) {
                throw new NullPointerException();
            }
            if (this.closed) {
                throw new IOException("Stream closed");
            }
        }
    }

    /**
     * [FUNCTION] VoidOutputStreamAutomaton::write(VoidOutputStream, array<byte>, int, int) -> void
     */
    public void write(byte[] b, int off, int len) throws java.io.IOException {
        /* body */ {
            _checkFromIndexSize(off, len, b.length);
            if (this.closed) {
                throw new IOException("Stream closed");
            }
        }
    }

    /**
     * [FUNCTION] VoidOutputStreamAutomaton::write(VoidOutputStream, int) -> void
     */
    public void write(int b) throws java.io.IOException {
        /* body */ {
            if (this.closed) {
                throw new IOException("Stream closed");
            }
        }
    }

    public static final class __$lsl_States {
        public static final byte Initialized = (byte) 0;
    }

    @Approximate(OutputStream$Void.class)
    public static final class __hook {
        private __hook(Void o1, Void o2) {
            Engine.assume(false);
        }
    }
}
