package book.chap2.apple.model;

public class Apple {
    private int weight;
    private AppleColor color;

    public Apple(int weight, AppleColor color) {
        this.weight = weight;
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color.name();
    }

    public void setColor(AppleColor color) {
        this.color = color;
    }
}
