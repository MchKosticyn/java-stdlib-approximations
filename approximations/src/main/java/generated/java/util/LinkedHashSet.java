// Generated by the LibSL translator.  DO NOT EDIT!
// source: ?
//
package generated.java.util;

import generated.runtime.LibSLGlobals;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Cloneable;
import java.lang.IllegalArgumentException;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.Void;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;

/**
 * LinkedHashSetAutomaton for LinkedHashSet ~> java.util.LinkedHashSet
 */
@SuppressWarnings({"all", "unchecked"})
@Approximate(java.util.LinkedHashSet.class)
public class LinkedHashSet implements LibSLRuntime.Automaton, Set, Cloneable, Serializable {
    private static final long serialVersionUID = -2851667679971038690L;

    static {
        Engine.assume(true);
    }

    private byte __$lsl_state = __$lsl_States.Allocated;

    public LibSLRuntime.Map<Object, Object> storage;

    public transient int modCount;

    @LibSLRuntime.AutomatonConstructor
    public LinkedHashSet(Void __$lsl_token, final byte p0,
            final LibSLRuntime.Map<Object, Object> p1, final int p2) {
        this.__$lsl_state = p0;
        this.storage = p1;
        this.modCount = p2;
    }

    @LibSLRuntime.AutomatonConstructor
    public LinkedHashSet(final Void __$lsl_token) {
        this(__$lsl_token, __$lsl_States.Allocated, null, 0);
    }

    /**
     * [CONSTRUCTOR] LinkedHashSetAutomaton::LinkedHashSet(LinkedHashSet) -> LinkedHashSet
     */
    public LinkedHashSet() {
        this((Void) null);
        Engine.assume(this.__$lsl_state == __$lsl_States.Allocated);
        /* body */ {
            this.storage = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
        }
        this.__$lsl_state = __$lsl_States.Initialized;
    }

    /**
     * [CONSTRUCTOR] LinkedHashSetAutomaton::LinkedHashSet(LinkedHashSet, Collection) -> LinkedHashSet
     */
    public LinkedHashSet(Collection c) {
        this((Void) null);
        Engine.assume(this.__$lsl_state == __$lsl_States.Allocated);
        /* body */ {
            this.storage = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
            _addAllElements(c);
        }
        this.__$lsl_state = __$lsl_States.Initialized;
    }

    /**
     * [CONSTRUCTOR] LinkedHashSetAutomaton::LinkedHashSet(LinkedHashSet, int) -> LinkedHashSet
     */
    public LinkedHashSet(int initialCapacity) {
        this((Void) null);
        Engine.assume(this.__$lsl_state == __$lsl_States.Allocated);
        /* body */ {
            if (initialCapacity < 0) {
                throw new IllegalArgumentException();
            }
            this.storage = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
        }
        this.__$lsl_state = __$lsl_States.Initialized;
    }

    /**
     * [CONSTRUCTOR] LinkedHashSetAutomaton::LinkedHashSet(LinkedHashSet, int, float) -> LinkedHashSet
     */
    public LinkedHashSet(int initialCapacity, float loadFactor) {
        this((Void) null);
        Engine.assume(this.__$lsl_state == __$lsl_States.Allocated);
        /* body */ {
            if (initialCapacity < 0) {
                throw new IllegalArgumentException();
            }
            if ((loadFactor <= 0) || (loadFactor != loadFactor)) {
                throw new IllegalArgumentException();
            }
            this.storage = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
        }
        this.__$lsl_state = __$lsl_States.Initialized;
    }

    /**
     * [SUBROUTINE] LinkedHashSetAutomaton::_checkForComodification(int) -> void
     */
    public void _checkForComodification(int expectedModCount) {
        /* body */ {
            if (this.modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    /**
     * [SUBROUTINE] LinkedHashSetAutomaton::_addAllElements(Collection) -> boolean
     */
    private boolean _addAllElements(Collection c) {
        boolean result = false;
        /* body */ {
            final int lengthBeforeAdd = this.storage.size();
            final Iterator iter = c.iterator();
            while (iter.hasNext()) {
                final Object key = iter.next();
                if (!this.storage.hasKey(key)) {
                    this.storage.set(key, LibSLGlobals.SOMETHING);
                }
            }
            ;
            if (lengthBeforeAdd != this.storage.size()) {
                this.modCount += 1;
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::add(LinkedHashSet, Object) -> boolean
     */
    public boolean add(Object obj) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            final boolean hasKey = this.storage.hasKey(obj);
            if (hasKey) {
                result = false;
            } else {
                this.storage.set(obj, LibSLGlobals.SOMETHING);
                result = true;
            }
            this.modCount += 1;
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::clear(LinkedHashSet) -> void
     */
    public void clear() {
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            this.storage = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
            this.modCount += 1;
        }
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::clone(LinkedHashSet) -> Object
     */
    public Object clone() {
        Object result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = (java.util.LinkedHashSet) ((Object) new LinkedHashSet((Void) null, 
                /* state = */ LinkedHashSet.__$lsl_States.Initialized, 
                /* storage = */ this.storage.duplicate(), 
                /* modCount = */ 0
            ));
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::contains(LinkedHashSet, Object) -> boolean
     */
    public boolean contains(Object obj) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (this.storage.size() == 0) {
                result = false;
            } else {
                result = this.storage.hasKey(obj);
            }
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::isEmpty(LinkedHashSet) -> boolean
     */
    public boolean isEmpty() {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = this.storage.size() == 0;
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::iterator(LinkedHashSet) -> Iterator
     */
    public Iterator iterator() {
        Iterator result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            final LibSLRuntime.Map<Object, Object> unseenKeys = this.storage.duplicate();
            result = (stub.java.util.LinkedHashSet_KeyIterator) ((Object) new LinkedHashSet_KeyIterator((Void) null, 
                /* state = */ LinkedHashSet_KeyIterator.__$lsl_States.Initialized, 
                /* expectedModCount = */ this.modCount, 
                /* unseenKeys = */ unseenKeys, 
                /* parent = */ this, 
                /* index = */ 0, 
                /* currentKey = */ 0, 
                /* nextWasCalled = */ false
            ));
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::remove(LinkedHashSet, Object) -> boolean
     */
    public boolean remove(Object obj) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (this.storage.hasKey(obj)) {
                this.storage.remove(obj);
                this.modCount += 1;
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::size(LinkedHashSet) -> int
     */
    public int size() {
        int result = 0;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = this.storage.size();
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::spliterator(LinkedHashSet) -> Spliterator
     */
    public Spliterator spliterator() {
        Spliterator result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            final Object[] keysStorageArray = new Object[this.storage.size()];
            final LibSLRuntime.Map<Object, Object> unseenKeys = this.storage.duplicate();
            int i = 0;
            for (i = 0; i < this.storage.size(); i += 1) {
                final Object key = unseenKeys.anyKey();
                unseenKeys.remove(key);
                keysStorageArray[i] = key;
            }
            ;
            result = (stub.java.util.LinkedHashSet_KeySpliterator) ((Object) new LinkedHashSet_KeySpliterator((Void) null, 
                /* state = */ LinkedHashSet_KeySpliterator.__$lsl_States.Initialized, 
                /* keysStorage = */ keysStorageArray, 
                /* index = */ 0, 
                /* fence = */ -1, 
                /* est = */ 0, 
                /* expectedModCount = */ this.modCount, 
                /* parent = */ this
            ));
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::equals(LinkedHashSet, Object) -> boolean
     */
    public boolean equals(Object other) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (other == this) {
                result = true;
            } else {
                if ((other != null && other.getClass() == java.util.LinkedHashSet.class)) {
                    final int expectedModCount = this.modCount;
                    final int otherExpectedModCount = ((LinkedHashSet) ((Object) other)).modCount;
                    final LibSLRuntime.Map<Object, Object> otherStorage = ((LinkedHashSet) ((Object) other)).storage;
                    if (this.storage.size() == otherStorage.size()) {
                        result = LibSLRuntime.equals(this.storage, otherStorage);
                    } else {
                        result = false;
                    }
                    ((LinkedHashSet) ((Object) other))._checkForComodification(otherExpectedModCount);
                    _checkForComodification(expectedModCount);
                } else {
                    result = false;
                }
            }
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::hashCode(LinkedHashSet) -> int
     */
    public int hashCode() {
        int result = 0;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = LibSLRuntime.hashCode(this.storage);
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::removeAll(LinkedHashSet, Collection) -> boolean
     */
    public boolean removeAll(Collection c) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (c == null) {
                throw new NullPointerException();
            }
            final int expectedModCount = this.modCount;
            final int otherSize = c.size();
            final Iterator iter = c.iterator();
            final int lengthBeforeRemoving = this.storage.size();
            int i = 0;
            if (this.storage.size() > otherSize) {
                while (iter.hasNext()) {
                    final Object key = iter.next();
                    if (this.storage.hasKey(key)) {
                        this.storage.remove(key);
                    }
                }
                ;
            } else {
                final LibSLRuntime.Map<Object, Object> unseenKeys = this.storage.duplicate();
                while (i < this.storage.size()) {
                    final Object key = unseenKeys.anyKey();
                    unseenKeys.remove(key);
                    if (c.contains(key)) {
                        this.storage.remove(key);
                    }
                    i += 1;
                }
                ;
            }
            _checkForComodification(expectedModCount);
            this.modCount += 1;
            result = lengthBeforeRemoving != this.storage.size();
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::toArray(LinkedHashSet) -> array<Object>
     */
    public Object[] toArray() {
        Object[] result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            final int len = this.storage.size();
            result = new Object[len];
            final int expectedModCount = this.modCount;
            final LibSLRuntime.Map<Object, Object> unseenKeys = this.storage.duplicate();
            int i = 0;
            for (i = 0; i < len; i += 1) {
                final Object key = unseenKeys.anyKey();
                unseenKeys.remove(key);
                result[i] = key;
            }
            ;
            _checkForComodification(expectedModCount);
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::toArray(LinkedHashSet, array<Object>) -> array<Object>
     */
    public Object[] toArray(Object[] a) {
        Object[] result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            final int expectedModCount = this.modCount;
            final int aLen = a.length;
            final int len = this.storage.size();
            final LibSLRuntime.Map<Object, Object> unseenKeys = this.storage.duplicate();
            int i = 0;
            if (aLen < len) {
                a = new Object[len];
            }
            result = a;
            for (i = 0; i < len; i += 1) {
                final Object key = unseenKeys.anyKey();
                unseenKeys.remove(key);
                result[i] = key;
            }
            ;
            if (aLen > len) {
                result[len] = null;
            }
            _checkForComodification(expectedModCount);
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::toArray(LinkedHashSet, IntFunction) -> array<Object>
     */
    public Object[] toArray(IntFunction generator) {
        Object[] result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (generator == null) {
                throw new NullPointerException();
            }
            final int len = this.storage.size();
            result = ((Object[]) generator.apply(0));
            final int expectedModCount = this.modCount;
            final LibSLRuntime.Map<Object, Object> unseenKeys = this.storage.duplicate();
            int i = 0;
            for (i = 0; i < len; i += 1) {
                final Object key = unseenKeys.anyKey();
                unseenKeys.remove(key);
                result[i] = key;
            }
            ;
            _checkForComodification(expectedModCount);
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::containsAll(LinkedHashSet, Collection) -> boolean
     */
    public boolean containsAll(Collection c) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            final int otherSize = c.size();
            final Iterator iter = c.iterator();
            boolean isContainsAll = true;
            while (iter.hasNext()) {
                final Object key = iter.next();
                final boolean isKeyExist = this.storage.hasKey(key);
                if (!isKeyExist) {
                    isContainsAll = false;
                    break;
                }
            }
            ;
            result = isContainsAll;
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::addAll(LinkedHashSet, Collection) -> boolean
     */
    public boolean addAll(Collection c) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = _addAllElements(c);
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::retainAll(LinkedHashSet, Collection) -> boolean
     */
    public boolean retainAll(Collection c) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (c == null) {
                throw new NullPointerException();
            }
            final int lengthBeforeAdd = this.storage.size();
            final Iterator iter = c.iterator();
            while (iter.hasNext()) {
                final Object key = iter.next();
                if (!this.storage.hasKey(key)) {
                    this.storage.remove(key);
                }
            }
            ;
            if (lengthBeforeAdd != this.storage.size()) {
                this.modCount += 1;
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::removeIf(LinkedHashSet, Predicate) -> boolean
     */
    public boolean removeIf(Predicate filter) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (filter == null) {
                throw new NullPointerException();
            }
            final int lengthBeforeAdd = this.storage.size();
            final int expectedModCount = this.modCount;
            int i = 0;
            final LibSLRuntime.Map<Object, Object> unseenKeys = this.storage.duplicate();
            while (i < lengthBeforeAdd) {
                final Object key = unseenKeys.anyKey();
                unseenKeys.remove(key);
                if (filter.test(key)) {
                    this.storage.remove(key);
                }
                i += 1;
            }
            ;
            _checkForComodification(expectedModCount);
            if (lengthBeforeAdd != this.storage.size()) {
                this.modCount += 1;
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::forEach(LinkedHashSet, Consumer) -> void
     */
    public void forEach(Consumer userAction) {
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (userAction == null) {
                throw new NullPointerException();
            }
            int i = 0;
            final int expectedModCount = this.modCount;
            final LibSLRuntime.Map<Object, Object> unseenKeys = this.storage.duplicate();
            while (i < this.storage.size()) {
                final Object key = unseenKeys.anyKey();
                unseenKeys.remove(key);
                userAction.accept(key);
                i += 1;
            }
            ;
            _checkForComodification(expectedModCount);
        }
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::stream(LinkedHashSet) -> Stream
     */
    public Stream stream() {
        Stream result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = Engine.makeSymbolic(Stream.class);
            Engine.assume(result != null);
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::parallelStream(LinkedHashSet) -> Stream
     */
    public Stream parallelStream() {
        Stream result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = Engine.makeSymbolic(Stream.class);
            Engine.assume(result != null);
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::writeObject(LinkedHashSet, ObjectOutputStream) -> void
     */
    private void writeObject(ObjectOutputStream s) throws java.io.IOException {
        /* body */ {
            LibSLRuntime.not_implemented(/* no serialization support yet */);
        }
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::readObject(LinkedHashSet, ObjectInputStream) -> void
     */
    private void readObject(ObjectInputStream s) throws java.io.IOException,
            java.lang.ClassNotFoundException {
        /* body */ {
            LibSLRuntime.not_implemented(/* no serialization support yet */);
        }
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::toString(LinkedHashSet) -> String
     */
    public String toString() {
        String result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = LibSLRuntime.toString(this.storage);
        }
        return result;
    }

    public static final class __$lsl_States {
        public static final byte Allocated = (byte) 0;

        public static final byte Initialized = (byte) 1;
    }

    @Approximate(LinkedHashSet.class)
    public static final class __hook {
        private __hook(Void o1, Void o2) {
            Engine.assume(false);
        }
    }
}
