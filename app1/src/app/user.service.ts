import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const URL = 'http://localhost:8000/api/auth/'
@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(public http: HttpClient ){}
  signup(user:any) {
    //logic
    console.log(user );
    console.log(user.gender);
    return this.http.post(URL+'signup',user);
  }
  signin(user:any) {
    
    return this.http.post(URL+'signin',user);
  }
}