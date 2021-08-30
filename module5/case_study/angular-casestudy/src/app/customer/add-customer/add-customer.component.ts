import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {CustomerService} from '../../service/customer.service';
import {MatDialog, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})
export class AddCustomerComponent implements OnInit {

  customerForm: FormGroup = new FormGroup({
    name: new FormControl(),
    email: new FormControl(),
    phone: new FormControl(),
    dateOfBirth: new FormControl(),
    idCard: new FormControl(),
    gender: new FormControl(),
    idTypeCustomer: new FormControl()
  });

  constructor(private customerService: CustomerService,
              private dialogRef: MatDialog) { }

  ngOnInit(): void {
  }


  save() {
    const customer = this.customerForm.value;
    this.customerService.saveCustomer(customer).subscribe(() => {
      this.customerForm.reset();
      alert('success');
    }, e => {
      console.log(e);
    });
  }

  close() {
    this.dialogRef.closeAll();
  }

}
