class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int left = 0, right = 0;
        while (i < word1.length() && i < word2.length()) {
            sb.append(word1.charAt(left));
            left++;
            sb.append(word2.charAt(right));
            right++;

            i++;
        }
        while (left < word1.length()) {
            sb.append(word1.charAt(left));
            left++;
        }
        while (right < word2.length()) {
            sb.append(word2.charAt(right));
            right++;
        }
        return sb.toString();
    }
}