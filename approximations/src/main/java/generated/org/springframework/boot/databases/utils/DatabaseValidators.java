package generated.org.springframework.boot.databases.utils;

import java.lang.reflect.Array;
import java.util.function.Function;

public class DatabaseValidators {

    public static Function<Object, Boolean> getIdValidator (Class<?> clazz) {
        if (clazz.equals(Boolean.class)) {
            return (Object v) -> v != null && (Boolean) v;
        }
        else if (clazz.equals(Byte.class)) {
            return (Object v) -> v != null && (Byte) v > 0;
        }
        else if (clazz.equals(Short.class)) {
            return (Object v) -> v != null && (Short) v > 0;
        }
        else if (clazz.equals(Integer.class)) {
            return (Object v) -> v != null && (Integer) v > 0;
        }
        else if (clazz.equals(Long.class)) {
            return (Object v) -> v != null && (Long) v > 0;
        }
        else if (clazz.equals(Float.class)) {
            return (Object v) -> v != null && (Float) v > 0;
        }
        else if (clazz.equals(Double.class)) {
            return (Object v) -> v != null && (Double) v > 0;
        }
        else if (clazz.equals(String.class)) {
            return (Object v) -> v != null && !((String) v).isEmpty();
        }
        else {
            throw new IllegalArgumentException("Unsupported id type validator");
        }
    }

    public static <T> boolean isDefaultValue(T value, Class<T> clazz) {
        return value.equals(Array.get(Array.newInstance(clazz, 1), 0));
    }
}
