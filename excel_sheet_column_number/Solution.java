package kai.leetcode.algorithm.excel_sheet_column_number;

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