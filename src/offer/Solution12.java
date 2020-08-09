package offer;

/**
 * @Author WuHao
 * @Create 2020-08-09-23:55
 *
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 */
public class Solution12 {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray(); // 转字符数组
        for(int i = 0; i < board.length;i++){
            for(int j = 0; j < board[0].length;j++){
                if(dfs(board,words,i,j,0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board,char[] word,int i, int j,int k){
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;

        if(k == word.length - 1) return true;

        char tmp = board[i][j]; //记录该满足条件的元素
        // 将满足条件的元素置为'/'
        board[i][j] = '/';

        boolean res = dfs(board,word,i - 1, j, k + 1) || dfs(board,word,i,j + 1,k + 1) || dfs(board,word,i + 1, j, k +                          1) || dfs(board,word,i,j - 1,k + 1);

        // check失败 回溯 将原点该为未访问过
        board[i][j] = tmp;

        return res;
    }
}
