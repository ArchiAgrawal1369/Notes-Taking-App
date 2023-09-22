import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { APIserviceService } from '../apiservice.service';

@Component({
  selector: 'app-note-detail',
  templateUrl: './note-detail.component.html',
  styleUrls: ['./note-detail.component.css']
})
export class NoteDetailComponent implements OnInit {
  noteTitle; noteDesc; noteTime;
  constructor(private router: ActivatedRoute, private service: APIserviceService, private route:Router) { }

  ngOnInit() {
    this.service.viewDetail(this.router.snapshot.params.id).subscribe((result)=>{
      this.noteTitle= result['noteTitle'];
      this.noteDesc= result['noteDescription'];
      this.noteTime= result['noteTime'];
    })
  }
  logout(){
    sessionStorage.removeItem('isLoggedIn');
    this.route.navigate(['']);
  }

}
