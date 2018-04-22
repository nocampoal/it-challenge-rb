import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'; //http include
import { Router } from '@angular/router';


@Injectable()
export class LocationService {

  constructor(private http: HttpClient,private router: Router) { }

  
  getLocations() { 
    return this.http.get('http://localhost:8080/boards/nicolas/locations');
  }

  getLocation(idLocation){
    return this.http.get('http://localhost:8080/boards/nicolas/location/'+idLocation);
  }

  addLocation(nameLocation){
    return this.http.post('http://localhost:8080/boards/nicolas/location',nameLocation);
  }

  deleteLocation(idLocation){
    return this.http.delete('http://localhost:8080/boards/nicolas/location/'+idLocation)
  }
}
