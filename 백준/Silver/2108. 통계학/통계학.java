import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static ArrayList<Integer> numList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputCnt = Integer.parseInt(br.readLine());

        for(int i = 0; i < inputCnt; i++) {
            int num = Integer.parseInt(br.readLine());
            numList.add(num);
        }

        CalcAverage();
        CalcCenter();
        CalcFrequency();
        CalcRange();
    }

    //산술평균 : N개의 수들의 합을 N으로 나눈 값. 소수점 이하 첫째자리에서 반올림한 값을 출력한다.
    public static void CalcAverage() {
        double total = 0;           //total을 int로 하면 나눗셈할 경우 소숫점 부분이 버려지게되므로 주의
        int size = numList.size();

        //N개의 수의 합
        for(int i = 0; i < size; i++) {
            total += numList.get(i);
        }

        //산술평균 = N개의 수의 합/N을 반올림
        int average = (int) Math.round(total/size);
        System.out.println(average);
    }

    //중앙값 :  N개의 수들을 오름차순으로 나열했을 경우, 그 중앙에 위치하는 값
    public static void CalcCenter() {
        //리스트를 오름차순으로 정렬 -> 어차피 다른데도 영향이 없기 때문에 정렬을 해준다.
        numList.sort(Comparator.naturalOrder());
        int size = numList.size();
        //수의 갯수는 홀수이므로, 반드시 2로 나누면 .5가 남게됨.
        //index는 0부터 시작하므로, 소수점 .5를 버려주면 중간을 찾게 된다.
        double center = Math.floor(size/2);
        int centerData = numList.get((int)center);

        System.out.println(centerData);
    }

    //최빈값 : N개의 수들 중 가장 많이 나타나는 값. 여러개 있을 경우, 최빈값 중 두번째로 작은 값을 출력한다.
    public static void CalcFrequency() {
        Map<Integer, Integer> freqMap = new HashMap<>();

        if(numList.size() == 1) {
            System.out.println(numList.get(0));
            return;
        }

        for(int i = 0; i < numList.size(); i++) {
            int currentNum = numList.get(i);
            if(freqMap.containsKey(currentNum)) {
                //해당 숫자의 키가 있다면..
                int currentFreq = freqMap.get(currentNum); //키가 있다면 현재의 값을 취득
                freqMap.put(currentNum, currentFreq + 1);  //다시 해당 키에 value값을 1 더해서 put
            } else {
                //해당 숫자의 키가 없다면..
                freqMap.put(currentNum, 1); //키값이 없으니, Map에 추가
            }
        }

        ArrayList<Integer> freqList = new ArrayList<>();

        int max = Collections.max(freqMap.values()); //맵에 있는 value의 최대값

        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int entryKey = entry.getKey();
            int entryValue = entry.getValue();

            if(max == entryValue) {
                freqList.add(entryKey);
            }
        }

        freqList.sort(Comparator.naturalOrder());

        if(freqList.size() == 1) {
            System.out.println(freqList.get(0));
        } else {
            System.out.println(freqList.get(1));
        }
    }

    //범위 : N개의 수들 중 최댓값과 최솟값의 차이
    public static void CalcRange() {
        //중앙값에서 오름차순으로 정렬하기 때문에 맨 앞과 맨 뒤를 받아와준다.
        int min = numList.get(0);
        int max = numList.get(numList.size()-1);
        int range = max - min;
        System.out.println(range);
    }
}
