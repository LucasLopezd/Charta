import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';
import { HojaComponent } from 'src/app/components/hoja/hoja.component';

// Components Page
import { TemplateDashboardComponent } from 'src/app/core/layouts/layout-dashboard/template-dashboard/template-dashboard.component';
import { ConfiguracionComponent } from './pages/configuracion/configuracion.component';
import { EstadisticasComponent } from './pages/estadisticas/estadisticas.component';
import { GastosComponent } from './pages/gastos/gastos.component';
import { GeneralComponent } from './pages/general/general.component';
import { IngresosComponent } from './pages/ingresos/ingresos.component';/*
import { PruebaComponent } from './pages/prueba/prueba.component';*/

const routes: Routes = [
  {
    path: '',
    component: TemplateDashboardComponent,
    children: [
      { path: 'gastos', component: GastosComponent },
      { path: 'general', component: GeneralComponent },
      { path: 'ingresos', component: IngresosComponent },
      { path: 'estadisticas', component: EstadisticasComponent },
      { path: 'configuracion', component: ConfiguracionComponent },/*
      { path: 'prueba', component: PruebaComponent },*/
      { path: '**', redirectTo: 'general'}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],  
  })

export class DashboardRoutingModule { }
