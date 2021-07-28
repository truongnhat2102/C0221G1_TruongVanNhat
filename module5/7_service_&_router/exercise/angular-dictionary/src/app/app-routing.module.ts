import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DictionaryTranslateComponent} from "./dictionary/dictionary-translate/dictionary-translate.component";
import {DictionaryListComponent} from "./dictionary/dictionary-list/dictionary-list.component";


const routes: Routes = [{
  path: 'dictionary/dictionary-translate',
  component: DictionaryTranslateComponent
},{
  path: 'dictionary/dictionary-list',
  component: DictionaryListComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
