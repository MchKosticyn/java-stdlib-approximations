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
import stub.java.util.SubListSpliteratorStub;

@Approximate(SubListSpliteratorStub.class)
public final class SubListSpliteratorStubImpl implements Spliterator<Object> {

    public AbstractListImpl root;

    public SubListStubImpl parent;

    public int index;

    public int fence;

    public int expectedModCount;

    public SubListSpliteratorStubImpl(
        AbstractListImpl root,
        SubListStubImpl parent,
        int index,
        int fence,
        int expectedModCount
    ) {
        Engine.assume(root != null);
        Engine.assume(parent != null);
        this.root = root;
        this.parent = parent;
        this.index = index;
        this.fence = fence;
        this.expectedModCount = expectedModCount;
    }

    private int _getFence() {
        if (this.fence == -1) {
            Engine.assume(this.parent != null);
            this.expectedModCount = this.parent.modCount;
            int newFence = this.parent.length;
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
        Engine.assume(this.root != null);
        Engine.assume(this.parent != null);
        if (_action == null) {
            throw new NullPointerException();
        }
        SymbolicList<Object> a = this.root.storage;
        if (a == null) {
            throw new ConcurrentModificationException();
        }
        int hi = this.fence;
        int mc = this.expectedModCount;
        if (hi == -1) {
            hi = this.parent.length;
            mc = this.parent.modCount;
        }
        int i = this.index;
        this.index = hi;
        if ((i < 0) || (hi > this.parent.length)) {
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
        return _getFence() - this.index;
    }
    public boolean tryAdvance(Consumer<Object> _action) {
        if (_action == null) {
            throw new NullPointerException();
        }
        int hi = _getFence();
        int i = this.index;
        if (i < hi) {
            Engine.assume(this.root != null);
            this.index = i + 1;
            SymbolicList<Object> rootStorage = this.root.storage;
            Object item = rootStorage.get(i);
            _action.accept(item);
            if (this.root.modCount != this.expectedModCount) {
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
        return new SubListSpliteratorStubImpl(this.root, this.parent, lo, mid, this.expectedModCount);
    }
}
