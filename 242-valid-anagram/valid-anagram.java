class Solution {
    public boolean isAnagram(String s, String t) {
        
        if (s.length() != t.length()) return false;
        HashMap<Character,Integer> mp = new HashMap<>();
        for(int i = 0; i <s.length() ;i++){
            mp.put(s.charAt(i) , mp.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i = 0; i <t.length() ;i++){
            if(!mp.containsKey(t.charAt(i)) || mp.get(t.charAt(i)) == 0)return false;
            mp.put(t.charAt(i), mp.get(t.charAt(i)) - 1);
        }
        return true;

    }
}