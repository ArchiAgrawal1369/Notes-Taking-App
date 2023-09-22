import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { APIserviceService } from '../apiservice.service';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-edit-note',
  templateUrl: './edit-note.component.html',
  styleUrls: ['./edit-note.component.css']
})
export class EditNoteComponent implements OnInit {

  constructor(private router:Router, private service:APIserviceService, private active:ActivatedRoute) { }
  editNote= new FormGroup({
    noteTitle: new FormControl(),
    noteDescription: new FormControl()
  })

  ngOnInit() {
    this.service.viewDetail(this.active.snapshot.params.noteid).subscribe((result)=>
    { 
      console.warn(result);
      this.editNote= new FormGroup({
      noteTitle: new FormControl(result['noteTitle']),
      noteDescription: new FormControl(result['noteDescription'])
    });
  }
    )
  }
  logout(){
    sessionStorage.removeItem('isLoggedIn');
    this.router.navigate(['']);
  }
  editNoteFunction(){
    this.service.editDetail(this.active.snapshot.params.noteid, this.editNote.value).subscribe((result)=>{
      this.router.navigate([`viewAll/${this.active.snapshot.params.userid}`]);
    })
    }
}
