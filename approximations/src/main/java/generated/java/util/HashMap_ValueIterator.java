package generated.java.util;

import java.lang.IllegalStateException;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.SuppressWarnings;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;

@Approximate(stub.java.util.HashMap_ValueIterator.class)
public class HashMap_ValueIterator implements Iterator<Object> {

    public AbstractHashMapImpl parent;

    public LibSLRuntime.Map<Object, Map.Entry<Object, Object>> unseen;

    public int expectedModCount;

    public Object currentKey;

    public HashMap_ValueIterator(
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

    public void forEachRemaining(Consumer<? super Object> userAction) {
        if (userAction == null) {
            throw new NullPointerException();
        }

        int size = this.unseen.size();
        if (size == 0)
            return;

        while (size != 0) {
            if (this.parent.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            Object key = this.unseen.anyKey();
            Map.Entry<Object, Object> entry = this.unseen.get(key);
            userAction.accept(entry.getValue());
            this.unseen.remove(key);
            size--;
        }
    }

    public boolean hasNext() {
        return this.unseen.size() != 0;
    }

    public Object next() {
        if (this.parent.modCount != this.expectedModCount) {
            throw new ConcurrentModificationException();
        }
        if (this.unseen.size() == 0) {
            throw new NoSuchElementException();
        }
        Object key = this.unseen.anyKey();
        Map.Entry<Object, Object> entry = this.unseen.get(key);
        this.unseen.remove(key);
        this.currentKey = key;
        return entry.getValue();
    }

    @SuppressWarnings("DataFlowIssue")
    public void remove() {
        Engine.assume(this.parent != null);
        Object key = this.currentKey;
        if (this.currentKey == null) {
            throw new IllegalStateException();
        }
        if (this.parent.modCount != this.expectedModCount) {
            throw new ConcurrentModificationException();
        }
        this.unseen.remove(key);
        this.parent.storage.remove(key);
        int newModCount = this.parent.modCount + 1;
        this.parent.modCount = newModCount;
        this.expectedModCount = newModCount;
        this.currentKey = null;
    }
}
