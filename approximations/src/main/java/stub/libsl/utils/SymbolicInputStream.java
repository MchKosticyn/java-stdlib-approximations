package stub.libsl.utils;

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.LinkageError;

public final class SymbolicInputStream extends InputStream {

    public int available() {
        throw new LinkageError();
    }

    public void close() throws java.io.IOException {
        throw new LinkageError();
    }

    public void mark(int readLimit) {
        throw new LinkageError();
    }

    public boolean markSupported() {
        throw new LinkageError();
    }

    public int read() {
        throw new LinkageError();
    }

    public int read(byte[] b) {
        throw new LinkageError();
    }

    public int read(byte[] b, int off, int len) {
        throw new LinkageError();
    }

    public byte[] readAllBytes() {
        throw new LinkageError();
    }

    public int readNBytes(byte[] b, int off, int len) {
        throw new LinkageError();
    }

    public byte[] readNBytes(int len) {
        throw new LinkageError();
    }

    public void reset() {
        throw new LinkageError();
    }

    public long skip(long n) throws java.io.IOException {
        throw new LinkageError();
    }

    public long transferTo(OutputStream output) {
        throw new LinkageError();
    }
}
