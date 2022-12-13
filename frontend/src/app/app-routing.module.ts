import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes} from '@angular/router';

// Components Page
import { LandingComponent } from './components/landing/landing.component';
import { GastosComponent } from './modules/dashboard/pages/gastos/gastos.component';
import { HojaComponent } from './components/hoja/hoja.component';
import { TemplateDashboardComponent } from './core/layouts/layout-dashboard/template-dashboard/template-dashboard.component';
import { GeneralComponent } from './modules/dashboard/pages/general/general.component';
import { IngresosComponent } from './modules/dashboard/pages/ingresos/ingresos.component';
import { EstadisticasComponent } from './modules/dashboard/pages/estadisticas/estadisticas.component';
import { ConfiguracionComponent } from './modules/dashboard/pages/configuracion/configuracion.component';
/*import { PruebaComponent } from './modules/dashboard/pages/prueba/prueba.component';*/
import { GuardGuard } from './guards/guard.guard';

const routes: Routes = [
  {path:'landing', component:LandingComponent},
  {path:'hoja', component:HojaComponent},
  {path: 'auth', loadChildren: () => import('./modules/auth/auth.module').then(m => m.AuthModule)},
  { path: 'dashboard', loadChildren: () => import('./modules/dashboard/dashboard.module').then(m => m.DashboardModule), canActivate: [GuardGuard]},
  /*
  {
    path: 'dashboard',
    component: TemplateDashboardComponent,
    children: [
      { path: 'gastos', component: GastosComponent },
      { path: 'general', component: GeneralComponent },
      { path: 'ingresos', component: IngresosComponent },
      { path: 'estadisticas', component: EstadisticasComponent },
      { path: 'configuracion', component: ConfiguracionComponent },
      { path: 'prueba', component: PruebaComponent },
      { path: '**', redirectTo: 'general'}
    ]
  },*/
  { path: '**', redirectTo: 'landing'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes,
    {
      preloadingStrategy: PreloadAllModules
    })],
  exports: [RouterModule]
})
export class AppRoutingModule { }