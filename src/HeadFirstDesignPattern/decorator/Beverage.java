package HeadFirstDesignPattern.decorator;

public abstract class Beverage {
    public enum Size { TALL, GRANDE, VENTI };
    Size size = Size.TALL;

    String description = "不明な飲み物";

    public void setSize(Size size) {
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}

