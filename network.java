import java.util.regex.Pattern;
public class IPv4Validator {
    private static final Pattern SEGMENT_PATTERN = Pattern.compile("^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
    public static boolean isValidIPv4(String ip) {
        String[] segments = ip.split("\\.");
        if (segments.length != 4) {
            return false;
        }
        for (String segment : segments) {
            if (!SEGMENT_PATTERN.matcher(segment).matches()) {
                return false;
            }
            if (segment.length() > 1 && segment.startsWith("0")) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isValidIPv4("222.111.111.111")); // true
        System.out.println(isValidIPv4("5555..555"));       // false
        System.out.println(isValidIPv4("0.0.0.255"));       // true
        System.out.println(isValidIPv4("0.0.0.0255"));      // false
    }
}
