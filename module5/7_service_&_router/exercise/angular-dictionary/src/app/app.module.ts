import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DictionaryListComponent } from './dictionary/dictionary-list/dictionary-list.component';
import { DictionaryTranslateComponent } from './dictionary/dictionary-translate/dictionary-translate.component';

@NgModule({
  declarations: [
    AppComponent,
    DictionaryListComponent,
    DictionaryTranslateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
