package HeadFirstDesignPattern.Compound;

public class RubberDuck implements Quackable {
    Observable observable;

    public RubberDuck() {
        this.observable = new Observable(this);
    }


    @Override
    public void quack() {
        System.out.println("キューキュー");
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        observable.notifyObservers();
    }
}
