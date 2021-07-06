package com.furama_resort.model.entity.contract_detail;

import com.furama_resort.model.entity.contract.Contract;

import javax.persistence.*;

@Entity
@Table(name = "contract_detail")
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long contractDetailId;
    private int quantity;

    @OneToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;

    @OneToOne
    @JoinColumn(name = "attach_service_id")
    private AttachService attachService;

    public long getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(long contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }
}
