package control;

public class InputSanitizer {

    public static String sanitize(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        StringBuilder sanitized = new StringBuilder(input.length());
        for (char c : input.toCharArray()) {
            switch (c) {
                case '<':
                    sanitized.append("&lt;");
                    break;
                case '>':
                    sanitized.append("&gt;");
                    break;
                case '&':
                    sanitized.append("&amp;");
                    break;
                case '"':
                    sanitized.append("&quot;");
                    break;
                case '\'':
                    sanitized.append("&#x27;");
                    break;
                case '/':
                    sanitized.append("&#x2F;");
                    break;
                default:
                    sanitized.append(c);
                    break;
            }
        }
        return sanitized.toString();
    }

    public static String truncate(String input, int maxLength) {
        if (input == null) {
            return null;
        }
        return input.length() <= maxLength ? input : input.substring(0, maxLength);
    }
}
