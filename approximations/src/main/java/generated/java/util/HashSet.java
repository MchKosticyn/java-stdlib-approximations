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
import java.lang.Void;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;

/**
 * HashSetAutomaton for HashSet ~> java.util.HashSet
 */
@Approximate(java.util.HashSet.class)
public class HashSet extends AbstractSet implements LibSLRuntime.Automaton, Set, Cloneable, Serializable {
    private static final long serialVersionUID = -5024744406713321676L;

    static {
        Engine.assume(true);
    }

    private byte __$lsl_state = __$lsl_States.Allocated;

    public LibSLRuntime.Map<Object, Object> storage;

    public transient int length;

    public transient int modCount;

    @LibSLRuntime.AutomatonConstructor
    public HashSet(Void __$lsl_token, final byte p0, final LibSLRuntime.Map<Object, Object> p1,
            final int p2, final int p3) {
        this.__$lsl_state = p0;
        this.storage = p1;
        this.length = p2;
        this.modCount = p3;
    }

    @LibSLRuntime.AutomatonConstructor
    public HashSet(final Void __$lsl_token) {
        this(__$lsl_token, __$lsl_States.Allocated, null, 0, 0);
    }

    /**
     * [CONSTRUCTOR] HashSetAutomaton::HashSet(HashSet) -> HashSet
     */
    public HashSet() {
        this((Void) null);
        Engine.assume(this.__$lsl_state == __$lsl_States.Allocated);
        /* body */ {
            this.storage = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
        }
        this.__$lsl_state = __$lsl_States.Initialized;
    }

    /**
     * [CONSTRUCTOR] HashSetAutomaton::HashSet(HashSet, Collection) -> HashSet
     */
    public HashSet(Collection c) {
        this((Void) null);
        Engine.assume(this.__$lsl_state == __$lsl_States.Allocated);
        /* body */ {
            this.storage = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
            _addAllElements(c);
        }
        this.__$lsl_state = __$lsl_States.Initialized;
    }

    /**
     * [CONSTRUCTOR] HashSetAutomaton::HashSet(HashSet, int) -> HashSet
     */
    public HashSet(int initialCapacity) {
        this((Void) null);
        /* body */ {
            if (initialCapacity < 0) {
                throw new IllegalArgumentException();
            }
            this.storage = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
        }
    }

    /**
     * [CONSTRUCTOR] HashSetAutomaton::HashSet(HashSet, int, float) -> HashSet
     */
    public HashSet(int initialCapacity, float loadFactor) {
        this((Void) null);
        Engine.assume(this.__$lsl_state == __$lsl_States.Allocated);
        /* body */ {
            if (initialCapacity < 0) {
                throw new IllegalArgumentException();
            }
            if ((loadFactor <= 0) || Float.isNaN(loadFactor)) {
                throw new IllegalArgumentException();
            }
            this.storage = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
        }
        this.__$lsl_state = __$lsl_States.Initialized;
    }

    /**
     * [CONSTRUCTOR] HashSetAutomaton::HashSet(HashSet, int, float, boolean) -> HashSet
     */
    private HashSet(int initialCapacity, float loadFactor, boolean dummy) {
        this((Void) null);
        Engine.assume(this.__$lsl_state == __$lsl_States.Allocated);
        /* body */ {
            LibSLRuntime.error("Private constructor call");
        }
        this.__$lsl_state = __$lsl_States.Initialized;
    }

    /**
     * [SUBROUTINE] HashSetAutomaton::_checkForComodification(int) -> void
     */
    public void _checkForComodification(int expectedModCount) {
        /* body */ {
            if (this.modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    /**
     * [SUBROUTINE] HashSetAutomaton::_addAllElements(Collection) -> boolean
     */
    private boolean _addAllElements(Collection c) {
        boolean result = false;
        /* body */ {
            final int lengthBeforeAdd = this.length;
            final Iterator iter = c.iterator();
            while (iter.hasNext()) {
                final Object key = iter.next();
                final boolean hasKey = this.storage.hasKey(key);
                if (!hasKey) {
                    this.storage.set(key, LibSLGlobals.SOMETHING);
                    this.length += 1;
                }
            }
            ;
            if (lengthBeforeAdd != this.length) {
                this.modCount += 1;
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }

    /**
     * [SUBROUTINE] HashSetAutomaton::_generateKey(map<Object, Object>) -> Object
     */
    private Object _generateKey(LibSLRuntime.Map<Object, Object> visitedKeys) {
        Object result = null;
        /* body */ {
            result = Engine.makeSymbolic(Object.class);
            Engine.assume(result != null);
            final boolean isKeyExist = this.storage.hasKey(result);
            Engine.assume(isKeyExist);
            final boolean isKeyWasVisited = visitedKeys.hasKey(result);
            Engine.assume(!isKeyWasVisited);
        }
        return result;
    }

    /**
     * [FUNCTION] HashSetAutomaton::add(HashSet, Object) -> boolean
     */
    public boolean add(Object obj) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            final boolean hasKey = this.storage.hasKey(obj);
            if (hasKey) {
                result = false;
            } else {
                this.length += 1;
                this.storage.set(obj, LibSLGlobals.SOMETHING);
                result = true;
            }
            this.modCount += 1;
        }
        return result;
    }

    /**
     * [FUNCTION] HashSetAutomaton::clear(HashSet) -> void
     */
    public void clear() {
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            this.length = 0;
            this.storage = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
            this.modCount += 1;
        }
    }

    /**
     * [FUNCTION] HashSetAutomaton::clone(HashSet) -> Object
     */
    public Object clone() {
        Object result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            final LibSLRuntime.Map<Object, Object> storageCopy = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
            storageCopy.union(this.storage);
            result = new HashSet((Void) null, 
            /* state = */ HashSet.__$lsl_States.Initialized, 
            /* storage = */ storageCopy, 
            /* length = */ this.length, 
            /* modCount = */ 0);
        }
        return result;
    }

    /**
     * [FUNCTION] HashSetAutomaton::contains(HashSet, Object) -> boolean
     */
    public boolean contains(Object obj) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (this.length == 0) {
                result = false;
            } else {
                result = this.storage.hasKey(obj);
            }
        }
        return result;
    }

    /**
     * [FUNCTION] HashSetAutomaton::isEmpty(HashSet) -> boolean
     */
    public boolean isEmpty() {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = this.length == 0;
        }
        return result;
    }

    /**
     * [FUNCTION] HashSetAutomaton::iterator(HashSet) -> Iterator
     */
    public Iterator iterator() {
        Iterator result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            final LibSLRuntime.Map<Object, Object> visitedKeysMap = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
            result = new HashSet_KeyIterator((Void) null, 
            /* state = */ HashSet_KeyIterator.__$lsl_States.Initialized, 
            /* expectedModCount = */ this.modCount, 
            /* visitedKeys = */ visitedKeysMap, 
            /* parent = */ this, 
            /* index = */ 0, 
            /* currentKey = */ 0, 
            /* nextWasCalled = */ false);
        }
        return result;
    }

    /**
     * [FUNCTION] HashSetAutomaton::remove(HashSet, Object) -> boolean
     */
    public boolean remove(Object obj) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            final boolean hasKey = this.storage.hasKey(obj);
            if (hasKey) {
                this.storage.remove(obj);
                this.length -= 1;
                this.modCount += 1;
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }

    /**
     * [FUNCTION] HashSetAutomaton::size(HashSet) -> int
     */
    public int size() {
        int result = 0;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = this.length;
        }
        return result;
    }

    /**
     * [FUNCTION] HashSetAutomaton::spliterator(HashSet) -> Spliterator
     */
    public Spliterator spliterator() {
        Spliterator result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            final Object[] keysStorageArray = new Object[this.length];
            final LibSLRuntime.Map<Object, Object> visitedKeys = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
            int i = 0;
            for (i = 0; i < this.length; i += 1) {
                final Object key = _generateKey(visitedKeys);
                keysStorageArray[i] = key;
                visitedKeys.set(key, LibSLGlobals.SOMETHING);
            }
            ;
            result = new HashSet_KeySpliterator((Void) null, 
            /* state = */ HashSet_KeySpliterator.__$lsl_States.Initialized, 
            /* keysStorage = */ keysStorageArray, 
            /* index = */ 0, 
            /* fence = */ -1, 
            /* est = */ 0, 
            /* expectedModCount = */ this.modCount, 
            /* parent = */ this);
        }
        return result;
    }

    /**
     * [FUNCTION] HashSetAutomaton::equals(HashSet, Object) -> boolean
     */
    public boolean equals(Object other) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (other == this) {
                result = true;
            } else {
                final boolean isSameType = Engine.typeEquals(this, other);
                if (isSameType) {
                    final int expectedModCount = this.modCount;
                    final int otherExpectedModCount = ((HashSet) other).modCount;
                    final LibSLRuntime.Map<Object, Object> otherStorage = ((HashSet) other).storage;
                    final int otherLength = ((HashSet) other).length;
                    if (this.length == otherLength) {
                        result = LibSLRuntime.equals(this.storage, otherStorage);
                    } else {
                        result = false;
                    }
                    ((HashSet) other)._checkForComodification(otherExpectedModCount);
                    _checkForComodification(expectedModCount);
                } else {
                    result = false;
                }
            }
        }
        return result;
    }

    /**
     * [FUNCTION] HashSetAutomaton::hashCode(HashSet) -> int
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
     * [FUNCTION] HashSetAutomaton::removeAll(HashSet, Collection) -> boolean
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
            final int lengthBeforeRemoving = this.length;
            int i = 0;
            if (this.length > otherSize) {
                while (iter.hasNext()) {
                    final Object key = iter.next();
                    final boolean isKeyExist = this.storage.hasKey(key);
                    if (isKeyExist) {
                        this.storage.remove(key);
                        this.length -= 1;
                    }
                }
                ;
            } else {
                final LibSLRuntime.Map<Object, Object> visitedKeys = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
                while (i < this.length) {
                    final Object key = _generateKey(visitedKeys);
                    final boolean isCollectionContainsKey = c.contains(key);
                    if (isCollectionContainsKey) {
                        this.storage.remove(key);
                        this.length -= 1;
                    }
                    visitedKeys.set(key, LibSLGlobals.SOMETHING);
                    i += 1;
                }
                ;
            }
            _checkForComodification(expectedModCount);
            this.modCount += 1;
            result = lengthBeforeRemoving != this.length;
        }
        return result;
    }

    /**
     * [FUNCTION] HashSetAutomaton::toArray(HashSet) -> array<Object>
     */
    public Object[] toArray() {
        Object[] result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            final int len = this.length;
            result = new Object[len];
            final int expectedModCount = this.modCount;
            final LibSLRuntime.Map<Object, Object> visitedKeys = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
            int i = 0;
            for (i = 0; i < len; i += 1) {
                final Object key = _generateKey(visitedKeys);
                result[i] = key;
                visitedKeys.set(key, LibSLGlobals.SOMETHING);
            }
            ;
            _checkForComodification(expectedModCount);
        }
        return result;
    }

    /**
     * [FUNCTION] HashSetAutomaton::toArray(HashSet, array<Object>) -> array<Object>
     */
    public Object[] toArray(Object[] a) {
        Object[] result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            final int expectedModCount = this.modCount;
            final int aLen = a.length;
            final int len = this.length;
            final LibSLRuntime.Map<Object, Object> visitedKeys = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
            int i = 0;
            if (aLen < len) {
                a = new Object[len];
            }
            result = a;
            for (i = 0; i < len; i += 1) {
                final Object key = _generateKey(visitedKeys);
                result[i] = key;
                visitedKeys.set(key, LibSLGlobals.SOMETHING);
            }
            ;
            if (aLen > this.length) {
                result[this.length] = null;
            }
            _checkForComodification(expectedModCount);
        }
        return result;
    }

    /**
     * [FUNCTION] HashSetAutomaton::containsAll(HashSet, Collection) -> boolean
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
     * [FUNCTION] HashSetAutomaton::addAll(HashSet, Collection) -> boolean
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
     * [FUNCTION] HashSetAutomaton::retainAll(HashSet, Collection) -> boolean
     */
    public boolean retainAll(Collection c) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (c == null) {
                throw new NullPointerException();
            }
            final int lengthBeforeAdd = this.length;
            final Iterator iter = c.iterator();
            while (iter.hasNext()) {
                final Object key = iter.next();
                final boolean hasKey = this.storage.hasKey(key);
                if (!hasKey) {
                    this.storage.remove(key);
                    this.length -= 1;
                }
            }
            ;
            if (lengthBeforeAdd != this.length) {
                this.modCount += 1;
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }

    /**
     * [FUNCTION] HashSetAutomaton::removeIf(HashSet, Predicate) -> boolean
     */
    public boolean removeIf(Predicate filter) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (filter == null) {
                throw new NullPointerException();
            }
            final int lengthBeforeAdd = this.length;
            final int expectedModCount = this.modCount;
            int i = 0;
            final LibSLRuntime.Map<Object, Object> visitedKeys = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
            while (i < lengthBeforeAdd) {
                final Object key = _generateKey(visitedKeys);
                boolean isDelete = filter.test(key);
                if (isDelete) {
                    this.storage.remove(key);
                    this.length -= 1;
                }
                i += 1;
                visitedKeys.set(key, LibSLGlobals.SOMETHING);
            }
            ;
            _checkForComodification(expectedModCount);
            if (lengthBeforeAdd != this.length) {
                this.modCount += 1;
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }

    /**
     * [FUNCTION] HashSetAutomaton::forEach(HashSet, Consumer) -> void
     */
    public void forEach(Consumer userAction) {
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (userAction == null) {
                throw new NullPointerException();
            }
            int i = 0;
            final int expectedModCount = this.modCount;
            final LibSLRuntime.Map<Object, Object> visitedKeys = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
            while (i < this.length) {
                final Object key = _generateKey(visitedKeys);
                userAction.accept(key);
                i += 1;
                visitedKeys.set(key, LibSLGlobals.SOMETHING);
            }
            ;
            _checkForComodification(expectedModCount);
        }
    }

    /**
     * [FUNCTION] HashSetAutomaton::stream(HashSet) -> Stream
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
     * [FUNCTION] HashSetAutomaton::parallelStream(HashSet) -> Stream
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
     * [FUNCTION] HashSetAutomaton::writeObject(HashSet, ObjectOutputStream) -> void
     */
    private void writeObject(ObjectOutputStream s) throws java.io.IOException {
        /* body */ {
            LibSLRuntime.not_implemented(/* no serialization support yet */);
        }
    }

    /**
     * [FUNCTION] HashSetAutomaton::readObject(HashSet, ObjectInputStream) -> void
     */
    private void readObject(ObjectInputStream s) throws java.io.IOException,
            java.lang.ClassNotFoundException {
        /* body */ {
            LibSLRuntime.not_implemented(/* no serialization support yet */);
        }
    }

    public static final class __$lsl_States {
        public static final byte Allocated = (byte) 0;

        public static final byte Initialized = (byte) 1;
    }

    @Approximate(HashSet.class)
    public static final class __hook {
        private __hook(Void o1, Void o2) {
            Engine.assume(false);
        }
    }
}
