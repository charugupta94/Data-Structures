class Solution {
    public String generateTag(String caption) {
        caption = caption.trim();
        if (caption.isEmpty()) return "#";
        String[] words = caption.split("\\s+");
        int n = words.length;
        String[] arr = new String[n+1];
        arr[0] = "#";
        arr[1] = words[0].toLowerCase();
        for(int i=1;i<n;i++){
            words[i] = words[i].toLowerCase();
            arr[i+1] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
        }
        String tag = String.join("", arr);
        if (tag.length() > 100) {
            return tag.substring(0, 100);
        }
        return tag;
    }
}