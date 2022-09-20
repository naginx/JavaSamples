package decorator;

public class StarBuzzCoffee {

    public static void main(String[] args) {
        Beverage beverage1 = new HouseBlend();
        beverage1 = new Soy(beverage1);
        System.out.println(beverage1.getDescription() + " $" + beverage1.cost());
        beverage1 = new Mocha(beverage1);
        System.out.println(beverage1.getDescription() + " $" + beverage1.cost());
        beverage1 = new Whip(beverage1);
        System.out.println(beverage1.getDescription() + " $" + beverage1.cost());
    }
}

