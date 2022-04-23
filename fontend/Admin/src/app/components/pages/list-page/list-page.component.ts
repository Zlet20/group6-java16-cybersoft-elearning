
import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { PageRequest } from 'src/app/api-clients/model/common.model';
import { BaseRole } from 'src/app/api-clients/model/role.model';
import { RoleClient } from 'src/app/api-clients/role.client';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-list-page',
  templateUrl: './list-page.component.html',
  styleUrls: ['./list-page.component.scss'],
})
export class ListPageComponent implements OnInit {
  public list_role: BaseRole[] = [];

  rq: PageRequest = new PageRequest(1,
    10,
    null,
    true,
    null,
    null);

  constructor(private roleClient: RoleClient,
    private toastr: ToastrService) {
   
  }
  ngOnInit(): void {
    this.loadData();
  }


  public settings = {
    pager: {
        display: true,
        perPage: 10,
    },
    delete: {
        confirmDelete: true,
    },
    edit: {
        confirmSave: true,
    },
    actions: {
        custom: true,
        delete: true,
        add: false,
    },
    columns: {
      name: {
        title: 'Name',
        editable: true,
      },
      description: {
        title: 'Description',
        editable: true,
      }

  }
  
  }

  loadData() {
     this.roleClient.searchAll(this.rq).subscribe(
      response =>
      {
        console.log(response)
        this.list_role= response.content.items
      });
  }
  onDeleteConfirm(event) {
    Swal.fire({
      title: 'Are you sure?',
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, delete it!',
    }).then((result) => {
        if (result.isConfirmed) {
          let isLoadData = false;
          
          this.roleClient.deleteById(event.data.id).subscribe(
            response => 
            { 
              isLoadData=true;

              this.toastr.success('Success','Delete role success')
              this.loadData();
            });
            if(!isLoadData){
              this.loadData();

            }
        
           }
    });
    
  }


  onSaveConfirm(event) {
    Swal.fire({
      title: 'Are you sure?',
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, delete it!',
    }).then((result) => {
      if (result.isConfirmed) {
        let isLoadData = false;
        console.log(event)
        this.roleClient.updateById(event.data.id,event.data.new).subscribe(
          response => 
            { 
              isLoadData=true;
              this.toastr.success('Success','Update role success')
              this.loadData();
            });
            if(!isLoadData){
              this.loadData();

            }
                  
           }
          });
}
  

}