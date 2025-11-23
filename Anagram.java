/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static String normalize(String a) {
    if (a == null || a.isEmpty()) return "";
    StringBuilder cleaned = new StringBuilder(a.length());
    for (int i = 0; i < a.length(); i++) {
        char ch = a.charAt(i);
        if (Character.isLetter(ch)) cleaned.append(Character.toLowerCase(ch));
    }
    return cleaned.toString();

	}
	public static boolean areAnagrams(String a, String b) {
    String Anorm = normalize(a), Bnorm = normalize(b);
    if (Anorm.length() != Bnorm.length()) return false;
    int[] counts = new int[26];
    for (int i = 0; i < Anorm.length(); i++) {
        counts[Anorm.charAt(i) - 'a']++;
        counts[Bnorm.charAt(i) - 'a']--;
    }
    for (int c : counts) if (c != 0) return false;
    return true;
	}	
}		