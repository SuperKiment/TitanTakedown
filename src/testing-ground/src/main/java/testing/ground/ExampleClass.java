package testing.ground;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class ExampleClass {

    String name;
    String id = "ocuou";
    int hp;
    float idk;

    @JsonIdentityReference(alwaysAsId = true)
    public ExampleClass parent;

    @JsonIdentityReference(alwaysAsId = true)
    public ExampleClass enfant;

    ExampleClass() {
    }
}