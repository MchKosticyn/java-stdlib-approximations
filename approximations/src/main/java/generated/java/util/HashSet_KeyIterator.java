package generated.java.util;

import java.lang.IllegalStateException;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.SuppressWarnings;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;

@Approximate(stub.java.util.HashSet_KeyIterator.class)
public final class HashSet_KeyIterator implements Iterator<Object> {

    public int expectedModCount;

    public LibSLRuntime.Map<Object, Object> unseenKeys;

    public AbstractSetImpl parent;

    public int index;

    public Object currentKey;

    public boolean nextWasCalled;

    public HashSet_KeyIterator(
        int expectedModCount,
        LibSLRuntime.Map<Object, Object> unseenKeys,
        AbstractSetImpl parent,
        int index,
        Object currentKey,
        boolean nextWasCalled
    ) {
        this.expectedModCount = expectedModCount;
        this.unseenKeys = unseenKeys;
        this.parent = parent;
        this.index = index;
        this.currentKey = currentKey;
        this.nextWasCalled = nextWasCalled;
    }

    private HashSet_KeyIterator(HashMapImpl source) {
        LibSLRuntime.error("Private constructor call");
    }

    private void _checkForModification() {
        if (this.expectedModCount != this.parent.modCount) {
            throw new ConcurrentModificationException();
        }
    }

    @SuppressWarnings("DataFlowIssue")
    public boolean hasNext() {
        Engine.assume(this.parent != null);
        LibSLRuntime.Map<Object, Object> parentStorage = this.parent.storage;
        int length = parentStorage.size();
        return this.index < length;
    }

    @SuppressWarnings("DataFlowIssue")
    public Object next() {
        Engine.assume(this.parent != null);
        _checkForModification();
        LibSLRuntime.Map<Object, Object> parentStorage = this.parent.storage;
        int length = parentStorage.size();
        if (this.index >= length) {
            throw new NoSuchElementException();
        }
        Object key = this.unseenKeys.anyKey();
        this.unseenKeys.remove(key);
        this.currentKey = key;
        this.index++;
        this.nextWasCalled = true;
        return key;
    }

    @SuppressWarnings("DataFlowIssue")
    public void remove() {
        Engine.assume(this.parent != null);
        LibSLRuntime.Map<Object, Object> parentStorage = this.parent.storage;
        int length = parentStorage.size();
        boolean atValidPosition = this.index < length;
        if (!atValidPosition || !this.nextWasCalled) {
            throw new IllegalStateException();
        }
        this.nextWasCalled = false;
        _checkForModification();
        parentStorage.remove(this.currentKey);
        this.expectedModCount = this.parent.modCount;
    }

    @SuppressWarnings("DataFlowIssue")
    public void forEachRemaining(Consumer<? super Object> userAction) {
        Engine.assume(this.parent != null);
        if (userAction == null) {
            throw new NullPointerException();
        }
        LibSLRuntime.Map<Object, Object> parentStorage = this.parent.storage;
        int length = parentStorage.size();
        int i = this.index;
        while (i < length) {
            _checkForModification();
            Object key = this.unseenKeys.anyKey();
            this.unseenKeys.remove(key);
            Engine.assume(key != this.currentKey);
            this.currentKey = key;
            userAction.accept(key);
            i++;
        }

        this.index = i;
        this.nextWasCalled = true;
    }
}
