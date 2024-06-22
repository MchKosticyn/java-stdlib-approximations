package generated.java.util;

import java.lang.IllegalStateException;
import java.lang.NullPointerException;
import java.lang.Object;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import org.usvm.api.SymbolicList;

@Approximate(stub.java.util.ArrayList_ListItr.class)
public final class ArrayList_ListItrImpl implements ListIterator<Object> {

    public AbstractListImpl parent;

    public int cursor;

    public int expectedModCount;

    public int lastRet;

    @SuppressWarnings("ConstantValue")
    public ArrayList_ListItrImpl(AbstractListImpl parent, int cursor, int expectedMocCount, int lastRet) {
        Engine.assume(this.parent != null);
        this.parent = parent;
        this.cursor = cursor;
        this.expectedModCount = expectedMocCount;
        this.lastRet = lastRet;
    }

    @SuppressWarnings("DataFlowIssue")
    private void _checkForComodification() {
        Engine.assume(parent != null);
        int modCount = this.parent.modCount;
        if (modCount != this.expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean hasPrevious() {
        return this.cursor != 0;
    }

    public int nextIndex() {
        return this.cursor;
    }

    public int previousIndex() {
        return this.cursor - 1;
    }

    @SuppressWarnings("DataFlowIssue")
    public boolean hasNext() {
        Engine.assume(parent != null);
        return this.cursor != this.parent.storage.size();
    }

    @SuppressWarnings("DataFlowIssue")
    public Object next() {
        _checkForComodification();
        Engine.assume(parent != null);
        SymbolicList<Object> parentStorage = this.parent.storage;
        int i = this.cursor;
        if (i >= parentStorage.size()) {
            throw new NoSuchElementException();
        }
        this.cursor = i + 1;
        this.lastRet = i;
        return parentStorage.get(i);
    }

    @SuppressWarnings("DataFlowIssue")
    public Object previous() {
        _checkForComodification();
        Engine.assume(parent != null);
        SymbolicList<Object> parentStorage = this.parent.storage;
        int i = this.cursor - 1;
        if (i < 0) {
            throw new NoSuchElementException();
        }
        if (i >= parentStorage.size()) {
            throw new ConcurrentModificationException();
        }
        this.cursor = i;
        this.lastRet = i;
        return parentStorage.get(i);
    }

    @SuppressWarnings("DataFlowIssue")
    public void remove() {
        if (this.lastRet < 0) {
            throw new IllegalStateException();
        }
        _checkForComodification();
        Engine.assume(parent != null);
        SymbolicList<Object> pStorage = this.parent.storage;
        if (this.lastRet >= pStorage.size()) {
            throw new ConcurrentModificationException();
        } else {
            this.parent.modCount++;
            pStorage.remove(this.lastRet);
        }
        this.cursor = this.lastRet;
        this.lastRet = -1;
        this.expectedModCount = this.parent.modCount;
    }

    @SuppressWarnings("DataFlowIssue")
    public void set(Object e) {
        if (this.lastRet < 0) {
            throw new IllegalStateException();
        }
        _checkForComodification();
        Engine.assume(parent != null);
        SymbolicList<Object> pStorage = this.parent.storage;
        if (this.lastRet >= pStorage.size()) {
            throw new ConcurrentModificationException();
        }
        pStorage.set(this.lastRet, e);
    }

    @SuppressWarnings("DataFlowIssue")
    public void add(Object e) {
        _checkForComodification();
        int i = this.cursor;
        Engine.assume(parent != null);
        SymbolicList<Object> pStorage = this.parent.storage;
        if (this.lastRet > pStorage.size()) {
            throw new ConcurrentModificationException();
        }
        this.parent.modCount++;
        pStorage.insert(i, e);
        this.cursor = i + 1;
        this.lastRet = -1;
        this.expectedModCount = this.parent.modCount;
    }

    @SuppressWarnings("DataFlowIssue")
    public void forEachRemaining(Consumer<Object> userAction) {
        if (userAction == null) {
            throw new NullPointerException();
        }
        int i = this.cursor;
        Engine.assume(parent != null);
        SymbolicList<Object> es = this.parent.storage;
        int size = es.size();
        if (i < size) {
            while ((i < size) && (this.parent.modCount == this.expectedModCount)) {
                Object item = es.get(i);
                userAction.accept(item);
                i++;
            }
            this.cursor = i;
            this.lastRet = i - 1;
            _checkForComodification();
        }
    }
}
