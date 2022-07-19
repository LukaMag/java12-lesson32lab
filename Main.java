package CLASSWORK32LAB;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        Vendor vendor = new Vendor(0,new ArrayList<>(),false);
        final List<Card> cards = new ArrayList<>();
        cards.add(new Card("4565","pass4565"));
        cards.add(new Card("2132","pass2132"));
        String ch ;
        while(true) {
            try {
                printChoice();
                ch = sc.nextLine();
                isEmpty(ch);
                isCapable(ch);
                break;
            }catch (OutOfMemoryError | IndexOutOfBoundsException e){
                System.out.println(e.getMessage());
            }
        }
        if(ch.equals("m")){
            vendor.setReceiver(true);
        }
        for (int i = 0; i < vendor.getValue(); i++) {
            int rndProduct = r.nextInt(5);
            switch (rndProduct) {
                case 0 -> vendor.getProducts().add(Product.COKE);
                case 1 -> vendor.getProducts().add(Product.COOKIES);
                case 2 -> vendor.getProducts().add(Product.BANANACHIPS);
                case 3 -> vendor.getProducts().add(Product.SWEETS);
                case 4 -> vendor.getProducts().add(Product.WATER);
            }
        }
        List<Product> products = new ArrayList<>();
        action(vendor,products,cards);
    }

    static void action(Vendor vendor,List<Product> products,List<Card> cards){
        Scanner sc = new Scanner(System.in);
        var capableToTotal = vendor.getProducts().stream()
                .distinct()
                .filter(e -> e.getPrice() <= vendor.getTotal())
                .toList();
        String answer;
        String id;
        String password;
        int cash;
        while(true){
            try {
                printDistinct(vendor);
                printActions(vendor, capableToTotal);
                answer = sc.nextLine();
                isEmpty(answer);
                break;
            }catch (IndexOutOfBoundsException e){
                System.out.println(e.getMessage());
            }
        }
        Product b = Product.BANANACHIPS;
        switch (answer) {
            case "q" -> {
                printProducts(products);
                System.out.println("That's enough for ya");
            }
            case "a" -> {
                if (vendor.isReceiver()) {
                    cards.forEach(System.out::println);
                    while (true) {
                        try {
                            System.out.print("Enter id of card:");
                            id = sc.nextLine();
                            isEmpty(id);
                            System.out.print("Enter password of card:");
                            password = sc.nextLine();
                            isEmpty(password);
                            cardCapable(id, password, cards);
                            cash = cashToTake();
                            vendor.setTotal(vendor.getTotal() + cash);
                            break;
                        } catch (IndexOutOfBoundsException | InputMismatchException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                } else {
                    vendor.setTotal(vendor.getTotal() + 10);
                }
                action(vendor, products, cards);
            }
            case "r" -> {
                vendor.setReceiver(!vendor.isReceiver());
                action(vendor, products, cards);
            }
            default -> {
                switch (answer) {
                    case "b" -> {
                    }
                    case "s" -> b = Product.SWEETS;
                    case "w" -> b = Product.WATER;
                    case "c" -> b = Product.COOKIES;
                    case "d" -> b = Product.COKE;
                    default -> System.out.println("Choose a correct letter of command!!!");
                }
                System.out.printf("You've chosen %s\n", b.getName());
                printProductAction(vendor, b);
                products.add(b);
                action(vendor, products, cards);
            }
        }
    }
    static void printActions(Vendor vendor,List<Product> products){
        System.out.printf("\nCoins in total: %d \n", vendor.getTotal());
        if(vendor.isReceiver()) {
            System.out.println("a - to withdraw some money from the card");
            if (products.isEmpty()) {
            } else {
                products.forEach(Product::printChoosingCommand);
            }
        }else {
            System.out.println("a - take another coin(10 cents)");
            if (products.isEmpty()) {
            } else {
                System.out.println("a - take another coin");
                products.forEach(Product::printChoosingCommand);
            }
        }
        System.out.println("r - to change vendor's receiver");
        System.out.println("q - go out");
        System.out.print("What do u want to do:");
    }
    static void printDistinct(Vendor vendor){
        var productsDistinct = vendor.getProducts().stream()
                .distinct()
                .toList();
        productsDistinct.forEach(System.out::println);
    }
    static void printProductAction(Vendor vendor, Product product){
        var ex = vendor.getProducts().stream()
                .filter(e -> e == product)
                .count();
        if(ex > 0){
            if (vendor.getTotal()  >= product.getPrice()) {
                vendor.getProducts().remove(product);
                vendor.setTotal(vendor.getTotal() - product.getPrice());
            } else {
                System.out.printf("You don't have enough money to buy %s\n",product.getName());
            }
        }else{
            System.out.printf("There is no more %s\n",product.getName());
        }
    }
    static void printProducts(List<Product> products){
        products.forEach(System.out::println);
    }
    static void isEmpty(String s)throws IndexOutOfBoundsException{
        if(s.isEmpty()){
            throw new IndexOutOfBoundsException("It can not be empty!!!");
        }
    }
    static void isCapable(String s)throws OutOfMemoryError{
        if(s.equals("m") || s.equals("c")){

        }else{
            throw new OutOfMemoryError("Choose correct command!!!");
        }
    }
    static void cardCapable(String id,String password,List<Card> cards)throws InputMismatchException{
        var idCheck = cards.stream()
                .filter(e -> e.getId().equals(id) && e.getPassword().equals(password)).findAny();
        if(idCheck.isEmpty()){
            throw new InputMismatchException("There is no card like this one(((");
        }
    }
    static int cashToTake(){
        Scanner sc = new Scanner(System.in);
        int cash = 0;
        String c;
        while(true) {
            try{
                System.out.print("Enter amount of money:");
                c = sc.nextLine();
                isEmpty(c);
                cash = isNumber(c);
                break;
            }catch (NumberFormatException | IndexOutOfBoundsException e){
                System.out.println(e.getMessage());
            }
        }
        return cash;
    }
    static int isNumber(String s)throws NumberFormatException{
        int num;
        try{
            num = Integer.parseInt(s);
            return num;
        }catch (NumberFormatException e){
            throw new NumberFormatException("It has to number!!!");
        }
    }
    static void printChoice(){
        System.out.println("m - Vendor with Receiver of money");
        System.out.println("c - Vendor with Receiver of coin");
        System.out.print("Choose a vendor:");
    }
}
