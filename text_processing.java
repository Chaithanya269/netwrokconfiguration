import java.util.HashSet;
import java.util.Set;
public class PalindromicSubstrings {
    public static int countDistinctPalindromicSubstrings(String s) {
        Set<String> palindromicSubstrings = new HashSet<>();
        String normalizedString = s.replaceAll("\\s+", "").toLowerCase();
        for (int i = 0; i < normalizedString.length(); i++) {
            expandAroundCenter(normalizedString, i, i, palindromicSubstrings);
            expandAroundCenter(normalizedString, i, i + 1, palindromicSubstrings);
        }
        return palindromicSubstrings.size();
    }
    private static void expandAroundCenter(String s, int left, int right, Set<String> palindromicSubstrings) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            palindromicSubstrings.add(s.substring(left, right + 1));
            left--;
            right++;
        }
    }
    public static void main(String[] args) {
        System.out.println(countDistinctPalindromicSubstrings("Madam Arora teaches Malayalam")); 
        System.out.println(countDistinctPalindromicSubstrings("Nitin speaks Malayalam")); 
    }
}
