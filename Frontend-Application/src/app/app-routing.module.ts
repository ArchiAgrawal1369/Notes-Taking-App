import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ViewNotesComponent } from './view-notes/view-notes.component';
import { AddNoteComponent } from './add-note/add-note.component';
import { NoteDetailComponent } from './note-detail/note-detail.component';
import { EditNoteComponent } from './edit-note/edit-note.component';

const routes: Routes = [
  {
    component:HomeComponent, path:''
  },{
    component:RegisterComponent, path:'register'
  },{
    component:LoginComponent, path:'login'
  },
  {component:ViewNotesComponent, path:'viewAll/:id'
  },
  {component:NoteDetailComponent, path:'note/:id'
  },
  {component:AddNoteComponent, path:'addNote/:id'
  },
  {component:EditNoteComponent, path:'editNote/:userid/:noteid'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
