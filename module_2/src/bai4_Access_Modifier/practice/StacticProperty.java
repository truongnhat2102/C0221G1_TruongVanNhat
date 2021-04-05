package bai4_Access_Modifier.practice;

public class StacticProperty {
    private String name;

    private String engine;


    public static int numberOfCars;


    public StacticProperty(String name, String engine) {

        this.name = name;

        this.engine = engine;

        numberOfCars++;

    }
}
