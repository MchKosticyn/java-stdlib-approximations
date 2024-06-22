package generated.java.util.stream;

import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.SymbolicList;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.stream.Stream;

@Approximate(stub.java.util.stream.BaseStream.class)
public class BaseStreamImpl implements java.util.stream.BaseStream<Object, Stream<Object>> {

    public transient int length;

    public SymbolicList<Runnable> closeHandlers;

    public boolean isParallel;

    public boolean linkedOrConsumed;

    public BaseStreamImpl(
        int length,
        SymbolicList<Runnable> handlers,
        boolean isParallel,
        boolean linkedOrConsumed
    ) {
        this.length = length;
        this.closeHandlers = handlers;
        this.isParallel = isParallel;
        this.linkedOrConsumed = linkedOrConsumed;
    }

    @NotNull
    @Override
    public Iterator<Object> iterator() {
        return null;
    }

    @NotNull
    @Override
    public Spliterator<Object> spliterator() {
        return null;
    }

    @Override
    public boolean isParallel() {
        return false;
    }

    @NotNull
    @Override
    public Stream<Object> sequential() {
        return Stream.empty();
    }

    @NotNull
    @Override
    public Stream<Object> parallel() {
        return Stream.empty();
    }

    @NotNull
    @Override
    public Stream<Object> unordered() {
        return Stream.empty();
    }

    @NotNull
    @Override
    public Stream<Object> onClose(@NotNull Runnable closeHandler) {
        return Stream.empty();
    }

    @Override
    public void close() {

    }
}
