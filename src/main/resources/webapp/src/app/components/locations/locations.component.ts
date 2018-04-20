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
  
  ngOnInit() {
      console.log(" getLocations locationService ");
      this.locationService.getLocations();
  }

}
