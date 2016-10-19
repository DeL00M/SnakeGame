class Directions {
    public int horizontal;
    public int vertical;

    Directions() {

    }

    Directions(int horizontal, int vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
    }
}

public abstract class Direction extends  Directions {
    static final Directions UP = new Directions(0, -1);
    static final Directions DOWN = new Directions(0, 1);
    static final Directions LEFT = new Directions(-1, 0);
    static final Directions RIGHT = new Directions(1, 0);
}
