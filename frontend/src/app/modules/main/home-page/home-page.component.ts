import {Component, OnInit} from '@angular/core';
import {LoginModalComponent} from "../login-modal/login-modal.component";
import {BsModalService} from "ngx-bootstrap";

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {


  constructor(private modalService: BsModalService) {
  }

  ngOnInit() {
  }

  onClick(/*template: TemplateRef<any>*/) {
    /*this.modalService.show(template);*/
    this.modalService.show(LoginModalComponent);
  }

}
