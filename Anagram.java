// Anagram.java
public class Anagram {

    public static String preProcess(String s) {
        if (s == null || s.isEmpty()) return "";
        StringBuilder out = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                out.append(Character.toLowerCase(c));
            }
        }
        return out.toString();
    }

    public static boolean isAnagram(String a, String b) {
        String s1 = preProcess(a);
        String s2 = preProcess(b);
        if (s1.length() != s2.length()) return false;

        int[] freq = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }
        for (int x : freq) {
            if (x != 0) return false;
        }
        return true;
    }

    public static String randomAnagram(String s) {
        String t = preProcess(s);
        char[] a = t.toCharArray();
        java.util.concurrent.ThreadLocalRandom r = java.util.concurrent.ThreadLocalRandom.current();
        for (int i = a.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            char tmp = a[i]; a[i] = a[j]; a[j] = tmp;
        }
        return new String(a);
    }
}
