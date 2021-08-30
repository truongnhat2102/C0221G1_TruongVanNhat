import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {CustomerComponent} from './customer/customer.component';
import {DropdownModule, IconsModule, NavbarModule, TableModule, WavesModule, ButtonsModule, MDBBootstrapModule} from 'angular-bootstrap-md';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {HttpClientModule} from '@angular/common/http';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatDialogModule} from '@angular/material/dialog';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatSelectModule} from '@angular/material/select';
import { AddCustomerComponent } from './customer/add-customer/add-customer.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { EditCustomerComponent } from './customer/edit-customer/edit-customer.component';
import { DeleteCustomerComponent } from './customer/delete-customer/delete-customer.component';
import {NgxPaginationModule} from 'ngx-pagination';
import { NavbarComponent } from './navbar/navbar.component';


@NgModule({
  declarations: [
    AppComponent,
    CustomerComponent,
    AddCustomerComponent,
    EditCustomerComponent,
    DeleteCustomerComponent,
    NavbarComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    MatButtonModule,
    MatIconModule,
    TableModule,
    MatFormFieldModule,
    MatDialogModule,
    ReactiveFormsModule,
    MatSelectModule,
    BrowserAnimationsModule,
    FormsModule,
    NgxPaginationModule,
    IconsModule,
    DropdownModule,
    WavesModule,
    NavbarModule,
    ButtonsModule,
    MDBBootstrapModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
