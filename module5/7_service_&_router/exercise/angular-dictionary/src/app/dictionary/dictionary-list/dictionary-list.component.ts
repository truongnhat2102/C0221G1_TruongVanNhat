import { Component, OnInit } from '@angular/core';
import {DictionaryService} from "../../service/dictionary.service";
import {Dictionary} from "../../model/dictionary";
import {ModalDismissReasons, NgbModal} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-dictionary-list',
  templateUrl: './dictionary-list.component.html',
  styleUrls: ['./dictionary-list.component.css']
})
export class DictionaryListComponent implements OnInit {

  dictionaries: Dictionary[];
  detailOfWord: Dictionary;
  private closeResult: string;

  constructor(private dictionaryService: DictionaryService, private modalService: NgbModal) { this.dictionaries = this.dictionaryService.getAll(); }

  ngOnInit(): void {
  }

  getDictionary(id: number) {
    this.detailOfWord = this.dictionaryService.findById(id);
  }



}
