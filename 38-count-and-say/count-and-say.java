public class Solution {
    public String countAndSay(int n) {
        String result = "1";
        
        for (int i = 1; i < n; i++) {
            StringBuilder current = new StringBuilder();
            int count = 1;
            char prevChar = result.charAt(0);
            
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == prevChar) {
                    count++;
                } else {
                    current.append(count).append(prevChar);
                    prevChar = result.charAt(j);
                    count = 1;
                }
            }
            
            current.append(count).append(prevChar);
            result = current.toString();
        }
        
        return result;
    }
}
