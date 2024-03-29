# Data-Structures
Some projects with implementing data structures

## Contents

- [TWO DIMENSIONAL ARRAY GAME](#two-dimensional-array-game)
- [CIRCULAR LINKEDLIST 1](#circular-linkedlist-1)
- [CIRCULAR LINKEDLIST 2](#circular-linkedlist-2)
- [PATH FINDING](#path-finding)
- [STACK](#stack)
- [BALANCED TREE](#balanced-tree)
- [TREE PATH](#tree-path)
- [NGRAM ANALYZER](#ngram-analyzer)
- [SPLAY TREE](#splay-tree)

## TWO DIMENSIONAL ARRAY GAME

The Rules of the Game

      1.  All players can move one step at a turn.
      2.  All movements must be in random direction (north, south, east or west).
      3.  Any obstacles are not permitted to move.
      4.  If a player moves to the obstacle, it remains inactive in its place for the same turn.
      5.  All players and obstacles occupy one tile space.
      6.  There can be any number of players in one tile.  There must be only one obstacle in any tile.
      7.  If any player reaches to the finish point, the game is over and the player wins.

Sample Game Config (var.cfg file)

      height: 5000
      width: 5000
      numberOfPeople: 500
      numberOfObstacle: 2000

commands for run
 
      javac *.java
      java Main
      
returns 

      result.txt file


## CIRCULAR LINKEDLIST 1

 Given two circularly linked lists, L and M.
 Develop java application for telling 
 if L and M store the same sequence of elements 
 (but perhaps with different starting points)
 
commands for run
 
      javac *.java
      java Main 

returns 

      true, if there is same sequence of elements 
      false, if there is not
      
 ## CIRCULAR LINKEDLIST 2
 
 Given a circularly linked list L containing an even number of nodes,
 develop java application how to split L into two circularly linked lists of half the size.
 
 commands for run
 
      javac *.java
      java Main 

returns 

      splits 2nd half of circular linked list to another list and returns this list.
      And given circular linked list becomes 1st half of the circular linked list

## PATH FINDING

Rules

      There is a terrain that consists of a number of H x W tiles.  
      In each tile, there can be a player or an obstacle. 
      There must be 1 player and p obstacles and 1 finish point that are placed in a random position upon the terrain. 
      Write all possible route in which no tile is revisited for the player from starting point to finishing point.

Sample Config (var.cfg file)

      height: 3
      width: 4
      numberOfObstacle: 2

commands for run
 
      javac *.java
      java Main 

returns 

      result.txt

sample result output

      f is finish point, x is obstacle, p is player

      0x00
      00px
      f000
      (2, 1) (1, 1) (0, 1) (0, 2) 
      (2, 1) (1, 1) (1, 2) (0, 2) 
      (2, 1) (2, 2) (1, 2) (0, 2) 
      (2, 1) (2, 2) (1, 2) (1, 1) (0, 1) (0, 2) 
      
## STACK

Rules

      For a given integer array. for each element, starting from left to right,
      find the first integer(y) with a value greater than the existing one(x),
      then find the next first integer(z) with a value smaller than y(left to right) integer of it.
      If next greater and small are no -1, print (y-z)to the console, else print -1.
      **Must use stack to find numbers**
      
Sample Config (stackInput.txt)
      
      input: 3, 0, 11, 9, 2, 1, 10, 5

Visualization
      
	1. arr[0]= 3 (x), next greater 11 (y), next smaller: 9 (z)
	2. arr[0]= 0, next greater 11, next smaller: 9
	3. arr[0]= 11, next greater -1, next smaller: -1
	4. arr[0]= 9, next greater 10, next smaller: 5
	5. arr[0]= 2, next greater 10, next smaller: 5
	6. arr[0]= 1, next greater 10, next smaller: 5
	7. arr[0]= 10, next greater -1, next smaller: -1
	8. arr[0]= 5, next greater -1, next smaller: -1

Output

      2, 2, -1, 5, 5, 5, -1, -1

Commands for Run

      javac *.java
      java Main 

returns 

      outputStack.txt


## BALANCED TREE

Rules

      Find is binary tree balanced or not
      
Sample Config (input.txt)
      
      5 4 8 11 - 13 4 7 2 - - - - - 1 // breadth-first search ('-' is null pointer) 
      
Output

      true or false //  false for this case	

Commands for Run

      javac *.java
      java Balanced 

returns 

      output.txt

## TREE PATH

Rules

      check is tree have path that sum of values is equal to given number
      
Sample Config (input.txt)
      
      5 4 8 11 - 13 4 7 2 - - - - - 1 // breadth-first search ('-' is null pointer) **searching for 22**
      
Output

      false or true // true:  T[0] 5 T[1] 4 T[3] 11 T[8] 2  for this one (searching for 22)
      
Commands for Run

      javac *.java
      java Path 

returns 

      output.txt
      
## NGRAM ANALYZER

Rules

      Given a text document and a n value. Program must exrtact all n-gram of the text document
      an n-gram is a contigous sequence of from a given sample of text.
      Basically frequency of sequence of n(2 in this case) words
      MUST USE HASHMAP
      
Commands for Run

      javac *.java
      Java NgramExtractor input.txt output.csv 2
      
Sample Config (input.txt)
      
      You are expected to develop a text analyzer tool.  The program allows you to find the most
      frequent phrases and frequencies of words.  Non-English language texts are supported.  It
      also counts number of words,  characters,  sentences and syllables.  Also calculates lexical
      density
      
Output

        Total number of tokens: 41
	ngram,count,frequency
	of words,2,4.878048780487805
	the program,1,2.4390243902439024
	characters sentences,1,2.4390243902439024
	frequent phrases,1,2.4390243902439024
	to develop,1,2.4390243902439024
	and syllables,1,2.4390243902439024
	frequencies of,1,2.4390243902439024
	counts number,1,2.4390243902439024
	language texts,1,2.4390243902439024
	allows you,1,2.4390243902439024
	a text,1,2.4390243902439024
	calculates lexical,1,2.4390243902439024
	the most,1,2.4390243902439024
	words nonenglish,1,2.4390243902439024
	also counts,1,2.4390243902439024
	you are,1,2.4390243902439024
	develop a,1,2.4390243902439024
	and frequencies,1,2.4390243902439024
	supported ıt,1,2.4390243902439024
	find the,1,2.4390243902439024
	most frequent,1,2.4390243902439024
	sentences and,1,2.4390243902439024
	tool the,1,2.4390243902439024
	are supported,1,2.4390243902439024
	number of,1,2.4390243902439024
	text analyzer,1,2.4390243902439024
	also calculates,1,2.4390243902439024
	syllables also,1,2.4390243902439024
	to find,1,2.4390243902439024
	you to,1,2.4390243902439024
	analyzer tool,1,2.4390243902439024
	nonenglish language,1,2.4390243902439024
	ıt also,1,2.4390243902439024
	phrases and,1,2.4390243902439024
	are expected,1,2.4390243902439024
	program allows,1,2.4390243902439024
	expected to,1,2.4390243902439024
	lexical density,1,2.4390243902439024
	words characters,1,2.4390243902439024
	texts are,1,2.4390243902439024

returns 

      output.csv

## SPLAY TREE

Rules

      Splay tree implementation and print Breadth first search of current splay tree after every operation
      
      operation lists
      void insert(int ele) -> add element to tree
      void makeLeftChildParent(Node c, Node p) -> makes left child new parent(right rotation)
      void makeRightChildParent(Node c, Node p) -> makes right child new parent(left rotation)
      void splay(Node x) -> makes x new root
      Node findNode(int ele) -> finds node which has same data as ele
      void remove(Node node) -> remove node in splay tree
      
Commands for Run

      javac *.java
      Java Main input.txt output.txt
      
Sample Config (input.txt)
      
	insert 1
	insert 2
	remove 2
	insert 5
	remove 1
	find 5
	insert 19
	find 15
	insert 12
	remove 3

Output 

	1 
	2 1 - 
	1 
	5 1 - 
	5 
	5 
	19 5 - 
	5 - 19 
	12 5 19 
	5 - 12 - - - 19 
	
returns 

      output.txt
