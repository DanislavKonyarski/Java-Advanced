package SetsAndMapsAdvancedLab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class T2SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Set<String> vipGuest = new TreeSet<>();
        Set<String> regularGuest = new TreeSet<>();

        while (!input.equals("PARTY")) {
            if (Character.isDigit(input.charAt(0))){
                vipGuest.add(input);
            }else {
                regularGuest.add(input);
            }
            input = scanner.nextLine();
        }

        while (!input.equals("END")) {
            if (Character.isDigit(input.charAt(0))){
                vipGuest.remove(input);
            }else {
                regularGuest.remove(input);
            }
            input = scanner.nextLine();
        }
        System.out.println(vipGuest.size()+regularGuest.size());
        for (String s : vipGuest) {
            System.out.println(s);
        }
        for (String s : regularGuest) {
            System.out.println(s);
        }
    }
}
