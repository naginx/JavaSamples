package HeadFirstDesignPattern.Factory;

import HeadFirstDesignPattern.Factory.Ingredients.NYPizzaIngredientFactory;

public class NYPizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(String item) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

        if (item.equals("チーズ")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("ニューヨークスタイルチーズピザ");
        }
        return pizza;
    }
}
