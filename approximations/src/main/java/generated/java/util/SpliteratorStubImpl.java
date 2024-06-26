package generated.java.util;

import generated.runtime.LibSLGlobals;
import java.lang.NullPointerException;
import java.lang.Object;
import java.util.ConcurrentModificationException;
import java.util.Spliterator;
import java.util.function.Consumer;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import org.usvm.api.SymbolicList;
import stub.java.util.SpliteratorStub;

@Approximate(SpliteratorStub.class)
public final class SpliteratorStubImpl implements Spliterator<Object> {

    public AbstractListImpl parent;

    public int index;

    public int fence;

    public int expectedModCount;

    public SpliteratorStubImpl(AbstractListImpl parent, int index, int fence, int expectedModCount) {
        Engine.assume(this.parent != null);
        this.parent = parent;
        this.index = index;
        this.fence = fence;
        this.expectedModCount = expectedModCount;
    }

    private int _getFence() {
        if (this.fence == -1) {
            Engine.assume(this.parent != null);
            this.expectedModCount = this.parent.modCount;
            int newFence = this.parent.storage.size();
            this.fence = newFence;
            return newFence;
        }

        return this.fence;
    }

    public int characteristics() {
        return LibSLGlobals.SPLITERATOR_ORDERED | LibSLGlobals.SPLITERATOR_SIZED | LibSLGlobals.SPLITERATOR_SUBSIZED;
    }

    public long estimateSize() {
        return _getFence() - this.index;
    }

    public void forEachRemaining(Consumer<Object> _action) {
        Engine.assume(this.parent != null);
        if (_action == null) {
            throw new NullPointerException();
        }
        SymbolicList<Object> a = this.parent.storage;
        if (a == null) {
            throw new ConcurrentModificationException();
        }
        int hi = this.fence;
        int mc = this.expectedModCount;
        if (hi == -1) {
            hi = a.size();
            mc = this.parent.modCount;
        }
        int i = this.index;
        this.index = hi;
        if ((i < 0) || (hi > a.size())) {
            throw new ConcurrentModificationException();
        }
        for (int j = i; j < hi; j++) {
            Object item = a.get(j);
            _action.accept(item);
        }
        if (mc != this.parent.modCount) {
            throw new ConcurrentModificationException();
        }
    }

    public long getExactSizeIfKnown() {
        return estimateSize();
    }

    public boolean tryAdvance(Consumer<Object> _action) {
        if (_action == null) {
            throw new NullPointerException();
        }
        int hi = _getFence();
        int i = this.index;
        if (i < hi) {
            Engine.assume(this.parent != null);
            this.index = i + 1;
            SymbolicList<Object> parentStorage = this.parent.storage;
            Object item = parentStorage.get(i);
            _action.accept(item);
            if (this.parent.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            return true;
        }

        return false;
    }

    public Spliterator<Object> trySplit() {
        int hi = _getFence();
        int lo = this.index;
        int mid = (lo + hi) >>> 1;
        this.index = mid;
        if (lo >= mid)
            return null;

        return new SpliteratorStubImpl(this.parent, lo, mid, this.expectedModCount);
    }
}
