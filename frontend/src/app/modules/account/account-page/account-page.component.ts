import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-account-page',
  templateUrl: './account-page.component.html',
  styleUrls: ['./account-page.component.css']
})
export class AccountPageComponent implements OnInit {

  isTableSubscr:boolean=false;
  isTableServices:boolean=false;
  constructor() { }

  ngOnInit() {

  }
  showTableSubscr()
  {
    this.isTableSubscr=!this.isTableSubscr;
  }
  showTableServices()
  {
    this.isTableServices=!this.isTableServices;
  }


}
