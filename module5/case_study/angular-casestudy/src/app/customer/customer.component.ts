import {Component, Injectable, OnInit} from '@angular/core';
import {Customer} from '../model/customer';
import {CustomerService} from '../service/customer.service';
import {MatDialog, MatDialogConfig} from '@angular/material/dialog';
import {AddCustomerComponent} from './add-customer/add-customer.component';
import {EditCustomerComponent} from './edit-customer/edit-customer.component';
import {DeleteCustomerComponent} from './delete-customer/delete-customer.component';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css'],
})
@Injectable()
export class CustomerComponent implements OnInit {


  constructor(private customerService: CustomerService,
              private dialog: MatDialog ) { }

  customerList: Customer[] = [];
  customerList1: Customer[] = [];


  ngOnInit() {
    this.getAll();
  }

  // LIST
  p: number;
  private getAll() {
    this.customerService.getAll().subscribe(customer => {
      this.customerList = customer;
      this.customerList1 = this.customerList;
    });
  }

  openDialogAdd(): void {
    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;

    this.dialog.open(AddCustomerComponent, dialogConfig);
  }

  openDialogEdit(id: number): void {
    const dialogConfig = new MatDialogConfig();

    dialogConfig.data = {id};
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;

    this.dialog.open(EditCustomerComponent, dialogConfig);
  }

  openDialogDelete(id: number): void {
    const dialogConfig = new MatDialogConfig();

    dialogConfig.data = {id};
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;

    this.dialog.open(DeleteCustomerComponent, dialogConfig);
  }

  findByName(search: string) {
    this.customerService.findByName(search).subscribe(customer => {
      if (search == '') {
        this.customerList = this.customerList1;
      } else {
        this.customerList = customer;
      }
    });
  }

  findByCategory(id: string) {
    // tslint:disable-next-line:radix
    const idSearch = parseInt(id);
    this.customerService.findByCategory(idSearch).subscribe(customer => {
      if (idSearch == 0) {
        this.customerList = this.customerList1;
      } else {
        this.customerList = customer;
      }
    });
  }

}

