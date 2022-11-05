package HeadFirstDesignPattern.Compound;

public class QuackCounter implements Quackable {
    Quackable duck;
    static int numberOfQuack;

    public QuackCounter(Quackable duck) {
        this.duck = duck;
    }

    @Override
    public void quack() {
        duck.quack();
        numberOfQuack++;
    }

    public static int getQuacks() {
        return numberOfQuack;
    }

    // Decoratorによってラップしているため、呼び出し元でラップ前と同様に扱うために保持しているduckに処理を委譲する
    @Override
    public void registerObserver(Observer observer) {
        duck.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        duck.notifyObservers();
    }
}
