package HeadFirstDesignPattern.decorator;

public class Mocha extends CondimentDecorator {
    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", モカ";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.20;
    }
}

