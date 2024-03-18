import java.util.*;

/**
 * <p>
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 * </p>
 * <br/>
 *
 *
 * <p>
 * Example 1:
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
 * </p>
 * <br/>
 *
 * <p>
 * Example 2:
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 * </p>
 *
 * <br/>
 * <p>
 * Constraints:
 * 1 <= beginWord.length <= 10
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 5000
 * wordList[i].length == beginWord.length
 * beginWord, endWord, and wordList[i] consist of lowercase English letters.
 * beginWord != endWord
 * All the words in wordList are unique.
 * </p>
 * <br/>
 */
public class WordLadder {

	public static void main(String[] args) {
		//#region Inputs
		String beginWord = "hit", endWord = "cog";
		String[] words = {"hot","dot","dog","lot","log","cog"};
		//#endregion

		System.out.println(ladderLength(beginWord, endWord, Arrays.asList(words)));
	}

	/**
	 * Get the number of words
	 * @param beginWord Starting word, It may or may not be available in wordsArr
	 * @param endWord End word
	 * @param wordList Words arr
	 * @return No. of words in the shortest path from begin word to end word
	 */
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if(! wordList.contains(endWord)) return 0;		// When endWord is not in array

		Set<String> words = new HashSet<>(wordList);
		Queue<String> visited = new LinkedList<>();
		visited.add(beginWord);
		int numberOfWords = 0;
		while (! visited.isEmpty()) {
			numberOfWords++;
			int nodesAtCurrentLevel = visited.size();
			for (int j = 0; j < nodesAtCurrentLevel; j++) {
				String currentWord = visited.poll();
				char[] currentWordChars = currentWord.toCharArray();		// currentWord will be always != null here
				for (int i =0 ; i< currentWordChars.length; i++) {
					char currentChar = currentWordChars[i];
					for (char c = 'a'; c<= 'z'; c++) {
						currentWordChars[i] = c;

						if(words.contains(String.valueOf(currentWordChars))) {
							if(String.valueOf(currentWordChars).equals(endWord)) {
								return ++numberOfWords;
							}
							visited.add(String.valueOf(currentWordChars));
							words.remove(String.valueOf(currentWordChars));
						}
					}
					currentWordChars[i] = currentChar;
				}
			}
		}
		return 0;
	}


//	public static int minWordsInShortestPath(String beginWord, String endWord, String[] wordsArr) {
//		Set<String> words = new HashSet<>(Arrays.asList(wordsArr));
//		Queue<String> visited = new LinkedList<>();
//		visited.add(beginWord);
//		if (! words.contains(endWord)) return 0;
//		int level = 0;
//		Map<String, Set<String>> adjacencyList = new HashMap<>();
//
//		while (!visited.isEmpty()) {
//			level++;
//
//			int nodesAtCurrentLevel = visited.size();
//			for (int k = 0; k < nodesAtCurrentLevel; k++) {
//				String currentWord = visited.poll();
//				if(currentWord == null) continue;
//
//				Set<String> adjacentNodes = new HashSet<>();
//				adjacencyList.put(currentWord, adjacentNodes);
//
//				char[] chars = currentWord.toCharArray();
//
//				for (int i = 0; i < chars.length; i++) {
//					for (char j = 'a'; j < 'z'; j++) {
//						char currentChar = chars[i];
//						chars[i] = j;
//						String newWord = String.valueOf(chars);
//						if(words.contains(newWord)) {
//							if(newWord.equals(endWord)) {
//								print(beginWord, endWord, currentWord, adjacencyList);
//								return level + 1;
//							}
//							adjacentNodes.add(newWord);
//							visited.add(newWord);
//							words.remove(newWord);
//						}
//						chars[i] = currentChar;
//					}
//				}
//			}
//		}
//		return 0;
//	}
//
//	static void print(String beginWord, String endWord, String prevWord, Map<String, Set<String>> adjacencyList) {
//		Stack<String> words = new Stack<>();
//		words.push(endWord);
//		words.push(prevWord);
//
//		while (!words.contains(beginWord)) {
//			String current = words.peek();
//			for (var entry: adjacencyList.entrySet()) {
//				if(entry.getValue().contains(current)) {
//					words.push(entry.getKey());
//					break;
//				}
//			}
//		}
//
//		while (!words.isEmpty()) {
//			System.out.print(words.pop());
//			if (!words.isEmpty()) System.out.print("->");
//		}
//		System.out.println();
//	}

}
