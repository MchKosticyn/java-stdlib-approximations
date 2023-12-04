// Generated by the LibSL translator.  DO NOT EDIT!
// sources:
//  - java/security/SecureRandom.lsl:25
//  - java/security/SecureRandom.main.lsl:24
//
package generated.java.security;

import generated.runtime.LibSLGlobals;
import java.lang.IllegalArgumentException;
import java.lang.InternalError;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.Void;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandomSpi;
import java.security.Security;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;
import stub.java.util.stream.DoubleStreamLSL;
import stub.java.util.stream.IntStreamLSL;
import stub.java.util.stream.LongStreamLSL;

/**
 * SecureRandomAutomaton for SecureRandomLSL ~> java.security.SecureRandom
 */
@SuppressWarnings({"all", "unchecked"})
@Approximate(java.security.SecureRandom.class)
public class SecureRandom implements LibSLRuntime.Automaton {
    private static final long serialVersionUID = 4940670005562187L;

    private static final LibSLRuntime.Map<String, Object> defaultProvidersMap = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());

    static {
        /* SecureRandomAutomaton::__clinit__() */ {
            defaultProvidersMap.set("SUN", LibSLGlobals.SOMETHING);
            defaultProvidersMap.set("SunRsaSign", LibSLGlobals.SOMETHING);
            defaultProvidersMap.set("SunJSSE", LibSLGlobals.SOMETHING);
            defaultProvidersMap.set("SunJCE", LibSLGlobals.SOMETHING);
            defaultProvidersMap.set("Apple", LibSLGlobals.SOMETHING);
            defaultProvidersMap.set("JdkLDAP", LibSLGlobals.SOMETHING);
            defaultProvidersMap.set("SunJGSS", LibSLGlobals.SOMETHING);
            defaultProvidersMap.set("SunSASL", LibSLGlobals.SOMETHING);
            defaultProvidersMap.set("SunPCSC", LibSLGlobals.SOMETHING);
            defaultProvidersMap.set("XMLDSig", LibSLGlobals.SOMETHING);
            defaultProvidersMap.set("SunPKCS11", LibSLGlobals.SOMETHING);
            defaultProvidersMap.set("SunEC", LibSLGlobals.SOMETHING);
            defaultProvidersMap.set("SunMSCAPI", LibSLGlobals.SOMETHING);
            defaultProvidersMap.set("OracleUcrypto", LibSLGlobals.SOMETHING);
            defaultProvidersMap.set("JdkSASL", LibSLGlobals.SOMETHING);
        }
    }

    private byte __$lsl_state = __$lsl_States.Allocated;

    public Provider provider;

    public String algorithm;

    public boolean defaultProvider;

    @LibSLRuntime.AutomatonConstructor
    public SecureRandom(Void __$lsl_token, final byte p0, final Provider p1, final String p2,
            final boolean p3) {
        this.__$lsl_state = p0;
        this.provider = p1;
        this.algorithm = p2;
        this.defaultProvider = p3;
    }

    @LibSLRuntime.AutomatonConstructor
    public SecureRandom(final Void __$lsl_token) {
        this(__$lsl_token, __$lsl_States.Allocated, null, null, false);
    }

    /**
     * [CONSTRUCTOR] SecureRandomAutomaton::SecureRandom(SecureRandom) -> SecureRandomLSL
     * Source: java/security/SecureRandom.main.lsl:200
     */
    public SecureRandom() {
        this((Void) null);
        Engine.assume(this.__$lsl_state == __$lsl_States.Allocated);
        /* body */ {
            _getDefaultPRNG();
        }
        this.__$lsl_state = __$lsl_States.Initialized;
    }

    /**
     * [CONSTRUCTOR] SecureRandomAutomaton::SecureRandom(SecureRandom, SecureRandomSpi, Provider) -> SecureRandomLSL
     * Source: java/security/SecureRandom.main.lsl:207
     */
    protected SecureRandom(SecureRandomSpi secureRandomSpi, Provider provider) {
        this((Void) null);
        Engine.assume(this.__$lsl_state == __$lsl_States.Allocated);
        /* body */ {
            LibSLRuntime.error("Protected constructor call");
        }
        this.__$lsl_state = __$lsl_States.Initialized;
    }

    /**
     * [CONSTRUCTOR] SecureRandomAutomaton::SecureRandom(SecureRandom, SecureRandomSpi, Provider, String) -> SecureRandomLSL
     * Source: java/security/SecureRandom.main.lsl:214
     */
    private SecureRandom(SecureRandomSpi secureRandomSpi, Provider provider, String algorithm) {
        this((Void) null);
        Engine.assume(this.__$lsl_state == __$lsl_States.Allocated);
        /* body */ {
            LibSLRuntime.error("Private constructor call");
        }
        this.__$lsl_state = __$lsl_States.Initialized;
    }

    /**
     * [CONSTRUCTOR] SecureRandomAutomaton::SecureRandom(SecureRandom, array<byte>) -> SecureRandomLSL
     * Source: java/security/SecureRandom.main.lsl:220
     */
    public SecureRandom(byte[] seed) {
        this((Void) null);
        Engine.assume(this.__$lsl_state == __$lsl_States.Allocated);
        /* body */ {
            _getDefaultPRNG();
        }
        this.__$lsl_state = __$lsl_States.Initialized;
    }

    /**
     * [SUBROUTINE] SecureRandomAutomaton::_getDefaultPRNG() -> void
     * Source: java/security/SecureRandom.main.lsl:114
     */
    private void _getDefaultPRNG() {
        /* body */ {
            this.provider = Engine.makeSymbolic(Provider.class);
            this.algorithm = Engine.makeSymbolic(String.class);
            Engine.assume(this.algorithm.length() > 0);
            if ((this.provider == null) || (this.algorithm == null)) {
                throw new InternalError();
            }
            this.defaultProvider = _isDefaultProvider(this.provider);
        }
    }

    /**
     * [SUBROUTINE] SecureRandomAutomaton::_isDefaultProvider(Provider) -> boolean
     * Source: java/security/SecureRandom.main.lsl:128
     */
    private static boolean _isDefaultProvider(Provider curProvider) {
        boolean result = false;
        /* body */ {
            final String providerName = curProvider.getName();
            result = defaultProvidersMap.hasKey(providerName);
        }
        return result;
    }

    /**
     * [SUBROUTINE] SecureRandomAutomaton::_nextBytes(array<byte>, int) -> void
     * Source: java/security/SecureRandom.main.lsl:135
     */
    private static void _nextBytes(byte[] result, int numBytes) {
        /* body */ {
            final byte[] symbolicArray = Engine.makeSymbolicByteArray(numBytes);
            LibSLRuntime.ArrayActions.copy(symbolicArray, 0, result, 0, numBytes);
        }
    }

    /**
     * [SUBROUTINE] SecureRandomAutomaton::_generateRandomIntegerArrayWithBounds(int, int, int) -> array<int>
     * Source: java/security/SecureRandom.main.lsl:142
     */
    private int[] _generateRandomIntegerArrayWithBounds(int size, int randomNumberOrigin,
            int randomNumberBound) {
        int[] result = null;
        /* body */ {
            result = Engine.makeSymbolicIntArray(size);
            int i = 0;
            for (i = 0; i < size; i += 1) {
                Engine.assume(result[i] >= randomNumberOrigin);
                Engine.assume(result[i] < randomNumberBound);
            }
            ;
        }
        return result;
    }

    /**
     * [SUBROUTINE] SecureRandomAutomaton::_generateRandomLongArrayWithBounds(int, long, long) -> array<long>
     * Source: java/security/SecureRandom.main.lsl:160
     */
    private long[] _generateRandomLongArrayWithBounds(int size, long randomNumberOrigin,
            long randomNumberBound) {
        long[] result = null;
        /* body */ {
            result = Engine.makeSymbolicLongArray(size);
            int i = 0;
            for (i = 0; i < size; i += 1) {
                Engine.assume(result[i] >= randomNumberOrigin);
                Engine.assume(result[i] < randomNumberBound);
            }
            ;
        }
        return result;
    }

    /**
     * [SUBROUTINE] SecureRandomAutomaton::_generateRandomDoubleArrayWithBounds(int, double, double) -> array<double>
     * Source: java/security/SecureRandom.main.lsl:178
     */
    private double[] _generateRandomDoubleArrayWithBounds(int size, double randomNumberOrigin,
            double randomNumberBound) {
        double[] result = null;
        /* body */ {
            result = Engine.makeSymbolicDoubleArray(size);
            int i = 0;
            for (i = 0; i < size; i += 1) {
                final double item = result[i];
                Engine.assume(item == item);
                Engine.assume(item >= randomNumberOrigin);
                Engine.assume(item < randomNumberBound);
            }
            ;
        }
        return result;
    }

    /**
     * [FUNCTION] SecureRandomAutomaton::getInstance(String) -> SecureRandom
     * Source: java/security/SecureRandom.main.lsl:228
     */
    public static java.security.SecureRandom getInstance(String _algorithm) throws
            java.security.NoSuchAlgorithmException {
        java.security.SecureRandom result = null;
        // WARNING: no state checks in static context
        /* body */ {
            final Provider resultProvider = Engine.makeSymbolic(Provider.class);
            final String resultAlgorithm = Engine.makeSymbolic(String.class);
            if (resultAlgorithm == null) {
                throw new NoSuchAlgorithmException();
            }
            final int resultAlgorithmLength = resultAlgorithm.length();
            Engine.assume(resultAlgorithmLength > 0);
            result = (java.security.SecureRandom) ((Object) new SecureRandom((Void) null, 
                /* state = */ SecureRandom.__$lsl_States.Initialized, 
                /* provider = */ resultProvider, 
                /* algorithm = */ resultAlgorithm, 
                /* defaultProvider = */ _isDefaultProvider(resultProvider)
            ));
        }
        // WARNING: no state transitions in static context
        return result;
    }

    /**
     * [FUNCTION] SecureRandomAutomaton::getInstance(String, Provider) -> SecureRandom
     * Source: java/security/SecureRandom.main.lsl:248
     */
    public static java.security.SecureRandom getInstance(String _algorithm, Provider provider)
            throws java.security.NoSuchAlgorithmException {
        java.security.SecureRandom result = null;
        // WARNING: no state checks in static context
        /* body */ {
            if (provider == null) {
                throw new IllegalArgumentException();
            }
            final Provider resultProvider = Engine.makeSymbolic(Provider.class);
            final String resultAlgorithm = Engine.makeSymbolic(String.class);
            if (resultAlgorithm == null) {
                throw new NoSuchAlgorithmException();
            }
            final int resultAlgorithmLength = resultAlgorithm.length();
            Engine.assume(resultAlgorithmLength > 0);
            result = (java.security.SecureRandom) ((Object) new SecureRandom((Void) null, 
                /* state = */ SecureRandom.__$lsl_States.Initialized, 
                /* provider = */ resultProvider, 
                /* algorithm = */ resultAlgorithm, 
                /* defaultProvider = */ _isDefaultProvider(resultProvider)
            ));
        }
        // WARNING: no state transitions in static context
        return result;
    }

    /**
     * [FUNCTION] SecureRandomAutomaton::getInstance(String, String) -> SecureRandom
     * Source: java/security/SecureRandom.main.lsl:271
     */
    public static java.security.SecureRandom getInstance(String _algorithm, String providerName)
            throws java.security.NoSuchAlgorithmException, java.security.NoSuchProviderException {
        java.security.SecureRandom result = null;
        // WARNING: no state checks in static context
        /* body */ {
            if ((providerName == null) || (providerName.length() == 0)) {
                throw new IllegalArgumentException();
            }
            final Provider resultProvider = Engine.makeSymbolic(Provider.class);
            final String resultAlgorithm = Engine.makeSymbolic(String.class);
            if (resultProvider == null) {
                throw new NoSuchProviderException();
            }
            if (resultAlgorithm == null) {
                throw new NoSuchAlgorithmException();
            }
            final int resultAlgorithmLength = resultAlgorithm.length();
            Engine.assume(resultAlgorithmLength > 0);
            result = (java.security.SecureRandom) ((Object) new SecureRandom((Void) null, 
                /* state = */ SecureRandom.__$lsl_States.Initialized, 
                /* provider = */ resultProvider, 
                /* algorithm = */ resultAlgorithm, 
                /* defaultProvider = */ _isDefaultProvider(resultProvider)
            ));
        }
        // WARNING: no state transitions in static context
        return result;
    }

    /**
     * [FUNCTION] SecureRandomAutomaton::getInstanceStrong() -> SecureRandom
     * Source: java/security/SecureRandom.main.lsl:297
     */
    public static java.security.SecureRandom getInstanceStrong() throws
            java.security.NoSuchAlgorithmException {
        java.security.SecureRandom result = null;
        // WARNING: no state checks in static context
        /* body */ {
            final String propertyName = "securerandom.strongAlgorithms";
            final String property = Security.getProperty(propertyName);
            if (property == null) {
                throw new NoSuchAlgorithmException();
            }
            final int propertyLength = property.length();
            if (propertyLength == 0) {
                throw new NoSuchAlgorithmException();
            }
            final Provider resultProvider = Engine.makeSymbolic(Provider.class);
            final String resultAlgorithm = Engine.makeSymbolic(String.class);
            if (resultAlgorithm == null) {
                throw new NoSuchAlgorithmException();
            }
            result = (java.security.SecureRandom) ((Object) new SecureRandom((Void) null, 
                /* state = */ SecureRandom.__$lsl_States.Initialized, 
                /* provider = */ resultProvider, 
                /* algorithm = */ resultAlgorithm, 
                /* defaultProvider = */ _isDefaultProvider(resultProvider)
            ));
        }
        // WARNING: no state transitions in static context
        return result;
    }

    /**
     * [FUNCTION] SecureRandomAutomaton::getSeed(int) -> array<byte>
     * Source: java/security/SecureRandom.main.lsl:327
     */
    public static byte[] getSeed(int numBytes) {
        byte[] result = null;
        // WARNING: no state checks in static context
        /* body */ {
            if (numBytes < 0) {
                throw new IllegalArgumentException();
            }
            result = new byte[numBytes];
            _nextBytes(result, numBytes);
        }
        // WARNING: no state transitions in static context
        return result;
    }

    /**
     * [FUNCTION] SecureRandomAutomaton::doubles(SecureRandom) -> DoubleStream
     * Source: java/security/SecureRandom.main.lsl:339
     */
    public DoubleStream doubles() {
        DoubleStream result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = (DoubleStreamLSL) ((Object) new generated.java.util.stream.DoubleStreamLSL((Void) null, 
                /* state = */ generated.java.util.stream.DoubleStreamLSL.__$lsl_States.Initialized, 
                /* storage = */ _generateRandomDoubleArrayWithBounds(LibSLGlobals.MAX_RANDOM_STREAM_SIZE, 0, 1), 
                /* length = */ LibSLGlobals.MAX_RANDOM_STREAM_SIZE, 
                /* closeHandlers = */ Engine.makeSymbolicList(), 
                /* isParallel = */ false, 
                /* linkedOrConsumed = */ false
            ));
        }
        return result;
    }

    /**
     * [FUNCTION] SecureRandomAutomaton::doubles(SecureRandom, double, double) -> DoubleStream
     * Source: java/security/SecureRandom.main.lsl:350
     */
    public DoubleStream doubles(double randomNumberOrigin, double randomNumberBound) {
        DoubleStream result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (randomNumberOrigin >= randomNumberBound) {
                throw new IllegalArgumentException();
            }
            result = (DoubleStreamLSL) ((Object) new generated.java.util.stream.DoubleStreamLSL((Void) null, 
                /* state = */ generated.java.util.stream.DoubleStreamLSL.__$lsl_States.Initialized, 
                /* storage = */ _generateRandomDoubleArrayWithBounds(LibSLGlobals.MAX_RANDOM_STREAM_SIZE, randomNumberOrigin, randomNumberBound), 
                /* length = */ LibSLGlobals.MAX_RANDOM_STREAM_SIZE, 
                /* closeHandlers = */ Engine.makeSymbolicList(), 
                /* isParallel = */ false, 
                /* linkedOrConsumed = */ false
            ));
        }
        return result;
    }

    /**
     * [FUNCTION] SecureRandomAutomaton::doubles(SecureRandom, long) -> DoubleStream
     * Source: java/security/SecureRandom.main.lsl:363
     */
    public DoubleStream doubles(long streamSize) {
        DoubleStream result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            int size = ((int) streamSize);
            if (size < 0) {
                throw new IllegalArgumentException();
            }
            if (size > LibSLGlobals.MAX_RANDOM_STREAM_SIZE) {
                size = LibSLGlobals.MAX_RANDOM_STREAM_SIZE;
            }
            result = (DoubleStreamLSL) ((Object) new generated.java.util.stream.DoubleStreamLSL((Void) null, 
                /* state = */ generated.java.util.stream.DoubleStreamLSL.__$lsl_States.Initialized, 
                /* storage = */ Engine.makeSymbolicDoubleArray(size), 
                /* length = */ size, 
                /* closeHandlers = */ Engine.makeSymbolicList(), 
                /* isParallel = */ false, 
                /* linkedOrConsumed = */ false
            ));
        }
        return result;
    }

    /**
     * [FUNCTION] SecureRandomAutomaton::doubles(SecureRandom, long, double, double) -> DoubleStream
     * Source: java/security/SecureRandom.main.lsl:381
     */
    public DoubleStream doubles(long streamSize, double randomNumberOrigin,
            double randomNumberBound) {
        DoubleStream result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            int size = ((int) streamSize);
            if (size < 0) {
                throw new IllegalArgumentException();
            }
            if (randomNumberOrigin >= randomNumberBound) {
                throw new IllegalArgumentException();
            }
            if (size > LibSLGlobals.MAX_RANDOM_STREAM_SIZE) {
                size = LibSLGlobals.MAX_RANDOM_STREAM_SIZE;
            }
            result = (DoubleStreamLSL) ((Object) new generated.java.util.stream.DoubleStreamLSL((Void) null, 
                /* state = */ generated.java.util.stream.DoubleStreamLSL.__$lsl_States.Initialized, 
                /* storage = */ _generateRandomDoubleArrayWithBounds(size, randomNumberOrigin, randomNumberBound), 
                /* length = */ size, 
                /* closeHandlers = */ Engine.makeSymbolicList(), 
                /* isParallel = */ false, 
                /* linkedOrConsumed = */ false
            ));
        }
        return result;
    }

    /**
     * [FUNCTION] SecureRandomAutomaton::generateSeed(SecureRandom, int) -> array<byte>
     * Source: java/security/SecureRandom.main.lsl:400
     */
    public byte[] generateSeed(int numBytes) {
        byte[] result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (numBytes < 0) {
                throw new IllegalArgumentException();
            }
            result = new byte[numBytes];
            _nextBytes(result, numBytes);
        }
        return result;
    }

    /**
     * [FUNCTION] SecureRandomAutomaton::getAlgorithm(SecureRandom) -> String
     * Source: java/security/SecureRandom.main.lsl:410
     */
    public String getAlgorithm() {
        String result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = this.algorithm;
        }
        return result;
    }

    /**
     * [FUNCTION] SecureRandomAutomaton::getProvider(SecureRandom) -> Provider
     * Source: java/security/SecureRandom.main.lsl:416
     */
    public final Provider getProvider() {
        Provider result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = this.provider;
        }
        return result;
    }

    /**
     * [FUNCTION] SecureRandomAutomaton::ints(SecureRandom) -> IntStream
     * Source: java/security/SecureRandom.main.lsl:423
     */
    public IntStream ints() {
        IntStream result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = (IntStreamLSL) ((Object) new generated.java.util.stream.IntStreamLSL((Void) null, 
                /* state = */ generated.java.util.stream.IntStreamLSL.__$lsl_States.Initialized, 
                /* storage = */ Engine.makeSymbolicIntArray(LibSLGlobals.MAX_RANDOM_STREAM_SIZE), 
                /* length = */ LibSLGlobals.MAX_RANDOM_STREAM_SIZE, 
                /* closeHandlers = */ Engine.makeSymbolicList(), 
                /* isParallel = */ false, 
                /* linkedOrConsumed = */ false
            ));
        }
        return result;
    }

    /**
     * [FUNCTION] SecureRandomAutomaton::ints(SecureRandom, int, int) -> IntStream
     * Source: java/security/SecureRandom.main.lsl:434
     */
    public IntStream ints(int randomNumberOrigin, int randomNumberBound) {
        IntStream result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (randomNumberOrigin >= randomNumberBound) {
                throw new IllegalArgumentException();
            }
            result = (IntStreamLSL) ((Object) new generated.java.util.stream.IntStreamLSL((Void) null, 
                /* state = */ generated.java.util.stream.IntStreamLSL.__$lsl_States.Initialized, 
                /* storage = */ _generateRandomIntegerArrayWithBounds(LibSLGlobals.MAX_RANDOM_STREAM_SIZE, randomNumberOrigin, randomNumberBound), 
                /* length = */ LibSLGlobals.MAX_RANDOM_STREAM_SIZE, 
                /* closeHandlers = */ Engine.makeSymbolicList(), 
                /* isParallel = */ false, 
                /* linkedOrConsumed = */ false
            ));
        }
        return result;
    }

    /**
     * [FUNCTION] SecureRandomAutomaton::ints(SecureRandom, long) -> IntStream
     * Source: java/security/SecureRandom.main.lsl:447
     */
    public IntStream ints(long streamSize) {
        IntStream result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            int size = ((int) streamSize);
            if (size < 0) {
                throw new IllegalArgumentException();
            }
            if (size > LibSLGlobals.MAX_RANDOM_STREAM_SIZE) {
                size = LibSLGlobals.MAX_RANDOM_STREAM_SIZE;
            }
            result = (IntStreamLSL) ((Object) new generated.java.util.stream.IntStreamLSL((Void) null, 
                /* state = */ generated.java.util.stream.IntStreamLSL.__$lsl_States.Initialized, 
                /* storage = */ Engine.makeSymbolicIntArray(size), 
                /* length = */ size, 
                /* closeHandlers = */ Engine.makeSymbolicList(), 
                /* isParallel = */ false, 
                /* linkedOrConsumed = */ false
            ));
        }
        return result;
    }

    /**
     * [FUNCTION] SecureRandomAutomaton::ints(SecureRandom, long, int, int) -> IntStream
     * Source: java/security/SecureRandom.main.lsl:465
     */
    public IntStream ints(long streamSize, int randomNumberOrigin, int randomNumberBound) {
        IntStream result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            int size = ((int) streamSize);
            if (size < 0) {
                throw new IllegalArgumentException();
            }
            if (randomNumberOrigin >= randomNumberBound) {
                throw new IllegalArgumentException();
            }
            if (size > LibSLGlobals.MAX_RANDOM_STREAM_SIZE) {
                size = LibSLGlobals.MAX_RANDOM_STREAM_SIZE;
            }
            result = (IntStreamLSL) ((Object) new generated.java.util.stream.IntStreamLSL((Void) null, 
                /* state = */ generated.java.util.stream.IntStreamLSL.__$lsl_States.Initialized, 
                /* storage = */ _generateRandomIntegerArrayWithBounds(size, randomNumberOrigin, randomNumberBound), 
                /* length = */ size, 
                /* closeHandlers = */ Engine.makeSymbolicList(), 
                /* isParallel = */ false, 
                /* linkedOrConsumed = */ false
            ));
        }
        return result;
    }

    /**
     * [FUNCTION] SecureRandomAutomaton::longs(SecureRandom) -> LongStream
     * Source: java/security/SecureRandom.main.lsl:485
     */
    public LongStream longs() {
        LongStream result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = (LongStreamLSL) ((Object) new generated.java.util.stream.LongStreamLSL((Void) null, 
                /* state = */ generated.java.util.stream.LongStreamLSL.__$lsl_States.Initialized, 
                /* storage = */ Engine.makeSymbolicLongArray(LibSLGlobals.MAX_RANDOM_STREAM_SIZE), 
                /* length = */ LibSLGlobals.MAX_RANDOM_STREAM_SIZE, 
                /* closeHandlers = */ Engine.makeSymbolicList(), 
                /* isParallel = */ false, 
                /* linkedOrConsumed = */ false
            ));
        }
        return result;
    }

    /**
     * [FUNCTION] SecureRandomAutomaton::longs(SecureRandom, long) -> LongStream
     * Source: java/security/SecureRandom.main.lsl:496
     */
    public LongStream longs(long streamSize) {
        LongStream result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            int size = ((int) streamSize);
            if (size < 0) {
                throw new IllegalArgumentException();
            }
            if (size > LibSLGlobals.MAX_RANDOM_STREAM_SIZE) {
                size = LibSLGlobals.MAX_RANDOM_STREAM_SIZE;
            }
            result = (LongStreamLSL) ((Object) new generated.java.util.stream.LongStreamLSL((Void) null, 
                /* state = */ generated.java.util.stream.LongStreamLSL.__$lsl_States.Initialized, 
                /* storage = */ Engine.makeSymbolicLongArray(size), 
                /* length = */ size, 
                /* closeHandlers = */ Engine.makeSymbolicList(), 
                /* isParallel = */ false, 
                /* linkedOrConsumed = */ false
            ));
        }
        return result;
    }

    /**
     * [FUNCTION] SecureRandomAutomaton::longs(SecureRandom, long, long) -> LongStream
     * Source: java/security/SecureRandom.main.lsl:514
     */
    public LongStream longs(long randomNumberOrigin, long randomNumberBound) {
        LongStream result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (randomNumberOrigin >= randomNumberBound) {
                throw new IllegalArgumentException();
            }
            result = (LongStreamLSL) ((Object) new generated.java.util.stream.LongStreamLSL((Void) null, 
                /* state = */ generated.java.util.stream.LongStreamLSL.__$lsl_States.Initialized, 
                /* storage = */ _generateRandomLongArrayWithBounds(LibSLGlobals.MAX_RANDOM_STREAM_SIZE, randomNumberOrigin, randomNumberBound), 
                /* length = */ LibSLGlobals.MAX_RANDOM_STREAM_SIZE, 
                /* closeHandlers = */ Engine.makeSymbolicList(), 
                /* isParallel = */ false, 
                /* linkedOrConsumed = */ false
            ));
        }
        return result;
    }

    /**
     * [FUNCTION] SecureRandomAutomaton::longs(SecureRandom, long, long, long) -> LongStream
     * Source: java/security/SecureRandom.main.lsl:527
     */
    public LongStream longs(long streamSize, long randomNumberOrigin, long randomNumberBound) {
        LongStream result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            int size = ((int) streamSize);
            if (size < 0) {
                throw new IllegalArgumentException();
            }
            if (randomNumberOrigin >= randomNumberBound) {
                throw new IllegalArgumentException();
            }
            if (size > LibSLGlobals.MAX_RANDOM_STREAM_SIZE) {
                size = LibSLGlobals.MAX_RANDOM_STREAM_SIZE;
            }
            result = (LongStreamLSL) ((Object) new generated.java.util.stream.LongStreamLSL((Void) null, 
                /* state = */ generated.java.util.stream.LongStreamLSL.__$lsl_States.Initialized, 
                /* storage = */ _generateRandomLongArrayWithBounds(size, randomNumberOrigin, randomNumberBound), 
                /* length = */ size, 
                /* closeHandlers = */ Engine.makeSymbolicList(), 
                /* isParallel = */ false, 
                /* linkedOrConsumed = */ false
            ));
        }
        return result;
    }

    /**
     * [FUNCTION] SecureRandomAutomaton::nextBoolean(SecureRandom) -> boolean
     * Source: java/security/SecureRandom.main.lsl:547
     */
    public boolean nextBoolean() {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = Engine.makeSymbolicBoolean();
        }
        return result;
    }

    /**
     * [FUNCTION] SecureRandomAutomaton::nextBytes(SecureRandom, array<byte>) -> void
     * Source: java/security/SecureRandom.main.lsl:553
     */
    public void nextBytes(byte[] bytes) {
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            _nextBytes(bytes, bytes.length);
        }
    }

    /**
     * [FUNCTION] SecureRandomAutomaton::nextDouble(SecureRandom) -> double
     * Source: java/security/SecureRandom.main.lsl:566
     */
    public double nextDouble() {
        double result = 0.0d;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = Engine.makeSymbolicDouble();
            Engine.assume(0.0d <= result);
            Engine.assume(result < 1.0d);
        }
        return result;
    }

    /**
     * [FUNCTION] SecureRandomAutomaton::nextFloat(SecureRandom) -> float
     * Source: java/security/SecureRandom.main.lsl:576
     */
    public float nextFloat() {
        float result = 0.0f;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = Engine.makeSymbolicFloat();
            Engine.assume(0.0f <= result);
            Engine.assume(result < 1.0f);
        }
        return result;
    }

    /**
     * [FUNCTION] SecureRandomAutomaton::nextGaussian(SecureRandom) -> double
     * Source: java/security/SecureRandom.main.lsl:586
     */
    public synchronized double nextGaussian() {
        double result = 0.0d;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = Engine.makeSymbolicDouble();
            final boolean isNaN = result != result;
            Engine.assume(!isNaN);
        }
        return result;
    }

    /**
     * [FUNCTION] SecureRandomAutomaton::nextInt(SecureRandom) -> int
     * Source: java/security/SecureRandom.main.lsl:595
     */
    public int nextInt() {
        int result = 0;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = Engine.makeSymbolicInt();
        }
        return result;
    }

    /**
     * [FUNCTION] SecureRandomAutomaton::nextInt(SecureRandom, int) -> int
     * Source: java/security/SecureRandom.main.lsl:602
     */
    public int nextInt(int bound) {
        int result = 0;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (bound <= 0) {
                throw new IllegalArgumentException();
            }
            result = Engine.makeSymbolicInt();
            Engine.assume(0 <= result);
            Engine.assume(result < bound);
        }
        return result;
    }

    /**
     * [FUNCTION] SecureRandomAutomaton::nextLong(SecureRandom) -> long
     * Source: java/security/SecureRandom.main.lsl:615
     */
    public long nextLong() {
        long result = 0L;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = Engine.makeSymbolicLong();
        }
        return result;
    }

    /**
     * [FUNCTION] SecureRandomAutomaton::setSeed(SecureRandom, array<byte>) -> void
     * Source: java/security/SecureRandom.main.lsl:621
     */
    public synchronized void setSeed(byte[] seed) {
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (seed == null) {
                if (Engine.makeSymbolicBoolean()) {
                    throw new NullPointerException();
                }
            }
        }
    }

    /**
     * [FUNCTION] SecureRandomAutomaton::setSeed(SecureRandom, long) -> void
     * Source: java/security/SecureRandom.main.lsl:632
     */
    public void setSeed(long seed) {
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            Engine.assume(true);
        }
    }

    public static final class __$lsl_States {
        public static final byte Allocated = (byte) 0;

        public static final byte Initialized = (byte) 1;
    }

    @Approximate(SecureRandom.class)
    public static final class __hook {
        private __hook(Void o1, Void o2) {
            Engine.assume(false);
        }
    }
}
