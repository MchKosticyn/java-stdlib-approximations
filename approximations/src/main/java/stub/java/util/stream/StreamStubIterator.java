package stub.java.util.stream;

import java.lang.LinkageError;
import java.lang.Object;
import java.util.Iterator;
import java.util.function.Consumer;

public class StreamStubIterator implements Iterator<Object> {

    public boolean hasNext() {
        throw new LinkageError();
    }

    public Object next() {
        throw new LinkageError();
    }

    public void remove() {
        throw new LinkageError();
    }

    public void forEachRemaining(Consumer userAction) {
        throw new LinkageError();
    }
}
