package bai4_Access_Modifier.practice;

public class TestStacticProperty {
    public static void main(String[] args) {

        StacticProperty car1 = new StacticProperty("Mazda 3", "Skyactiv 3");

        System.out.println(StacticProperty.numberOfCars);

        StacticProperty car2 = new StacticProperty("Mazda 6", "Skyactiv 6");

        System.out.println(StacticProperty.numberOfCars);

    }

}
