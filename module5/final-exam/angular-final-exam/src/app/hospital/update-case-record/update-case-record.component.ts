import {Component, Inject, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {CaseRecord} from "../../model/case-record";
import {MAT_DIALOG_DATA, MatDialog} from "@angular/material/dialog";
import {HospitalService} from "../../service/hospital.service";

@Component({
  selector: 'app-update-case-record',
  templateUrl: './update-case-record.component.html',
  styleUrls: ['./update-case-record.component.css']
})
export class UpdateCaseRecordComponent implements OnInit {

  idRecord: string;

  recordForm: FormGroup;
  caseRecord: CaseRecord;

  constructor(private hospitalService: HospitalService,
              private dialogRef: MatDialog,
              @Inject(MAT_DIALOG_DATA) data) {
    this.idRecord = data.id;
    this.getTodo();
    console.log(this.caseRecord);
  }

  ngOnInit(): void {
  }

  getTodo() {
    return this.hospitalService.findRecordById(this.idRecord).subscribe(caseRecord => {
      this.recordForm = new FormGroup({
        idCaseRecord:  new FormControl(caseRecord.idCaseRecord, [Validators.required,Validators.pattern(/^[a-zA-Z ,.'-]+$/)]),
        idPatient:  new FormControl(caseRecord.idPatient),
        namePatient:  new FormControl(caseRecord.namePatient),
        dateOfAdmit:  new FormControl(caseRecord.dateOfAdmit),
        dateOfDischarge:  new FormControl(caseRecord.dateOfDischarge),
        reason:  new FormControl(caseRecord.reason),
        methodOfTreatment:  new FormControl(caseRecord.methodOfTreatment),
        doctor:  new FormControl(caseRecord.doctor)
      });
    });
  }

  update() {
    const caseRecord = this.recordForm.value;
    this.hospitalService.updateRecord(this.idRecord, caseRecord).subscribe(() => {
      alert('success');
      window.location.reload();
    }, e => {
      console.log(e);
    });
  }

  close() {
    this.dialogRef.closeAll();
    window.location.reload();
  }

}
