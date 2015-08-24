package kai.leetcode.algorithm.valid_sudoku;

import java.util.ArrayList;
import java.util.HashSet;

//Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
//
//The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
//
//
//A partially filled sudoku which is valid.

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        ArrayList<HashSet<Character>> setsM = new ArrayList<HashSet<Character>>();
        ArrayList<HashSet<Character>> setsN = new ArrayList<HashSet<Character>>();
        
        for (int i = 0; i < 9; i++){
            setsM.add(new HashSet<Character>());
            setsN.add(new HashSet<Character>());
        }
        
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (board[i][j] != '.'){
                    if (setsM.get(i).contains(board[i][j]))
                        return false;
                    else 
                        setsM.get(i).add(board[i][j]);
                        
                    if (setsN.get(j).contains(board[i][j]))
                        return false;
                    else 
                        setsN.get(j).add(board[i][j]);

                }
            }
        }
        

        for (int i = 0; i < 9; i = i + 3){
            for (int j = 0; j < 9; j = j + 3){
                HashSet<Character> set  = new HashSet<Character>();
                for (int i1 = 0; i1 < 3; i1++){
                    for (int j1 = 0; j1 < 3; j1++){
                        if (board[i + i1][j + j1] != '.'){
                            if (set.contains(board[i + i1][j + j1])){
                                return false;
                            } else {
                                set.add(board[i + i1][j + j1]);
                            }
                        }
                    }
                }
            }
            
        }
        return true;
        
    }
}
