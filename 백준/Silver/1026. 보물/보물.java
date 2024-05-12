import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //A의 가장 큰 값과 B의 가장 작은 값을 곱하면 최소값이기 때문에
        PriorityQueue<Integer> A = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> B = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            B.add(Integer.parseInt(st.nextToken()));
        }

        int total = 0;

        while(!A.isEmpty()) {
            total = total + (A.poll() * B.poll());
        }

        System.out.println(total);
    }
}
