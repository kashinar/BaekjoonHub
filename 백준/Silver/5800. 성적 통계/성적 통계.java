import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int class_num = Integer.parseInt(br.readLine());

        for(int i = 1; i <= class_num; i++) {
            sb = new StringBuilder();
            String[] class_info = br.readLine().split(" ");
            int[] class_set = new int[Integer.parseInt(class_info[0])];

            for(int j = 0; j < class_set.length; j++) {
              class_set[j] = Integer.parseInt(class_info[j + 1]);
            }
            System.out.println("Class " + i);
            ClassCalc(class_set);
            System.out.println(sb.toString());
        }
    }

    public static void ClassCalc(int[] set) {
        CalcMax(set);
        CalcMin(set);
        CalcGap(set);
    }

    public static void CalcMax(int[] data) {
        int max = Arrays.stream(data).max().getAsInt(); //배열에서 stream을 이용하여 max를 구함
        sb.append("Max " + max + ", ");
    }

    public static void CalcMin(int[] data) {
        int min = Arrays.stream(data).min().getAsInt(); //배열에서 stream을 이용하여 min을 구함
        sb.append("Min " + min + ", ");
    }

    public static void CalcGap(int[] data) {
        //stream, Collection을 이용한 내림차순 정렬을 위한 박싱 int -> Integer
        Integer[] arr = Arrays.stream(data).boxed().toArray(Integer[]::new);
        //내림차순 정렬
        Arrays.sort(arr, Collections.reverseOrder());
        //내림차순 정렬한 데이터를 다시 언박싱 Integer -> int
        int[] sortData = Arrays.stream(arr).mapToInt(Integer::intValue).toArray();

        int gap = Integer.MIN_VALUE;
        for(int i = 0; i < sortData.length - 1; i++) {
            //내림차순을 했으므로, 절대값으로 차이를 구해줌
            int current = Math.abs(sortData[i + 1] - sortData[i]);
            if(current > gap) {
                gap = current;
            }
        }
        sb.append("Largest gap " + gap);
    }
}
