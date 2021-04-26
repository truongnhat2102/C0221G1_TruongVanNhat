package furama_resort.models;

public class Villa extends House {
    private String poorArea;

    public Villa(String id, String name, String areaUse, String cost, String maxPeople, String rentType, String standardRoom, String description, String floors, String poorArea) {
        super(id, name, areaUse, cost, maxPeople, rentType, standardRoom, description, floors);
        this.poorArea = poorArea;
    }

    @Override
    void showInfor() {
        super.showInfor();
    }

    public String getPoorArea() {
        return poorArea;
    }

    public void setPoorArea(String poorArea) {
        this.poorArea = poorArea;
    }
}
