package generated.java.util;

import java.lang.Object;
import java.util.Collection;
import java.util.List;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import org.usvm.api.SymbolicList;

@SuppressWarnings("unused")
@Approximate(java.util.List.class)
public interface ListImpl extends List<Object> {

    @SuppressWarnings("unused")
    static List<Object> copyOf(Collection<?> coll) {
        return new ArrayListImpl(coll);
    }

    static List<Object> of() {
        return new ArrayListImpl();
    }

    static List<Object> of(Object element) {
        SymbolicList<Object> data = Engine.makeSymbolicList();
        data.insert(0, element);
        return new ArrayListImpl(data, 0);
    }

    static List<Object> of(Object element1, Object element2) {
        SymbolicList<Object> data = Engine.makeSymbolicList();
        data.insert(0, element1);
        data.insert(1, element2);
        return new ArrayListImpl(data, 0);
    }

    static List<Object> of(Object e1, Object e2, Object e3) {
        SymbolicList<Object> data = Engine.makeSymbolicList();
        data.insert(0, e1);
        data.insert(1, e2);
        data.insert(2, e3);
        return new ArrayListImpl(data, 0);
    }

    static List<Object> of(Object e1, Object e2, Object e3, Object e4) {
        SymbolicList<Object> data = Engine.makeSymbolicList();
        data.insert(0, e1);
        data.insert(1, e2);
        data.insert(2, e3);
        data.insert(3, e4);
        return new ArrayListImpl(data, 0);
    }

    static List<Object> of(Object e1, Object e2, Object e3, Object e4, Object e5) {
        SymbolicList<Object> data = Engine.makeSymbolicList();
        data.insert(0, e1);
        data.insert(1, e2);
        data.insert(2, e3);
        data.insert(3, e4);
        data.insert(4, e5);
        return new ArrayListImpl(data, 0);
    }

    static List<Object> of(Object e1, Object e2, Object e3, Object e4, Object e5, Object e6) {
        SymbolicList<Object> data = Engine.makeSymbolicList();
        data.insert(0, e1);
        data.insert(1, e2);
        data.insert(2, e3);
        data.insert(3, e4);
        data.insert(4, e5);
        data.insert(5, e6);
        return new ArrayListImpl(data, 0);
    }

    static List<Object> of(Object e1, Object e2, Object e3, Object e4, Object e5, Object e6, Object e7) {
        SymbolicList<Object> data = Engine.makeSymbolicList();
        data.insert(0, e1);
        data.insert(1, e2);
        data.insert(2, e3);
        data.insert(3, e4);
        data.insert(4, e5);
        data.insert(5, e6);
        data.insert(6, e7);
        return new ArrayListImpl(data, 0);
    }

    static List<Object> of(Object e1, Object e2, Object e3, Object e4, Object e5, Object e6, Object e7, Object e8) {
        SymbolicList<Object> data = Engine.makeSymbolicList();
        data.insert(0, e1);
        data.insert(1, e2);
        data.insert(2, e3);
        data.insert(3, e4);
        data.insert(4, e5);
        data.insert(5, e6);
        data.insert(6, e7);
        data.insert(7, e8);
        return new ArrayListImpl(data, 0);
    }

    static List<Object> of(Object e1, Object e2, Object e3, Object e4, Object e5, Object e6, Object e7, Object e8, Object e9) {
        SymbolicList<Object> data = Engine.makeSymbolicList();
        data.insert(0, e1);
        data.insert(1, e2);
        data.insert(2, e3);
        data.insert(3, e4);
        data.insert(4, e5);
        data.insert(5, e6);
        data.insert(6, e7);
        data.insert(7, e8);
        data.insert(8, e9);
        return new ArrayListImpl(data, 0);
    }

    static List<Object> of(Object e1, Object e2, Object e3, Object e4, Object e5, Object e6, Object e7, Object e8, Object e9, Object e10) {
        SymbolicList<Object> data = Engine.makeSymbolicList();
        data.insert(0, e1);
        data.insert(1, e2);
        data.insert(2, e3);
        data.insert(3, e4);
        data.insert(4, e5);
        data.insert(5, e6);
        data.insert(6, e7);
        data.insert(7, e8);
        data.insert(8, e9);
        data.insert(9, e10);
        return new ArrayListImpl(data, 0);
    }

    @SuppressWarnings("ConstantValue")
    static List<Object> of(Object[] elements) {
        SymbolicList<Object> data = Engine.makeSymbolicList();
        int size = elements.length;
        Engine.assume(size >= 0);
        for (int i = 0; i < size; i++) {
            data.insert(i, elements[i]);
        }
        return new ArrayListImpl(data, 0);
    }
}
