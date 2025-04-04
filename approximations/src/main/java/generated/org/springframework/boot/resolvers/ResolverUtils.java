package generated.org.springframework.boot.resolvers;

import generated.org.springframework.boot.pinnedValues.PinnedValueSource;
import generated.org.springframework.boot.pinnedValues.PinnedValueStorage;
import org.usvm.api.Engine;

public class ResolverUtils {
    public static String getNonEmptySymbolicString(PinnedValueSource source, String name){
        String string = PinnedValueStorage.getPinnedValue(source, name, String.class);
        Engine.assume(string != null);
        Engine.assume(!string.isEmpty());
        return string;
    }
}
