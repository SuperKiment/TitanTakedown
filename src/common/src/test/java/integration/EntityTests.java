package integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.superkiment.ttd.common.entity.Entity;
import com.superkiment.ttd.common.types.KVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("integration")
public class EntityTests {

    @Test
    void recupJSON() {
        Entity e = new Entity();
        e.setSpeed(1f);
        e.setId("abc");
        e.setPos(new KVector(1, 5));

        ObjectMapper mapper = new ObjectMapper();

        try {
            String json = mapper.writeValueAsString(e);
            assertEquals(json, "{\"id\":\"abc\",\"speed\":1.0,\"pos\":{\"x\":1.0,\"y\":5.0,\"z\":0.0},\"dir\":{\"x\":0.0,\"y\":0.0,\"z\":0.0},\"remanantDir\":{\"x\":0.0,\"y\":0.0,\"z\":0.0}}");
        } catch (Exception exception) {
            System.out.println(exception);
            Assertions.fail();
        }

    }
}
