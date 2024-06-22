package stub.java.util;

import java.lang.LinkageError;
import java.lang.SuppressWarnings;
import java.util.Spliterator;
import java.util.function.Consumer;

import generated.java.util.AbstractSetImpl;

public final class HashSet_KeySpliterator implements Spliterator<Object> {

    @SuppressWarnings("unused")
    public HashSet_KeySpliterator(Object[] keysStorage, int index, int fence, int est, int expectedModCount, AbstractSetImpl parent) {
        throw new LinkageError();
    }

    public long estimateSize() {
        throw new LinkageError();
    }

    public int characteristics() {
        throw new LinkageError();
    }

    public void forEachRemaining(Consumer userAction) {
        throw new LinkageError();
    }

    public boolean tryAdvance(Consumer userAction) {
        throw new LinkageError();
    }

    public Spliterator<Object> trySplit() {
        throw new LinkageError();
    }
}
