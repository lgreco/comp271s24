# Assignment 10 - final Assignment


## Part I: self-assessment




### Self-assessment

In *Ungrading,* you, the student, are responsible for assessing your work and for proposing your course grade. As your instructor, my responsibility is to ensure that your assessment and proposal are based on technical merit, facts, and fairness.

The Sakai grades you receive only indicate whether you turned in an assignment or not. A grade of 0 means that you missed the assignment. A grade of 1 means that you turned it in on time. *A grade of 1 does not mean that the assignment is correct.*

The only person that can determine if your assignment is correct, truly is you. Even before reviewing the solutions and the grading notes I share, you have an idea how good your assignment is. For example, if your code did not compile or if you did not try to compile your code, you know it's not as good as it could have been.

Reallistically, you can assign one of three grades to yourself: A, B, or C.


#### The job interview approach

One way to determine which grade to assign yourself, is to imagine the following scenario: you are at a job interview and the questions are based on this course. How do you feel about getting the job, after your technical interview? 

* **A** means that you are 100% confident you'll get the job, no matter how good the other candidates may be. An **A-** means that you believe there is another student in the course who may get the job instead of you.

* **B** means that you are confident you'll get the job as long as not too many better candidates show up. A **B+** means that no more than 1/5 of your classmates may be among these better candidates. A **B-** means that more than 1/2 of your classmates can be among these better candidates.

* **C** means that most of the other candidates will perform better than you and it's unlikely you'll get the job. A **C+** means that there may be one person in the course that is even less likely to get that job. A **C-** means that if everyone in your class went to the same interview, you will definitely not receive an offer.

What about a **D?** This grade means that after your technical interview you realized you should not have even tried. I reserve **D** for students that make an effort: coming to class, turning in assignments etc, but they decided this is not the time for them to pursue this discipline. Finally, I give an **F** only when there is no participation, no assignment submission, and no communication.


#### A course-based approach

The job interview approach above is illustrative but subjective. You may want to evaluate your work in the coure by reflecting on the strength of your participation, the quality of your assignments, and the responsiveness to feedback about mistakes.


##### Participation

Participation can be assessed across attendance, engagement, and involvement.

**Attendance** means that you came to class on time and that you did not miss more than 5 class meetings. On time means that you were present within a minute of class start time. 

**Engagement** means that your camera was on for most of the meetings (it's ok if it was off for a few minutes per meeting, or for a few meetings). It also means coming to *Student Hours* with questions, or emailing the instructor for assistance.

**Involvement** means that you asked questions during class, that you were among the first students to answer a question asked by the instructor, etc.


##### Assignments quality

This reflects mostly how good you feel about your work. Do you feel it's the best you could have done? Did you start working on assignments early or late? Did you give yourself enough time to study the assignment and formulate questions for the instructor? When hitting a snag, did you seek assistance/clarifications from your instructor?

If you wrote a program, did it compile without errors? Did it execute and produce the correct results?


##### Responsiveness to feedback

We all make mistakes. Our challenge is to learn from them. How well did you learn from your mistakes? Did you compare your code with the published solutions? Did you identify the differences? Did you learn from them and make a point not to repeat mistakes that you found? 

If your assignment required a checklist (such as the *Programmer's Pack)* did you use it? If you used it, did you miss any items? If you missed any items, did you make a point to avoid missing them in the next assignment?

Did you complete your assignment reviews based on published solutions and grading notes? If you found **red level** severities, did you schedule a meeting with the instructor to discuss them?


#### Deliverable

For this part of your final assignment, write a reflection assessing your peformance in the course. The reflection can be anywhere between 50 and 500 words. The last sentence of the last paragraph of reflection should be in the form: <br/>

<p style="text-align: center"><i>Based on the above, I propose a course grade of x.</i></p>

where `x` is an **A, B,** or **C**. You may use a +/- modifier as well. It is very important that the **last sentence of the last paragraph of your reflection is as specified above.** 

Your reflection should be factual and fair. 

You may discuss course challenges (for example, "Codespaces was a difficult environment") but also what you did to address them (for example, "I switch to BlueJay" or "I asked the instructor for assistance", etc). Challenges are present in everything we do; it's how we handle them that matters.


## Part II: technical


### Problem 1: Sorting

In introductory programming courses we learn how to do simple sorting of arrays, using inefficient methods like *Bubble Sort.* It is time to discover, on our own, a more efficient way to do so by implementing the *merge sort.*

There are two ways to implement merge sort: recursive and iterative. In this assignment we are **only interested in the iterative implementation.**

For this assignment, we'll assume that sorting is done in ascending order.


#### Merge first

Start with a method 

```java
int[] merge(int[] left, int[] right) {...}
```
that takes two integer **sorted** arrays called `left` and `right` respectively and merges them into a single sorted array. For example,

```java
int[] a = {1,2,8,9};
int[] b = {0,5,6,7};
...
int[] c = merge(a,b);
```
should result to
```java
[0,1,2,5,6,7,8,9]
```
The method may assume that the two input arrays are already sorted.

There are plenty of solutions to this problem online. Therefore, you are expected to document your code with sufficient comments and use highly descriptive variable names, demonstrating that you fully understand how it works.

#### Sort next

Merge sort is based on the observation that an array with one element is already sorted. Think, for example, who's the best CS professor you had at Loyola who's Greek, born in 1967, has two dogs, and a pilot's license. (Hint: he's also the worst CS professor you had at Loyola who's Greek, born in 1967, has two dogs, and a pilot's license).

If we have two singular arrays, for example,
```
int[] a = {10};
int[] b = {8};
``` 
they are, by definition sorted. As as such they can be fed to the `int[] merge` method and produce the sorted array `[8,10]`.

So, if someone gave us the array `[10,8]` and asked us to sort it in ascending order, we can split it in two singular arrays, feed them to `merge`, and get the desired result. Likewise, if we are given the array `[10,8,5,3]` to sort, we can first break it into two arrays `[10,8]` and `[5,3]`, then split them into halves again, which are the pairs `[10]`, `[8]` and `[5]`, `[3]`. These are singular arrays, and they can be fed to `merge`. They'll result into the sorted arrays `[8,10]` and `[3,5]`. And because they are sorted, they can be fed into `merge` again, resulting to `[3,5,8,10]`.

So the idea is that given an array, to keep dividing it in halves until no more, i.e., until it's all singular arrays. Then merge pairs of singular arrays to 2-element arrays that are now sorted. Then merge pairs of those 2-element arrays into 4-element arrays, that are also sorted as so on.

It helps if you assume that the input array we wish to sort has always $2^n$ elements, e.g., 8, 16, 32, 64, etc. That allows us keep dividing the array in halves perfectly. 

Write a method `int[] sort(int[] array)` that takes an integer array with $2^n$ elements and sorts it in ascending order, by using the technique described above.


#### Put it together


For this problem submit a Java class with name `Sorting271`. Your class should include the two methods described above, and a `main` method to test your code. You cannot use any methods from `System` or `java.util.Arrays`, except for `System.out.println`, `System.out.printf`, and `Arrays.toString`. You may also include any auxiliary methods you require.

It is imperative that your code is in full compliance with the Programmer's Pact.

Testing code will be provided by Friday 8/2/24.


### Problem 2: reverse list printing

Using classes `TrainLine` and `Station` write a method `String TrainLine.reverseListStations()` that returns a string with the names of the train station in reverse order. You may traverse the `TrainLine` object only once. 

 For example, if a train line is instantiated and populated as:

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
lincolnService.reverseListStations();
```

shall **return a `String`** with the following content (new line characters will not show explicitly but I am adding them here to *emphasize* that each station name shall appear in a separate line):

```text
Saint Louis\n
Alton\n
Carlinville\n
Springfield\n
Lincoln\n
Bloomington\n
Pontiac\n
Dwight\n
Joliet\n
Summit\n
Chicago
```

You may only traverse the `TrainLine` object once for this method and you cannot use any data types others than `Station` and `String` but not as arrays. If the `TrainLine` object is empty, `reverseListStations` should return the string `"The line is empty."`.


## Part III

You may skip Part I and Part II if you prefer to consider Part III. This alternative assignment comprises a live-coding session with your instructor during which you'll discuss your solution to a programming problem that will be given to you 24 hours prior to the meeting. Such a problem is likely to involve implementation of an interface, code refactoring, and testing. 

**This is a high risk, high gain** option. Your performance in this part will determine your course grade. You will be expected to be in complete command of your code, demonstrating that you fully understand everything that it does. You can change your mind and complete Parts I and II up until a Part III problem is assigned to you. Once the 24-hour clock has started, you have to complete Part III.

*In the past, some students opting for this final assignment have used online sources to support their work. However, during the live-coding session they were not able to justify the techniques used or to demonstrate they understood what was done. Such gaps will result to a D or F.*  

**If Part III is so risky, why do I offer it?** To help students that, for whatever reason, could not demonstrate fully their true skills. But they are confident enough in those skills to consider the risk. This option is available only to students who have completed at least 60% of the assignments in the course. It is not meant as a way to make up for signifant amounts of missed work.