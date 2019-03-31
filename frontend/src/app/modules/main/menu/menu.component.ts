import {Component, OnInit, TemplateRef} from '@angular/core';
import {BsModalService} from "ngx-bootstrap";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  constructor(private modalService: BsModalService) { }

  ngOnInit() {
  }
  onClick(template: TemplateRef<any>) {
    this.modalService.show(template);
  }
}
