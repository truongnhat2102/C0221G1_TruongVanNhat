import { Component, OnInit } from '@angular/core';
import {MatDialog, MatDialogConfig} from '@angular/material/dialog';
import {HospitalService} from "../service/hospital.service";
import {CaseRecord} from "../model/case-record";
import {UpdateCaseRecordComponent} from "./update-case-record/update-case-record.component";
import {DeleteCaseRecordComponent} from "./delete-case-record/delete-case-record.component";

@Component({
  selector: 'app-hospital',
  templateUrl: './hospital.component.html',
  styleUrls: ['./hospital.component.css']
})
export class HospitalComponent implements OnInit {

  recordList: CaseRecord[] = [];

  constructor(private hospitalService: HospitalService,
              private dialog: MatDialog ) { }

  ngOnInit(): void {
    this.getAllRecord();
  }

  getAllRecord() {
    this.hospitalService.getAllCaseRecord().subscribe( records => {
      this.recordList = records;
    });
  }

  openDialogEdit(id: number): void {
    const dialogConfig = new MatDialogConfig();

    dialogConfig.data = {id};
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;

    this.dialog.open(UpdateCaseRecordComponent, dialogConfig);
  }

  openDialogDelete(id: number): void {
    const dialogConfig = new MatDialogConfig();

    dialogConfig.data = {id};
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;

    this.dialog.open(DeleteCaseRecordComponent, dialogConfig);
  }

}
