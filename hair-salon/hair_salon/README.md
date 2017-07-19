# Hair Salon

#### _A Java Web Application for Epicodus Java Week 3 Independent Project, July 14, 2017_

#### By _**Lincoln Nguyen**_

## Description

A web application to keep track of all stylists that works at the hair salon but also to keep track of their customers. Features such as updates and deleting clients are available.

## Specifications

* Owner add new hired/existing stylist.
  * _Example Input: Stylist Name: Lincoln_
  * _Example Output: "Your stylist has been saved."_
* Stylist can add clients to their list.
  * _Example Input: Client Name: Molly_
  * _Example Output: Client has been saved to Lincoln's list_
* Updating an existing client.
  * _Example Input: Update Name: Molly Johnson_
  * _Example Output: Update client has been saved to Molly Johnson_
* Deleting an existing client.
  * _Example: Click delete client_
  * _Example Output: Client has been deleted_

  ## What's Included

```
hair-salon
├── README.md
├── build.gradle
├── .gitignore
└── src
     ├── main
     │     ├── java
     │     │     ├── App.java
     │     │     ├── Member.java
     │     │     ├── Team.java
     │     │     └── VelocityTemplateEngine.java
     │     │     ├── DB.java
     │     │  
     │     └── resources
     │             └── templates
     │                     ├── index.vtl
     │                     ├── layout.vtl
     │                     ├── client.vtl
     │                     ├── success.vtl
     │                     ├── client-form.vtl
     │                     ├── stylist-client-form.vtl
     │                     ├── stylist-client-success.vtl
     │                     ├── stylist-success.vtl
     │                     ├── stylist.vtl
     │                     └── stylists.vtl
     |                     └── clients.vtl
     └── test
           └── java
                 ├── ClientTest.java
                 └── StylistTest.java
                 └── DatabaseRule.java
```

## Setup/Installation Requirements

* User will need to install gradle on personal device
* User will need to install postgres
  * Once postgres installed, open terminal and type in psql
  * Type in "CREATE DATABASE hair-salon;"
  * Go into the database by "\c hair-salon"
  * To access DB, type "psql hair_salon < media.sql" into terminal
  * You can create tables by typing in "CREATE TABLE stylists (id serial PRIMARY KEY, name varchar);"
  * You can create tables by typing in "CREATE TABLE clients (id serial PRIMARY KEY, name varchar);"
* $ git clone this respository to local drive
* $ gradle run
* Input localhost:4567 in a web browser

## Support and contact details

Email: huylincoln007@yahoo.com

## Technologies Used

* Java
* jUnit
* Gradle

### License

_Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE._

Copyright (c) 2017 **_Lincoln Nguyen_**
