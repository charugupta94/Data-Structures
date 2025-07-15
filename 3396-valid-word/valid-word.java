class Solution {
    public boolean isValid(String word) {
        int n = word.length();
        if(n < 3)return false;
        boolean vowel = false;
        boolean consonant = false;
        for(int i =0 ;i < n; i++){
            char c = Character.toLowerCase(word.charAt(i));
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                vowel = true;
            }
            else if (Character.isLetter(c)) {
                consonant = true;
            } 
            else if (c == '@' || c == '#' || c == '$') {
                return false;
            }
        }

        return vowel && consonant;
    }
}