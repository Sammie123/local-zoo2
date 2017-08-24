# Local Zoo

Application that filters, edit, and add new animal to the zoo's list of Animal inventory.

## Planning

1. Configuration/dependencies
  * Angular2
    * Typescript
    * Bootstrap
  * Node.js


2. Specs
  * ZooKeepers can add new animal to the zoo's list of inventory. Properties are species, name, age, diet, location, caretakers, sex, likes, and dislikes. Once added, ZooKeepers can keep track of all animals added on the homepage.

  * Zookeepers can also edit individual animal by clicking on edit. ZooKeepers can edit any piece of information

  * Zookeepers can also filter animal listing by age. There is currently one filtering system based on age where any animal that is the age of three and up will be display while any animal under the age of three will not.

3. Integration
  * animal-list component that displays the list of animal-list
  * edit-animal component that allow the ZooKeepers to edit any information
  * filter-animal pipe that filter the list of animal based on age
  * new-animal component that allow ZooKeepers to add new animals to the list

4. UX/UI
  * Include and modify bootstrap/materialize/Sass etc.
  * Develop custom style

5. Polish
  * Make README awesome

## Prerequisites

You will need the following things properly installed on your computer.

* [Git](https://git-scm.com/)
* [Node.js](https://nodejs.org/) (with NPM)
* [Ember CLI](https://ember-cli.com/)
* [PhantomJS](http://phantomjs.org/)

## Installation

* `git clone <repository-url>` this repository
* `cd local-zoo2`
* `npm install`
* `bower install`
* `gulp build`
* `gulp serve`

## Running / Development

* `gulp build`
* `gulp serve`
* Visit your app at [http://localhost:3000](http://localhost:3000).

## Future Plans

* Include pictures for each animal
* Have multiple properties filtering system (i.e. age: three and up and sex: male)
* Delete button
