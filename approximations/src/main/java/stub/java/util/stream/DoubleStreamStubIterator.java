package stub.java.util.stream;

import java.lang.Double;
import java.lang.LinkageError;
import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

public class DoubleStreamStubIterator implements PrimitiveIterator.OfDouble {

    public boolean hasNext() {
        throw new LinkageError();
    }

    public Double next() {
        throw new LinkageError();
    }

    public double nextDouble() {
        throw new LinkageError();
    }

    public void remove() {
        throw new LinkageError();
    }

    public void forEachRemaining(Consumer userAction) {
        throw new LinkageError();
    }

    public void forEachRemaining(DoubleConsumer userAction) {
        throw new LinkageError();
    }
}
