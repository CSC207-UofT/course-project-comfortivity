# Progress Report

## Purpose:
Our Code is meant to be a productivity app that aids everyday students, especially the relatively new ones, make better planned decisions on where to spend their time in between classes.

So far, we have been able to plan the structure of the code, although we do not yet know exactly how certain parts will be implemented, we have a good idea of what each part should do.


## Data Management:

We have decided to use the application data platform MongoDB, but we are still learning it and working out the details. Especially an issue is how it will fit into our code.


## Challenges: (SOLID, Code Style, Testing, Functionality, etc.)

Our main challenges currently involve code readability, and the code compiling and running incorrectly. To put it bluntly, the design for our code is not in a good state, with a lot of the classes having some redundant methods we added before and did not remove, some classes not obeying the dependency rule and being much more complicated than necessary (not obeying SOLID well), and so on, violating Clean Architecture.

Reading the code is also very confusing, as there are no Java docs, a lot of things are improperly and inconsistently formatted, and the parts that do function well are hurt by that. We haven't done too much refactoring yet either, as it seems like the code is just too unworkable. Testing would have helped with dealing with bugs, but we feel that the code is already too confusing to debug.

Not just that, but since we are still working out the details of the data management in our code, it is very difficult to run it practically for the moment.


## Progress: 

However, we have figured a decent temporary organizational structure for our code. The base entities (Building, Review, User) are packaged together, while the UI and the controllers, GUI, and data managing pieces of the code all are grouped together. Similarly, the use cases are also put together, and the requests are in their own separate package as well. In general, classes with a similar abstract purpose (either as objects, interfaces, requests, and UI Data Managing) are put together. We will flesh this out more in our new draft of code.

As well, we considered mainly two design patterns to use: Decorator and Memento. The former was implemented already for Building, to specify different Building utilities while minimizing the number of additional subclasses. Since we were still working out the possible utilities, we also left it as abstract classes and left a sample ConcreteBuildingDecorator class. For Memento, we were thinking of map states and updating the states of buildings, and if it was invalid we would go back to a previous state.

## Moving Forward:

As a group, we are thinking of creating a completely new code draft branch, which will obviously be inspired by some of the structural choices we made before and the workable parts of our design. However, as we are completely rewriting the code based on our updated model as opposed to updating the old model manually, we will make sure to keep the code streamlined all through writing it, and instead of just writing redundant sample placeholders, we will leave them as TODOs.

As well, we will be adding a CRC card section to our code that describes our code in detail and how each module is dependent on one another. We were unable to do this clearly because of our lack of direction and our consideration of several ways of implementation, but after our meetings we have had a much more concrete idea of how to write this code. We plan on dedicating much more time to this project as well, especially as a complete rewrite of the project. We also will create a more coherent log of our contributions to this updated version of the project, as well as more clearly organized packages and good code style with documentation.

## Contributions: (what was implemented and done)

Gesikeme Wodu: 

David Basil: 

Edmund Rong: 

Nori Lam: 

Gurmanjot Singh: Organized modules into packages, made Decorators for Building, and Buildable interface.
