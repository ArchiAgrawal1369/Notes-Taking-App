import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class APIserviceService {
  private loginUrl="http://localhost:8086/login";
  private registerUrl="http://localhost:8086/register";
  private noteUrl="http://localhost:8086/note";
  private viewUrl="http://localhost:8086/viewNotes";
  private addUrl="http://localhost:8086/addNotes";

  constructor(private httpClient:HttpClient, private router:Router) { }

  loginUser(user: User){
    return this.httpClient.post(`${this.loginUrl}`,user);
  }

  registerUser(user: User){
    console.log(user)
    return this.httpClient.post(`${this.registerUrl}`,user);
  }
  viewNotes(id){
    console.warn(id);
    return this.httpClient.get(`${this.viewUrl}/${id}`);
  }
  viewDetail(id){
    return this.httpClient.get(`${this.noteUrl}/${id}`)
  }
  deleteDetail(id){
    return this.httpClient.delete(`${this.noteUrl}/${id}`)
  }
  editDetail(id,data){
    return this.httpClient.put(`${this.noteUrl}/${id}`,data)
  }
  addNote(id,data){
    return this.httpClient.post(`${this.addUrl}/${id}`,data)
  }
  
}
