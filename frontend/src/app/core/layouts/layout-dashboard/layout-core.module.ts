import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { RouterModule } from '@angular/router';
import { TemplateDashboardComponent } from './template-dashboard/template-dashboard.component';
import { MenuDashboardComponent } from './menu-dashboard/menu-dashboard.component';
import { ModalNewEntryComponent } from './components/modal-new-entry/modal-new-entry.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HeaderComComponent } from './header-com/header-com.component';


@NgModule({
  declarations: [
    MenuDashboardComponent,
    TemplateDashboardComponent,
    ModalNewEntryComponent,
    HeaderComComponent,
  ],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
    ReactiveFormsModule,
    NgbModule
  ],
  exports: [
    MenuDashboardComponent,
    TemplateDashboardComponent,
    HeaderComComponent
  ]
})
export class LayoutCoreModule { }
