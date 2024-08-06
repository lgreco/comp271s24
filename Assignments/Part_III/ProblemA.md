# Problem A

Make sure that the problem number above matches the problem assigned to you.

The Programmer's Pact is in full force here. Your code must compile and must produce correct results. Thoughtful comments, well formatted code, single returns, etc are essential.

Use of AI tools is highly discouraged.

During the one-on-one with Leo you are expected to explain how your code works and demonstrate mastery of the techniques used for the problem.

Read the specifications carefully. 

You may not use any external classes (no import statements) and no components of class `System` except for printing when necessary.

Please email all java files to Leo prior to your one-on-one with him. In preparation for your meeting, please have your IDE running so that you can demonstrate your code working.

## Specifications

Write a singly-linked list class with simple node objects that contain a String `data` and a `Node next`. You'll have to write class Node as well.

In your linked list class, write the following methods:

* **`void addNode(Node node)`** to **append** the given node to the linked list.
* **`void addNode(String data)`** to append a node with the string `data` to the linked list.
* A method of your own naming and type (including `void`) that splits the linked list object into a given number of linked lists and returns all of them.
* Additional methods to print the linked list object (`toString()`) an well as a method to print the result of the splitting. Notice that the method doing the spliting should not do any printing.

Your linked list object may have one and only one attribute.

If your splitting method works correctly and your initial linked list is, for example,

```
A -> B -> C -> D -> E -> F -> G -> null
```

then splitting it into say 3 linked lists would produce the following

```
A -> B -> null
C -> D -> null
E -> F -> G -> null
```

The resulting linked lists must be of even length, as much as possible. In the example above, we divided a linked list with 7 nodes into 3 lists of 2, 2, and 3 elements respectively. Therefore, the last linked list may, sometimes, have a few more elements than the rest of the lists.