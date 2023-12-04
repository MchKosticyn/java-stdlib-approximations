// Generated by the LibSL translator.  DO NOT EDIT!
// sources:
//  - java/util/LinkedHashSet.lsl:39
//  - java/util/LinkedHashSet.KeyIterator.lsl:19
//
package generated.java.util;

import java.lang.IllegalStateException;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.SuppressWarnings;
import java.lang.Void;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;

/**
 * LinkedHashSet_KeyIteratorAutomaton for LinkedHashSet_KeyIterator ~> java.util.LinkedHashSet_KeyIterator
 */
@SuppressWarnings({"all", "unchecked"})
@Approximate(stub.java.util.LinkedHashSet_KeyIterator.class)
public final class LinkedHashSet_KeyIterator implements LibSLRuntime.Automaton, Iterator {
    static {
        Engine.assume(true);
    }

    private byte __$lsl_state = __$lsl_States.Allocated;

    public int expectedModCount;

    public LibSLRuntime.Map<Object, Object> unseenKeys;

    public LinkedHashSet parent;

    public int index;

    public Object currentKey;

    public boolean nextWasCalled;

    @LibSLRuntime.AutomatonConstructor
    public LinkedHashSet_KeyIterator(Void __$lsl_token, final byte p0, final int p1,
            final LibSLRuntime.Map<Object, Object> p2, final LinkedHashSet p3, final int p4,
            final Object p5, final boolean p6) {
        this.__$lsl_state = p0;
        this.expectedModCount = p1;
        this.unseenKeys = p2;
        this.parent = p3;
        this.index = p4;
        this.currentKey = p5;
        this.nextWasCalled = p6;
    }

    @LibSLRuntime.AutomatonConstructor
    public LinkedHashSet_KeyIterator(final Void __$lsl_token) {
        this(__$lsl_token, __$lsl_States.Allocated, 0, null, null, 0, 0, false);
    }

    /**
     * [CONSTRUCTOR] LinkedHashSet_KeyIteratorAutomaton::LinkedHashSet_KeyIterator(LinkedHashSet_KeyIterator, HashMap) -> LinkedHashSet_KeyIterator
     * Source: java/util/LinkedHashSet.KeyIterator.lsl:65
     */
    private LinkedHashSet_KeyIterator(HashMap source) {
        this((Void) null);
        Engine.assume(this.__$lsl_state == __$lsl_States.Allocated);
        /* body */ {
            LibSLRuntime.error("Private constructor call");
        }
        this.__$lsl_state = __$lsl_States.Initialized;
    }

    /**
     * [SUBROUTINE] LinkedHashSet_KeyIteratorAutomaton::_checkForComodification() -> void
     * Source: java/util/LinkedHashSet.KeyIterator.lsl:55
     */
    private void _checkForComodification() {
        /* body */ {
            final int modCount = ((LinkedHashSet) ((Object) this.parent)).modCount;
            if (this.expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    /**
     * [FUNCTION] LinkedHashSet_KeyIteratorAutomaton::hasNext(LinkedHashSet_KeyIterator) -> boolean
     * Source: java/util/LinkedHashSet.KeyIterator.lsl:73
     */
    public boolean hasNext() {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            Engine.assume(this.parent != null);
            final LibSLRuntime.Map<Object, Object> parentStorage = ((LinkedHashSet) ((Object) this.parent)).storage;
            result = this.index < parentStorage.size();
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSet_KeyIteratorAutomaton::next(LinkedHashSet_KeyIterator) -> Object
     * Source: java/util/LinkedHashSet.KeyIterator.lsl:83
     */
    public final Object next() {
        Object result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            Engine.assume(this.parent != null);
            _checkForComodification();
            final LibSLRuntime.Map<Object, Object> parentStorage = ((LinkedHashSet) ((Object) this.parent)).storage;
            final boolean atValidPosition = this.index < parentStorage.size();
            if (!atValidPosition) {
                throw new NoSuchElementException();
            }
            final Object key = this.unseenKeys.anyKey();
            this.unseenKeys.remove(key);
            Engine.assume(key != this.currentKey);
            this.currentKey = key;
            result = key;
            this.index += 1;
            this.nextWasCalled = true;
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSet_KeyIteratorAutomaton::remove(LinkedHashSet_KeyIterator) -> void
     * Source: java/util/LinkedHashSet.KeyIterator.lsl:106
     */
    public void remove() {
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            Engine.assume(this.parent != null);
            final LibSLRuntime.Map<Object, Object> parentStorage = ((LinkedHashSet) ((Object) this.parent)).storage;
            final boolean atValidPosition = this.index < parentStorage.size();
            if (!atValidPosition || !this.nextWasCalled) {
                throw new IllegalStateException();
            }
            this.nextWasCalled = false;
            _checkForComodification();
            parentStorage.remove(this.currentKey);
            this.expectedModCount = ((LinkedHashSet) ((Object) this.parent)).modCount;
        }
    }

    /**
     * [FUNCTION] LinkedHashSet_KeyIteratorAutomaton::forEachRemaining(LinkedHashSet_KeyIterator, Consumer) -> void
     * Source: java/util/LinkedHashSet.KeyIterator.lsl:126
     */
    public void forEachRemaining(Consumer userAction) {
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            Engine.assume(this.parent != null);
            if (userAction == null) {
                throw new NullPointerException();
            }
            final LibSLRuntime.Map<Object, Object> parentStorage = ((LinkedHashSet) ((Object) this.parent)).storage;
            final int length = parentStorage.size();
            int i = this.index;
            while (i < length) {
                _checkForComodification();
                final Object key = this.unseenKeys.anyKey();
                this.unseenKeys.remove(key);
                Engine.assume(key != this.currentKey);
                this.currentKey = key;
                userAction.accept(key);
                i += 1;
            }
            ;
            this.index = i;
            this.nextWasCalled = true;
        }
    }

    public static final class __$lsl_States {
        public static final byte Allocated = (byte) 0;

        public static final byte Initialized = (byte) 1;
    }

    @Approximate(LinkedHashSet_KeyIterator.class)
    public static final class __hook {
        private __hook(Void o1, Void o2) {
            Engine.assume(false);
        }
    }
}
