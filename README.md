**Hangman game**

This is a simple Java implementation of the Hangman game.\
The server side is built upon a three-layer architecture: representation layer, business layer, and persistent layer.

These three layers are integrated by the Spring framework.
In the representation layer, this web-app uses Spring MVC framework to achieve the Model-View-Controller architecture, processing user requests.
The business layer performs the detailed game logic, including update the current game based on user input.
The persistent layer is responsible for data persistence. 
This web-app uses MyBatis framework.


*The following sections gives the instruction to run this web-app.*

---

## Database Preparation

This web-app requires a database to run. 
I use MySQL 8 throughout the development.
Two .sql file to generate table and data are provided in the repository. 
Here gives some descriptions of the database setting.

1. **game** table contains the information of every Hangman games.
   1. ID. The unique identifier of a game.
   2. word. The target word of this game.
   3. state. Indicating the game status (won, active, lost).
   4. remainingGuesses. Indicating the remaining number of guesses this game left.
   5. currentGuess. Representing the completion degree of this game.

2. **word** table stores a list of words that a game can choose from.
   1. ID. The unique identifier of a word.
   2. word. A word itself.


Note that the database connection configuration should be changed accordingly after the database initialization.
You can find the configuration in line 24 -- 29 from _src/main/resources/applicationContext.xml_.

---

## Build and Run

Next, you can use Maven to build this web-app and deploy it on a Tomcat server.

1. Import this project as a Maven web-app into your ide.
2. Build this project and deploy the **Hangman:war exploded** on the Tomcat server.
3. Run the web client at the URL http://localhost:8080/Hangman_war_exploded/index.jsp

---

## Future Work

