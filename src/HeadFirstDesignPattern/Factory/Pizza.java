package HeadFirstDesignPattern.Factory;

import HeadFirstDesignPattern.Factory.Ingredients.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {

    String name;
    Dough dough;
    Sauce sauce;
    Veggies[] veggies;
    Cheese cheese;
    Pepperroni pepperroni;
    Clams clam;

    List<String> toppings = new ArrayList<>();

    abstract void prepare();

    void bake() {
        System.out.println("180度で25分間焼く");
    }

    void cut() {
        System.out.println("ピザを扇形にカットする");
    }

    void box() {
        System.out.println("PizzaStoreの箱にピザを入れる");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
