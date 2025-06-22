class Solution {
    public String[] divideString(String s, int k, char fill) {
        char[] st = s.toCharArray();
        int n = s.length();
        int size = (n + k - 1) / k;;
        String[] res = new String[size];

        for (int i = 0; i < size; i++) {
            int start = i * k;
            int end = Math.min(start + k, n);
            StringBuilder sb = new StringBuilder();

            sb.append(s.substring(start, end));
            while (sb.length() < k) {
                sb.append(fill);
            }

            res[i] = sb.toString();
        }
        return res;
    }
}