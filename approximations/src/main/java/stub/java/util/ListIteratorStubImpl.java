package stub.java.util;

import java.lang.LinkageError;
import java.lang.Object;
import java.util.ListIterator;
import java.util.function.Consumer;

public final class ListIteratorStubImpl implements ListIterator<Object> {

    public boolean hasPrevious() {
        throw new LinkageError();
    }

    public int nextIndex() {
        throw new LinkageError();
    }

    public int previousIndex() {
        throw new LinkageError();
    }

    public boolean hasNext() {
        throw new LinkageError();
    }

    public Object next() {
        throw new LinkageError();
    }

    public Object previous() {
        throw new LinkageError();
    }

    public void remove() {
        throw new LinkageError();
    }

    public void set(Object e) {
        throw new LinkageError();
    }

    public void add(Object e) {
        throw new LinkageError();
    }

    public void forEachRemaining(Consumer userAction) {
        throw new LinkageError();
    }
}
