import { Component } from '@angular/core';
import { Animal } from './animal.model';

@Component({
  selector: 'app-root',
  template: `
    <div class="container">
      <h1>Local Zoo {{month}}/{{day}}/{{year}}</h1>
      <hr>
      <div>
        <div *ngIf="selectedAnimal">
          <animal-list [childAnimalList]="masterAnimalList"></animal-list>
          <hr>
          <h3>Edit Animal</h3>
          <label>Enter Animal Species:</label>
          <input [(ngModel)]="selectedAnimal.species">

          <label>Enter Animal Name:</label>
          <input [(ngModel)]="selectedAnimal.name">

          <label>Enter Animal Age:</label>
          <input [(ngModel)]="selectedAnimal.age">

          <label>Enter Animal Diet:</label>
          <input [(ngModel)]="selectedAnimal.diet">

          <label>Enter Animal Location:</label>
          <input [(ngModel)]="selectedAnimal.location">

          <label>Enter Animal Caretakers:</label>
          <input [(ngModel)]="selectedAnimal.caretakers">

          <label>Enter Animal Sex:</label>
          <input [(ngModel)]="selectedAnimal.sex">

          <label>Enter Animal Likes:</label>
          <input [(ngModel)]="selectedAnimal.likes">

          <label>Enter Animal Dislikes:</label>
          <input [(ngModel)]="selectedAnimal.dislikes">

          <button (click)="finishedEditing()">Done</button>
        </div>
      </div>
    </div>
  `
})

export class AppComponent {
  currentTime = new Date();
  month: number = this.currentTime.getMonth() + 1;
  day: number = this.currentTime.getDate();
  year: number = this.currentTime.getFullYear();
  selectedAnimal = null;

  masterAnimalList: Animal[] = [
  new Animal('Arctic Fox', 'Moon', 2, 'Carnivore', 'Northern Trail', 5, 'Female', 'Cool shade', 'Loud noises'),
  new Animal('Ocelot', 'Prince', 4, 'Carnivore', 'Tropical Rain Forest Building', 6, 'Male', 'Laying in the sunshine', 'Toys that are not rope-based'),
  new Animal('Northwest Black Tailed Deer', 'Tinkerbell', 8, 'Herbivore', 'Northern Trail', 2, 'Female', 'Delicate roots and leaves', 'Loud Noises')
  ];

  editAnimal(clickedAnimal) {
    this.selectedAnimal = clickedAnimal;
  }

  finishedEditing() {
    this.selectedAnimal = null;
  }
}
