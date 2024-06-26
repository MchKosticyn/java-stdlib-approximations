package generated.java.util;

import java.lang.IllegalStateException;
import java.lang.NullPointerException;
import java.lang.Object;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;

@Approximate(stub.java.util.HashMap_EntryIterator.class)
public class HashMap_EntryIterator implements Iterator<Map.Entry<Object, Object>> {

    public AbstractHashMapImpl parent;

    public LibSLRuntime.Map<Object, Map.Entry<Object, Object>> unseen;

    public int expectedModCount;

    public Object currentKey;

    public HashMap_EntryIterator(
        AbstractHashMapImpl parent,
        LibSLRuntime.Map<Object, Map.Entry<Object, Object>> unseen,
        int expectedModCount,
        Object currentKey
    ) {
        this.parent = parent;
        this.unseen = unseen;
        this.expectedModCount = expectedModCount;
        this.currentKey = currentKey;
    }

    private void _checkForModification() {
        if (this.parent.modCount != this.expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }

    private boolean isNotEmpty() {
        return this.unseen.size() != 0;
    }

    public void forEachRemaining(Consumer<? super Map.Entry<Object, Object>> userAction) {
        if (userAction == null) {
            throw new NullPointerException();
        }

        while (isNotEmpty()) {
            _checkForModification();
            Object curKey = this.unseen.anyKey();
            userAction.accept(this.unseen.get(curKey));
            this.unseen.remove(curKey);
        }
    }

    public boolean hasNext() {
        return isNotEmpty();
    }

    public Map.Entry<Object, Object> next() {
        _checkForModification();
        if (this.unseen.size() == 0) {
            throw new NoSuchElementException();
        }
        Object curKey = this.unseen.anyKey();
        Map.Entry<Object, Object> result = this.unseen.get(curKey);
        this.unseen.remove(curKey);
        this.currentKey = curKey;
        return result;
    }

    public void remove() {
        Engine.assume(this.parent != null);
        Object key = this.currentKey;
        if (key == null) {
            throw new IllegalStateException();
        }
        _checkForModification();
        this.parent.storage.remove(key);
        this.parent.modCount++;
        this.unseen.remove(key);
        this.expectedModCount = this.parent.modCount;
        this.currentKey = null;
    }
}
