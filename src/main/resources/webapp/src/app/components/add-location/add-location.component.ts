import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { LocationService } from '../../services/location.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-location',
  templateUrl: './add-location.component.html',
  styleUrls: ['./add-location.component.css']
})
export class AddLocationComponent implements OnInit {

  constructor(private route: Router,public locationService: LocationService) { }
  location: any;
  locations: any;
  showPanel : Boolean;
  locationAdded: any; 
  @Output() actualizarLocaciones = new EventEmitter();
  
  ngOnInit() {
    this.showPanel = false;
  }


  onSubmit() {
    if(this.location != '') {
      console.log("Location add : "+this.location);
      this.locationService.addLocation(this.location).subscribe(data => {
        console.log(data);
        this.location = '';
        this.locationAdded = data;
        if(this.locationAdded.channel.location != null){
          this.showPanel = false;
          this.locationService.getLocations().subscribe(locs => {
            console.log(locs);  
            this.locations = locs;
            this.actualizarLocaciones.emit(this.locations);
          })
        }else{
          this.showPanel = true;
        }
       
      },(err) => {
        console.log(err);
      })
      
    }
  }

}
