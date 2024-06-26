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
import stub.java.util.SubListIteratorStub;

@Approximate(SubListIteratorStub.class)
public final class SubListIteratorStubImpl implements ListIterator<Object> {

    public AbstractListImpl root;

    public SubListStubImpl sublist;

    public int cursor;

    public int expectedModCount;

    public int offset;

    public int size;

    public int lastRet;

    public SubListIteratorStubImpl(
        AbstractListImpl root,
        SubListStubImpl subList,
        int cursor,
        int expectedModCount,
        int offset,
        int size,
        int lastRet
    ) {
        Engine.assume(root != null);
        this.root = root;
        this.sublist = subList;
        this.cursor = cursor;
        this.expectedModCount = expectedModCount;
        this.offset = offset;
        this.size = size;
        this.lastRet = lastRet;
    }

    private void _checkForModification() {
        if (this.root.modCount != this.expectedModCount) {
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

    public boolean hasNext() {
        return this.cursor != this.size;
    }

    public Object next() {
        Engine.assume(this.root != null);
        _checkForModification();
        SymbolicList<Object> rootStorage = this.root.storage;
        int i = this.offset + this.cursor;
        if (i >= rootStorage.size()) {
            throw new NoSuchElementException();
        }
        this.lastRet = this.cursor;
        this.cursor++;
        return rootStorage.get(i);
    }

    public Object previous() {
        Engine.assume(this.root != null);
        _checkForModification();
        int i = (this.offset + this.cursor) - 1;
        if (i < this.offset) {
            throw new NoSuchElementException();
        }
        SymbolicList<Object> rootStorage = this.root.storage;
        if (i >= rootStorage.size()) {
            throw new ConcurrentModificationException();
        }
        this.cursor--;
        this.lastRet = this.cursor;
        return rootStorage.get(i);
    }

    public void remove() {
        Engine.assume(this.root != null);
        if (this.lastRet < 0) {
            throw new IllegalStateException();
        }
        _checkForModification();
        if (this.lastRet >= this.size) {
            throw new ConcurrentModificationException();
        } else {
            this.root._checkedDeleteElement(this.offset + this.lastRet);
            this.sublist._updateSizeAndModCount(-1);
            this.expectedModCount = this.root.modCount;
            this.size--;
        }
        this.cursor = this.lastRet;
        this.lastRet = -1;
    }

    public void set(Object e) {
        Engine.assume(this.root != null);
        if (this.lastRet < 0) {
            throw new IllegalStateException();
        }
        _checkForModification();
        SymbolicList<Object> rootStorage = this.root.storage;
        int index = this.offset + this.lastRet;
        if (index >= rootStorage.size()) {
            throw new ConcurrentModificationException();
        } else {
            rootStorage.set(index, e);
        }
    }

    public void add(Object e) {
        Engine.assume(this.root != null);
        _checkForModification();
        int i = this.offset + this.cursor;
        if ((this.offset + this.lastRet) > this.root.storage.size()) {
            throw new ConcurrentModificationException();
        } else {
            this.root._checkedAddElement(i, e);
            this.sublist._updateSizeAndModCount(1);
            this.expectedModCount = this.root.modCount;
            this.size++;
        }
        this.cursor++;
        this.lastRet = -1;
    }

    public void forEachRemaining(Consumer<Object> userAction) {
        Engine.assume(this.root != null);
        if (userAction == null) {
            throw new NullPointerException();
        }
        int i = this.cursor;
        if (i < this.size) {
            i += this.offset;
            SymbolicList<Object> es = this.root.storage;
            if (i >= es.size()) {
                throw new ConcurrentModificationException();
            }
            int end = this.offset + this.size;
            for (; i < end; i++) {
                Object item = es.get(i);
                userAction.accept(item);
            }
            this.cursor = i - this.offset;
            this.lastRet = this.cursor - 1;
            _checkForModification();
        }
    }
}
