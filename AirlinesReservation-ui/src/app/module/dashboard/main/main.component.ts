import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Observable, map, startWith } from 'rxjs';
import { Options } from 'src/app/shared/shared';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss']
})
export class MainComponent implements OnInit {
  minDate = new Date();
  myControl = new FormControl('');
  selectedNum = '';
  selectClass = '';
  options: any = Options;
  filteredOptions!: Observable<any[]>;

  ngOnInit() {
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
