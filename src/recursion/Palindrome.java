package recursion;

public class Palindrome {

    private boolean isPalindrome(String s) {
        return check(s, 0);
    }

    private boolean check(String s, int i) {
        int rightPointer = s.length() - 1 - i;

        if (i >= rightPointer) {
            return true;
        }

        Character leftCharacter = s.charAt(i);
        Character rightCharacter = s.charAt(rightPointer);

        if (leftCharacter == rightCharacter) {
            return check(s, i + 1);
        }

        return false;
    }

    public static void main(String[] args) {
        Palindrome p = new Palindrome();
        System.out.println(p.isPalindrome("abc"));
        System.out.println(p.isPalindrome("abba"));
        System.out.println(p.isPalindrome("a"));
        System.out.println(p.isPalindrome("abdbba"));
    }
}
