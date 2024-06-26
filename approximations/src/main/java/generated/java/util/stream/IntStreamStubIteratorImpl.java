package generated.java.util.stream;

import java.lang.Integer;
import java.lang.NullPointerException;
import java.lang.SuppressWarnings;
import java.lang.UnsupportedOperationException;
import java.util.NoSuchElementException;
import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import stub.java.util.stream.IntStreamStubIterator;

@Approximate(IntStreamStubIterator.class)
public class IntStreamStubIteratorImpl implements PrimitiveIterator.OfInt {

    public IntStreamImpl parent;

    public int cursor;

    public IntStreamStubIteratorImpl(IntStreamImpl parent, int cursor) {
        this.parent = parent;
        this.cursor = cursor;
    }

    @SuppressWarnings("DataFlowIssue")
    public boolean hasNext() {
        Engine.assume(this.parent != null);
        return this.cursor != this.parent.length;
    }

    @SuppressWarnings("DataFlowIssue")
    public Integer next() {
        Engine.assume(this.parent != null);
        int[] parentStorage = this.parent.storage;
        if (this.cursor >= this.parent.length)
            throw new NoSuchElementException();

        return parentStorage[this.cursor++];
    }

    @SuppressWarnings("DataFlowIssue")
    public int nextInt() {
        Engine.assume(this.parent != null);
        int[] parentStorage = this.parent.storage;
        if (this.cursor >= this.parent.length)
            throw new NoSuchElementException();

        return parentStorage[this.cursor++];
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    @SuppressWarnings("DataFlowIssue")
    public void forEachRemaining(Consumer<? super Integer> userAction) {
        if (userAction == null)
            throw new NullPointerException();

        Engine.assume(this.parent != null);
        int size = this.parent.length;
        if (this.cursor == size)
            return;

        int[] pStorage = this.parent.storage;
        while (this.cursor < size) {
            int item = pStorage[this.cursor];
            userAction.accept(item);
            this.cursor++;
        }
    }

    @SuppressWarnings("DataFlowIssue")
    public void forEachRemaining(IntConsumer userAction) {
        if (userAction == null)
            throw new NullPointerException();

        Engine.assume(this.parent != null);
        int size = this.parent.length;
        if (this.cursor == size)
            return;

        int[] pStorage = this.parent.storage;
        while (this.cursor < size) {
            int item = pStorage[this.cursor];
            userAction.accept(item);
            this.cursor++;
        }
    }
}
