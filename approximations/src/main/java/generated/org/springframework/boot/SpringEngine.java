package generated.org.springframework.boot;

import java.util.ArrayList;
import java.util.List;

public class SpringEngine {
    public static void _println(String message) { }

    public static void _internalLog(String... message) {
        for (String str : message) {
            _println(str);
        }
    }

    public static void _startAnalysis() { }

    public static void _endAnalysis() { }

    public static List<List<Object>> _allControllerPaths() {
        return new ArrayList<>();
    }

    public static boolean _isSecurityEnabled() { throw new IllegalStateException("This method must be approximated!"); }
}
