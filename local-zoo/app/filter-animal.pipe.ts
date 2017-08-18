import {Pipe, PipeTransform} from '@angular/core';
import {Animal} from './animal.model';

@Pipe({
  name: "filter-animal",
  pure: false

})


export class filterAnimalPipe implements PipeTransform {
  transform(input: Animal[], desiredAge) {
    var output: Animal[] = [];
    if(desiredAge === "ageThreeAndUp") {
      for (var i=0; i<input.length; i++) {
        if(input[i].age > 2) {
          output.push(input[i]);
        }
      }
      return output;
    } else {
      return input;
    }
  }
}
