import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { LocationsComponent } from './components/locations/locations.component';
import { AddLocationComponent } from './components/add-location/add-location.component';


@NgModule({
  declarations: [
    AppComponent,
    LocationsComponent,
    AddLocationComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
