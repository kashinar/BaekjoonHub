import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int card = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= card; i++) {
            queue.add(i);
        }

        while(!queue.isEmpty()) {
            if(queue.size() > 1) {
                int top = queue.poll();     //맨 위의 카드 제거
                sb.append(top + " ");       //제거한 카드를 출력으로 이동
            } else if(queue.size() == 1) {
                int last = queue.peek();
                sb.append(last);
                break;
            }
            int next = queue.poll();    //그 다음 카드 꺼내기
            queue.add(next);            //다음 카드를 맨 뒤로
        }

        String output = sb.toString();
        System.out.println(output);
    }
}
