package generated.java.util;

import generated.runtime.LibSLGlobals;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.SuppressWarnings;
import java.util.ConcurrentModificationException;
import java.util.Spliterator;
import java.util.function.Consumer;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;

@Approximate(stub.java.util.HashSet_KeySpliterator.class)
public final class HashSet_KeySpliterator implements Spliterator<Object> {

    public Object[] keysStorage;

    public int index;

    public int fence;

    public int est;

    public int expectedModCount;

    public AbstractSetImpl parent;

    public HashSet_KeySpliterator(
        Object[] keysStorage,
        int index,
        int fence,
        int est,
        int expectedModCount,
        AbstractSetImpl parent
    ) {
        this.keysStorage = keysStorage;
        this.index = index;
        this.fence = fence;
        this.est = est;
        this.expectedModCount = expectedModCount;
        this.parent = parent;
    }

    @SuppressWarnings("DataFlowIssue")
    private int _getFence() {
        int hi = this.fence;
        if (hi < 0) {
            Engine.assume(this.parent != null);
            LibSLRuntime.Map<Object, Object> parentStorage = this.parent.storage;
            this.est = parentStorage.size();
            this.expectedModCount = this.parent.modCount;
            this.fence = this.est;
            hi = this.fence;
        }
        return hi;
    }

    private void _checkForComodification() {
        if (this.expectedModCount != this.parent.modCount) {
            throw new ConcurrentModificationException();
        }
    }

    public long estimateSize() {
        _getFence();
        return this.est;
    }

    @SuppressWarnings("DataFlowIssue")
    public int characteristics() {
        Engine.assume(this.parent != null);
        LibSLRuntime.Map<Object, Object> parentStorage = this.parent.storage;
        int length = parentStorage.size();
        if (this.fence < 0 || this.est == length) {
            return LibSLGlobals.SPLITERATOR_SIZED | LibSLGlobals.SPLITERATOR_DISTINCT;
        }

        return LibSLGlobals.SPLITERATOR_DISTINCT;
    }

    @SuppressWarnings({"ConditionCoveredByFurtherCondition", "DataFlowIssue"})
    public void forEachRemaining(Consumer<? super Object> userAction) {
        Engine.assume(this.parent != null);
        if (userAction == null) {
            throw new NullPointerException();
        }
        int hi = this.fence;
        int mc = this.expectedModCount;
        int i = this.index;
        LibSLRuntime.Map<Object, Object> parentStorage = this.parent.storage;
        int length = parentStorage.size();
        if (hi < 0) {
            this.expectedModCount = this.parent.modCount;
            mc = this.expectedModCount;
            this.fence = length;
            hi = length;
        }
        this.index = hi;
        if (length > 0 && length >= hi && i >= 0 && i < hi) {
            Object[] storage = this.keysStorage;
            Engine.assume(storage != null);
            while (i < hi) {
                Object key = storage[i];
                userAction.accept(key);
                i++;
            }

            if (this.parent.modCount != mc) {
                throw new ConcurrentModificationException();
            }
        }
    }

    public boolean tryAdvance(Consumer<? super Object> userAction) {
        if (userAction == null) {
            throw new NullPointerException();
        }
        int hi = _getFence();
        int i = this.index;
        if (i < hi) {
            Object key = keysStorage[i];
            userAction.accept(key);
            this.index++;
            _checkForComodification();
            return true;
        }
        return false;
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
        return new HashSet_KeySpliterator(this.keysStorage, lo, mid, this.est, this.expectedModCount, this.parent);
    }
}
