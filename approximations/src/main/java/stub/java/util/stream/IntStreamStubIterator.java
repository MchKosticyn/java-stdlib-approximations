package stub.java.util.stream;

import java.lang.Integer;
import java.lang.LinkageError;
import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class IntStreamStubIterator implements PrimitiveIterator.OfInt {

    public boolean hasNext() {
        throw new LinkageError();
    }

    public Integer next() {
        throw new LinkageError();
    }

    public int nextInt() {
        throw new LinkageError();
    }

    public void remove() {
        throw new LinkageError();
    }

    public void forEachRemaining(Consumer userAction) {
        throw new LinkageError();
    }

    public void forEachRemaining(IntConsumer userAction) {
        throw new LinkageError();
    }
}
