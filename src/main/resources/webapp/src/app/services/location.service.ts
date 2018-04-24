import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'; //http include
import { Router } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { IntervalObservable } from 'rxjs/observable/IntervalObservable'; // <--- This changes from the first Example!

import "rxjs/add/operator/mergeMap";



@Injectable()
export class LocationService {

  urlAPIAllLocations: string;
  urlAPI: string;
  
  constructor(private http: HttpClient,private router: Router) {
    this.urlAPIAllLocations =  'http://localhost:8080/boards/nicolas/locations';
    this.urlAPI = 'http://localhost:8080/boards/nicolas/location/';
   }

  
  getLocations(): Observable<any> { 
    return this.http.get(this.urlAPIAllLocations);
  }

  getLocation(idLocation): Observable<any>{
    return this.http.get(this.urlAPI+idLocation);
  }

  addLocation(nameLocation){
    return this.http.post(this.urlAPI,nameLocation);
  }

  deleteLocation(idLocation){
    return this.http.delete(this.urlAPI+idLocation)
  }

  getNewValue = () => { return IntervalObservable
      .create(100000)
      .flatMap((i) => this.http.get(this.urlAPIAllLocations));
  }

  getLocationsPolling = () => {
    return IntervalObservable
    .create(43200)
    .flatMap((i) => this.http.get(this.urlAPIAllLocations));
  }
  

  getLocationPolling = (id) => {
    return IntervalObservable
    .create(43200)
    .flatMap((i) => this.http.get(this.urlAPI+id));
  }
}

