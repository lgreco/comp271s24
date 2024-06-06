# Grading Notes for Assignment 01: Dynamic Array

In this assignemnt you were given the following starter code and you were asked to complete it (for brevity, mostcomments have been ommitted).

```java
public class DynamicArray {

    private String[] data;
    private int position;
    private static final int DEFAULT_SIZE = 10;

    public DynamicArray(int size) {
        this.data = new String[size];
        this.position = 0;
    } // basic constructor

    public DynamicArray() {
        this(DEFAULT_SIZE);
    } // default constructor

    public void add(String string) {
        // Make sure there is room in array data
        if (this.position == this.data.length) {
            resize();
        }
        // Now array has room for more elements.
        this.data[this.position] = string;
        this.position++;
    } // method add
    
} // class DynamicArray
```
Specifically, you were asked to write three methods:

* `resize`
* `contains`, and
* `countOf`



## Method `resize`

There best way is to write a **void** method:

```java
private void resize() {
  String[] temp = new String[2*this.data.length];
  for (int i = 0; i < this.data.length; i++) {
    temp[i] = this.data[i];
  }
  this.data = temp;
} // method resize
```
Notice that the method is **private.** It cannot be called by an outside program. Resizing the underlying array is an *internal* affair for this object.

In the implementation above, we use a temporary array with twice as much room as the object's underlying array. Once the values from `this.data` have been copied over to the temporary array, we reassign `this.data` to the new array. The object now has a larger underlying array.

The choice for a void method is supported in the code provided: method `add` calls remove `resize()` without expecting a return.

```java
if (this.position == this.data.length)
  resize();
```


Another way to write `resize()` is to make it a return method:

```java
private String[] resize() {
  String[] temp = new String[2*this.data.length];
  for (int i = 0; i < this.data.length; i++) {
    temp[i] = this.data[i];
  }
  return temp;
} // method resize
```

This method however, is not supported in the code provided. If we needed a return type for `resize()`, the code in method `add` would have been:
```java
if (this.position == this.data.length)
  this.data = resize();
```

Method `resize()` should be parameter-*less*. That's because it is invoked -- in method `add` without any arguments. 



### Common mistakes in `resize`

* Writing the method with a return type, e.g., `String[] resize()`. It's important to look at how the method is invoked in the existing code, and infer its characteristics.

* Writing the method with parameters, e..g., `resize(String[] someArray)`. Again, we must look at how the method is invoked. If there are no argumenents in the invocation, we cannot arbitrarily decide to add parameters to the method.

* Syntax errors such as typeless arguments, e.g, `resize(someArray)` instead of `resize(String[] someArray)` or ommitted return statement if method is writen with a return type. 



## Method `contains`

We discussed this method in class, so its implementation is straight-forward.

```java
public boolean contains(String string) {
  boolean found = false;
  int i = 0;
  while (!found && i < this.position) {
    found = string.equals(this.data[i++]);
  }
  return found;
} // method contains
```
The while-loop above ends when a match is found or we run out of elements to consider, whichever happens first. Notice that the loop does not run all the way to the end of the array (`i<this.data.length`) but stops when it reaches `this.position`. That's important because the underlying array has values up to `this.data[position]`. Everything beyond that are `null` values.