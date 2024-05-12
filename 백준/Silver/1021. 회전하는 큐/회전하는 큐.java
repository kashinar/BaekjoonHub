import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> deque = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); //큐의 크기
        int M = Integer.parseInt(st.nextToken()); //뽑으려는 숫자의 갯수

        //큐에 N까지의 숫자를 담아줌
        for(int i = 1; i <= N; i++) {
            deque.add(i);
        }

        String[] input = br.readLine().split(" ");
        int cnt = 0;

        for(int i = 0; i < input.length; i++) {
            int target = Integer.parseInt(input[i]);
            int position = deque.indexOf(target); //구하고자 하는 숫자의 위치
            
            //타겟의 위치가 절반 아래일 경우와 절반보다 클 경우로 나눔
            if(position <= deque.size() / 2) {
                while(true) {
                    int current = deque.peekFirst();
                    if(current == target) {
                        deque.pollFirst();
                        break;
                    } else {
                        deque.addLast(deque.pollFirst());
                        cnt++;
                    }
                }
            } else {
                while(true) {
                    int current = deque.peekFirst();
                    if(current == target) {
                        deque.pollFirst();
                        break;
                    } else {
                        deque.addFirst(deque.pollLast());
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
