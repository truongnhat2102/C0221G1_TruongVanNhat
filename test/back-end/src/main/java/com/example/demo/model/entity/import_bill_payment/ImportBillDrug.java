package com.example.demo.model.entity.import_bill_payment;

import com.example.demo.model.entity.drug.Drug;
import com.example.demo.model.entity.export_bill.ExportBillDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "import_bill_drug")
public class ImportBillDrug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long ImportBillDrugId;
    Integer importAmount;
    Double importPrice;
    Integer discountRate;
    Integer lotNumber ;
    Date expiry ;
    Integer vat;
    private Boolean flag=true;
    @ManyToOne
    @JoinColumn(name = "import_bill_id")

    ImportBill importBill;
    @ManyToOne
    @JoinColumn(name = "drug_id")
    Drug drug;
    @OneToOne(mappedBy = "importBillDrug")
    private ExportBillDetail exportBillDetail;
}
