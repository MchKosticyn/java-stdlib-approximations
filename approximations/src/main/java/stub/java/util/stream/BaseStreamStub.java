package stub.java.util.stream;

import org.jetbrains.annotations.NotNull;

public class BaseStreamStub {

    public boolean isParallel() {
        throw new LinkageError();
    }

    @NotNull
    public BaseStreamStub sequential() {
        throw new LinkageError();
    }

    @NotNull
    public BaseStreamStub parallel() {
        throw new LinkageError();
    }

    public long count() {
        throw new LinkageError();
    }

    @NotNull
    public BaseStreamStub onClose(@NotNull Runnable closeHandler) {
        throw new LinkageError();
    }

    public void close() {
        throw new LinkageError();
    }
}
