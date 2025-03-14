package testing.ground;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

@Data
public class ExampleClass {


    String name;
    Long id;
    int hp;
    float idk;

    @JsonBackReference
    public ExampleClass parent;

    @JsonManagedReference
    public ExampleClass enfant;

    ExampleClass() {
    }
}




