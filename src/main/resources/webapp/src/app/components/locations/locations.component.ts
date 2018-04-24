import { Component, OnInit, Input, Output } from '@angular/core';
import { LocationService } from '../../services/location.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-locations',
  templateUrl: './locations.component.html',
  styleUrls: ['./locations.component.css']
})
export class LocationsComponent implements OnInit {
  locations : any;
  constructor(public locationService: LocationService,public router: Router) { }
  
  imgIconGif : "http://l.yimg.com/a/i/us/we/52/";
  
  
  
  ngOnInit() {
      this.locationService.getLocations().subscribe(locations =>{
        this.locations = locations;
      
        this.locationService.getLocationsPolling().subscribe(locationsPolling => {
         console.log(locationsPolling);
          this.locations = locationsPolling;
       });
      })
  }

  deleteLocation(idLocation) {
    const response = confirm('are you sure you want to delete?');
    if (response ) {
      this.locationService.deleteLocation(idLocation).subscribe(data => {
         this.locationService.getLocations().subscribe(data => {
          this.locations = data;
        })
      })
    }
  }

  actualizarLocs(locs):void{
    console.log(locs);
    this.locations = locs;  
  }
  

}
