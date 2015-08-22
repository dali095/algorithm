package kai.leetcode.algorithm.excel_sheet_column_number;
//
//Related to question Excel Sheet Column Title
//
//Given a column title as appear in an Excel sheet, return its corresponding column number.
//
//For example:
//
//    A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28 

public class Solution {
    public int titleToNumber(String s) {
        if (s == null || s.length() < 1)
            return 0;
        int result = 0;
        
        for (int i = 0; i < s.length(); i++){
            result = result + (s.charAt(i) - 'A' + 1) * ((int)Math.pow(26, s.length() - i - 1));
        }
        
        return result;
    }
}