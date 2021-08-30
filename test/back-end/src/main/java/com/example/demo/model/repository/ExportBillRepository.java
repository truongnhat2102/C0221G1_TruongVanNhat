package com.example.demo.model.repository;


import com.example.demo.model.entity.export_bill.ExportBill;
import com.example.demo.model.entity.export_bill.ExportBillDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExportBillRepository extends JpaRepository<ExportBill, Long> {
    @Query(value = "select export_bill_code from export_bill ",nativeQuery  = true)
    List<String> getAllExportBillCode();

    //List
    @Query(value = "select * from export_bill ORDER BY ?#{#pageable}",
            countQuery = "select count(*) from export_bill",
            nativeQuery = true)
    Page<ExportBill> getAllExportBill(Pageable pageable);

    @Query(value = "select * from export_bill where flag = true and export_bill_id = ?1", nativeQuery = true)
    ExportBill getExportBillById(long id);

    @Query(value = "update export_bill set flag = false where export_bill_id = ?1", nativeQuery = true)
    void deleteExportBillById(long id);

    @Query(value = "select * from export_bill where cast(export_bill.export_bill_date as time) > cast(?1 as time) and cast(export_bill.export_bill_date as time) < cast(?2 as time) ORDER BY ?#{#pageable}",
            countQuery = "select count(*) from export_bill where cast(export_bill.export_bill_date as time) > cast(?1 as time) and cast(export_bill.export_bill_date as time) < cast(?2 as time)",
            nativeQuery = true)
    Page<ExportBill> findByTimeFields1(String timeCreate, String toTime, Pageable pageable);

    @Query(value = "select * from export_bill where cast(export_bill.export_bill_date as time) > cast(?1 as time) and cast(export_bill.export_bill_date as time) < cast(?2 as time) in (select export_bill_date from export_bill where cast(export_bill.export_bill_date as date) = ?3;) ORDER BY ?#{#pageable};",
            countQuery = "select count(*) from export_bill where cast(export_bill.export_bill_date as time) > cast(?1 as time) and cast(export_bill.export_bill_date as time) < cast(?2 as time) in (select export_bill_date from export_bill where cast(export_bill.export_bill_date as date) = ?3 ;",
            nativeQuery = true)
    Page<ExportBill> findByTimeFieldsWith1Day1(String timeCreate, String toTime, String dateCreate, Pageable pageable);

    @Query(value = "select * from export_bill where cast(export_bill.export_bill_date as date) > cast(?1 as date) and cast(export_bill.export_bill_date as date) < cast(?2 as date);",
            countQuery = "select count(*) from export_bill where cast(export_bill.export_bill_date as date) > cast(?1 as date) and cast(export_bill.export_bill_date as date) < cast(?2 as date);",
            nativeQuery = true)
    Page<ExportBill> findByDateFields1(String dateCreate, String toDate, Pageable pageable);

    @Query(value = "select * from export_bill where cast(export_bill.export_bill_date as date) > cast(?1 as date) and cast(export_bill.export_bill_date as date) < cast(?2 as date) in (select * from export_bill where and cast(export_bill.export_bill_date as time) = ?3;) ORDER BY ?#{#pageable};",
            countQuery = "select count(*) from export_bill where cast(export_bill.export_bill_date as date) > cast(?1 as date) and cast(export_bill.export_bill_date as date) < cast(?2 as date) in (select * from export_bill where and cast(export_bill.export_bill_date as time) = ?3;);",
            nativeQuery = true)
    Page<ExportBill> findByDateFieldsWith1Time1(String dateCreate, String toDate, String timeCreate, Pageable pageable);

    @Query(value = "select * from export_bill where cast(export_bill.export_bill_date as time) > cast(?3 as time) and cast(export_bill.export_bill_date as time) < cast(?4 as time) and cast(export_bill.export_bill_date as date) > cast(?1 as date) and cast(export_bill.export_bill_date as date) < cast(?2 as date) ORDER BY ?#{#pageable};",
            countQuery = "select count(*) from export_bill where cast(export_bill.export_bill_date as time) > cast(?3 as time) and cast(export_bill.export_bill_date as time) < cast(?4 as time) and cast(export_bill.export_bill_date as date) > cast(?1 as date) and cast(export_bill.export_bill_date as date) < cast(?2 as date);",
            nativeQuery = true)
    Page<ExportBill> findBy4Fields1(String dateCreate, String toDate, String timeCreate, String toTime, Pageable pageable);

    @Query(value = "select * from export_bill where cast(export_bill.export_bill_date as time) > cast(?1 as time) and cast(export_bill.export_bill_date as time) < cast(?2 as time) in (select export_bill_type_id from export_bill where export_bill.export_bill_type_id like ?3) ORDER BY ?#{#pageable};",
            countQuery = "select count(*) from export_bill where cast(export_bill.export_bill_date as time) > cast(?1 as time) and cast(export_bill.export_bill_date as time) < cast(?2 as time) in (select export_bill_type_id from export_bill where export_bill.export_bill_type_id like ?3);",
            nativeQuery = true)
    Page<ExportBill> findByTimeFields2(String timeCreate, String toTime, long typeId, Pageable pageable);

    @Query(value = "select * from export_bill where cast(export_bill.export_bill_date as time) > cast(?1 as time) and cast(export_bill.export_bill_date as time) < cast(?2 as time) in (select export_bill_type_id from export_bill where export_bill.export_bill_type_id like ?4 and cast(export_bill.export_bill_date as date) = ?3;) ORDER BY ?#{#pageable};",
            countQuery = "select count(*) from export_bill where cast(export_bill.export_bill_date as time) > cast(?1 as time) and cast(export_bill.export_bill_date as time) < cast(?2 as time) in (select export_bill_type_id from export_bill where export_bill.export_bill_type_id like ?4 and cast(export_bill.export_bill_date as date) = ?3;);",
            nativeQuery = true)
    Page<ExportBill> findByTimeFieldsWith1Day2(String timeCreate, String toTime, String dateCreate, long typeId, Pageable pageable);

    @Query(value = "select * from export_bill where cast(export_bill.export_bill_date as date) > cast(?1 as date) and cast(export_bill.export_bill_date as date) < cast(?2 as date) in (select * from export_bill where export_bill.export_bill_type_id like ?3) ORDER BY ?#{#pageable};",
            countQuery = "select count(*) from export_bill where cast(export_bill.export_bill_date as date) > cast(?1 as date) and cast(export_bill.export_bill_date as date) < cast(?2 as date) in (select bill_type_id from export_bill where export_bill.export_bill_type_id like ?3);",
            nativeQuery = true)
    Page<ExportBill> findByDateFields2(String dateCreate, String toDate, long typeId, Pageable pageable);

    @Query(value = "select * from export_bill where cast(export_bill.export_bill_date as date) > cast(?1 as date) and cast(export_bill.export_bill_date as date) < cast(?2 as date) in (select * from export_bill where export_bill.export_bill_type_id like ?4 and cast(export_bill.export_bill_date as time) = ?3;) ORDER BY ?#{#pageable};",
            countQuery = "select count(*) from export_bill where cast(export_bill.export_bill_date as date) > cast(?1 as date) and cast(export_bill.export_bill_date as date) < cast(?2 as date) in (select export_bill_type_id from export_bill where export_bill.export_bill_type_id = ?4 and cast(export_bill.export_bill_date as time) = ?3;);",
            nativeQuery = true)
    Page<ExportBill> findByDateFieldsWith1Time2(String dateCreate, String toDate, String timeCreate, long typeId, Pageable pageable);

    @Query(value = "select * from export_bill where cast(export_bill.export_bill_date as time) > cast(?3 as time) and cast(export_bill.export_bill_date as time) < cast(?4 as time) and cast(export_bill.export_bill_date as date) > cast(?1 as date) and cast(export_bill.export_bill_date as date) < cast(?2 as date) in (select export_bill_type_id from export_bill where export_bill.export_bill_type_id like ?5) ORDER BY ?#{#pageable};",
            countQuery = "select count(*) from export_bill where cast(export_bill.export_bill_date as time) > cast(?3 as time) and cast(export_bill.export_bill_date as time) < cast(?4 as time) and cast(export_bill.export_bill_date as date) > cast(?1 as date) and cast(export_bill.export_bill_date as date) < cast(?2 as date) in (select export_bill_type_id from export_bill where export_bill.export_bill_type_id like ?5);",
            nativeQuery = true)
    Page<ExportBill> findBy4Fields2(String dateCreate, String toDate, String timeCreate, String toTime, long typeId, Pageable pageable);

    @Query(value = "select * from export_bill where export_bill.export_bill_type_id like ?1;",
            countQuery = "select count(*) from export_bill where export_bill.export_bill_type_id like ?1;",
            nativeQuery = true)
    Page<ExportBill> findByType2(long typeId, Pageable pageable);
}
