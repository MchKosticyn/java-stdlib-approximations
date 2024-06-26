package stub.java.util;

import org.jetbrains.annotations.NotNull;

import java.lang.LinkageError;
import java.lang.Object;
import java.lang.String;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public final class SubListStub extends AbstractList<Object> implements List<Object>, RandomAccess {

    @SuppressWarnings("unused")
    public SubListStub(ArrayList<Object> root, int fromIndex, int toIndex) {
        throw new LinkageError();
    }

    @SuppressWarnings("unused")
    private SubListStub(SubListStub parent, int fromIndex, int toIndex) {
        throw new LinkageError();
    }

    public boolean add(Object e) {
        throw new LinkageError();
    }

    public void add(int index, Object element) {
        throw new LinkageError();
    }

    public boolean addAll(@NotNull Collection c) {
        throw new LinkageError();
    }

    public boolean addAll(int index, @NotNull Collection c) {
        throw new LinkageError();
    }

    public void clear() {
        throw new LinkageError();
    }

    public boolean contains(Object o) {
        throw new LinkageError();
    }

    public boolean containsAll(@NotNull Collection c) {
        throw new LinkageError();
    }

    public boolean equals(Object o) {
        throw new LinkageError();
    }

    public void forEach(Consumer _action) {
        throw new LinkageError();
    }

    public Object get(int index) {
        throw new LinkageError();
    }

    public int hashCode() {
        throw new LinkageError();
    }

    public int indexOf(Object o) {
        throw new LinkageError();
    }

    public boolean isEmpty() {
        throw new LinkageError();
    }

    @NotNull
    public Iterator<Object> iterator() {
        throw new LinkageError();
    }

    public int lastIndexOf(Object o) {
        throw new LinkageError();
    }

    @NotNull
    public ListIterator<Object> listIterator() {
        throw new LinkageError();
    }

    @NotNull
    public ListIterator<Object> listIterator(int index) {
        throw new LinkageError();
    }

    public Stream<Object> parallelStream() {
        throw new LinkageError();
    }

    public boolean remove(Object o) {
        throw new LinkageError();
    }

    public Object remove(int index) {
        throw new LinkageError();
    }

    public boolean removeAll(@NotNull Collection c) {
        throw new LinkageError();
    }

    public boolean removeIf(Predicate filter) {
        throw new LinkageError();
    }

    public void replaceAll(UnaryOperator operator) {
        throw new LinkageError();
    }

    public boolean retainAll(@NotNull Collection c) {
        throw new LinkageError();
    }

    public Object set(int index, Object element) {
        throw new LinkageError();
    }

    public int size() {
        throw new LinkageError();
    }

    public void sort(Comparator c) {
        throw new LinkageError();
    }

    public Spliterator<Object> spliterator() {
        throw new LinkageError();
    }

    public Stream<Object> stream() {
        throw new LinkageError();
    }

    @NotNull
    public List<Object> subList(int fromIndex, int toIndex) {
        throw new LinkageError();
    }

    @NotNull
    public Object[] toArray() {
        throw new LinkageError();
    }

    @SuppressWarnings("unchecked")
    public Object[] toArray(IntFunction generator) {
        throw new LinkageError();
    }

    @NotNull
    @SuppressWarnings("unchecked")
    public Object[] toArray(@NotNull Object[] a) {
        throw new LinkageError();
    }

    public String toString() {
        throw new LinkageError();
    }
}
