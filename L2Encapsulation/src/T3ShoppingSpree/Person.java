package T3ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {


//+	buyProduct (Product): void

    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
            this.name = name.trim();
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public String getName() {
        return name;
    }
    public void buyProduct (Product product){
        if (this.money>= product.getCost()){
            this.money-= product.getCost();
            this.products.add(product);
        }else {
            throw new IllegalArgumentException(this.name+" can't afford "+product.getName());
        }
    }
    public int getSizeProduct (){
        return products.size();
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name+" -");
        for (int i = 0; i < products.size(); i++) {
            if (i+1==products.size()){
                stringBuilder.append(" "+products.get(i).getName());
            }else {
                stringBuilder.append(" "+products.get(i).getName()+",");
            }
        }
        return String.valueOf(stringBuilder);
    }
}
