# Assignment 5

As with *every assignment* in this course, you cannot import anything to your code. Furthermore, you cannot use any `System` function except for `System.out` print statements where and when needed. Finally, your code should not use any `for`-loops.

Your code must be compliant with the Programmers Pact, as much as possible.

You can test your work by running `SimpleTesting.main`.



## Search for the position of a station

Using classes `Station` and `TrainLine` in **this** folder (`Assignment_05`), write a method called `indexOf` that returns the numeric position of a station with a specified name in a `TrainLine` object. If no station with the specified name is found, the method returns -1. Use 0 for the `head` station. A stub method is provided at the end of the `Trainline` file.

Then rewrite `TrainLine.contains` to take advantage of `TrainLine.indexOf`. You earn bragging rights if your revised `contains` has only one statement it it.


## Design (specify) a method to append a `TrainLine` object to another `TrainLine` object

Consider that you want to add an existing, non-null, non-empty `TrainLine` object to end of similar object. For example consider the following two objects:

```
TrainLine A = Howard --> Jarvis --> Morse --> Loyola --> null
TrainLine B = Granville -- > Thorndale --> Bryn Mawr --> null
```

The desired behavior should be

```java
A.append(B)
```

resulting to

```
TrainLine A = Howard --> Jarvis --> Morse --> Loyola --> Granville -- > Thorndale --> Bryn Mawr --> null
(TrainLine B remains the same)
```

The behavior `A.append(B)` implies that we write, in `TrainLine`, a method with signature

```java
public void append(TrainLine other)
```

Write the `append` method.

Modify `SimpleTesting` to demonstrate that your `TrainLine.append` works.

