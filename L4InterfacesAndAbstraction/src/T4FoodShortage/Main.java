package T4FoodShortage;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countBuyer = Integer.parseInt(scanner.nextLine());
        Map<String, Buyer> buyerMap = new LinkedHashMap<>();

        for (int i = 0; i < countBuyer; i++) {
            String[] inputPerson = scanner.nextLine().split("\\s+");
            if (inputPerson.length==3){
                String nameRebel = inputPerson[0];
                int ageRabel = Integer.parseInt(inputPerson[1]);
                String groupRebel = inputPerson[2];
                Rebel rebel = new Rebel(nameRebel,ageRabel,groupRebel);
                buyerMap.put(nameRebel,rebel);
            }else {
                String nameCitizen = inputPerson[0];
                int ageCitizen = Integer.parseInt(inputPerson[1]);
                String idCitizen = inputPerson[2];
                String birthDateCitizen = inputPerson[2];
                Citizen citizen = new Citizen(nameCitizen,ageCitizen,idCitizen,birthDateCitizen);
                buyerMap.put(nameCitizen,citizen);
            }
        }

        String buyer = scanner.nextLine();
        while (!"End".equals(buyer)) {
            for (Map.Entry<String, Buyer> entry : buyerMap.entrySet()) {
                if (entry.getKey().equals(buyer)) {
                    entry.getValue().buyFood();
                }
            }
            buyer = scanner.nextLine();
        }

        int sumBuyFood = 0;
        for (Map.Entry<String, Buyer> entry : buyerMap.entrySet()) {
            sumBuyFood += entry.getValue().getFood();
        }

        System.out.println(sumBuyFood);
    }
}
