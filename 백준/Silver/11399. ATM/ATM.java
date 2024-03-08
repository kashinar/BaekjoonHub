import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Queue<Integer> queue = new LinkedList<>();

        int person = Integer.parseInt(br.readLine());
        String[] sTime = br.readLine().split(" ");

        for(int i = 0; i < sTime.length; i++) {
            pq.add(Integer.parseInt(sTime[i]));
        }

        int total = 0;
        while(!pq.isEmpty()) {
            total += pq.poll();
            queue.add(total);
        }

        int timeTotal = 0;
        while(!queue.isEmpty()) {
            timeTotal += queue.poll();
        }

        System.out.println(timeTotal);
    }
}
