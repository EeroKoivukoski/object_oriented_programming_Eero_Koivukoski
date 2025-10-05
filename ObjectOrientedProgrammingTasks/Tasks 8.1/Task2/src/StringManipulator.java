public class StringManipulator {

    public String concatenate(String str1, String str2) {
        return str1 + str2;
    }

    public int findLength(String str) {
        return (str == null) ? 0 : str.length();
    }

    public String convertToUpperCase(String str) {
        return (str == null) ? null : str.toUpperCase();
    }

    public String convertToLowerCase(String str) {
        return (str == null) ? null : str.toLowerCase();
    }

    public boolean containsSubstring(String str, String subStr) {
        if (str == null || subStr == null) return false;
        return str.contains(subStr);
    }
}
