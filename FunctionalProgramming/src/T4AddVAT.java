import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class T4AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> input = Arrays.stream(scanner.nextLine().split(", ")).map(Double::parseDouble)
                .map(e -> e * 1.2).collect(Collectors.toList());
        System.out.println("Prices with VAT:");
        input.forEach(e -> System.out.printf("%.2f%n",e) );
    }
}
