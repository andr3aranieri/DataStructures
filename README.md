[![Build v0.01 Status](https://travis-ci.org/andr3aranieri/DataStructures.svg?branch=master)](https://travis-ci.org/andr3aranieri/DataStructures)

# DataStructures
A reimplementation of the java data structures

In this project i will try to reimplement different Java data structures in a more efficient way than the original implementation.

## Queues

###### QueueWith2Stacks

The idea is taken from a challenge on the [HackerRank](https://www.hackerrank.com) website. 

I've used 2 instances of the class [java.util.Stack](https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html) to emulate a Queue with
the following operations:
1. enqueue to add an element;
2. dequeue to return and remove the last inserted element;
3. peek to return the last inserted element without removing it from the queue;

I use the 2 stacks as the 2 halves of the queue:
1. all the enqueues are done in the stack1;
2. all the dequeues and peek are done from the stack2; when stack2 is empy, we reverse the elements of stack1 in stack2. 
This reverse operation is done using the addAll() method inherited by the Vector class, and the Collestions.reverse() method.

The test executed on 100000 operations (conteined in the file inputdata/MyQueue/Input1) showed a performance comparable to 
ConcurrentLinkedQueue, LinkedBlockingDeque, LinkedBlockingQueue and LinkedTransferQueue java 7 implementations.

###### Run

Just run the Main class and you'll be asked to choose the implementation to test. 

Welcome. Commands:
   1 --> Test Queue with 2 stacks implementation;
   2 --> Test Java Concurrent Linked Queue;
   3 --> Test Java Linked Blocking Deque;
   4 --> Test Java Linked Blocking Queue;
   5 --> Test Java Linked Transfer Queue;

