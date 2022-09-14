package decorator.StarBuzzCoffee;

public class Espresso extends Beverage {

    public Espresso() {
        description = "エスプレッソ";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}

