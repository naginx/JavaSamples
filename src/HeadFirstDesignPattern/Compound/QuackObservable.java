package HeadFirstDesignPattern.Compound;

public interface QuackObservable {
    void registerObserver(Observer observer);
    void notifyObservers();
}


