package encoders.java.util;

import org.usvm.api.encoder.EncoderFor;
import org.usvm.api.encoder.ObjectEncoder;

import java.util.HashMap;

@EncoderFor(HashMap.class)
public class HashMap_Encoder implements ObjectEncoder {

    @Override
    public Object encode(Object object) {
        HashMap<?, ?> map = (HashMap<?, ?>) object;
        return new generated.java.util.HashMap(map);
    }
}
