import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
    public static boolean[] selfNumber = new boolean[10001];
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        //탐색 메소드 실행
        Search();
    }

    public static void Search() throws IOException {
        //1~10000까지 계산
        for(int i = 1; i < selfNumber.length; i++) {
            Calc(i);
        }

        //계산 결과를 BufferedWriter에 저장
        for(int i = 1; i < selfNumber.length; i++) {
            if(selfNumber[i] == false) {
                bw.write(i + "\n");
            }
        }

        //출력
        bw.flush();
    }

    public static int Calc(int num) {
        //숫자를 받음
        String number = String.valueOf(num);
        //숫자를 쪼갬
        String[] digits = number.split("(?<=.)");
        //문자열인 숫자를 받을 정수 배열 초기화
        int[] numArray = new int[digits.length];
        //합계를 받을 변수 선언
        int sum = 0;
        //숫자가 한자리일 경우..
        if(digits.length == 1) {
            sum = Integer.parseInt(digits[0]) + Integer.parseInt(digits[0]);
            selfNumber[sum] = true;

            return sum;
        }
        //두자리 이상일 경우..
        //문자로 존재하는 숫자를 정수로 변경
        for(int i = 0; i < digits.length; i++) {
            numArray[i] = Integer.parseInt(digits[i]);
        }

        //2자리 이상일 경우 각자 자릿수를 더하는 공식
        int calcSum = 0;
        for(int i = 0; i < numArray.length; i++) {
            calcSum += numArray[i];
        }

        //자기자신 + 자기 자신의 각 자릿수의 합
        sum = num + calcSum;
        if(sum <= 10000) {
            selfNumber[sum] = true;
        }

        return sum;
    }
}
