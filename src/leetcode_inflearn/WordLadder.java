package leetcode_inflearn;

import java.util.*;

// 127. Word Ladder
// https://leetcode.com/problems/word-ladder/
public class WordLadder {

    public static void main(String[] args) {

        String beginWord = "hit";
        String endWord = "cog";
        String[] words = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = Arrays.asList(words);

        WordLadder prob = new WordLadder();
        System.out.println(prob.ladderLength(beginWord, endWord, wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<String> queue = new LinkedList<>();
        Set<String> dict = new HashSet<>(wordList);
        queue.offer(beginWord);
        dict.add(endWord);
        dict.remove(beginWord);
        int level = 1;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                String str = queue.poll();
                if(str.equals(endWord)) return  level;
                for(String neighbor : neighbors(str, wordList)){
                    queue.offer(neighbor);
                }
            }
            level++;
        }
        return 0;
    }

    private List<String> neighbors(String s, List<String> wordList) {

        List<String> res = new LinkedList<>();
        Set<String> dict = new HashSet<>(wordList);

        for(int i=0;i<s.length();i++){
            char[] chars = s.toCharArray();
            for(char ch='a';ch<='z';ch++){
                chars[i] = ch;
                String word = new String(chars);
                if(dict.remove(word)){
                    res.add(word);
                }
            }
        }
        return res;
    }
}
