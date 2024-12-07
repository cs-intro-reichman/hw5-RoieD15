/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        String hello = "hello";
        //System.out.println(subsetOf("hel", "hello")); // true
        //System.out.println(subsetOf("leh", "hello")); // true
        //System.out.println(subsetOf("lo", "hello")); // true
        System.out.println(subsetOf("runi", "enirungni")); // true
        System.out.println(subsetOf("sap", "space")); // true
        System.out.println(subsetOf("spa", "space")); // true
        System.out.println(subsetOf("pass", "space")); // false
        System.out.println(subsetOf("c", "space")); // true
        System.out.println(subsetOf("", "anything")); // true
        //System.out.println(spacedString("silent")); // 
        //System.out.println(spacedString("a")); // 
        //System.out.println(spacedString("")); // 
        //System.out.println(spacedString("hi"));
        //System.out.println(randomStringOfLetters(11));
        //System.out.println(remove("committee", "meet"));
        //System.out.println(remove("abc", "abc"));
        //System.out.println(remove("abc", "b"));
        //System.out.println(remove("hello", ""));
        //System.out.println(countChar(hello, 'h'));
        //System.out.println(countChar(hello, 'l'));
        //System.out.println(countChar(hello, 'z'));
        //System.out.println(countChar("", 'z'));
        //System.out.println(countChar("aaa", 'a'));
        //System.out.println(spacedString(hello));
        //// Put your other tests here.
    }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c') returns 0. 
     * 
     * @param str - a string
     * @param c - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ch){
                count++;
            }
        }
        return count;
    }

    /** Returns true if str1 is a subset string str2, false otherwise
     *  Examples:
     *  subsetOf("sap","space") returns true
     *  subsetOf("spa","space") returns true
     *  subsetOf("pass","space") returns false
     *  subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
        String newStr2 = str2;
        for(int i = 0; i < str1.length(); i++) {
            if((countChar(newStr2, str1.charAt(i))) == 0)
            return false;
            else {
                int index = newStr2.indexOf(str1.charAt(i));
                if(index == -1)
                return false;
                newStr2 = newStr2.substring(0,index) + newStr2.substring(index + 1);
            }
        }
        return true;
    }

    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character. 
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        String newString = "";
        if(!str.isEmpty()) {
        for(int i = 0; i < str.length() - 1; i++) {
            newString += str.charAt((i)) + " ";
        }
        newString += str.charAt(str.length() - 1);
    }
        return newString;
    }
  
    /**
     * Returns a string of n lowercase letters, selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String rndAlphStr = "";
        for(int i = 0; i < n; i++) {
            int rndIndex = (int) (Math.random() * alphabet.length());
            rndAlphStr += alphabet.charAt(rndIndex);
        }
        return rndAlphStr;
    }

    /**
     * Returns a string consisting of the string str2, minus all the characters in the
     * string str1. Assumes (without checking) that str1 is a subset of str2.
     * Example: remove("meet","committee") returns "comit" 
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str2 minus all the characters of str1
     */
    public static String remove(String str1, String str2) {
        String newString = "";
        String newStr2 = str2; 
        for(int i = 0; i < str1.length(); i++) {
            int countChar = countChar(newStr2, str1.charAt(i));
            if(countChar == 0) {
                newString += str1.charAt(i);
            } else {
                int index = newStr2.indexOf(str1.charAt(i));
                newStr2 = newStr2.substring(0,index) + newStr2.substring(index + 1);
                }
            }
        return newString;
    }

    /**
     * Returns a string consisting of the given string, with the given 
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or "cast", or "cats".  
     * @param ch - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
         // Generate a random index between 0 and str.length()
         int randomIndex = (int) (Math.random() * (str.length() + 1));
         // Insert the character at the random index
         String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
         return result;
    }    
}
