package generated.java.util;

import java.io.Serial;
import java.io.Serializable;
import java.lang.Object;
import java.lang.String;
import java.util.Map;

import runtime.LibSLRuntime;

public class AbstractMap_SimpleEntry implements Serializable, Map.Entry<Object, Object> {

    @Serial
    private static final long serialVersionUID = -8499721149061103585L;

    public Object key;

    public Object value;

    @SuppressWarnings("unused")
    public AbstractMap_SimpleEntry(Map.Entry<Object, Object> entry) {
        this.key = entry.getKey();
        this.value = entry.getValue();
    }

    @SuppressWarnings("unused")
    public AbstractMap_SimpleEntry(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    @SuppressWarnings("unchecked")
    public boolean equals(Object other) {
        if (other == this)
            return true;

        if (other instanceof Map.Entry) {
            Map.Entry<Object, Object> oEntry = ((Map.Entry<Object, Object>) other);
            Object otherKey = oEntry.getKey();
            Object otherValue = oEntry.getValue();
            return LibSLRuntime.equals(this.key, otherKey) && LibSLRuntime.equals(this.value, otherValue);
        }

        return false;
    }

    public Object getKey() {
        return this.key;
    }

    public Object getValue() {
        return this.value;
    }

    public int hashCode() {
        return LibSLRuntime.hashCode(this.key) ^ LibSLRuntime.hashCode(this.value);
    }

    public Object setValue(Object value) {
        Object oldValue = this.value;
        this.value = value;
        return oldValue;
    }

    public String toString() {
        return LibSLRuntime.toString(this.key).concat("=").concat(LibSLRuntime.toString(this.value));
    }
}
