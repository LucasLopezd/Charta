import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { interceptorProvider } from '../../interceptors/interceptor.service';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { DashboardRoutingModule } from './dashboard-routing.module';
import { RouterModule } from '@angular/router';

import { LayoutCoreModule } from 'src/app/core/layouts/layout-dashboard/layout-core.module';

import { GeneralComponent } from './pages/general/general.component';
import { GastosComponent } from './pages/gastos/gastos.component';
import { IngresosComponent } from './pages/ingresos/ingresos.component';
import { EstadisticasComponent } from './pages/estadisticas/estadisticas.component';
import { ConfiguracionComponent } from './pages/configuracion/configuracion.component';

import { EditarComponent } from './botones/editar/editar.component';
import { BorrarComponent } from './botones/borrar/borrar.component';
import { DropComponent } from './componentes/drop/drop.component';
import { OrdenarComponent } from './componentes/ordenar/ordenar.component';
import { FiltrarComponent } from './componentes/filtrar/filtrar.component';
import { FiltrarIngresoComponent } from './componentes/filtrar-ingreso/filtrar-ingreso.component';
import { PaginacionPipe } from './pipes/paginacion.pipe';
import { PaginacionIngresoPipe } from './pipes/paginacion-ingreso.pipe';
import { RecargaDirective } from './directives/recarga.directive';
import { GastoPipe } from './pipes/gasto.pipe';
import { IngresoPipe } from './pipes/ingreso.pipe';


@NgModule({
  declarations: [
    GeneralComponent,
    GastosComponent,
    IngresosComponent,
    EstadisticasComponent,
    ConfiguracionComponent,
    EditarComponent,
    BorrarComponent,
    DropComponent,
    OrdenarComponent,
    FiltrarComponent,
    FiltrarIngresoComponent,
    PaginacionPipe,
    PaginacionIngresoPipe,
    RecargaDirective,
    GastoPipe,
    IngresoPipe
  ],
  imports: [
    DashboardRoutingModule,
    NgbModule,
    RouterModule,
    LayoutCoreModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
providers: [interceptorProvider],
  exports: [
  ]
})
export class DashboardModule { }
