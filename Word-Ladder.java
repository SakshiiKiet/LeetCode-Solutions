1class Pair{
2    String word;
3    int len;
4    Pair(String word,int len){
5        this.word=word;
6        this.len=len;
7    }
8}
9class Solution {
10    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
11        Queue<Pair>q=new LinkedList<>();
12        q.offer(new Pair(beginWord,1));
13        HashSet<String>set=new HashSet<>();
14        int n=wordList.size();
15        for(int i=0;i<n;i++){
16            set.add(wordList.get(i));
17        }
18        set.remove(beginWord);
19        while(!q.isEmpty()){
20            String word=q.peek().word;
21            int len=q.peek().len;
22            q.poll();
23             if(word.equals(endWord)) return len;    
24            //word=hit
25            for(int i=0;i<word.length();i++){
26                for(char ch='a';ch<='z';ch++){
27                    char[] arr=word.toCharArray();
28                     arr[i]=ch;
29                     String newWord=new String(arr);
30
31                     // if newWord exists in set
32                     if(set.contains(newWord)==true){
33                        set.remove(newWord);
34                        q.offer(new Pair(newWord,len+1));
35                     }
36                }
37            }
38        }
39        return 0;
40    }
41}