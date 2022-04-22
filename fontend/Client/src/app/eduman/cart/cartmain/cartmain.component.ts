import { Component, OnInit, ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'app-cartmain',
  templateUrl: './cartmain.component.html',
  styleUrls: ['./cartmain.component.scss'],
  encapsulation: ViewEncapsulation.None
})
export class CartmainComponent implements OnInit {
  //counter
  count=0
  count1=0
  count2=0

  counter(type:string) {
    type==="add" ?this.count++:this.count--;
  }
  counter1(type:string) {
    type==="add" ?this.count1++:this.count1--;
  }
  counter2(type:string) {
    type==="add" ?this.count2++:this.count2--;
  }

  
  constructor() { }

  ngOnInit(): void {}

}
