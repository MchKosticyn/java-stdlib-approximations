package stub.java.util;

import java.lang.LinkageError;
import java.lang.Object;
import java.lang.SuppressWarnings;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;

public final class ArraySpliterator implements Spliterator<Object> {

    @SuppressWarnings("unused")
    public ArraySpliterator(Object[] arr, int additionalCharacteristics) {
        throw new LinkageError();
    }

    @SuppressWarnings("unused")
    public ArraySpliterator(Object[] arr, int origin, int pFence, int additionalCharacteristics) {
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

    public Comparator<Object> getComparator() {
        throw new LinkageError();
    }

    public long getExactSizeIfKnown() {
        throw new LinkageError();
    }

    public boolean hasCharacteristics(int _characteristics) {
        throw new LinkageError();
    }

    public boolean tryAdvance(Consumer _action) {
        throw new LinkageError();
    }

    public Spliterator<Object> trySplit() {
        throw new LinkageError();
    }
}
