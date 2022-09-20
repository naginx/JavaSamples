package Factory;

public class PizzaSystem {

    public static void main(String[] args) {
        NYPizzaStore nyPizzaStore = new NYPizzaStore();
        nyPizzaStore.orderPizza("チーズ");
    }
}

