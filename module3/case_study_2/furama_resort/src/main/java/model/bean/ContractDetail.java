package model.bean;

public class ContractDetail {
    private int idContractDetail;
    private Contract contract;
    private ExtraService extraService;
    private int quantity;

    public ContractDetail(int idContractDetail, Contract contract, ExtraService extraService, int quantity) {
        this.idContractDetail = idContractDetail;
        this.contract = contract;
        this.extraService = extraService;
        this.quantity = quantity;
    }

    public int getIdContractDetail() {
        return idContractDetail;
    }

    public void setIdContractDetail(int idContractDetail) {
        this.idContractDetail = idContractDetail;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public ExtraService getExtraService() {
        return extraService;
    }

    public void setExtraService(ExtraService extraService) {
        this.extraService = extraService;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
