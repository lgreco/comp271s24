# Assignment 8

As with *every assignment* in this course, you cannot import anything to your code. Furthermore, you cannot use any `System` function except for `System.out` print statements where and when needed. Finally, your code should not use any `for`-loops.

Your code must be compliant with the Programmers Pact, as much as possible.



## List stations

Write a method `String listStations` that returns a string with names of the stations in a `TrainLine` object, in the order in which the train line is traversed. For example, if a train line is instantiated and populated as:

```java
TrainLine linconService = new TrainLine();
lincolnService.add("Chicago");
lincolnService.add("Summit");
lincolnService.add("Joliet");
lincolnService.add("Dwight");
lincolnService.add("Pontiac");
lincolnService.add("Bloomington");
lincolnService.add("Lincoln");
lincolnService.add("Springfield");
lincolnService.add("Carlinville");
lincolnService.add("Alton");
lincolnService.add("Saint Louis");
```

then

```java
lincolnService.listStations();
```

shall **return a `String`** with the following content (new line characters will not show explicitly but I am adding them here to *emphasize* that each station name shall appear in a separate line):

```text
Chicago\n
Summit\n
Joliet\n
Dwight\n
Pontiac\n
Bloomington\n
Lincoln\n
Springfield\n
Carlinville\n
Alton\n
Saint Louis
```

You may only traverse the `TrainLine` object once for this method and you cannot use any data types others than `Station` and `String`. If the `TrainLine` object is empty, `listStations` should return the string `"The line is empty."`.

## Detect intersections

Consider the following three `TrainLine` objects.

```java
TrainLine t1 = new TrainLine();
t1.add("A"); t1.add("B"); t1.add("C"); t1.add("D"); 

TrainLine t2 = new TrainLine();
t2.add("Y"); t2.add("B"); t2.add("Z"); 

TrainLine t3 = new TrainLine();
t3.add("K"); t3.add("L");

TrainLine t4 = new TrainLine();
```

Write a method `boolean intersects(TrainLine other)` that returns `true` if the two lines cross each other and false otherwise. For example:

```java
t1.intersects(t2); // true because "B"
t2.intersects(t1); // also true because of "B"
t1.intesercts(t1); // duh, I mean true by definition
t1.intersects(t3); // false, no common station
t1.intersects(t4); // false because t3 is empty
```

## Implement Comparable

Write a method `int CompareTo(TrainLine other)` that returns a negative value if the invoking `TrainLine` is smaller than the `other` one, zero when equal, and a positive number when greater. You can always assume that the invoking `TrainLine` is not null.

It is up to you to determine what makes a `TrainLine` object bigger, same, or smaller than another one. Document your decision in the Javadoc of the method.