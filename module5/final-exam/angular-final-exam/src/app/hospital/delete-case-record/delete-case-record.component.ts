import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog} from "@angular/material/dialog";
import {HospitalService} from "../../service/hospital.service";

@Component({
  selector: 'app-delete-case-record',
  templateUrl: './delete-case-record.component.html',
  styleUrls: ['./delete-case-record.component.css']
})
export class DeleteCaseRecordComponent implements OnInit {

  id: string;

  namePatient: string;

  constructor(private hospitalService: HospitalService,
              private dialogRef: MatDialog,
              @Inject(MAT_DIALOG_DATA) data) {
    this.id = data.id;
    this.getTodo();
    console.log(this.id);
  }

  ngOnInit(): void {
  }

  getTodo() {
    return this.hospitalService.findRecordById(this.id).subscribe(caseRecord => {
      this.namePatient = caseRecord.namePatient;
    });
  }

  delete() {
    this.hospitalService.deleteRecord(this.id).subscribe(() => {
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
