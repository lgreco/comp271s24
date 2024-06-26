# Grading notes for assignment 04

## Search for a station

*Using classes `Station` and `TrainLine` in folder `Week_05`, write a method called `contains` that returns true if a station with a specified name exists in a `TrainLine` object and false otherwise.*

The problem specifies that the method should return `true/false` values and that implies a boolean method. 

```java
public boolean contains(String name) {
    boolean found = false;
    Station current = this.head;
    while (!found && current != null) {
        found = current.getName().equals(name);
        current = current.getNext();
    }
    return found;
} // method contains
```



## Design (specify) the string representation of `TrainLine`

*Propose a String representation of a `TrainLine` object. Your proposal should be specific enough that an intermediate developer could execute it. Focus on what would you like the representative string to look like.*

For this method, I'd use a `StringBuilder` object to build a textual representation of a `TrainLine`. `StringBuilder` is gentler with memory resources and prefereable when building a textual representation of an object iteratively. Using a `String` is fine too, but gradually you should shift to `StringBuilder` for iterative constructions.


```java
public String toString() {
    StringBuilder sb = new StringBuilder();
    if (this.head == null) {
        sb.append(EMPTY_LINE);
    } else {
        Station current = this.head;
        while (current.hasNext()) {
            sb.append(String.format("[ %s ] --> ", current.getName()));
            current = current.getNext()
        }
        // Treat the last station in the line
        sb.append(String.format("[ %s ]", tail.getName()));
    }
    return sb.toString();
} // method toString
```

Assume that `EMPTY_LINE` is defined as a `TrainLine` class constant:

```java
private static final String EMPTY_LINE = "This line has no stations";
```