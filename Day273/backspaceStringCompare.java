package Day273;

public class backspaceStringCompare {

    public static boolean backspaceCompare(String s, String t) {
        int sl = s.length()-1;
        int tl = t.length() -1;
        int skip =0, tkip = 0;
        while(sl>=0 || tl >=0) {
            while (sl>=0) {
                if (s.charAt(sl) == '#') {
                    skip++;
                    sl--;
                } else if (skip>0) {
                    sl--;
                    skip--;
                } else {
                    break;
                }
            }
            while (tl >=0) {
                if (t.charAt(tl) == '#') {
                    tkip++;
                    tl--;
                } else if (tkip>0) {
                    tkip--;
                    tl--;
                } else {
                    break;
                }
            }
            if (sl >=0 && tl>=0 &&s.charAt(sl) !=t.charAt(tl)) {
                return false;
            }
            if ((sl>=0) != (tl >=0 )) {
                return false;
            }
            sl--;
            tl--;
        }
        return true;
    }
    public static void main(String[] args) {
        String s1 = "ab#c";
        String t1 = "ad#c";
        String s2 = "ab##";
        String t2 = "c#d#";
        String s3 = "a#c";
        String t3 = "b";
        System.out.println(backspaceCompare(s1,t1));
        System.out.println(backspaceCompare(s2,t2));
        System.out.println(backspaceCompare(s3,t3));


    }
}