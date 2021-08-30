package com.example.demo.model.entity.export_bill;
import com.example.demo.model.entity.import_bill_payment.ImportBillDrug;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "export_bill_detail")
public class ExportBillDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exportBillDetailId;
    @ManyToOne
    @JoinColumn(name = "export_bill_id")
    private ExportBill exportBill;

    @OneToOne
    @JoinColumn(name = "import_bill_drug_id")
    private ImportBillDrug importBillDrug;

    public Long getExportBillDetailId() {
        return exportBillDetailId;
    }

    public void setExportBillDetailId(Long exportBillDetailId) {
        this.exportBillDetailId = exportBillDetailId;
    }

    public ExportBill getExportBill() {
        return exportBill;
    }

    public void setExportBill(ExportBill exportBill) {
        this.exportBill = exportBill;
    }

    public ImportBillDrug getImportBillDrug() {
        return importBillDrug;
    }

    public void setImportBillDrug(ImportBillDrug importBillDrug) {
        this.importBillDrug = importBillDrug;
    }
}
