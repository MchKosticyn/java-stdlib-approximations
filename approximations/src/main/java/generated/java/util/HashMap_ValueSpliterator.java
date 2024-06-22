package generated.java.util;

import generated.runtime.LibSLGlobals;
import java.lang.NullPointerException;
import java.lang.Object;
import java.util.ConcurrentModificationException;
import java.util.Spliterator;
import java.util.function.Consumer;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;

@Approximate(stub.java.util.HashMap_ValueSpliterator.class)
public final class HashMap_ValueSpliterator implements Spliterator<Object> {

    public Object[] storage;

    public AbstractHashMapImpl parent;

    public int index;

    public int fence;

    public int est;

    public int expectedModCount;

    public HashMap_ValueSpliterator(
        Object[] storage,
        AbstractHashMapImpl parent,
        int index,
        int fence,
        int est,
        int expectedModCount
    ) {
        this.storage = storage;
        this.parent = parent;
        this.index = index;
        this.fence = fence;
        this.est = est;
        this.expectedModCount = expectedModCount;
    }

    @SuppressWarnings("DataFlowIssue")
    private int _getFence() {
        if (this.fence < 0) {
            Engine.assume(this.parent != null);
            int storageSize = this.storage.length;
            this.est = storageSize;
            this.fence = storageSize;
            this.expectedModCount = this.parent.modCount;
        }
        return this.fence;
    }

    public int characteristics() {
        if (this.fence < 0 || this.est == this.storage.length)
            return LibSLGlobals.SPLITERATOR_SIZED;

        return 0;
    }

    public long estimateSize() {
        _getFence();
        return this.est;
    }

    @SuppressWarnings("ConditionCoveredByFurtherCondition")
    public void forEachRemaining(Consumer<? super Object> userAction) {
        if (userAction == null) {
            throw new NullPointerException();
        }
        int hi = this.fence;
        int mc = this.expectedModCount;
        int i = this.index;
        int storageSize = this.storage.length;
        if (hi < 0) {
            mc = this.parent.modCount;
            this.expectedModCount = mc;
            this.fence = storageSize;
            hi = storageSize;
        }
        this.index = hi;
        if (storageSize > 0 && storageSize >= hi && i >= 0 && i < hi) {
            while (i < hi) {
                userAction.accept(storage[i]);
                i++;
            }
            int modCount = this.parent.modCount;
            if (modCount != mc) {
                throw new ConcurrentModificationException();
            }
        }
    }

    public long getExactSizeIfKnown() {
        return _getFence() - this.index;
    }

    public boolean tryAdvance(Consumer<? super Object> userAction) {
        if (userAction == null) {
            throw new NullPointerException();
        }
        int hi = _getFence();
        int i = this.index;
        if (i >= hi)
            return false;

        this.index = i + 1;
        userAction.accept(storage[i]);
        if (this.parent.modCount != this.expectedModCount) {
            throw new ConcurrentModificationException();
        }

        return true;
    }

    public Spliterator<Object> trySplit() {
        Engine.assume(this.parent != null);
        int hi = _getFence();
        int lo = this.index;
        int mid = (hi + lo) >>> 1;
        if (lo >= mid)
            return null;

        this.est = this.est >>> 1;
        this.index = mid;
        return new HashMap_ValueSpliterator(this.storage, this.parent, lo, mid, this.est, this.expectedModCount);
    }
}
