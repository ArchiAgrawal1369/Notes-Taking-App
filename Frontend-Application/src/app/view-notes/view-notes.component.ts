import { Component, OnInit } from '@angular/core';
import { APIserviceService } from '../apiservice.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-view-notes',
  templateUrl: './view-notes.component.html',
  styleUrls: ['./view-notes.component.css']
})
export class ViewNotesComponent implements OnInit {
  constructor(private service:APIserviceService, private router:Router, private activeRoute:ActivatedRoute) { }
  collection:any=[];
  userEmail:"";
  ngOnInit():void {
    this.userEmail=this.activeRoute.snapshot.params.id;
      this.service.viewNotes(this.activeRoute.snapshot.params.id).subscribe((result)=>{
      this.collection=result
    })
  }
 
  addNoteFunction(){
    this.router.navigate([`addNote/${this.activeRoute.snapshot.params.id}`])
  }

  deleteDetail(item){
    this.collection.splice(item-1,1);
    this.service.deleteDetail(item).subscribe((result)=>{
      console.warn("result",result)
    })
  }

  logout(){
    sessionStorage.removeItem('isLoggedIn');
    this.router.navigate(['/login']);
  }
}
