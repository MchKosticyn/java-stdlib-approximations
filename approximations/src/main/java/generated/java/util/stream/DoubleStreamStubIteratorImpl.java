package generated.java.util.stream;

import java.lang.Double;
import java.lang.NullPointerException;
import java.lang.SuppressWarnings;
import java.lang.UnsupportedOperationException;
import java.util.NoSuchElementException;
import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import stub.java.util.stream.DoubleStreamStubIterator;

@Approximate(DoubleStreamStubIterator.class)
public class DoubleStreamStubIteratorImpl implements PrimitiveIterator.OfDouble {

    public DoubleStreamImpl parent;

    public int cursor;

    public DoubleStreamStubIteratorImpl(DoubleStreamImpl parent, int cursor) {
        this.parent = parent;
        this.cursor = cursor;
    }

    @SuppressWarnings("DataFlowIssue")
    public boolean hasNext() {
        Engine.assume(this.parent != null);
        return this.cursor != this.parent.length;
    }

    @SuppressWarnings("DataFlowIssue")
    public Double next() {
        Engine.assume(this.parent != null);
        double[] parentStorage = this.parent.storage;
        if (this.cursor >= this.parent.length)
            throw new NoSuchElementException();

        return parentStorage[this.cursor++];
    }

    @SuppressWarnings("DataFlowIssue")
    public double nextDouble() {
        Engine.assume(this.parent != null);
        double[] parentStorage = this.parent.storage;
        if (this.cursor >= this.parent.length)
            throw new NoSuchElementException();

        return parentStorage[this.cursor++];
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    @SuppressWarnings("DataFlowIssue")
    public void forEachRemaining(Consumer<? super Double> userAction) {
        if (userAction == null)
            throw new NullPointerException();

        Engine.assume(this.parent != null);
        int size = this.parent.length;
        if (this.cursor == size)
            return;

        double[] pStorage = this.parent.storage;
        while (this.cursor < size) {
            double item = pStorage[this.cursor];
            userAction.accept(item);
            this.cursor++;
        }
    }

    @SuppressWarnings("DataFlowIssue")
    public void forEachRemaining(DoubleConsumer userAction) {
        if (userAction == null)
            throw new NullPointerException();

        Engine.assume(this.parent != null);
        int size = this.parent.length;
        if (this.cursor == size)
            return;

        double[] pStorage = this.parent.storage;
        while (this.cursor < size) {
            double item = pStorage[this.cursor];
            userAction.accept(item);
            this.cursor++;
        }
    }
}
