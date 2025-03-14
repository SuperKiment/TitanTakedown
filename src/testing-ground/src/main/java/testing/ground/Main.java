package testing.ground;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!\n");

        ExampleClass par = new ExampleClass();
        ExampleClass enf = new ExampleClass();

        par.setEnfant(enf);
        enf.setParent(par);

        ObjectMapper mapper = new ObjectMapper();
        try {

            String json = mapper.writeValueAsString(par);
            System.out.println(json);
            System.out.println();

            String json2 = mapper.writeValueAsString(enf);
            System.out.println(json2);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}