package extra_service.model.bean;

public class ExtraService {
    private int idExtraService;
    private String nameExtraService;
    private double costExtraService;
    private int unitExtraService;
    private String statusExtraService;

    public ExtraService(int idExtraService, String nameExtraService, double costExtraService, int unitExtraService, String statusExtraService) {
        this.idExtraService = idExtraService;
        this.nameExtraService = nameExtraService;
        this.costExtraService = costExtraService;
        this.unitExtraService = unitExtraService;
        this.statusExtraService = statusExtraService;
    }

    public int getIdExtraService() {
        return idExtraService;
    }

    public void setIdExtraService(int idExtraService) {
        this.idExtraService = idExtraService;
    }

    public String getNameExtraService() {
        return nameExtraService;
    }

    public void setNameExtraService(String nameExtraService) {
        this.nameExtraService = nameExtraService;
    }

    public double getCostExtraService() {
        return costExtraService;
    }

    public void setCostExtraService(double costExtraService) {
        this.costExtraService = costExtraService;
    }

    public int getUnitExtraService() {
        return unitExtraService;
    }

    public void setUnitExtraService(int unitExtraService) {
        this.unitExtraService = unitExtraService;
    }

    public String getStatusExtraService() {
        return statusExtraService;
    }

    public void setStatusExtraService(String statusExtraService) {
        this.statusExtraService = statusExtraService;
    }
}
