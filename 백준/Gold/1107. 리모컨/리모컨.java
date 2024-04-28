import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int channel = sc.nextInt();
        int brokenCnt = sc.nextInt();
        boolean[] broken = new boolean[10];
        for(int i = 0; i < brokenCnt; i++) {
            broken[sc.nextInt()] = true;
        }

        //현재 채널은 100
        int result = Math.abs(channel - 100);

        //0~999999까지 확인
        for(int i = 0; i <= 999999; i++) {
            String num = String.valueOf(i);

            boolean isBreak = false;
            for(int j = 0; j < num.length(); j++) {
                if(broken[num.charAt(j) - '0']) {
                    isBreak = true;
                    break;
                }
            }

            if(!isBreak) {
                //가장 적은 횟수를 result에 담는다.
                int min = Math.abs(channel - i) + num.length();
                result = Math.min(min, result);
            }
        }

        System.out.println(result);
    }
}
