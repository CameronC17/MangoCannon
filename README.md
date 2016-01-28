# MangoCannon

##Jacob Burns, Cameron Chalmers, Tom Hanson
- not designing from scratch

###Stuff to ask Andy
1. Do we need a GUISettings Class?
No
'The idea of permissions' - different users?
- can manage permissions through GUI but its not very nice

2. GPS class has no variables - I am manually adding the x and y coordinates as an array
- How a sensor gets to know and reports it's location
- Simulate it

3. User class has no password
- add it
4. Where are we importing the libraries mentioned in the class diagram?
- use whatever
5. Class diagram shows no use of super classes to hold objects created by other classes, instead uses arrays. Will we be penalised for this?
- adding the superclasses in is OK 
- exam open wuestiosn changed between design and application. say these classes were not there so you added them.
6. UserRegister login function returns a user - what if the login credentials are wrong?
- throw an exception
7. Should we use a seperate (new) coordinates class, because lots of classes use coordinates, and it would be neater to use standardised coordinates!!
- yes
- Have a location class because not just found by GPS coordinates, can be triangulated
8. There shouldnt be a list of fields in the main GUI - do we need a new class of ListOfFields?
- A user has a list of fields
