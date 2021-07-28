import { Injectable } from '@angular/core';
import {Dictionary} from "../model/dictionary";

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {

  dictionary:Dictionary[] = [
    {word: 'red',
    mean: 'mau do'},
    {word: 'yellow',
      mean: 'mau vang'},
    {word: 'blue',
      mean: 'mau xanh'},
    {word: 'green',
      mean: 'mau xanh la'},
    {word: 'purple',
      mean: 'mau tim'},
    {word: 'orange',
      mean: 'mau cam'}
    ]

  constructor() { }

  findByWord(find: string): string {
    let result: string = '';
    for (let i = 0; i < this.dictionary.length; i++) {
      if (this.dictionary[i].word.includes(find)){
        result += (this.dictionary[i].mean);
      }
    }
    return result;
  }

}
