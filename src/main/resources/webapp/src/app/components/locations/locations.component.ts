import { Component, OnInit } from '@angular/core';
import { LocationService } from '../../services/location.service';

@Component({
  selector: 'app-locations',
  templateUrl: './locations.component.html',
  styleUrls: ['./locations.component.css']
})
export class LocationsComponent implements OnInit {

  constructor(public locationService: LocationService) { }
  locations : any;
  imgIconGif : "http://l.yimg.com/a/i/us/we/52/";
  
  
  
  ngOnInit() {
      console.log(" in location component ");
      this.locationService.getLocations().subscribe(data => {
        console.log(data);
        this.locations = data;
      })
  }

  locationDetail(location){
    console.log("detalle locacion");
    console.log(location);
  }

}
