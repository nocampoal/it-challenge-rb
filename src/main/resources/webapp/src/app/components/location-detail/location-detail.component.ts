import { Component, OnInit } from '@angular/core';
import { LocationService } from '../../services/location.service';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-location-detail',
  templateUrl: './location-detail.component.html',
  styleUrls: ['./location-detail.component.css']
})
export class LocationDetailComponent implements OnInit {

  constructor(private route: ActivatedRoute,public locationService: LocationService) { }
  location : any;
  
  ngOnInit() {
    this.getLocationDetail(this.route.snapshot.params['id']);
  }

   getLocationDetail(id){
     this.locationService.getLocation(id).subscribe(data => {
      console.log(data);
      this.location = data;
    })
   }

}
