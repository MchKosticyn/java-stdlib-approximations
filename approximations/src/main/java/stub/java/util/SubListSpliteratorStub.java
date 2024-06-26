package stub.java.util;

import java.lang.LinkageError;
import java.util.Spliterator;
import java.util.function.Consumer;

public final class SubListSpliteratorStub implements Spliterator<Object> {

    public int characteristics() {
        throw new LinkageError();
    }

    public long estimateSize() {
        throw new LinkageError();
    }

    public void forEachRemaining(Consumer _action) {
        throw new LinkageError();
    }

    public long getExactSizeIfKnown() {
        throw new LinkageError();
    }

    public boolean tryAdvance(Consumer _action) {
        throw new LinkageError();
    }

    public Spliterator<Object> trySplit() {
        throw new LinkageError();
    }
}
