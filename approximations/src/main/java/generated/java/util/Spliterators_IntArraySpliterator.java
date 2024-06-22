package generated.java.util;

import generated.runtime.LibSLGlobals;
import java.lang.IllegalStateException;
import java.lang.NullPointerException;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import org.jacodb.approximation.annotation.Approximate;

@Approximate(stub.java.util.Spliterators_IntArraySpliterator.class)
public final class Spliterators_IntArraySpliterator implements Spliterator.OfInt {

    public int[] array;

    public int index;

    public int fence;

    public int characteristics;

    public Spliterators_IntArraySpliterator(int[] array, int index, int fence, int characteristics) {
        this.array = array;
        this.index = index;
        this.fence = fence;
        this.characteristics = characteristics | SpliteratorsImpl._characteristics;;
    }

    public Spliterators_IntArraySpliterator(int[] arr, int additionalCharacteristics) {
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

    public void forEachRemaining(Consumer<? super Integer> _action) {
        if (_action == null)
            throw new NullPointerException();

        int current = this.index;
        this.index = this.fence;
        for (int i = current; i < this.fence; i++) {
            int item = this.array[i];
            _action.accept(item);
        }
    }

    public void forEachRemaining(IntConsumer _action) {
        if (_action == null)
            throw new NullPointerException();

        int current = this.index;
        this.index = this.fence;
        for (int i = current; i < this.fence; i++) {
            int item = this.array[i];
            _action.accept(item);
        }
    }

    public Comparator<? super Integer> getComparator() {
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

    public boolean tryAdvance(IntConsumer _action) {
        if (_action == null)
            throw new NullPointerException();

        int current = this.index;
        if (current < this.fence) {
            this.index = current + 1;
            int item = array[current];
            _action.accept(item);
            return true;
        }

        return false;
    }

    public boolean tryAdvance(Consumer<? super Integer> _action) {
        if (_action == null)
            throw new NullPointerException();

        int current = this.index;
        if (current < this.fence) {
            this.index = current + 1;
            int item = array[current];
            _action.accept(item);
            return true;
        }

        return false;
    }

    public Spliterator.OfInt trySplit() {
        int hi = this.fence;
        int lo = this.index;
        int mid = (lo + hi) >>> 1;
        if (lo >= mid)
            return null;

        this.index = mid;
        return new Spliterators_IntArraySpliterator(this.array, lo, mid, this.characteristics);
    }
}
