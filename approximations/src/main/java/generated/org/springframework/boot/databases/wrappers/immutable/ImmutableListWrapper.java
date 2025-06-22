package generated.org.springframework.boot.databases.wrappers.immutable;

import generated.org.springframework.boot.SpringEngine;
import generated.org.springframework.boot.databases.CacheTable;
import generated.org.springframework.boot.databases.ITable;
import generated.org.springframework.boot.databases.MappedTable;
import generated.org.springframework.boot.databases.wrappers.IWrapper;
import generated.org.springframework.boot.databases.wrappers.ListWrapper;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Function;

// Used to represent collection in not copied yet objects from database
public class ImmutableListWrapper<T> implements List<T>, IWrapper<T> {

    private final CacheTable<T> cache;

    public ImmutableListWrapper(CacheTable<T> cache) {
        this.cache = cache;
    }

    @Override
    public IWrapper<T> copy(Function<T, T> copyFunction) {
        MappedTable<T, T> copied = new MappedTable<>(cache, copyFunction);
        return new ListWrapper<>(copied);
    }

    @Override
    public ITable<T> unwrap() {
        return cache;
    }

    @Override
    public int size() {
        SpringEngine._internalLog("[DB Warning] ImmutableListWrapper's not implemented function");
        return 0;
    }

    @Override
    public boolean isEmpty() {
        SpringEngine._internalLog("[DB Warning] ImmutableListWrapper's not implemented function");
        return false;
    }

    @Override
    public boolean contains(Object o) {
        SpringEngine._internalLog("[DB Warning] ImmutableListWrapper's not implemented function");
        return false;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        SpringEngine._internalLog("[DB Warning] ImmutableListWrapper's not implemented function");
        return null;
    }

    @NotNull
    @Override
    public Object[] toArray() {
        SpringEngine._internalLog("[DB Warning] ImmutableListWrapper's not implemented function");
        return new Object[0];
    }

    @NotNull
    @Override
    public <T1> T1[] toArray(@NotNull T1[] a) {
        SpringEngine._internalLog("[DB Warning] ImmutableListWrapper's not implemented function");
        return null;
    }

    @Override
    public boolean add(T t) {
        SpringEngine._internalLog("[DB Warning] ImmutableListWrapper's not implemented function");
        return false;
    }

    @Override
    public boolean remove(Object o) {
        SpringEngine._internalLog("[DB Warning] ImmutableListWrapper's not implemented function");
        return false;
    }

    @Override
    public boolean containsAll(@NotNull Collection<?> c) {
        SpringEngine._internalLog("[DB Warning] ImmutableListWrapper's not implemented function");
        return false;
    }

    @Override
    public boolean addAll(@NotNull Collection<? extends T> c) {
        SpringEngine._internalLog("[DB Warning] ImmutableListWrapper's not implemented function");
        return false;
    }

    @Override
    public boolean addAll(int index, @NotNull Collection<? extends T> c) {
        SpringEngine._internalLog("[DB Warning] ImmutableListWrapper's not implemented function");
        return false;
    }

    @Override
    public boolean removeAll(@NotNull Collection<?> c) {
        SpringEngine._internalLog("[DB Warning] ImmutableListWrapper's not implemented function");
        return false;
    }

    @Override
    public boolean retainAll(@NotNull Collection<?> c) {
        SpringEngine._internalLog("[DB Warning] ImmutableListWrapper's not implemented function");
        return false;
    }

    @Override
    public void clear() {
        SpringEngine._internalLog("[DB Warning] ImmutableListWrapper's not implemented function");
    }

    @Override
    public T get(int index) {
        SpringEngine._internalLog("[DB Warning] ImmutableListWrapper's not implemented function");
        return null;
    }

    @Override
    public T set(int index, T element) {
        SpringEngine._internalLog("[DB Warning] ImmutableListWrapper's not implemented function");
        return null;
    }

    @Override
    public void add(int index, T element) {
        SpringEngine._internalLog("[DB Warning] ImmutableListWrapper's not implemented function");
    }

    @Override
    public T remove(int index) {
        SpringEngine._internalLog("[DB Warning] ImmutableListWrapper's not implemented function");
        return null;
    }

    @Override
    public int indexOf(Object o) {
        SpringEngine._internalLog("[DB Warning] ImmutableListWrapper's not implemented function");
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        SpringEngine._internalLog("[DB Warning] ImmutableListWrapper's not implemented function");
        return 0;
    }

    @NotNull
    @Override
    public ListIterator<T> listIterator() {
        SpringEngine._internalLog("[DB Warning] ImmutableListWrapper's not implemented function");
        return null;
    }

    @NotNull
    @Override
    public ListIterator<T> listIterator(int index) {
        SpringEngine._internalLog("[DB Warning] ImmutableListWrapper's not implemented function");
        return null;
    }

    @NotNull
    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        SpringEngine._internalLog("[DB Warning] ImmutableListWrapper's not implemented function");
        return List.of();
    }
}
