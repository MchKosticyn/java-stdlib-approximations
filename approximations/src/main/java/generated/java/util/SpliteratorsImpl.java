package generated.java.util;

import generated.runtime.LibSLGlobals;
import java.lang.Object;
import java.util.Spliterator;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;

@SuppressWarnings("unused")
@Approximate(java.util.Spliterators.class)
public final class SpliteratorsImpl {

    static {
        Engine.assume(true);
    }

    private SpliteratorsImpl() { }

    public static final int _characteristics = LibSLGlobals.SPLITERATOR_SIZED | LibSLGlobals.SPLITERATOR_SUBSIZED;

    public static Spliterator<Object> spliterator(Object[] arr, int additionalCharacteristics) {
        return new ArraySpliterator(arr, 0, arr.length, additionalCharacteristics);
    }

    public static Spliterator<Object> spliterator(Object[] arr, int fromIndex, int toIndex, int additionalCharacteristics) {
        return new ArraySpliterator(arr, fromIndex, toIndex, additionalCharacteristics);
    }

    public static Spliterator.OfDouble spliterator(double[] arr, int additionalCharacteristics) {
        return new Spliterators_DoubleArraySpliterator(arr, 0, arr.length, additionalCharacteristics);
    }

    public static Spliterator.OfDouble spliterator(double[] arr, int fromIndex, int toIndex, int additionalCharacteristics) {
        return new Spliterators_DoubleArraySpliterator(arr, fromIndex, toIndex, additionalCharacteristics);
    }

    public static Spliterator.OfInt spliterator(int[] arr, int additionalCharacteristics) {
        return new Spliterators_IntArraySpliterator(arr, 0, arr.length, additionalCharacteristics);
    }

    public static Spliterator.OfInt spliterator(int[] arr, int fromIndex, int toIndex, int additionalCharacteristics) {
        return new Spliterators_IntArraySpliterator(arr, fromIndex, toIndex, additionalCharacteristics);
    }

    public static Spliterator.OfLong spliterator(long[] arr, int additionalCharacteristics) {
        return new Spliterators_LongArraySpliterator(arr, 0, arr.length, additionalCharacteristics);
    }

    public static Spliterator.OfLong spliterator(long[] arr, int fromIndex, int toIndex, int additionalCharacteristics) {
        return new Spliterators_LongArraySpliterator(arr, fromIndex, toIndex, additionalCharacteristics);
    }
}
