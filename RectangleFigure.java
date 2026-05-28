public class RectangleFigure implements Shape {

    private int x;
    private int y;
    private int width;
    private int height;

    public RectangleFigure(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing rectangle at (" + x + ", " + y + ") " + width + "x" + height);
    }

    @Override
    public int[] getBounds() {
        return new int[]{x, y, width, height};
    }

    @Override
    public void move(int deltaX, int deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

    @Override
    public double getArea() {
        return width * height;
    }
}
