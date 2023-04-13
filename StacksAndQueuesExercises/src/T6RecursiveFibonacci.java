import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class T6RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Deque<Long> num = new ArrayDeque<>();
        num.push(0L);
        num.push(1L);

        for (int i = 0 ; i < n ; i++) {

            if (n<2){
                break;
            }else {
                Long numOne = num.pop();
                Long numTwo = num.pop();
                num.push(numOne);
                num.push(numTwo+numOne);
            }
        }
        System.out.println(num.peek());
    }
}
