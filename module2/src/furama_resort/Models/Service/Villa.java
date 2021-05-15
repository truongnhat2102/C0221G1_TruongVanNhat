package furama_resort.Models.Service;

public class Villa extends Service{
    private String roomStandard;
    private String anotherFacility;
    private String poolArea;
    private String floor;

    public Villa(String id, String name, String area, String price, String maxPeople, String typeOfRent, String roomStandard, String anotherFacility, String poolArea, String floor) {
        super(id, name, area, price, maxPeople, typeOfRent);
        this.roomStandard = roomStandard;
        this.anotherFacility = anotherFacility;
        this.poolArea = poolArea;
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

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
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
                ", poolArea='" + poolArea + '\'' +
                ", floor='" + floor + '\'' +
                '}';
    }

    @Override
    public String toString() {
        return super.toString() +
                "," + roomStandard +
                "," + anotherFacility +
                "," + poolArea +
                "," + floor;
    }
}
