package encoders.java.util;

import org.usvm.api.encoder.EncoderFor;
import org.usvm.api.encoder.ObjectEncoder;

@EncoderFor(java.lang.String.class)
public class String_Encoder implements ObjectEncoder {

    @Override
    public Object encode(Object object) {
        return new generated.java.lang.String(((String) object).getBytes());
    }
}
