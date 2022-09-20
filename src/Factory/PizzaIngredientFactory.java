package Factory;

import Factory.Ingredients.*;

public interface PizzaIngredientFactory {

    Dough createDough();
    Sauce createSauce();
    Cheese createCheese();
    Veggies[] createVeggies();
    Pepperroni createPepperoni();
    Clams createClams();
}

