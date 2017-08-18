import { Component } from '@angular/core';

@Component({
  selector: 'animal-list',
  template: `
  <ul>
    <li *ngFor="let currentAnimal of animals">
      {{currentAnimal.species}}<br>
      {{currentAnimal.name}}<br>
      {{currentAnimal.age}}<br>
      {{currentAnimal.diet}}<br>
      {{currentAnimal.location}}<br>
      {{currentAnimal.caretakers}}<br>
      {{currentAnimal.sex}}<br>
      {{currentAnimal.likes}}<br>
      {{currentAnimal.dislikes}}<br>
      <button (click)="editAnimal(currentAnimal)">Edit</button></li>
  </ul>
  `
})

export class AnimalListComponent {
  animals: Animal[] = [
  new Animal('Arctic Fox', 'Moon', 2, 'Carnivore', 'Northern Trail', 5, 'Female', 'Cool shade', 'Loud noises'),
  new Animal('Ocelot', 'Prince', 4, 'Carnivore', 'Tropical Rain Forest Building', 6, 'Male', 'Laying in the sunshine', 'Toys that are not rope-based'),
  new Animal('Northwest Black Tailed Deer', 'Tinkerbell', 8, 'Herbivore', 'Northern Trail', 2, 'Female', 'Delicate roots and leaves', 'Loud Noises')
  ];
}
