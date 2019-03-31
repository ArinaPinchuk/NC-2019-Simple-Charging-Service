import {Component, OnInit, TemplateRef} from '@angular/core';
import {BsModalService} from "ngx-bootstrap";


@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: []
})
export class TestComponent implements OnInit {

  constructor(private modalService: BsModalService) { }

  ngOnInit() {

  }

  onClick(template: TemplateRef<any>) {
    this.modalService.show(template);
  }
 /* ClickButton()
  {this.popup.show();}*/

}
