package stub.java.util.stream;

import java.lang.LinkageError;
import java.lang.Long;
import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

public class LongStreamStubIterator implements PrimitiveIterator.OfLong {

    public boolean hasNext() {
        throw new LinkageError();
    }

    public Long next() {
        throw new LinkageError();
    }

    public long nextLong() {
        throw new LinkageError();
    }

    public void remove() {
        throw new LinkageError();
    }

    public void forEachRemaining(Consumer userAction) {
        throw new LinkageError();
    }

    public void forEachRemaining(LongConsumer userAction) {
        throw new LinkageError();
    }
}
