package encoders.java.util;

import generated.java.util.AbstractListImpl;
import org.usvm.api.encoder.EncoderFor;
import org.usvm.api.encoder.ObjectEncoder;

import java.util.ArrayList;

@EncoderFor(ArrayList.class)
public class ArrayList_Encoder implements ObjectEncoder {

    @Override
    public Object encode(Object list) {
        AbstractListImpl result = new AbstractListImpl();
        result.addAll(((ArrayList<?>) list).stream().toList());
        return result;
    }
}
