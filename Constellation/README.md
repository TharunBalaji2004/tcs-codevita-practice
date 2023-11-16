## Problem Description
Three characters { #, *, . } represents a constellation of stars and galaxies in space. Each galaxy is demarcated by # characters. There can be one or many stars in a given galaxy. Stars can only be in the shape of vowels { A, E, I, O, U }. A collection of * in the shape of the vowels is a star. A star is contained in a 3×3 block. Stars cannot be overlapping. The dot(.) character denotes empty space.

Given 3xN matrix comprising of { #, *, . } character, find the galaxy and stars within them.

Note: Please pay attention to how vowel A is denoted in a 3×3 block in the examples section below.

### Constraints

3 <= N <= 10^5
Input

### Input 
consists of a single integer N denoting the number of columns.

### Output
The output contains vowels (stars) in order of their occurrence within the given galaxy. The galaxy itself is represented by the # character.

### Example 1

Input

18

* . * # * * * # * * * # * * * . * .

* . * # * . * # . * . # * * * * * *

* * * # * * * # * * * # * * * * . *

Output

U#O#I#EA

Explanation

As it can be seen that the stars make the image of the alphabets U, O, I, E, and A respectively.

### Example 2

Input

12

```
* . * # . * * * # . * .

* . * # . . * . # * * *

* * * # . * * * # * . *
```

Output

U#I#A

Explanation

As it can be seen that the stars make the image of the alphabet U, I, and A.

Possible solution:

Input:

12

```
* . * # . * * * # . * .

* . * # . . * . # * * *

* * * # . * * * # * . *
```
