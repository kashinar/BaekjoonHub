import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String Words = br.readLine();

        Stack<String> stack = new Stack<>();

        String[] Word = Words.split("");

        for (int i = 0; i < Word.length; i++) {
            stack.push(Word[i]);
        }

        boolean isCorrect = true;
        int count = 0;

        while (!stack.isEmpty()){
            if(Word[count].equals(stack.pop())){
                count++;
            } else {
                isCorrect = false;
            }
        }

        if(isCorrect) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
