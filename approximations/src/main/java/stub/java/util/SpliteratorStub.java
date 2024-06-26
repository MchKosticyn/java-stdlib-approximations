package stub.java.util;

import java.lang.LinkageError;
import java.util.ArrayList;
import java.util.Spliterator;
import java.util.function.Consumer;

public final class SpliteratorStub implements Spliterator<Object> {

    @SuppressWarnings("unused")
    private SpliteratorStub(ArrayList<Object> _this, int origin, int fence, int expectedModCount) {
        throw new LinkageError();
    }

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
