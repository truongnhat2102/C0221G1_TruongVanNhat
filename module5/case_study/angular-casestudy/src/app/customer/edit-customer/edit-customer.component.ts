import {Component, Inject, OnInit} from '@angular/core';
import {CustomerService} from '../../service/customer.service';
import {FormControl, FormGroup} from '@angular/forms';
import {MAT_DIALOG_DATA, MatDialog} from '@angular/material/dialog';
import {Customer} from '../../model/customer';

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css']
})
export class EditCustomerComponent implements OnInit {

  id: string;

  customerForm: FormGroup;
  customer: Customer;

  constructor(private customerService: CustomerService,
              private dialogRef: MatDialog,
              @Inject(MAT_DIALOG_DATA) data) {
    this.id = data.id;
    this.getTodo();
    console.log(this.customer);
  }

  ngOnInit(): void {
  }

  getTodo() {
    return this.customerService.findById(this.id).subscribe(customer => {
      this.customerForm = new FormGroup({
        id:  new FormControl(customer.id),
        name: new FormControl(customer.name),
        email: new FormControl(customer.email),
        phone: new FormControl(customer.phone),
        dateOfBirth: new FormControl(customer.dateOfBirth),
        idCard: new FormControl(customer.idCard),
        gender: new FormControl(customer.gender),
        idTypeCustomer: new FormControl(customer.idTypeCustomer)
      });
    });
  }

  update() {
    const customer = this.customerForm.value;
    this.customerService.updateCustomer(this.id, customer).subscribe(() => {
      alert('success');
    }, e => {
      console.log(e);
    });
  }

  close() {
    this.dialogRef.closeAll();
  }

}
