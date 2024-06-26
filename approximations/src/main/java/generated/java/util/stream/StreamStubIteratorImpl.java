package generated.java.util.stream;

import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.UnsupportedOperationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import stub.java.util.stream.StreamStubIterator;

@Approximate(StreamStubIterator.class)
public class StreamStubIteratorImpl implements Iterator<Object> {

    public StreamStubImpl parent;

    public int cursor;

    public StreamStubIteratorImpl(StreamStubImpl parent, int cursor) {
        this.parent = parent;
        this.cursor = cursor;
    }

    @SuppressWarnings("DataFlowIssue")
    public boolean hasNext() {
        Engine.assume(this.parent != null);
        return this.cursor != this.parent.length;
    }

    @SuppressWarnings("DataFlowIssue")
    public Object next() {
        Engine.assume(this.parent != null);
        Object[] parentStorage = this.parent.storage;
        if (this.cursor >= this.parent.length)
            throw new NoSuchElementException();

        return parentStorage[this.cursor++];
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    @SuppressWarnings("DataFlowIssue")
    public void forEachRemaining(Consumer<? super Object> userAction) {
        if (userAction == null)
            throw new NullPointerException();

        Engine.assume(this.parent != null);
        int size = this.parent.length;
        if (this.cursor == size)
            return;

        Object[] pStorage = this.parent.storage;
        while (this.cursor < size) {
            Object item = pStorage[this.cursor];
            userAction.accept(item);
            this.cursor++;
        }
    }
}
