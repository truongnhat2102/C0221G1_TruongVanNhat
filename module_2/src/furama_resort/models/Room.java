package furama_resort.models;

public class Room extends Services {
    private String freeService;

    @Override
    public void showInfor() {
        super.showInfor();
    }

    public Room(String id, String name, String areaUse, String cost, String maxPeople, String rentType, String freeService) {
        super(id, name, areaUse, cost, maxPeople, rentType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

}
