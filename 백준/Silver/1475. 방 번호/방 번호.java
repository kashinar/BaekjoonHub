import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //방 번호 입력 받음
        String[] roomNo = br.readLine().split("");
        //방 번호를 큐에 저장
        Queue<String> queue = new LinkedList<>();
        for(int i = 0; i < roomNo.length; i++) {
            queue.add(roomNo[i]);
        }

        //0~9까지의 숫자 세트를 준비
        int[] numSet = new int[10];
        //큐가 빌때까지 반복
        while(!queue.isEmpty()) {
            //큐에서 하나 뺌
            int current = Integer.parseInt(queue.poll());

            //현재 숫자가 6 혹은 9인지 확인
            if(current == 6 || current == 9) {
                //6이나 9일 경우 같은 6을 봄
                numSet[6] = numSet[6] + 1;
            } else {
                numSet[current] = numSet[current] + 1;
            }
        }

        numSet[6] = numSet[6]/2 + numSet[6]%2;

        int max = 0;

        for(int i : numSet) {
            if(i >= max) {
                max = i;
            }
        }

        System.out.println(max);
    }
}
