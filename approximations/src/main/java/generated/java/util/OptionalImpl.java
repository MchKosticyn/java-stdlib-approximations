package generated.java.util;

import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Runnable;
import java.lang.String;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

import generated.java.util.stream.StreamStubImpl;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;

@SuppressWarnings("unused")
@Approximate(java.util.Optional.class)
public final class OptionalImpl {

    private static final OptionalImpl EMPTY = new OptionalImpl(null);

    static {
        Engine.assume(true);
    }

    public Object value;

    private OptionalImpl(Object value) {
        this.value = value;
    }

    private OptionalImpl() {
        LibSLRuntime.error("Private constructor call");
    }

    public static OptionalImpl empty() {
        return EMPTY;
    }

    public static OptionalImpl of(Object obj) {
        return new OptionalImpl(obj);
    }

    public static OptionalImpl ofNullable(Object obj) {
        if (obj == null)
            return EMPTY;

        return new OptionalImpl(obj);
    }

    public boolean equals(Object other) {
        if (other == this)
            return true;

        if (Engine.typeEquals(this, other)) { // TODO: change on 'typeIs'
            Object otherValue = ((OptionalImpl) other).value;
            return LibSLRuntime.equals(this.value, otherValue);
        }

        return false;
    }

    public OptionalImpl filter(Predicate<? super Object> predicate) {
        if (predicate == null)
            throw new NullPointerException();

        if (this.value == null)
            return this;

        if (predicate.test(this.value))
            return this;

        return EMPTY;
    }

    public OptionalImpl flatMap(Function<? super Object, ? extends OptionalImpl> mapper) {
        if (mapper == null)
            throw new NullPointerException();

        if (this.value == null)
            return EMPTY;

        OptionalImpl result = mapper.apply(this.value);
        if (result == null) {
            throw new NullPointerException();
        }

        return result;
    }

    public Object get() {
        if (this.value == null) {
            throw new NoSuchElementException("No value present");
        }

        return this.value;
    }

    public int hashCode() {
        return LibSLRuntime.hashCode(this.value);
    }

    public void ifPresent(Consumer<? super Object> consumer) {
        if (this.value == null)
            return;

        if (consumer == null)
            throw new NullPointerException();

        consumer.accept(this.value);
    }

    public void ifPresentOrElse(Consumer<? super Object> consumer, Runnable emptyAction) {
        if (this.value != null) {
            if (consumer == null)
                throw new NullPointerException();

            consumer.accept(this.value);
            return;
        }

        if (emptyAction == null) {
            throw new NullPointerException();
        }
        emptyAction.run();
    }

    public boolean isEmpty() {
        return this.value == null;
    }

    public boolean isPresent() {
        return this.value != null;
    }

    public OptionalImpl map(Function<? super Object, ?> mapper) {
        if (mapper == null)
            throw new NullPointerException();


        if (this.value == null)
            return EMPTY;

        Object mappedValue = mapper.apply(this.value);
        if (mappedValue == null)
            return EMPTY;

        return new OptionalImpl(mappedValue);
    }

    public OptionalImpl or(Supplier<? extends OptionalImpl> supplier) {
        if (supplier == null)
            throw new NullPointerException();

        if (value != null)
            return this;

        OptionalImpl result = supplier.get();
        if (result == null)
            throw new NullPointerException();

        return result;
    }

    public Object orElse(Object other) {
        if (this.value == null)
            return other;

        return this.value;
    }

    public Object orElseGet(Supplier<?> supplier) {
        if (this.value == null)
            return supplier.get();

        return this.value;
    }

    public Object orElseThrow() {
        if (this.value == null) {
            throw new NoSuchElementException("No value present");
        }

        return this.value;
    }

    public Object orElseThrow(Supplier<Throwable> exceptionSupplier) throws Throwable {
        if (exceptionSupplier == null)
            throw new NullPointerException();

        if (this.value == null)
            throw exceptionSupplier.get();

        return this.value;
    }

    public Stream<Object> stream() {
        Object[] items;
        if (this.value == null) {
            items = new Object[0];
        } else {
            items = new Object[1];
            items[0] = this.value;
        }
        return new StreamStubImpl(items, items.length, Engine.makeSymbolicList(), false, false);
    }

    public String toString() {
        if (this.value == null)
            return "Optional.empty";

        String valueStr = LibSLRuntime.toString(this.value);
        return "Optional[".concat(valueStr).concat("]");
    }
}
