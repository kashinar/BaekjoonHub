import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        LinkedHashSet<String> set = new LinkedHashSet<>();

        for(int i = 0; i < L; i++) {
            String student = br.readLine();

            if(set.contains(student)) {
                set.remove(student); //해당 키가 존재하면 제거 하여 맨 뒤로 이동할 수 있게 함
            }
            set.add(student);//값을 삽입
        }

        int cnt = 0;
        for(String s : set) {
            cnt++;
            System.out.println(s);
            if(cnt == K) {
                break;
            }
        }
    }
}
