public class PermutationInString {
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] count = new int[26];
        for (char c : s1.toCharArray()) count[c - 'a']++;
        int[] window = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            window[s2.charAt(i) - 'a']++;
        }
        if (matches(count, window)) return true;

        for (int i = s1.length(); i < s2.length(); i++) {
            window[s2.charAt(i) - 'a']++;
            window[s2.charAt(i - s1.length()) - 'a']--;

            if (matches(count, window)) return true;
        }
        return false;
    }
    private static boolean matches(int[] count, int[] window) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != window[i]) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo")); 
        System.out.println(checkInclusion("ab", "eidboaoo")); 
    }
}
