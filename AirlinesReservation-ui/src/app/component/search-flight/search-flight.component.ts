import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Observable, map, startWith } from 'rxjs';
import { Options } from '../../shared/shared';

@Component({
  selector: 'app-search-flight',
  templateUrl: './search-flight.component.html',
  styleUrls: ['./search-flight.component.scss']
})
export class SearchFlightComponent implements OnInit{  
  minDate = new Date();
  selectedNum = '';
  selectClass = '';
  myControl = new FormControl('');
  options: any = Options;
  filteredOptions!: Observable<any[]>;
 
  constructor(){ }


  ngOnInit(){
    this.filteredOptions = this.myControl.valueChanges.pipe(
      startWith(''),
      map(value => this._filter(value || '')),
    );
  }
  

  private _filter(value: string): string[] {
    const filterValue = value.toLowerCase();
    return this.options.filter((option: { view_value: string; }) => 
      option.view_value.toLowerCase().includes(filterValue));
  }

}
