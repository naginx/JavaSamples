package HeadFirstDesignPattern.Command;

public class GarageDoor {

    void up() {
        System.out.println("ガレージを開けます");
    }

    void down() {
        System.out.println("ガレージを閉じます");
    }

    void stop() {
        System.out.println("ガレージの動作を止めます");
    }

    void lightOn() {
        System.out.println("ガレージの照明を点けます");
    }

    void lightOff() {
        System.out.println("ガレージの照明を消します");
    }
}
