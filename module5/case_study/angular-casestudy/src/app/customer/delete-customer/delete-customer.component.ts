import {Component, Inject, OnInit} from '@angular/core';
import {CustomerService} from '../../service/customer.service';
import {FormControl, FormGroup} from '@angular/forms';
import {MAT_DIALOG_DATA, MatDialog} from '@angular/material/dialog';

@Component({
  selector: 'app-delete-customer',
  templateUrl: './delete-customer.component.html',
  styleUrls: ['./delete-customer.component.css']
})
export class DeleteCustomerComponent implements OnInit {
  id: string;

  name: string;

  constructor(private customerService: CustomerService,
              private dialogRef: MatDialog,
              @Inject(MAT_DIALOG_DATA) data) {
    this.id = data.id;
    this.getTodo();
    console.log(this.id);
  }

  ngOnInit(): void {
  }

  getTodo() {
    return this.customerService.findById(this.id).subscribe(customer => {
      this.name = customer.name;
    });
  }

  delete() {
    this.customerService.deleteCustomer(this.id).subscribe(() => {
      alert('success');
    }, e => {
      console.log(e);
    });
  }

  close() {
    this.dialogRef.closeAll();
  }
}
