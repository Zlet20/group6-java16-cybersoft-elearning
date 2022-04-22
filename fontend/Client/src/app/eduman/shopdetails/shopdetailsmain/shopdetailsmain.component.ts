import { Component, OnInit, ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'app-shopdetailsmain',
  templateUrl: './shopdetailsmain.component.html',
  styleUrls: ['./shopdetailsmain.component.scss'],
  encapsulation: ViewEncapsulation.None
})
export class ShopdetailsmainComponent implements OnInit {
  //counter
  count=0

  counter(type:string) {
    type==="add" ?this.count++:this.count--;
  }
  constructor() { }

  ngOnInit(): void {}

}
