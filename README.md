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


Support
-------

If you are having issues, please let us know.
I can be contacted at: johnobruachail@hotmail.com

License
-------

The project has no licence.
