package stub.java.util.stream;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.Spliterator;

public class BaseStream implements java.util.stream.BaseStream<Object, BaseStream> {

    @NotNull
    @Override
    public Iterator<Object> iterator() {
        throw new LinkageError();
    }

    @NotNull
    @Override
    public Spliterator<Object> spliterator() {
        throw new LinkageError();
    }

    @Override
    public boolean isParallel() {
        throw new LinkageError();
    }

    @NotNull
    @Override
    public BaseStream sequential() {
        throw new LinkageError();
    }

    @NotNull
    @Override
    public BaseStream parallel() {
        throw new LinkageError();
    }

    @NotNull
    @Override
    public BaseStream unordered() {
        throw new LinkageError();
    }

    @NotNull
    @Override
    public BaseStream onClose(@NotNull Runnable closeHandler) {
        throw new LinkageError();
    }

    @Override
    public void close() {
        throw new LinkageError();
    }
}
