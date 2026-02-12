1class Solution {
2    public boolean exist(char[][] board, String word) {
3     int m=board.length;
4     int n= board[0].length;
5     for(int i=0;i<m;i++){
6         for(int j=0;j<n;j++){
7            if(search(board,word,i,j,0)){
8                return true;
9            }
10         }   
11     }
12     return false;
13    }
14   public boolean search(char[][] board, String word,int i,int j,int idx){
15    if(idx==word.length()) return true;
16    if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]!=word.charAt(idx)){
17        return false;
18    }
19    char temp=board[i][j];
20    board[i][j]='*';
21    boolean found=search(board,word,i+1,j,idx+1) || 
22                  search(board,word,i-1,j,idx+1) ||
23                  search(board,word,i,j+1,idx+1) ||
24                  search(board,word,i,j-1,idx+1);
25          board[i][j]=temp;
26          return found;        
27                  
28   }
29}