import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] nCard = br.readLine().split(" ");

        int M = Integer.parseInt(br.readLine());
        String[] mCard = br.readLine().split(" ");

        HashSet<Integer> cardSet = new HashSet<>();

        for(int i = 0; i < nCard.length; i++) {
            cardSet.add(Integer.parseInt(nCard[i]));
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < mCard.length; i++) {
            if(cardSet.contains(Integer.parseInt(mCard[i]))) {
                sb.append(1 + " ");
            } else {
                sb.append(0 + " ");
            }
        }

        System.out.println(sb.toString());
    }
}
