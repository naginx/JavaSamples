package HeadFirstDesignPattern.Command;

public class Light {
    String name;

    public Light(String name) {
        this.name = name;
    }

    void on() {
        System.out.println("照明がついています");
    }

    void off() {
        System.out.println("照明が消えています");
    }
}
