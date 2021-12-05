# Design Document

## Specification
Running the project allows the user to interact with a UofT Building Review System that shows 
in the system terminal. When the program runs, the program prints a prompt where the user can:
- Login 
- Create a new profile
- Exit (Quit the program)

Once logged in, the program prompts the user to input user's location on the alphanumerically 
gridded map

The program then prompts the user to either:
- View buildings
  - View all buildings
    - The program will return a list of all buildings
      - Leave a review of a building out of 5
  - Filter for buildings
    - The user can filter for specific buildings based on attributes like: group sitting, tables, 
    private study space, group study space, bathrooms, water fountain, food, accessibility, grid location
    - The program will return locations with those attributes that best fit the users specifications
        - Leave a review of a building out of 5
- Add building to system

## Clean Architecture
1) Dependency rule 
2) Entities
3) Use Cases
4) Controllers
5) UI

## SOLID
1) Single Responsibility Principle:
2) Open closed principle:
3) Liskov Substitution Principle:
4) Interface Segregation Principle:
5) Dependency Inversion Principle:

## Code Organization (Packaging strategies and use of git)
Files are packaged by layer and then by feature. This packaging is a reminder to follow clean 
architecture and keeps the packages small and manageable.

## Design Patterns
1) Decorator
   - The former was implemented already for Building, to specify different Building utilities while 
minimizing the number of additional subclasses. Since we were still working out the possible utilities,
we also left it as abstract classes and left a sample ConcreteBuildingDecorator class.
2) Memento
   - we were thinking of map states and updating the states of buildings, and if it was invalid we would go back to a 
previous state.