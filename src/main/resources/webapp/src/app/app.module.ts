import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { LocationsComponent } from './components/locations/locations.component';
import { AddLocationComponent } from './components/add-location/add-location.component';
import { LocationService } from './services/location.service';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { LocationDetailComponent } from './components/location-detail/location-detail.component';

const appRoutes: Routes = [
  {
    path: 'locations',
    component: LocationsComponent,
    data: { title: 'Locations List' }
  },
  {
    path: 'location-detail/:id',
    component: LocationDetailComponent,
    data: {title: 'Location detail'}
  },
  { path: '',
    redirectTo: '/locations',
    pathMatch: 'full'
  }
];





@NgModule({
  declarations: [
    AppComponent,
    LocationsComponent,
    AddLocationComponent,
    LocationDetailComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
      RouterModule.forRoot(appRoutes)
  ],
  providers: [LocationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
