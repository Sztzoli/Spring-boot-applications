import { Component, OnInit } from '@angular/core';
import {DataService} from "../data.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  beers : Beer[] = []

  constructor(private data: DataService) { }

  ngOnInit(): void {
    this.data.getAll().subscribe(
      response => {
        this.beers = response;
      }
    )
  }

}

export class Beer {
  constructor(public name: string) {
  }
}
