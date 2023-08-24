package Day217;
import java.util.List;
import java.util.ArrayList;

public class textJustification {

    public static List<String> justify(String[] words, int maxWidth) {
        List<String> answer = new ArrayList<>();
        int wc , sl;
        for(int i=0; i<words.length; i+=wc) {
            sl = 0;
            for (wc=0; i+wc<words.length && sl+words[i+wc].length()+wc<=maxWidth; wc++) {
                sl += words[i+wc].length();
            }
            StringBuilder sb = new StringBuilder(words[i]);
            if (wc == 1 || wc+i == words.length) {
                for (int j=1; j<wc; j++) {
                    sb.append(" ").append(words[i+j]);
                }
                sb.append(" ".repeat(maxWidth - sb.length()));
            } else {
                int tab = (maxWidth - sl) / (wc-1);
                int extra = (maxWidth - sl) % (wc-1);
                for (int j=1;j<wc;j++) {
                    sb.append(" ".repeat(tab+(extra-->0?1:0))).append(words[i+j]);
                }
            }
            answer.add(sb.toString());
        }
        return answer;
    }

    public static void main(String[] args){
        String words[] = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        System.out.println(justify(words, maxWidth));
    }
}