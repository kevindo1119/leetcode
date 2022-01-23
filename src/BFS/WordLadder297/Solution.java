package BFS.WordLadder297;

import java.util.*;


class Solution {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // put wordList in a hashSet
        Set<String> dict = new HashSet<>();
        for (String word : wordList) {
            dict.add(word);
        }

        // edge case, startWord is same as endWord
        if (beginWord.equals(endWord)) {
            return 1;
        }

        // run BFS, add root
        Queue<String> bfsQueue = new LinkedList<>();
        bfsQueue.offer(beginWord);
        // add root to visited
        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);

        int length = 1;
        while (!bfsQueue.isEmpty()) {            //开始bfs
            length++;
            int size = bfsQueue.size();
            for (int i = 0; i < size; i++) {        //枚举当前步数队列的情况
                String word = bfsQueue.poll();
                for (String nextWord : getNextWords(word, dict)) {
                    if (visited.contains(nextWord)) {
                        continue;
                    }
                    if (nextWord.equals(endWord)) {
                        return length;
                    }

                    visited.add(nextWord);                //存入新单词
                    bfsQueue.offer(nextWord);
                }
            }
        }

        return 0;
    }

    // replace character of a string at given index to a given character
    // return a new string
    private static String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }

    // get connections with given word.
    // for example, given word = 'hot', dict = {'hot', 'hit', 'hog'}
    // it will return ['hit', 'hog']
    private static ArrayList<String> getNextWords(String word, Set<String> dict) {
        ArrayList<String> nextWords = new ArrayList<>();
        /*for (char c = 'a'; c <= 'z'; c++) {                    //枚举替换字母
            for (int i = 0; i < word.length(); i++) {        //枚举替换位置
                if (c == word.charAt(i)) {
                    continue;
                }
                String nextWord = replace(word, i, c);
                if (dict.contains(nextWord)) {                //如果dict中包含新单词，存入nextWords
                    nextWords.add(nextWord);
                }
            }
        }*/
        for (String nextWord : dict) {
            int numberDiff = 0;
            if (word.length() == nextWord.length()) {
                for (int i = 0; i < word.length(); ++i) {
                    if (word.charAt(i) != nextWord.charAt(i)) {
                        numberDiff += 1;
                    }
                }
                if (numberDiff == 1) {
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;                                    //构造当前单词的全部下一步方案
    }

    /* Driver program to test above function*/
    // Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }
}