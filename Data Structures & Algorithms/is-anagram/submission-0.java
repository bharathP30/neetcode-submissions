class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        // brute force. sort both and compare
        char[] c = s.toCharArray();
        Arrays.sort(c);
        s = new String(c);
    
        char[] ch = t.toCharArray();
        Arrays.sort(ch);
        t = new String(ch);

        if(s.equals(t)) return true;
        else return false;
    }
}
