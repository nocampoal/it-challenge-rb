import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'; //http include


@Injectable()
export class LocationService {

  constructor(private http: HttpClient) { }

  
  getLocations() { 
    return this.http.get('http://localhost:8080/boards/nicolas/locations');
  }

  getLocation(id){
    return this.http.get('http://localhost:8080/boards/nicolas/location/'+id);
  }
}
