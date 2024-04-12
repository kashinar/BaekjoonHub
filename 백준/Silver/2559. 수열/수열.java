import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        //범위를 지정하기 위한 포인트
        int point1 = 0;
        int point2 = point1 + Integer.parseInt(input[1]);

        //기온정보를 temper배열에 저장
        String[] temper = br.readLine().split(" ");

        int max = Integer.MIN_VALUE;
        int current = 0;

        for(int i = 0; i < point2; i++) {
            current += Integer.parseInt(temper[i]);
        }

        max = current;

        for(int i = point2; i < temper.length; i++) {
            current = current - Integer.parseInt(temper[i - point2]) + Integer.parseInt(temper[i]);
            max = Math.max(max, current);
        }

        System.out.println(max);
    }
}
