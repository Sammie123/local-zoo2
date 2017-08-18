import { Component, Input, Output, EventEmitter } from '@angular/core';
import { Animal } from './animal.model';

@Component({
  selector: 'animal-list',
  template: `
  <ul>
    <li *ngFor="let currentAnimal of childAnimalList">
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

  editButtonHasBeenClicked(animalToEdit: Animal) {
    this.clickSender.emit(animalToEdit);
  }
}
