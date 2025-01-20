# SimpleWebDataEntry

## Description
The following is a project proposed for an interview.
### Requirements
Using a tech stack of your choice (e.g., Python and Django, Java and Spring) develop a simple data entry web application.

This application should have a single form with inputs for:
·        Name
·        Age
·        Title
·        Hometown

The form should also have a single submit button.
Name and Title should be required fields, while the others are not. The system should display an error message if the required fields aren’t entered.
When the submit button is pressed, the application should take you to a confirmation page that has all of the information that was entered, as well as a table of previous entries.
Include some basic CSS styling on the page to make it look somewhat presentable.

## Tech Stack
* Java
  * SpringBoot
  * Flyway
  * JPA
  * Lombok
* HTML
* CSS
* Javascript
* JQuery
* SQLite

## Setup
In order to have the application working as expected, follow the given steps.
1. Use IntelliJ Community IDE
2. Clone the project from GitHub
   1. Clone link - https://github.com/wmspaul/SimpleWebDataEntry.git
   2. How to clone - https://docs.github.com/en/repositories/creating-and-managing-repositories/cloning-a-repository
2. Open the project in IntelliJ
3. Install the Lombok Plugin
   1. Settings > Plugins > Search for Lombok > Install > Enable
   2. NOTE - IntelliJ may need to be restarted
4. If the project did not have a Run application configuration, then you will set up an edit configuration
   1. Top right of IntelliJ > Click Drop Down > Click Edit Configurations
   2. Add new application edit configuration > specify Main class under org.example packages as the main class
5. Click the run button top right of IntelliJ
6. You may now view the application by going opening a browser and setting the link to http://localhost:8080

## Things of Note
There are many ways the application could be improved upon, with the requirements gathering being the correct start to understand business needs and stakeholder opinions. This would have occurred prior to even starting development.

### Examples:
* Test Driven Development, what percent coverage would we want to aim for?
* Error Handling, what characters should we allow for a name, or title, or hometown? i.e. hyphenated names
* Duplication records, how should one form a unique, or does it matter?
* Pagination, would we want to limit the number of records per page, or present all records?
* etc...

As I enjoy programming, I did incorporate some of this while it was not a requirement in the base design. Hope you enjoy this Simple Web Data Entry application!
