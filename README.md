# quiz-challange

QUIZ
========

QUIZ is a project to create a running web application that allows a user to take part in an online quiz



Functional spec
--------
- The system should be a web application.
- The user should be able to take a quiz.
- The quiz consists of one or more questions.
- The quiz only has multiple-choice questions.
- The app should tell the user how he did at the end of the quiz.


Problems breakdown
--------

- Requires database for storing information.
- Requires front end web interface for input/output.
- Requires an framework linking these requirments.

solution
--------
- The following was used to meet the requirments of the project. The main focus was on full stack development of the project. 

- Oracle SQL (Database)
- Spring web-MVC
- Java langauge
- Maven (project managment tool)
- Tomcat (Hosted web Application)

Reasoning for choices
--------

- Most choices were taken due to familiarity with the language and time constraints in the project.
- Maven is an execelent project/dependency managment tool and saves time on projet creation.
- Spring web-MVC simply makes sense considering the requirments, I decided against using the
- hibernate for relational mapping as that framework is feature rich but I did not require almost all of its features 
- for the tasks of this project.



Omitted features
--------

Due to having limited time for the project certain sections were rushed and were I given more time I would certainly redesign certain aspects of the database's design.
For example being very familure with TDD I would have created mock objects tests for all java objects and used jUnit to test.
There are also several design choices such as the results display I would have coded in a more elegent future expansion way.
The quiz input does not have validation and is missing feedback should a question be left unanswered.
I would be happier if the users score was input into the database at the end of the quiz allowing a single query to be used to check the results rather then calculating the score later with 2 querys to the database for questions and results.


Features
--------
- log in/out
- admin distinction for future website expansion
- user authentication (this was included as I had previosuly coded this work and so did not take up any development time)
- take quiz/quiz format and rules becoming of a professinal online muitipule choise quiz.
- direct link from frontend to backend.


What the code is doing
--------

From a high level perspective the code generates a model from the database tables and objects representing the data, logic and rules of the application, the view is a format for displaying the model information and allows the user to see how to make input to trigger the controller, The controller accepts input from the user through the web interface and triggers changes to the model or loads new views to the screen.

Upone loading the application we reach a default view in the form of the welcome page, user input allows for a login which sends th einput to thge controler, triggers a check and validation of the information in the database and outputs a successful log in or a faled to login message.

When selecting the take quiz option the controller requests the quesion information from the database using an SQL query, the information result set is then transferred to a questions object, this ovbject is passed to the model which is used by the view to output the quiz information onto the .jsp page.

quiz answers are selected using radio buttons inside a form, once complete and submitted the answer values are used to create an object "results" which is then used by the controller input the information into an SQL statment to add to the database table.

Upon loading the scores page the results and questions are query from the database, compairs the two and outputs the user's score based on matching criteria/


Support
-------

If you are having issues, please let us know.
I can be contacted at: johnobruachail@hotmail.com

License
-------

The project has no licence.
