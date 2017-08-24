import { Component, Input, Output, EventEmitter } from '@angular/core';
import { Animal } from './animal.model';

@Component({
  selector: 'animal-list',
  template: `
  <select (change)="onChange($event.target.value)">
    <option value="allAnimals" selected="selected">All Animals</option>
    <option value="ageThreeAndUp">Age Three and Up Animals</option>
  </select>

  <div class="panel" *ngFor="let currentAnimal of childAnimalList | filterAnimal:filterByAge">
    <h3>Species: {{currentAnimal.species}}</h3>
    <h4>Name: {{currentAnimal.name}}</h4>
    <h5>Age: {{currentAnimal.age}}</h5>
    <h5>Diet: {{currentAnimal.diet}}</h5>
    <h5>Location: {{currentAnimal.location}}</h5>
    <h5>Caretakers: {{currentAnimal.caretakers}}</h5>
    <h5>Sex: {{currentAnimal.sex}}</h5>
    <h5>Likes: {{currentAnimal.likes}}</h5>
    <h5>Dislikes: {{currentAnimal.dislikes}}</h5>
    <button (click)="editButtonHasBeenClicked(currentAnimal)">Edit</button>
  </div>
  `
})

export class AnimalListComponent {
  @Input() childAnimalList: Animal[];
  @Output() clickSender = new EventEmitter();

  filterByAge: string = "age";

  onChange(optionFromMenu) {
    this.filterByAge = optionFromMenu;
  }

  editButtonHasBeenClicked(animalToEdit: Animal) {
    this.clickSender.emit(animalToEdit);
  }
}
