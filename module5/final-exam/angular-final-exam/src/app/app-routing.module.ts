import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HospitalComponent} from "./hospital/hospital.component";


const routes: Routes = [{
  path:'hospital',
  component: HospitalComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
