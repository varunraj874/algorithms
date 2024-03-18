# Algorithms
Algorithms for different problems.

## [PairSum](src/main/java/PairSum.java) O(n)
Find the unique pairs in the given array whose sum equal to given target number.

### Example 1:
<strong>Input: </strong> target = 11, arr = [3, 2, 7, 1, 8, 9, 4, 5, 6]

<strong>Output: </strong>
(3, 8)
(4, 7)
(5, 6)
(2, 9)

<strong> Explanation: </strong> Pair (3, 8) sum is 3+8 = 11 which is equals to given target.

### Example 2:
<strong>Input: </strong> target = 18, arr = [3, 2, 7, 1, 8, 9, 4, 5, 6]

<strong>Output: </strong> Not found.

<strong> Explanation: </strong> There are no pairs in the given array whose sum will be 18.

## [WordLadder](src/main/java/WordLadder.java)
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

* Every adjacent pair of words differs by a single letter.
* Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord

Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

### Example 1:
<strong>Input: </strong>beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]

<strong>Output: </strong> 5

<strong> Explanation: </strong> One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.

### Example 2:
<strong>Input: </strong> beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]

<strong>Output: </strong> 0

<strong> Explanation: </strong> The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
