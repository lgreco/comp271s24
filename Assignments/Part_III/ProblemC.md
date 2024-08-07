# Problem C

Make sure that the problem number above matches the problem assigned to you.

The Programmer's Pact is in full force here. Your code must compile and must produce correct results. Thoughtful comments, well formatted code, single returns, etc are essential.

Use of AI tools is highly discouraged.

During the one-on-one with Leo you are expected to explain how your code works and demonstrate mastery of the techniques used for the problem.

Read the specifications carefully. 

You may not use any external classes (no import statements) and no components of class `System` except for printing when necessary.

Please email all java files to Leo prior to your one-on-one with him. In preparation for your meeting, please have your IDE running so that you can demonstrate your code working.

## Specifications

Write a singly-linked list class with simple node objects that contain a String `data` and a `Node next`. You'll have to write class Node as well.

In your linked list class, write the following methods

* **`void addNode(Node node)`** to **append** the given node to the linked list.
* **`void addNode(String data)`** to append a node with the string `data` to the linked list.
* A method of your own naming and type (including `void`) that reverses the linked list -- for now let's call it `method1`, but you should find a better, more descriptive name.
* A method of your own naming and type (including `void`) that removes any duplicate nodes from the linked list -- for now let's call it `method2`, but you should find a better, more descriptive name.



Your linked list object may have one and only one attribute.


If your `method1` works correctly and your initial linked list is, for example,

```
A -> B -> C -> D -> E -> F -> G -> null
```

then the invocation of your method will return

```
G -> F -> E -> D -> C -> B -> A -> null
```


If your `method2` works correctly and your initial linked list is, for example,

```
A -> B -> B -> B -> B -> C -> C -> null
```

then the invocation of your method will return

```
A -> B -> C -> null
```