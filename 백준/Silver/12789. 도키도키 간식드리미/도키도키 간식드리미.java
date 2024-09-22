import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] waiting = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Stack<Integer> stack = new Stack<>();       //중간의 대기열

        //순번
        int turn = 1;

        //for반복문을 이용해서 한번 생각해보기
        for(int idx = 0; idx < waiting.length ;) {
            int current = waiting[idx]; //현재 줄의 맨 앞의 친구를 받아옴

            if(current == N && N == turn) {
                System.out.println("Nice");
                return;
            }

            //줄의 맨 앞의 친구의 순서면
            if(current == turn) {
                turn++;
                idx++;
            } else {
            //줄의 맨 앞의 친구가 순번이 아니라면
                if(stack.isEmpty()) {
                    //스택이 비어있으면
                    stack.add(current);
                    idx++;
                } else {
                    //스택이 비어있지 않으면
                    //스택의 맨 앞을 봄
                    int temp = stack.peek();

                    //순번이라면
                    if(temp == turn) {
                        stack.pop();
                        turn++;
                    } else {
                        stack.add(current);
                        idx++;
                    }
                }
            }
        }

        //따로 빼낸 줄에 사람이 남아있을수 있으므로
        while(!stack.isEmpty()) {
            //한명씩 빼냄
            int temp = stack.pop();

            if(temp != turn) {
                System.out.println("Sad");
                return;
            }

            turn++;
        }

        //문제 없이 끝났으면
        System.out.println("Nice");
    }
}
