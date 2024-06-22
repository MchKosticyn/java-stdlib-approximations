package generated.java.util;

import java.lang.IllegalStateException;
import java.lang.NullPointerException;
import java.lang.Object;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import org.usvm.api.SymbolicList;

@Approximate(stub.java.util.LinkedList_DescendingIterator.class)
public final class LinkedList_DescendingIterator implements Iterator<Object> {

    public LinkedListImpl parent;

    public int cursor;

    public int expectedModCount;

    public int lastRet;

    public LinkedList_DescendingIterator(LinkedListImpl parent, int cursor, int expectedModCount, int lastRet) {
        this.parent = parent;
        this.cursor = cursor;
        this.expectedModCount = expectedModCount;
        this.lastRet = lastRet;
    }

    public boolean hasNext() {
        Engine.assume(this.parent != null);
        return this.cursor != 0;
    }

    @SuppressWarnings("DataFlowIssue")
    private void _checkForComodofication() {
        Engine.assume(this.parent != null);
        if (this.parent.modCount != this.expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }

    public Object next() {
        Engine.assume(this.parent != null);
        _checkForComodofication();
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

    public void remove() {
        if (this.lastRet < 0) {
            throw new IllegalStateException();
        }
        Engine.assume(this.parent != null);
        _checkForComodofication();
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
    public void forEachRemaining(Consumer<? super Object> userAction) {
        if (userAction == null) {
            throw new NullPointerException();
        }
        Engine.assume(this.parent != null);
        SymbolicList<Object> es = this.parent.storage;
        int size = es.size();
        int i = this.cursor;
        if (i >= size)
            return;

        while (i < size) {
            _checkForComodofication();
            Object item = es.get(i);
            userAction.accept(item);
            i++;
        }
        this.cursor = i;
        this.lastRet = i - 1;
    }
}
