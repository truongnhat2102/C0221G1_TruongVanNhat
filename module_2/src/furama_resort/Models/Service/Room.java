package furama_resort.Models.Service;

public class Room extends Service{
    private String freeService;

    public Room(String id, String name, String area, String price, String maxPeople, String typeOfRent, String freeService) {
        super(id, name, area, price, maxPeople, typeOfRent);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    public String showInfor() {
        return "Villa{" +
                "id='" + this.getId() + '\'' +
                "name='" + this.getName() + '\'' +
                ", area='" + this.getArea() + '\'' +
                ", price='" + this.getPrice() + '\'' +
                ", maxPeople='" + this.getMaxPeople() + '\'' +
                ", typeOfRent='" + this.getTypeOfRent() + '\'' +
                ", freeService='" + freeService + '\'' +
                '}';
    }

    @Override
    public String toString() {
        return super.toString() +
                "," + freeService;
    }
}
