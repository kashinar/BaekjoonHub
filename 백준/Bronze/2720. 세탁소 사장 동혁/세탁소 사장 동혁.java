import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int q,d,n,p; //쿼터, 다임, 니켈 페니


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //테스트케이스 입력
        int TestCase = Integer.parseInt(br.readLine());

        //테스트케이스만큼 반복
        for (int i = 0; i < TestCase; i++) {
            int change_case = Integer.parseInt(br.readLine());
            Calc(change_case);
        }

    }

    public static void Calc(int change) {
        q = 25;
        d = 10;
        n = 5;
        p = 1;
        int current = change;
        int qCnt, dCnt, nCnt, pCnt; //동전의 갯수변수
        qCnt = dCnt = nCnt = pCnt = 0;
        
        //필요 동전 갯수 카운트 -> 가치가 높은 동전부터 낮은 동전 순으로
        while (current >= q) {
            current = current - q;
            qCnt++;
        }

        while (current >= d) {
            current = current - d;
            dCnt++;
        }

        while (current >= n) {
            current = current - n;
            nCnt++;
        }

        while (current >= p) {
            current = current - p;
            pCnt++;
        }

        if (current == 0) {
            System.out.println(qCnt + " " + dCnt + " " + nCnt + " " +pCnt);
        } else {
            System.out.println("error occurred");
        }
    }
}
