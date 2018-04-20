import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'; //http include


@Injectable()
export class LocationService {

  constructor(private http: HttpClient) { }


  getLocations() { 
    console.log("pase por el service")
    //this.http.get('http://localhost:8080/contacts').subscribe(data => {
    
   
  }

}
