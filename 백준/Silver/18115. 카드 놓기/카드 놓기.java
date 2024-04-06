import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static Deque<Integer> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        deque = new LinkedList<>();

        //기술 횟수
        int N = Integer.parseInt(br.readLine());
        //기술 번호
        String[] numStr = br.readLine().split(" ");

        int card = 1;

        for(int i = numStr.length - 1 ; i >= 0; i--) {
            int selectCard = Integer.parseInt(numStr[i]);
            GetCard(selectCard, card);
            card++;
        }

        StringBuilder sb = new StringBuilder();

        deque.forEach(c -> sb.append(c + " "));
        System.out.println(sb.toString());
        br.close();
    }

    public static void GetCard(int cardTech, int cardSet) {
        switch (cardTech) {
            case 1:
                Drop(cardSet);
            break;
            case 2:
                DropSecond(cardSet);
            break;
            case 3:
                DropLast(cardSet);
            break;
        }
    }

    public static void Drop(int cardNum) {
        deque.addFirst(cardNum);
    }

    public static void DropSecond(int cardNum) {
        int temp = deque.pollFirst();
        deque.addFirst(cardNum);
        deque.addFirst(temp);
    }

    public static void DropLast(int cardNum) {
        deque.addLast(cardNum);
    }
}
