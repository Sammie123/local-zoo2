import { Component, Input, Output, EventEmitter } from '@angular/core';
import { Animal } from './animal.model';

@Component({
  selector: 'animal-list',
  template: `
  <select (change)="onChange($event.target.value)">
    <option value="allAnimals">All Animals</option>
    <option value="ageThreeAndUp">Age Three and Up Animals</option>
  </select>

  <ul>
    <li *ngFor="let currentAnimal of childAnimalList | filter-animal:filterByAge">
      {{currentAnimal.species}}<br>
      {{currentAnimal.name}}<br>
      {{currentAnimal.age}}<br>
      {{currentAnimal.diet}}<br>
      {{currentAnimal.location}}<br>
      {{currentAnimal.caretakers}}<br>
      {{currentAnimal.sex}}<br>
      {{currentAnimal.likes}}<br>
      {{currentAnimal.dislikes}}<br>
      <button (click)="editButtonHasBeenClicked(currentAnimal)">Edit</button></li>
  </ul>
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
