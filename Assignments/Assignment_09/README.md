# Assignment 9

As with *every assignment* in this course, you cannot import anything to your code. Furthermore, you cannot use any `System` function except for `System.out` print statements where and when needed. Finally, your code should not use any `for`-loops.

Your code must be compliant with the Programmers Pact, as much as possible.


## Class `Hash271`

Modify class `Hash271` as follows.

* Maintain a `double loadFactor` defined as the ratio of nodes present in `this.foundation` to the length of `this.foundation`.

* When `loadFactor` exceeds a user-specified threshold, double the size of `this.foundation` and move the nodes from the old array to the new array, using the same mechanism as before, to find their positions in the new array. The default value for the threshold should be `0.75`.

## Hints

Resizing and repopulating `this.foundation` should be done in a separate method:

```java 
private void rehash() {...}
```

