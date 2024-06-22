package generated.java.util;

import generated.runtime.LibSLGlobals;
import java.lang.IllegalStateException;
import java.lang.NullPointerException;
import java.lang.Object;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import org.jacodb.approximation.annotation.Approximate;

@Approximate(stub.java.util.Spliterators_ArraySpliterator.class)
public final class Spliterators_ArraySpliterator implements Spliterator<Object> {

    public Object[] array;

    public int index;

    public int fence;

    public int characteristics;

    public Spliterators_ArraySpliterator(Object[] array, int index, int fence, int characteristics) {
        this.array = array;
        this.index = index;
        this.fence = fence;
        this.characteristics = characteristics | SpliteratorsImpl._characteristics;
    }

    @SuppressWarnings("unused")
    public Spliterators_ArraySpliterator(Object[] arr, int additionalCharacteristics) {
        this(arr, 0, arr.length, additionalCharacteristics);
    }

    private boolean _hasCharacteristics(int _characteristics) {
        return (this.characteristics & _characteristics) == _characteristics;
    }

    public int characteristics() {
        return this.characteristics;
    }

    public long estimateSize() {
        return this.fence - this.index;
    }

    public void forEachRemaining(Consumer<? super Object> _action) {
        if (_action == null)
            throw new NullPointerException();

        int current = this.index;
        this.index = this.fence;
        for (int i = current; i < this.fence; i++) {
            Object item = array[i];
            _action.accept(item);
        }
    }

    public Comparator<Object> getComparator() {
        if (_hasCharacteristics(LibSLGlobals.SPLITERATOR_SORTED))
            return null;

        throw new IllegalStateException();
    }

    public long getExactSizeIfKnown() {
        return estimateSize();
    }

    public boolean hasCharacteristics(int _characteristics) {
        return _hasCharacteristics(_characteristics);
    }

    public boolean tryAdvance(Consumer<? super Object> _action) {
        if (_action == null) {
            throw new NullPointerException();
        }
        int current = this.index;
        if (current < this.fence) {
            this.index = current + 1;
            Object item = array[current];
            _action.accept(item);
            return true;
        }

        return false;
    }

    public Spliterator<Object> trySplit() {
        int hi = this.fence;
        int lo = this.index;
        int mid = (lo + hi) >>> 1;
        if (lo >= mid)
            return null;

        this.index = mid;
        return new Spliterators_ArraySpliterator(this.array, lo, mid, this.characteristics);
    }
}
