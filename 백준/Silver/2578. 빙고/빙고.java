import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] number = new int[5][5];
    static boolean[][] isCalled = new boolean[5][5];
    static int bingo = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 5; i++) {
            String[] sNum = br.readLine().split(" ");
            for(int j = 0; j < sNum.length; j++) {
                number[i][j] = Integer.parseInt(sNum[j]);
            }
        }

        int cnt = 0;

        a:while(true) {
            String[] sCall = br.readLine().split(" ");
            for (int i = 0; i < 5; i++) {
                int nCall = Integer.parseInt(sCall[i]);
                cnt++;
                b:for (int j = 0; j < isCalled.length; j++) {
                    for (int k = 0; k < isCalled[j].length; k++) {
                        bingo = 0;
                        if (number[j][k] == nCall) {
                            isCalled[j][k] = true;
                            Vertical();
                            Horizon();
                            Diagonal();
                            if (bingo >= 3) {
                                break a;
                            }
                            break b;
                        }
                    }
                }
            }
        }
        System.out.println(cnt);
    }

    //수직 체크
    public static void Vertical() {
        int count = 0;
        for(int i = 0; i < isCalled.length; i++) {
            for(int j = 0; j < isCalled[i].length; j++) {
                if(isCalled[j][i]) {
                    count++;
                    //5개가 전부 불렸을 경우
                    if(count == 5) {
                        //빙고 갯수 1개 올리고 카운트 초기화
                        bingo++;
                        count = 0;
                    }
                } else {
                    //한개라도 false가 있으면 더 볼필요가 없음
                    count = 0;
                    break;
                }
            }
        }
    }

    //수평 체크
    public static void Horizon() {
        int count = 0;
        for(int i = 0; i < isCalled.length; i++) {
            for(int j = 0; j < isCalled[i].length; j++) {
                if(isCalled[i][j]) {
                    count++;
                    //5개가 전부 불렸을 경우
                    if(count == 5) {
                        //빙고 갯수 1개 올리고 카운트 초기화
                        bingo++;
                        count = 0;
                    }
                } else {
                    //한개라도 false가 있으면 더 볼필요가 없음
                    count = 0;
                    break;
                }
            }
        }
    }

    //대각선 체크
    public static void Diagonal() {
        int count = 0;
        for(int i = 0; i < isCalled.length; i++) {
            if(isCalled[i][i]) {
                count++;
                if(count == 5) {
                    bingo++;
                    count = 0;
                }
            } else {
                count = 0;
                break;
            }
        }

        for(int i = 0; i < 5; i++) {
            if (isCalled[i][4 - i]) {
                count++;
                if(count == 5) {
                    bingo++;
                    count = 0;
                }
            } else {
                count = 0;
                break;
            }
        }
    }
}
