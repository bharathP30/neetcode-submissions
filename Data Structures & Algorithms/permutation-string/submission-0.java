class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] chars = s1.toCharArray();
        Arrays.sort(chars);
        String key = new String(chars);

        int left = 0;
        for (int right = 0; right < s2.length(); right++) {
            if (right - left + 1 > s1.length())
                left++;
            if (right - left + 1 == s1.length()) {
                String windowStr = s2.substring(left, right + 1);
                char[] chars1 = windowStr.toCharArray();
                Arrays.sort(chars1);
                String key2 = new String(chars1);

                if(key.equals(key2)) return true;
            }
        }
        return false;
    }
}
