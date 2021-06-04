package service.model.bean;

public class Service {
    private int id;
    private String name;
    private int area;
    private double cost;
    private int maxPeople;
    private int idTypeService;
    private String nameTypeService;
    private int idTypeRent;
    private String nameTypeRent;
    private String standardRoom;
    private String description;
    private double poolArea;
    private int floor;

    public Service(int id, String name, int area, double cost, int maxPeople, int idTypeService, String nameTypeService, int idTypeRent, String nameTypeRent, String standardRoom, String description, double poolArea, int floor) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.idTypeService = idTypeService;
        this.nameTypeService = nameTypeService;
        this.idTypeRent = idTypeRent;
        this.nameTypeRent = nameTypeRent;
        this.standardRoom = standardRoom;
        this.description = description;
        this.poolArea = poolArea;
        this.floor = floor;
    }

    public Service(String name, int area, double cost, int maxPeople, int idTypeService, int idTypeRent, String standardRoom, String description, double poolArea, int floor) {
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.idTypeService = idTypeService;
        this.idTypeRent = idTypeRent;
        this.standardRoom = standardRoom;
        this.description = description;
        this.poolArea = poolArea;
        this.floor = floor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public int getIdTypeService() {
        return idTypeService;
    }

    public void setIdTypeService(int idTypeService) {
        this.idTypeService = idTypeService;
    }

    public String getNameTypeService() {
        return nameTypeService;
    }

    public void setNameTypeService(String nameTypeService) {
        this.nameTypeService = nameTypeService;
    }

    public int getIdTypeRent() {
        return idTypeRent;
    }

    public void setIdTypeRent(int idTypeRent) {
        this.idTypeRent = idTypeRent;
    }

    public String getNameTypeRent() {
        return nameTypeRent;
    }

    public void setNameTypeRent(String nameTypeRent) {
        this.nameTypeRent = nameTypeRent;
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

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
