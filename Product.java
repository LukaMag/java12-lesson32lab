package CLASSWORK32LAB;

public enum Product {
    BANANACHIPS("Banana chips",70){
        @Override
        public void printChoosingCommand() {
            System.out.println("b - to buy banana chips");;
        }
    },
    SWEETS("Sweets",45){
        @Override
        public void printChoosingCommand() {
            System.out.println("s - to buy sweets");
        }
    },
    WATER("Water",25){
        @Override
        public void printChoosingCommand() {
            System.out.println("w - to buy a boaofwoa");
        }
    },
    COOKIES("Cookie",35){
        @Override
        public void printChoosingCommand() {
            System.out.println("c - to buy a cookies, and come to the dark side");
        }
    },
    COKE("Coke",30){
        @Override
        public void printChoosingCommand() {
            System.out.println("d - to buy a coke(not dietary)");
        }
    };

    private String name;
    private int price;

    Product( String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void printChoosingCommand(){};


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name +" - price = " + price ;
    }
}
