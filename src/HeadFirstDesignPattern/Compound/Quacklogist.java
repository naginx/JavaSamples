package HeadFirstDesignPattern.Compound;

public class Quacklogist implements Observer {
    @Override
    public void update(QuackObservable duck) {
        System.out.println("カモの鳴き声学者：" + duck + "が鳴きました");
    }
}
