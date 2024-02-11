import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static double score = 0;
    public static double grade = 0;
    public static double total = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        String[] inputData = new String[3];

        double sgTotal = 0; //학점x과목평점의 합
        double sTotal = 0;  //학점의 총합


        //과목수 20(고정)만큼 반복
        for(int i = 0; i < 20; i++) {
            input = br.readLine();
            inputData = input.split(" ");
            if(!inputData[2].equals("P")) {
                score = Double.parseDouble(inputData[1]);
                grade = CalcGrade(inputData[2]);

                sgTotal += score * grade;
                sTotal += score;
            }
        }

        total = sgTotal / sTotal;
        System.out.println(total);

    }

    public static double CalcGrade(String value) {
        double result = 0;
        switch(value) {
            case "A+":
                result = 4.5;
            break;
            case "A0":
                result = 4.0;
            break;
            case "B+":
                result = 3.5;
            break;
            case "B0":
                result = 3.0;
            break;
            case "C+":
                result = 2.5;
            break;
            case "C0":
                result = 2.0;
            break;
            case "D+":
                result = 1.5;
            break;
            case "D0":
                result = 1.0;
            break;
            case "F":
                result = 0;
            break;
        }

        return result;
    }
}
