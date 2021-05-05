package furama_resort.Models.Service;

public class House extends Service{
    private String roomStandard;
    private String anotherFacility;
    private String floor;


    public House(String id, String name, String area, String price, String maxPeople, String typeOfRent, String roomStandard, String anotherFacility, String floor) {
        super(id, name, area, price, maxPeople, typeOfRent);
        this.roomStandard = roomStandard;
        this.anotherFacility = anotherFacility;
        this.floor = floor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getAnotherFacility() {
        return anotherFacility;
    }

    public void setAnotherFacility(String anotherFacility) {
        this.anotherFacility = anotherFacility;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String showInfor() {
        return "Villa{" +
                "id='" + this.getId() + '\'' +
                "name='" + this.getName() + '\'' +
                ", area='" + this.getArea() + '\'' +
                ", price='" + this.getPrice() + '\'' +
                ", maxPeople='" + this.getMaxPeople() + '\'' +
                ", typeOfRent='" + this.getTypeOfRent() + '\'' +
                ", roomStandard='" + roomStandard + '\'' +
                ", anotherFacility='" + anotherFacility + '\'' +
                ", floor='" + floor + '\'' +
                '}';
    }

    @Override
    public String toString() {
        return super.toString() +
                "," + roomStandard +
                "," + anotherFacility +
                "," + floor;
    }
}
