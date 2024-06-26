package generated.java.util.stream;

import java.lang.Long;
import java.lang.NullPointerException;
import java.lang.UnsupportedOperationException;
import java.util.NoSuchElementException;
import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import stub.java.util.stream.LongStreamStubIterator;

@Approximate(LongStreamStubIterator.class)
public class LongStreamStubIteratorImpl implements PrimitiveIterator.OfLong {

    public LongStreamImpl parent;

    public int cursor;

    public LongStreamStubIteratorImpl(LongStreamImpl parent, int cursor) {
        this.parent = parent;
        this.cursor = cursor;
    }

    @SuppressWarnings("DataFlowIssue")
    public boolean hasNext() {
        Engine.assume(this.parent != null);
        return this.cursor != this.parent.length;
    }

    @SuppressWarnings("DataFlowIssue")
    public Long next() {
        Engine.assume(this.parent != null);
        long[] parentStorage = this.parent.storage;
        if (this.cursor >= this.parent.length)
            throw new NoSuchElementException();

        return parentStorage[this.cursor++];
    }

    @SuppressWarnings("DataFlowIssue")
    public long nextLong() {
        Engine.assume(this.parent != null);
        long[] parentStorage = this.parent.storage;
        if (this.cursor >= this.parent.length) {
            throw new NoSuchElementException();
        }
        return parentStorage[this.cursor++];
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    @SuppressWarnings("DataFlowIssue")
    public void forEachRemaining(Consumer<? super Long> userAction) {
        if (userAction == null)
            throw new NullPointerException();

        Engine.assume(this.parent != null);
        int size = this.parent.length;
        if (this.cursor == size)
            return;

        long[] pStorage = this.parent.storage;
        while (this.cursor < size) {
            long item = pStorage[this.cursor];
            userAction.accept(item);
            this.cursor++;
        }
    }

    @SuppressWarnings("DataFlowIssue")
    public void forEachRemaining(LongConsumer userAction) {
        if (userAction == null)
            throw new NullPointerException();

        Engine.assume(this.parent != null);
        int size = this.parent.length;
        if (this.cursor == size)
            return;

        long[] pStorage = this.parent.storage;
        while (this.cursor < size) {
            long item = pStorage[this.cursor];
            userAction.accept(item);
            this.cursor++;
        }
    }
}
