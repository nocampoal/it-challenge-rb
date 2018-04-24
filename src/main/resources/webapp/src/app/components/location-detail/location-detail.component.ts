import { Component, OnInit } from '@angular/core';
import { LocationService } from '../../services/location.service';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';


@Component({
  selector: 'app-location-detail',
  templateUrl: './location-detail.component.html',
  styleUrls: ['./location-detail.component.css']
})
export class LocationDetailComponent implements OnInit {

  constructor(private route: ActivatedRoute,public locationService: LocationService,public router: Router) { }
  location : any;
  forecasts : any;
  title : String;
  
  ngOnInit() {
    this.getLocationDetail(this.route.snapshot.params['id']);
  }

   getLocationDetail(id){
     this.locationService.getLocation(id).subscribe(data => {
      console.log(data);
      this.setValues(data);
      this.locationService.getLocationPolling(id).subscribe(loc =>{
        console.log("detail polling: "+loc);
        this.setValues(loc);
      }

      )
    })
   }

   deleteLocation(idLocation) {
    const response = confirm('are you sure you want to delete?');
    if (response ) {
      this.locationService.deleteLocation(idLocation).subscribe(data => {
          this.router.navigate(['/']);
        })
    }
  }

  setValues(loc){
    this.location = loc;
    this.forecasts = loc.channel.item.forecasts;
    this.title = loc.channel.item.title;
  }

}
