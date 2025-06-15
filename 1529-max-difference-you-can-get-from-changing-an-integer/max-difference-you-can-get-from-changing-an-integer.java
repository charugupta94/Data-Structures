class Solution {
    public int maxDiff(int num) {
        String s =Integer.toString(num);
        String r = s;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) != '9'){
                s = s.replace(s.charAt(i), '9');
                break;
            }
        }
        int a = Integer.parseInt(s);
        if(r.charAt(0) != '1')r =r.replace(r.charAt(0) , '1');
        else{
            for(int i=1;i<r.length();i++){
                if(r.charAt(i) != '0' && r.charAt(i) != '1'){
                    r = r.replace(r.charAt(i) , '0');
                    break;
                }
            }
        }
        int b = Integer.parseInt(r);
        return a - b;
    }
}