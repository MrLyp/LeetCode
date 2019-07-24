package com.robbie;

import java.util.*;

public class So127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;
        ArrayList<String> list = new ArrayList<>(wordList);
        list.add(0, beginWord);
        Map<String, List<String>> graph = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            List<String> temp = new ArrayList<>();
            for (int j = 0; j < list.size(); j++) {
                if (i == j)
                    continue;
                if (canTransform(list.get(i), list.get(j))) {
                    temp.add(list.get(j));
                }
            }
            graph.put(list.get(i), temp);
        }
        return bfs(beginWord, endWord, list, graph);
    }

    private boolean canTransform(String word, String target) {
        int diff = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != target.charAt(i)) {
                diff++;
            }
            if (diff > 1)
                return false;
        }
        return true;
    }

    private int bfs(String beginWord, String endWord, List<String> wordList, Map<String, List<String>> graph) {
        HashMap<String, Boolean> visited = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++ ){
            visited.put(wordList.get(i), false);
        }
        visited.put(beginWord, true);
        List<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1;
        int last = 0;
        int cur = 0;
        while (cur < queue.size()) {
            last = queue.size();
            while (cur < last) {
                String word = queue.get(cur);
                if (word.equals(endWord))
                    return level;
                List<String> list = graph.get(word);
                cur++;
                if (list == null)
                    continue;
                for (int i = 0; i < list.size(); i++) {
                    if (visited.get(list.get(i)))
                        continue;
                    visited.put(list.get(i), true);
                    queue.add(list.get(i));
                }
            }
            level++;

        }
        return 0;
    }

    public static void main(String[] args) {
        So127 so = new So127();
        System.out.println(so.ladderLength("hot", "dog", Arrays.asList("hot", "dog")));
        System.out.println(so.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(so.ladderLength("qa", "sq", Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye")));
    }
}
