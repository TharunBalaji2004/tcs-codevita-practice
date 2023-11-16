Problem Description
Question -: A math game is introduced in a school competition to test the skills of students. The game deals with Prime numbers.
The game rules are as follows:

From the given set of distinct natural numbers as input, consider the smallest natural number as q.
Your task is to compute the smallest prime number (p) such that when p is divided by all the distinct numbers in the input, except q, should result q as the remainder.
Constraints :

1 < n < 11
p < 10 ^ 10
Input :
Input consists of n+1 number of distinct natural numbers separated by spaces.
 
Output :
Print single integer p if such a p exists, else print “None”.
 
Time Limit : 1 secs

Example 1 :
Input :
4
3 4 5 1
Output : 61
Explanation : Here the n+1 numbers are 3, 4, 5 and 1 where q=1 (the least of the numbers)
The smallest number that leaves remainder 1 when divided by 3, 4 and 5 is 61 and is prime. Hence, output is 61.

Example 2 :
Input :
4
3 4 5 2
Output : None
Explanation : Here q=2. Any number that when divided by 4 leaving remainder 2 must be an even number e.g., 6, 10, 14 etc. Hence it can’t be prime. Hence, output is “None”.

Reference: https://prepinsta.com/tcs-codevita/cpp-code-for-primeconstruction-tcs-codevita-prepinsta-2/