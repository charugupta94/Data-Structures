class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[128];
        for(int i=0;i<s.length() ;i++){
            freq[s.charAt(i)]++;
        }

        List<Character> arr = new ArrayList<>();
        for(char c = 0 ; c< 128 ;c++){
            if(freq[c] > 0)arr.add(c);
        }

        arr.sort((a, b) -> freq[b] - freq[a]);
        StringBuilder sb  = new StringBuilder();
        for(int i =0 ;i<arr.size() ;i++){
            char ch  = arr.get(i);
            for(int j = 0; j< freq[ch] ;j++){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}