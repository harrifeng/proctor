package com.indeed.proctor.webapp.tags;

import com.indeed.proctor.common.PayloadType;
import com.indeed.proctor.common.Serializers;
import com.indeed.proctor.common.model.Payload;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * @author pwp
 */

public class PayloadFunctions {
    private static final ObjectMapper OBJECT_MAPPER = Serializers.strict();
    private static final String[] PROCTOR_PAYLOAD_TYPES = PayloadType.allTypeNames().toArray(new String[PayloadType.allTypeNames().size()]);

    /**
     * If o is a proctor Payload object, then print just the contents of the payload, otherwise just pretty print the object.
     */
    public static String prettyPrintJSONPayloadContents(Object o) throws IOException, JsonGenerationException, JsonMappingException {
        if (o != null && o instanceof Payload) {
            Payload p = (Payload) o;
            return OBJECT_MAPPER.defaultPrettyPrintingWriter().writeValueAsString(p.fetchAValue());
        } else {
            return OBJECT_MAPPER.defaultPrettyPrintingWriter().writeValueAsString(o);
        }
    }

    /**
     * If o is a proctor Payload object, then return its type as a string, otherwise return "none".
     */
    public static String printPayloadType(Object o) throws IOException, JsonGenerationException, JsonMappingException {
        if (o != null && o instanceof Payload) {
            Payload p = (Payload) o;
            return p.fetchType();
        } else {
            return "none";
        }
    }

    public static String[] allPayloadTypeStrings() {
        return PROCTOR_PAYLOAD_TYPES;
    }
}
