package HeadFirstDesignPattern.Compound;

public class DuckSimulator {

    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        simulator.simulate();
    }

    void simulate() {
        Quackable mallardDuck = new QuackCounter(new MallardDuck());
        Quackable redheadDuck = new QuackCounter(new RedheadDuck());
        Quackable duckCall = new QuackCounter(new DuckCall());
        Quackable rubberDuck = new QuackCounter(new RubberDuck());
        Quackable gooseAdapter = new GooseAdapter(new Goose());

        System.out.println("\nカモシミュレータ");
        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseAdapter);

        System.out.println("カモが鳴いた回数：" + QuackCounter.getQuacks() + "回");
    }

    void simulate(Quackable duck) {
        duck.quack();
    }
}
