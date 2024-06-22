package generated.java.util;

import generated.runtime.LibSLGlobals;
import java.lang.NullPointerException;
import java.lang.Object;
import java.util.ConcurrentModificationException;
import java.util.Spliterator;
import java.util.function.Consumer;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;

@Approximate(stub.java.util.HashMap_KeySpliterator.class)
public final class HashMap_KeySpliterator implements Spliterator<Object> {

    public Object[] keysStorage;

    public AbstractHashMapImpl parent;

    public int index;

    public int fence;

    public int est;

    public int expectedModCount;

    public HashMap_KeySpliterator(
        Object[] keysStorage,
        AbstractHashMapImpl parent,
        int index,
        int fence,
        int est,
        int expectedModCount
    ) {
        this.keysStorage = keysStorage;
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
            int storageSize = this.keysStorage.length;
            this.est = storageSize;
            this.fence = storageSize;
            this.expectedModCount = this.parent.modCount;
            return storageSize;
        }

        return this.fence;
    }

    public int characteristics() {
        if (this.fence < 0 || this.est == this.keysStorage.length)
            return LibSLGlobals.SPLITERATOR_SIZED | LibSLGlobals.SPLITERATOR_DISTINCT;

        return LibSLGlobals.SPLITERATOR_DISTINCT;
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
        int storageSize = this.keysStorage.length;
        if (hi < 0) {
            this.expectedModCount = this.parent.modCount;
            mc = this.expectedModCount;
            this.fence = storageSize;
            hi = storageSize;
        }
        this.index = hi;
        if (storageSize > 0 && storageSize >= hi && i >= 0 && i < hi) {
            while (i < hi) {
                Object curKey = keysStorage[i];
                userAction.accept(curKey);
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
        userAction.accept(keysStorage[i]);
        if (this.expectedModCount != this.parent.modCount) {
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
        return new HashMap_KeySpliterator(this.keysStorage, this.parent, lo, mid, this.est, this.expectedModCount);
    }
}
