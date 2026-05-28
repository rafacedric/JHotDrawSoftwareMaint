public interface Shape {

    void draw();

    int[] getBounds();

    void move(int deltaX, int deltaY);

    double getArea();
}
