# Grading notes for assignment 03

Essentially we are trying to check if two arrays have a common value. For example, if we had two String arrays called `thisArray` and `otherArray`, our impulse would be to write something like this:
```java
for (int i = 0; i < thisArray.length; i++) 
  for (int j = 0; j < otherArray.length; j++)
    if (thisArray[i].equals(otherArray[j]))
      return true;
return false
```
But we are not allowed to use multiple returns in a method, so we have to write things a bit differently.

To do so, we have to convert a for-loop into a while-loop. In general a for-loop has three defining components: initialization, termination, and increment:

```java
for (initialization; termination; increment) 
```

We can use the same three components in a while loop. For example, consider the following for-loop that searches for a specific value in a String array:

```java
boolean found = false;
for (int i = 0; i < array.length; i++) {
    if (array[i].equals(specificValue)) {
        found = true;
    }
}
return found;
``` 
can be rewritten as a while loop:

```java
boolean found = false;
int i = 0;
while (!found && i < array.length) {
    found = (array[i].equals(specificValue));
    i++;
}
return found;
```

The difference is that the while-loop will exit as soon as the first match is found. The for-loop will continue past the first match, wasting time. Unless we add a break statement after the assignment `found = true;`. Using break statements is not a good practice when we can use a while loop.

For this problem we need two nested while loops:

```java
int thisIndex = 0;
while (!intersection && thisIndex < this.position) {
  int otherIndex = 0;
  while (!intersection && otherIndex < other.position) {
    intersection = (this.data[thisIndex].equals(other.data[otherIndex]));
    otherIndex++;
  }
  thisIndex++;
}
```

Both loops will terminate as soon as the condition
```java
(this.data[thisIndex].equals(other.data[otherIndex]))
```
evaluates to `true`.

Notice that in my solution, the boolean `intersection` is initialized as
```java
boolean intersection = (this == other);
```
If the two objects we are considering are the same, then they intersect by definition. There is no need to run the loop at all.

Another way to write the `intersects` method is to leverage the `contains` method. For example

```java
boolean intersection = (this == other);
int thisIndex = 0;
while (!intersection && thisIndex < this.position) 
  intersection = other.contains(this.data[thisIndex++]);
return intersection;
```
