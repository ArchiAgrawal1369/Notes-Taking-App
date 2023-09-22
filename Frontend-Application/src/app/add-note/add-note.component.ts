import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { APIserviceService } from '../apiservice.service';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-add-note',
  templateUrl: './add-note.component.html',
  styleUrls: ['./add-note.component.css']
})
export class AddNoteComponent implements OnInit {

  constructor(private router:Router, private service:APIserviceService, private active:ActivatedRoute) { }
  addNote= new FormGroup({
    noteTitle: new FormControl(),
    noteDescription: new FormControl(),
    noteTime: new FormControl(new Date().getTime())
  })
  ngOnInit() {
  }
  logout(){
    sessionStorage.removeItem('isLoggedIn');
    this.router.navigate(['']);
  }

  addNoteFunction(){
    this.service.addNote(this.active.snapshot.params.id, this.addNote.value).subscribe((result)=>{
      this.router.navigate([`viewAll/${this.active.snapshot.params.id}`]);
      console.warn(result);})
    }

}
