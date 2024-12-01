import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static Deque<String> st_left;
    public static Deque<String> st_right;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        st_left = new LinkedList<>();
        st_right = new LinkedList<>();
        
        String[] firstWord = br.readLine().split("");
        int num = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < firstWord.length; i++) {
            st_left.addLast(firstWord[i]);
        }
        
        for(int i = 0; i < num; i++) {
            String[] word = br.readLine().split(" ");
            Cursor(word);
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!st_left.isEmpty()) {
            sb.append(st_left.pollFirst());
        }
        
        while(!st_right.isEmpty()) {
            sb.append(st_right.pollFirst());
        }
        
        System.out.println(sb.toString());
    }
    
    public static void Cursor(String[] move) {
        switch(move[0]) {
            case "L":
                if(!st_left.isEmpty()) {
                    st_right.addFirst(st_left.pollLast());
                }
                break;
                
            case "D":
                if(!st_right.isEmpty()) {
                    st_left.addLast(st_right.pollFirst());
                }
                break;
                
            case "B":
                if(!st_left.isEmpty()) {
                    st_left.pollLast();
                }
                break;
                    
            case "P":
                st_left.addLast(move[1]);
                break;
        }
    }
}
