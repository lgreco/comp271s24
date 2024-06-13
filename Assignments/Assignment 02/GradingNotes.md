# Grading notes for assignment 02

This was seemingly an easy task: write a method, in class `BookReview`, to load words from an online book to a `DynamicArray` object using its `addUnique` method. For example,

```java
DynamicArray uniqueWords = new DynamicArray();
Scanner book = connectToBook(bookLink);
while (book.hasNext()) {
  uniqueWords.addUnique(book.next());
}
```

Then what? How do we count and report the unique words.

There are two ways.

## Take advantage of `boolean addUnique`

Method `DynamicArray.addUnique` has a boolean return. We can capture that return and use it to operate a counter (for brevity, I am omitting curly braces):

```java
DynamicArray uniqueWords = new DynamicArray();
Scanner book = connectToBook(bookLink);
int counter = 0;
while (book.hasNext())
    if (uniqueWords.addUnique(book.next()))
        counter++;
return counter;
```

## Take advantage of `DynamicArray.position`

When we use `DynamicArray.addUnique` then `DynamicArray.position` is essentially the counter of items added to the dynamic array object. So we could try:

```java
DynamicArray uniqueWords = new DynamicArray();
Scanner book = connectToBook(bookLink);
while (book.hasNext())
    uniqueWords.addUnique(book.next());
return uniqueWords.position;
//                 ^^^^^^^^ OOPS!
```

It will not work because `position` is a private field and cannot be accessed from another class (in this case, the code above is in class `BookReview`). To overcome this problem, we can add a new method to `DynamicArray`:

```java
public int getPosition() { return this.position; }
```

and change the code above to 

```java
DynamicArray uniqueWords = new DynamicArray();
Scanner book = connectToBook(bookLink);
while (book.hasNext())
    uniqueWords.addUnique(book.next());
return uniqueWords.getPosition();
```

Of course we could also change the `position` field from `private` to `public`, and just access it directly. Perhaps, if we can absolutely sure that such exposure will not create security issues down the road. Until then, the best way to do things is to keep all object fields private, and expose them to other programs with accessor (getter) methods.
