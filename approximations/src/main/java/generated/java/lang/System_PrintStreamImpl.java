package generated.java.lang;

import java.io.PrintStream;
import java.lang.CharSequence;
import java.lang.IndexOutOfBoundsException;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.String;
import java.lang.StringIndexOutOfBoundsException;
import java.util.Locale;

import generated.libsl.utils.VoidOutputStreamImpl;
import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;

@Approximate(stub.java.lang.System_PrintStream.class)
public final class System_PrintStreamImpl extends PrintStream {

    public boolean closed;

    public boolean error;

    public System_PrintStreamImpl(boolean closed, boolean error) {
        super(new VoidOutputStreamImpl(closed));
        this.closed = closed;
        this.error = error;
    }

    public PrintStream append(CharSequence csq) {
        if (this.closed)
            this.error = true;
        return this;
    }

    public PrintStream append(CharSequence csq, int start, int end) {
        if (csq == null)
            csq = "null";
        int size = csq.length();
        if (start < 0 || end >= size)
            throw new StringIndexOutOfBoundsException();
        if (this.closed)
            this.error = true;

        return this;
    }

    public PrintStream append(char c) {
        if (this.closed)
            this.error = true;

        return this;
    }

    public boolean checkError() {
        return this.error;
    }

    public void close() {
        this.closed = true;
    }

    public void flush() {
        if (this.closed)
            this.error = true;
    }

    @SuppressWarnings("ConstantValue")
    public PrintStream format(Locale l, @NotNull String format, Object[] args) {
        if (format == null)
            throw new NullPointerException();
        if (this.closed)
            this.error = true;

        return this;
    }

    @SuppressWarnings("ConstantValue")
    public PrintStream format(@NotNull String format, Object[] args) {
        if (format == null)
            throw new NullPointerException();
        if (this.closed)
            this.error = true;

        return this;
    }

    public void print(Object obj) {
        if (this.closed)
            this.error = true;
    }

    public void print(String s) {
        if (this.closed)
            this.error = true;
    }

    public void print(boolean b) {
        if (this.closed)
            this.error = true;
    }

    public void print(char c) {
        if (this.closed)
            this.error = true;
    }

    @SuppressWarnings("ConstantValue")
    public void print(@NotNull char[] s) {
        if (s == null)
            throw new NullPointerException();
        if (this.closed)
            this.error = true;
    }

    public void print(double d) {
        if (this.closed)
            this.error = true;
    }

    public void print(float f) {
        if (this.closed)
            this.error = true;
    }

    public void print(int i) {
        if (this.closed)
            this.error = true;
    }

    public void print(long l) {
        if (this.closed)
            this.error = true;
    }

    @SuppressWarnings("ConstantValue")
    public PrintStream printf(Locale l, @NotNull String format, Object[] args) {
        if (l == null || format == null || args == null)
            throw new NullPointerException();
        if (this.closed)
            this.error = true;

        return this;
    }

    @SuppressWarnings("ConstantValue")
    public PrintStream printf(@NotNull String format, Object[] args) {
        if (format == null || args == null)
            throw new NullPointerException();
        if (this.closed)
            this.error = true;
        return this;
    }

    public void println() {
        if (this.closed)
            this.error = true;
    }

    public void println(Object x) {
        if (this.closed)
            this.error = true;
    }

    public void println(String x) {
        if (this.closed)
            this.error = true;
    }

    public void println(boolean x) {
        if (this.closed)
            this.error = true;
    }

    public void println(char x) {
        if (this.closed)
            this.error = true;
    }

    @SuppressWarnings("ConstantValue")
    public void println(@NotNull char[] x) {
        if (x == null)
            throw new NullPointerException();
        if (this.closed)
            this.error = true;
    }

    public void println(double x) {
        if (this.closed)
            this.error = true;
    }

    public void println(float x) {
        if (this.closed)
            this.error = true;
    }

    public void println(int x) {
        if (this.closed)
            this.error = true;
    }

    public void println(long x) {
        if (this.closed)
            this.error = true;
    }

    @SuppressWarnings("RedundantThrows")
    public void write(byte[] b) throws java.io.IOException {
        if (b == null)
            throw new NullPointerException();
        if (this.closed)
            this.error = true;
    }

    @SuppressWarnings("ConstantValue")
    public void write(@NotNull byte[] buf, int off, int len) {
        if (buf == null)
            throw new NullPointerException();
        int size = buf.length;
        if (off < 0 || off + len > size)
            throw new IndexOutOfBoundsException();
        if (this.closed)
            this.error = true;
    }

    public void write(int b) {
        if (this.closed)
            this.error = true;
    }
}
