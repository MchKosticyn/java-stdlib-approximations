package generated.java.util.stream;

import generated.runtime.LibSLGlobals;
import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;
import org.usvm.api.SymbolicList;
import stub.java.util.stream.BaseStreamStub;

@Approximate(BaseStreamStub.class)
public class BaseStreamImpl {

    public transient int length;

    public SymbolicList<Runnable> closeHandlers;

    public boolean isParallel;

    public boolean linkedOrConsumed;

    public int spliteratorCharacteristics =
        LibSLGlobals.SPLITERATOR_ORDERED
            | LibSLGlobals.SPLITERATOR_IMMUTABLE
            | LibSLGlobals.SPLITERATOR_SIZED
            | LibSLGlobals.SPLITERATOR_SUBSIZED;

    public BaseStreamImpl(
        int length,
        SymbolicList<Runnable> closeHandlers,
        boolean isParallel,
        boolean linkedOrConsumed
    ) {
        this.length = length;
        this.closeHandlers = closeHandlers;
        this.isParallel = isParallel;
        this.linkedOrConsumed = linkedOrConsumed;
    }

    public void evaluate() {
        if (this.linkedOrConsumed)
            throw new IllegalStateException();

        this.linkedOrConsumed = true;
    }

    public boolean isParallel() {
        return this.isParallel;
    }

    @NotNull
    public BaseStreamImpl sequential() {
        this.isParallel = false;
        return this;
    }

    @NotNull
    public BaseStreamImpl parallel() {
        this.isParallel = true;
        return this;
    }

    public long count() {
        evaluate();
        return this.length;
    }

    @NotNull
    public BaseStreamImpl onClose(@NotNull Runnable closeHandler) {
        if (this.linkedOrConsumed)
            throw new IllegalStateException();

        int listLength = this.closeHandlers.size();
        this.closeHandlers.insert(listLength, closeHandler);
        return this;
    }

    public void close() {
        int listLength = this.closeHandlers.size();
        for (int i = 0; i < listLength; i++) {
            Runnable currentHandler = this.closeHandlers.get(i);
            currentHandler.run();
        }
        this.closeHandlers = Engine.makeSymbolicList();
        this.linkedOrConsumed = true;
    }
}
