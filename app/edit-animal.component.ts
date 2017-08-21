import { Component, Input, Output, EventEmitter } from '@angular/core';
import { Animal } from './animal.model';

@Component({
  selector: 'edit-animal',
  template: `
    <div>
      <div *ngIf="childSelectedAnimal">
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

        <button (click)="doneButtonClicked()">Done</button>
      </div>
    </div>

  `
})

export class EditAnimalComponent {
  @Input() childSelectedAnimal: Animal;
  @Output() doneButtonClickedSender = new EventEmitter();

  doneButtonClicked() {
    this.doneButtonClickedSender.emit();
  }

}
