package generated.java.util;

import generated.runtime.LibSLGlobals;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.SuppressWarnings;
import java.util.ConcurrentModificationException;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;

@Approximate(stub.java.util.HashMap_EntrySpliterator.class)
public final class HashMap_EntrySpliterator implements Spliterator<Map.Entry<Object, Object>> {

    public AbstractHashMapImpl parent;

    public Map.Entry<Object, Object>[] entryStorage;

    public int index;

    public int fence;

    public int est;

    public int expectedModCount;

    public HashMap_EntrySpliterator(
        AbstractHashMapImpl parent,
        Map.Entry<Object, Object>[] storage,
        int index,
        int fence,
        int est,
        int expectedModCount
    ) {
        this.parent = parent;
        this.entryStorage = storage;
        this.index = index;
        this.fence = fence;
        this.est = est;
        this.expectedModCount = expectedModCount;
    }

    @SuppressWarnings("DataFlowIssue")
    private int _getFence() {
        if (this.fence < 0) {
            Engine.assume(this.parent != null);
            int storageSize = this.entryStorage.length;
            this.est = storageSize;
            this.fence = storageSize;
            this.expectedModCount = this.parent.modCount;
            return storageSize;
        }

        return this.fence;
    }

    public int characteristics() {
        if (this.fence < 0 || this.est == this.entryStorage.length)
            return LibSLGlobals.SPLITERATOR_SIZED | LibSLGlobals.SPLITERATOR_DISTINCT;

        return LibSLGlobals.SPLITERATOR_DISTINCT;
    }

    public long estimateSize() {
        _getFence();
        return ((long) this.est);
    }

    @SuppressWarnings("ConditionCoveredByFurtherCondition")
    public void forEachRemaining(Consumer<? super Map.Entry<Object, Object>> userAction) {
        if (userAction == null) {
            throw new NullPointerException();
        }
        int hi = this.fence;
        int mc = this.expectedModCount;
        int i = this.index;
        int storageSize = this.entryStorage.length;
        if (hi < 0) {
            mc = this.parent.modCount;
            this.expectedModCount = mc;
            this.fence = storageSize;
            hi = storageSize;
        }
        this.index = hi;
        if (storageSize > 0 && storageSize >= hi && i >= 0 && i < hi) {
            while (i < hi) {
                Map.Entry<Object, Object> entry = entryStorage[i];
                userAction.accept(entry);
                i++;
            }
            if (this.parent.modCount != mc) {
                throw new ConcurrentModificationException();
            }
        }
    }

    public long getExactSizeIfKnown() {
        return _getFence() - this.index;
    }

    public boolean tryAdvance(Consumer<? super Map.Entry<Object, Object>> userAction) {
        if (userAction == null) {
            throw new NullPointerException();
        }
        int hi = _getFence();
        int i = this.index;
        if (i >= hi)
            return false;

        this.index = i + 1;
        userAction.accept(entryStorage[i]);
        if (this.expectedModCount != this.parent.modCount) {
            throw new ConcurrentModificationException();
        }
        return true;
    }

    public Spliterator<Map.Entry<Object, Object>> trySplit() {
        Engine.assume(this.parent != null);
        int hi = _getFence();
        int lo = this.index;
        int mid = (hi + lo) >>> 1;
        if (lo >= mid)
            return null;

        this.est = this.est >>> 1;
        this.index = mid;
        return new HashMap_EntrySpliterator(this.parent, this.entryStorage, lo, mid, this.est, this.expectedModCount);
    }
}
