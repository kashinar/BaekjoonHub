import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
    static int N, S;
    static int[] button;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); //스위치의 갯수
        int[] input_switch = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        button = new int[N + 1];
        for(int i = 0; i < N; i++) {
            //버튼은 1번부터 이므로
            button[i + 1] = input_switch[i];
        }
        S = Integer.parseInt(br.readLine()); //학생 수

        for(int i = 0; i < S; i++) {
            int[] input_student = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            change(input_student[0], input_student[1]);
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < button.length; i++) {
            if(i % 20 != 0) {
                sb.append(button[i]).append(" ");
            } else {
                sb.append(button[i]).append(" ");
                sb.append("\n");
            }
        }

        System.out.println(sb.toString().trim());
    }

    public static void change(int student, int num) {
        switch(student) {
            //남성일 경우
            case 1:
                for(int i = 1; i * num <= N; i++) {
                    int current = i * num;
                    buttonChange(current);
                }
            break;
            //여성일 경우
            case 2:
                int left = num - 1;
                int current = num;
                int right = num + 1;
                //현재 번호는 무조건 바꾸므로 일단 변경
                buttonChange(current);

                while(left > 0 && right <= N) {
                    //두 스위치의 값이 같을 경우 변경
                    if(button[left] == button[right]) {
                        buttonChange(left);
                        buttonChange(right);
                        left--;
                        right++;
                    } else {
                        break;
                    }
                }
            break;
        }
    }

    public static void buttonChange(int idx) {
        //0이면 1로, 1이면 0으로
        if(button[idx] == 0) {
            button[idx] = 1;
        } else {
            button[idx] = 0;
        }
    }
}
