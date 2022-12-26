# Mat1_OOP

## Program Patterns and general explenation:
In this program we will use the Observer Desigen Pattern. 
Observer Pattern is a type of a Behavioral Pattern, which is a structures in charge of the algorithmic and practical part of the program.
The idea of the Observer pattern is that we define a dependence between an object(mostly called Observable) to a number of another 
objects (mostly called Observers), that so if the "Observable" changes it's status all the "observers" are informed about the change with the <notifyall/update> methods and get updated automaticlly.

In our program the "Observable" is defined as a "GroupAdmin" which includes the "UndoableStringBuilder" type, and all it's built-in methods. 
The "GroupAdmin" contains also a list that holds it's observers.
With each change we make in the Observable(such as append/delete/reverse...) we notify all the observers about the specific change and updating the ConcreteMember data field.


## How to run the program:
1. Download our zip folder and extract it to an empty folder
2. Open the project folder in your favorite JAVA IDE
3. Now you can create a new GroupAdmin Object which represents your observable Object and create a new ConcreteMember Object which represents the observers in your program
4. Registeration of a new ConcreteMember will be done using the "register" method. --> <GroupAdminName>.register(<ConcreteMemberName>)
5. In the same way the "unregister" method will un the desired ConcreteMember from the GroupAdmin database. 
6. With each change that will be made on the GroupAdmin(UndoableStringBuilder), all the observers that are registered to the GroupAdmin will be "notified" by the change and update their data accordingly. 


