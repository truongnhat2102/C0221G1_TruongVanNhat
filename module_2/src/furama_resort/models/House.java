package furama_resort.models;

public class House extends Services {
    private String standardRoom;
    private String description;
    private String floors;

    @Override
    public void showInfor() {
        super.showInfor();
    }

    public House(String id, String name, String areaUse, String cost, String maxPeople, String rentType, String standardRoom, String description, String floors) {
        super(id, name, areaUse, cost, maxPeople, rentType);
        this.standardRoom = standardRoom;
        this.description = description;
        this.floors = floors;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFloors() {
        return floors;
    }

    public void setFloors(String floors) {
        this.floors = floors;
    }
}
