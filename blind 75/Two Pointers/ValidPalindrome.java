public class ValidPalindrome {
    public static boolean isAlpha(char c) {
        switch (c) {
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'i':
            case 'j':
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 't':
            case 'u':
            case 'v':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                return true;
            default:
                return false;
        }
    }

    public static boolean isPalindrome(String s) {
        if (s.length() == 1)
            return true;
        String lower_s = s.toLowerCase();

        int i = 0;
        int j = lower_s.length() - 1;

        while (i < j) {
            if (!isAlpha(lower_s.charAt(i))) {
                i++;
                continue;
            }

            if (!isAlpha(lower_s.charAt(j))) {
                j--;
                continue;
            }

            if (lower_s.charAt(i) != lower_s.charAt(j))
                return false;

            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
