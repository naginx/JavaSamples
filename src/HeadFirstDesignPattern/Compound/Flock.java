package HeadFirstDesignPattern.Compound;

import java.util.ArrayList;

public class Flock implements Quackable {
    ArrayList<Quackable> ducks = new ArrayList<>();

    public void add(Quackable quacker) {
        ducks.add(quacker);
    }

    @Override
    public void quack() {
        for (Quackable duck : ducks) {
            duck.quack();
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        for (Quackable duck : ducks) {
            duck.registerObserver(observer);
        }
    }

    @Override
    public void notifyObservers() {
        // 実装不要
    }
}
