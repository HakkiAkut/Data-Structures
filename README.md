# Data-Structures
Some projects with implementing data structures

**TWO DIMENSIONAL ARRAY GAME**

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


**CIRCULAR LINKEDLIST 1**

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
      
 **CIRCULAR LINKEDLIST 2**
 
 Given a circularly linked list L containing an even number of nodes,
 develop java application how to split L into two circularly linked lists of half the size.
 
 commands for run
 
      javac *.java
      java Main 

returns 

      splits 2nd half of circular linked list to another list and returns this list.
      And given circular linked list becomes 1st half of the circular linked list

**PATH FINDING**

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
      
**PATH FINDING**

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
