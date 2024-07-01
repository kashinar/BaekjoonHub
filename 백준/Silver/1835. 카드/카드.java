import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new LinkedList<>();

        dq.add(target);

        if(target == 1) {
            System.out.println(1);
            return;
        } else {
            dq.addFirst(target -1);
            while(true) {
                target--;
                for(int i = target; i > 0; i--) {
                    dq.addFirst(dq.pollLast());
                }
                if(target == 1) break;
                dq.addFirst(target-1);
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!dq.isEmpty()) {
            sb.append(dq.pollFirst()).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
