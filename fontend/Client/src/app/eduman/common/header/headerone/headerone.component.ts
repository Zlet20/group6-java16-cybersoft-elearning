import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { HostListener } from '@angular/core';

@Component({
  selector: 'app-headerone',
  templateUrl: './headerone.component.html',
  styleUrls: ['./headerone.component.scss'],
  encapsulation: ViewEncapsulation.None
})
export class HeaderoneComponent implements OnInit {
  //topbar hide 
  noteContentActive:boolean=false;
  noteButton(){
    if(this.noteContentActive==false){
      this.noteContentActive=true;
    }
    else {
      this.noteContentActive=false;
    }
  }
  //topbar hide 


  //cart sidebar activation start
sidebarCartActive:boolean=false;
cartclick(){
  if(this.sidebarCartActive==false){
    this.sidebarCartActive=true;
    this.signInActive=false;
    this.signUpActive=false;
    this.sidebarInfoActive=false;
  }
  else {
    this.sidebarCartActive=false;
  }
}
//cart sidebar activation end

//sign in popup activation start
signInActive:boolean=false;
signinclick(){
  if(this.signInActive==false){
    this.sidebarCartActive=false;
    this.signInActive=true;
    this.signUpActive=false;
    this.sidebarInfoActive=false;
  }
  else {
    this.signInActive=false;
  }
}
//sign up popup activation end

  //sign in popup activation start
  signUpActive:boolean=false;
  signupclick(){
    if(this.signUpActive==false){
      this.sidebarCartActive=false;
      this.signUpActive=true;
      this.signInActive=false;
      this.sidebarInfoActive=false;
    }
    else {
      this.signUpActive=false;
    }
  }
  //sign up popup activation end

  //sidebar info click activation start
  sidebarInfoActive:boolean=false;
  infoclick(){
    if(this.sidebarInfoActive==false){
      this.sidebarCartActive=false;
      this.signUpActive=false;
      this.signInActive=false;
      this.sidebarInfoActive=true;
    }
    else {
      this.sidebarInfoActive=false;
    }
  }
  //sidebar info click activation end

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

  isSticky: boolean = false;

  @HostListener('window:scroll', ['$event'])
  checkScroll() {
    this.isSticky = window.pageYOffset >= 50;
  }

  constructor() {}

  ngOnInit(): void {}

}
