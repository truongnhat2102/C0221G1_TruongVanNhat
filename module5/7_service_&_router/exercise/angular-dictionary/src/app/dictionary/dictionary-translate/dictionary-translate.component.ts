import { Component, OnInit } from '@angular/core';
import {Dictionary} from "../../model/dictionary";
import {DictionaryService} from "../../service/dictionary.service";

@Component({
  selector: 'app-dictionary-translate',
  templateUrl: './dictionary-translate.component.html',
  styleUrls: ['./dictionary-translate.component.css']
})
export class DictionaryTranslateComponent implements OnInit {

  translate: string;

  constructor(private dictionaryService: DictionaryService) { }

  ngOnInit(): void {
  }

  toTranslate(find: string) {
    this.translate = this.dictionaryService.findByWord(find);
  }

}
