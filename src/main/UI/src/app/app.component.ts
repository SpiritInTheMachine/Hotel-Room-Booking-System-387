import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {HttpClient, HttpResponse,HttpHeaders} from "@angular/common/http";
import { Observable } from 'rxjs';
import {map} from "rxjs/operators";

export interface Roomsearch{
    checkin:string;
    checkout:string;
  }

export interface Room{
  id:string;
  roomNumber:string;
  price:string;
  links:string;
}
export class ReserveRoomRequest {
  roomId:string;
  checkin:string;
  checkout:string;

  constructor(roomId:string,
              checkin:string,
              checkout:string) {

    this.roomId = roomId;
    this.checkin = checkin;
    this.checkout = checkout;
  }
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Landon Hotel App';
  singularMessage: string = ''; //Singular message variable
  messagesArray: string[] = []; //Message Array

  roomsearch!: FormGroup; // Add FormGroup for the search form
  rooms: any[] = []; // Placeholder for room data

  constructor(private http: HttpClient) {}

  //Method to fetch messages
  getLocalizedMessages(): Observable<any> {
    const url = '/api/messages'; //Endpoint for MessageController
    return this.http.get<any>(url).pipe(
      map((response) => {
        return response; //backend response
      })
    );
  }

  ngOnInit(): void {
    // Initialize the roomsearch form
    this.roomsearch = new FormGroup({
      checkin: new FormControl(''),
      checkout: new FormControl('')
    });

    this.getLocalizedMessages().subscribe(
      //gets messages when initialized
        (data) => {
          //JSON object is send
          this.singularMessage = data['English']; //English message is assigned to singular Message
          this.messagesArray = Object.values(data); //Message conversion to array
        },
        (error) => {
          console.error('Error acquiring local message: ', error)
        }
      );
  }

  // Method to handle form submission
  onSubmit(searchForm: FormGroup): void {
    const formValues = searchForm.value;
    console.log('Form submitted:', formValues);
    // Add HTTP request to fetch room data if needed
  }

  // Placeholder method for reserving a room
  reserveRoom(roomId: string): void {
    console.log(`Reserving room with ID: ${roomId}`);
    // Add logic to reserve the room (e.g., HTTP request)
  }

}

/*
var ROOMS: Room[]=[
  {
  "id": "13932123",
  "roomNumber" : "409",
  "price" :"20",
  "links" : ""
},
{
  "id": "139324444",
  "roomNumber" : "509",
  "price" :"30",
  "links" : ""
},
{
  "id": "139324888",
  "roomNumber" : "609",
  "price" :"40",
  "links" : ""
}
] */

