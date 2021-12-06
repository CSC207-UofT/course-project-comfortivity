
SCENARIO:
The user is at 50 St. Joseph Street and would like a quiet place to study and eat. The system will then sort suggestions from: St. Michaels College’s the Coop (1 minute walk, with food at Brennan Hall’s Canada room), The Kelly’s Library study room (2 minutes walk, with food at Kelly’s Cafe), Robarts Library 5th floor (10 minutes walk, with food at the food court), etc.
The user then chose to go to the Kelly’s Library. After the stay they decide to review on the place and the food. They rated 4 out of 5 for quietness and 3 out of 5 for food.  

Scenario Walk-Through:
1.	The user creates a user profile. This prompts the creation of a NewUserRequest, which is passed to the UIController class which calls on the appropriate method in The Data Manager class that updates the Data Files(Files that store user info, building info and map info) with the new users information.
2.	The user begins a search and inputs his location, as well as the main activity he wants to do in the next building, e.g., private study, group study, rest, eat, etc. This also creates a SearchRequest that has the specifications for the user’s search as its attributes.
3.	The UIController returns a collection containing the search criteria. This is then passed to the search use case as arguments for the search method, which runs the code.
4.	The search method in the UseCases.Search UseCase Class class then runs and returns the best building option for the user based on algorithm that considers the building’s own starrating attribute, the user’s also stored preference list attribute(assuming this user has used the application before), and the inputted filter arguments.
5.	At any point, the user could give a general rating of the building, as well as criteria specific ratings, such as good for studying, good for eating, patio dining, e.t.c. When this happens, the UIController passes the review from the CLI to the appropriate DataManager method.
6.	When a new rating is made, the ReviewBuilding class calls on the Data Manager class(through its methods) updates the Data Files: the new rating is recorded under the user’s profile, and the rating is used along with other ratings to form the cumulative rating of the building which is then stored on the Data Files.
7.	When a user instance is loaded from the data files, the user’s preferences are used to  generate/update the user’s preference list – a list of buildings the user prefers based on the rating criteria, which is also stored as an attribute of user, and also updated on Data Files.
