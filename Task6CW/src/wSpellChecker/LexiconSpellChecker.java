package wSpellChecker;

import java.util.*;

public class LexiconSpellChecker {
    private Set<String> lexiconofwords;
    
    public void CheckSpelling(Set<String> words) {
        lexiconofwords = words;
    }
    
    public List<String> checker(String s) {
        List<String> listofsuggestions = new ArrayList<>();
        if (lexiconofwords.contains(s)) {
            listofsuggestions.add(s);
        } else {
            for (String word : lexiconofwords) {
                if (StringSimalarity(s, word)) {
                	listofsuggestions.add(word);
                }
            }
        }
        return listofsuggestions;
    }
    
    private boolean StringSimalarity(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int charactersdiff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
            	charactersdiff++;
                if (charactersdiff > 1) {
                    return false;
                }
            }
        }
        return charactersdiff == 1;
    }
}




