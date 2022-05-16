Let me recap the properties of functional programming once more to make sure we are all good.

So

#Pure Functions
A function is a pure function if:

* The execution of the function has no side effects.
* The return value of the function depends only on the input parameters passed to the function.

#Higher Order Functions
A function is a higher order function if at least one of the following conditions are met:

* The function takes one or more functions as parameters.
* The function returns another function as result.

#No State
As mentioned in the beginning of this tutorial, a rule of the functional programming paradigm is to have no state. By "no state" is typically meant no state external to the function. A function may have local variables containing temporary state internally, but the function cannot reference any member variables of the class or object the function belongs to.

#No Side Effects
Another rule in the functional programming paradigm is that of no side effects. This means, that a function cannot change any state outside of the function. Changing state outside of a function is referred to as a side effect.

State outside of a function refers both to member variables in the class or object the function, and member variables inside parameters to the functions, or state in external systems like file systems or databases.

#Functional Interfaces
A functional interface in Java is an interface that only has one abstract method. By an abstract method is meant only one method which is not implemented. An interface can have multiple methods, e.g. default methods and static methods, both with implementations, but as long as the interface only has one method that is not implemented, the interface is considered a functional interface.

from http://tutorials.jenkov.com/java-functional-programming/index.html