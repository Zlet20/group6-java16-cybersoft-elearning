import { Component, OnInit, ViewEncapsulation } from '@angular/core';

// import Swiper core and required modules
import SwiperCore, { Autoplay } from "swiper";

// install Swiper modules
SwiperCore.use([Autoplay]);

@Component({
  selector: 'app-relatedproduct',
  templateUrl: './relatedproduct.component.html',
  styleUrls: ['./relatedproduct.component.scss'],
  encapsulation: ViewEncapsulation.None
})
export class RelatedproductComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
