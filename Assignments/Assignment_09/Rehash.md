# Technical note: `rehash` and `put`

This note discusses the redundancy between methods `put` and `rehash` in the solution for assignment 9. The methods are shown below. Comments have removed for brevity.


## Method `put`

```java
public void put(Node node) {
    if (node != null) {
        int destination = computeArrayPosition(node.hashCode());
        if (destination < 0) destination = -destination;
        if (this.foundation[destination] != null) {
            node.setNext(this.foundation[destination]);
        } else {
            this.arrayUsed++;
        }
        this.foundation[destination] = node;
        this.nodesCount++;
        this.loadFactor = (double) nodesCount / (double) this.foundation.length;
        if (this.loadFactor > this.threshold) {
            this.rehash();
        }
    }
} // method put
```

## Method `rehash`


```java
private void rehash() {
    Node[] temp = new Node[RESIZE_BY * this.foundation.length];
    for (Node node : this.foundation) {
        Node current = node;
        while (current != null) {
            Node newNode = new Node(current.getData());
            int destination = newNode.hashCode() % temp.length;
            if (destination < 0) destination = -destination;
            if (temp[destination] != null) {
                newNode.setNext(temp[destination]);
            }
            temp[destination] = newNode;
            current = current.getNext();
        }
    }
    this.foundation = temp;
    this.loadFactor = (double) nodesCount / (double) temp.length;
} // method rehash
```


## Similarities and how to eliminate them

Both methods compute the position in an array of linked lists where to place a given node. And both methods place the node at the computed position, pushing existing nodes under the new node, if necessary.

Essntially, what `rehash` does is to create an array of linked lists, populate it, and then replace `this.foundation` with it. This is the equivalent of creating a hew `Hash271` object. So `rehash` can be reduced to the following (pseudo)code.

```java
Hash271 temp = new Hash271();
currentArray = this.getFoundation(); // instead of this.foundation
for (Node node: currentArray) {
    Node current = node;
    while (current != null) {
        temp.put(current); // use existing method to populate temp
        current = current.getNext();
    }
}
this.copyOf(temp) // see below about this new method we need
```

Method `copyOf` transfers the properties of `temp` to the current object:

```java
private void copyOf(Hash271 other) {
    this.foundation = other.getFoundation();   // copyOf 
    this.loadFactor = other.getLoadFactor();   // requires
    this.nodesCount = other.getNodesCount();   // 4 new
    this.arrayUsed = other.getArrayUsed();     // accessors
} // method copyOf
```


## Discussion

The new `rehash` method avoids the direct placement of nodes in the array of linked lists by delegating it to method `put`. So if we ever changed our insertion strategy we'll do that in one place only (`put`) and not two (`put` and `rehash`).

The "price" for this improved code is the implementation of five new methods: four accessors for `this.foundation`, `this.loadFactor`, `this.nodesCount` and `this.arrayUsed`, and a method `copyOf` to transfer one objects fields to another.

This is a small price to pay for better quality code.

In addition to `copyOf`, copying the temporary object `temp` to the current object can be achieved with a dedicated constructor or the implementation of the `Cloneable` interface. Both are beyond the scope of this technical note.