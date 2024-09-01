import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //양수, 음수를 저장하는 우선순위 큐 작성
        PriorityQueue<Integer> pluspq = new PriorityQueue<>();
        PriorityQueue<Integer> minuspq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i = 0; i < N; i++) {
            //입력을 받아서 각 큐에 삽입
            int x = Integer.parseInt(br.readLine());

            if(x > 0) {
                pluspq.add(x);
            } else if (x < 0){
                minuspq.add(x);
            } else {
                //x가 0이라면 출력문을 작성
                if(!pluspq.isEmpty() && !minuspq.isEmpty()) {
                    //두 배열이 비어있지 않는 상태라면..
                    //두 값의 절대값을 비교
                    int plus_temp = pluspq.peek();
                    int minus_temp = Math.abs(minuspq.peek());

                    if(plus_temp < minus_temp) {
                        System.out.println(pluspq.poll());
                    } else {
                        System.out.println(minuspq.poll());
                    }
                } else if(!pluspq.isEmpty()) {
                    //양수 배열이 비어있지 않은 상태라면..
                    System.out.println(pluspq.poll());
                } else if(!minuspq.isEmpty()) {
                    //음수 배열이 비어있지 않은 상태라면..
                    System.out.println(minuspq.poll());
                } else {
                    //둘다 비어있으면..
                    System.out.println(0);
                }
            }
        }
    }
}
