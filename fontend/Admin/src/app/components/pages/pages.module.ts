import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ReactiveFormsModule } from '@angular/forms';
import { CKEditorModule } from 'ngx-ckeditor';
import { NgxDatatableModule } from '@swimlane/ngx-datatable';


import { PagesRoutingModule } from './pages-routing.module';
import { ListPageComponent } from './list-page/list-page.component';
import { CreatePageComponent } from './create-page/create-page.component';
import { Ng2SmartTableModule } from 'ng2-smart-table';

@NgModule({
  declarations: [ListPageComponent, CreatePageComponent],
  imports: [
    CommonModule,
    PagesRoutingModule,
    NgbModule,
    ReactiveFormsModule,
    CKEditorModule,
    NgxDatatableModule,
    Ng2SmartTableModule

  ]
})
export class PagesModule { }
