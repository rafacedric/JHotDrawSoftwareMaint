public class TriangleFigure implements Shape {

    private int[] vertices;
    private int x;
    private int y;

    public TriangleFigure(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.vertices = new int[6];
        initializeVertices(x, y, width, height);
    }

    private void initializeVertices(int x, int y, int width, int height) {
        vertices[0] = x + width / 2;
        vertices[1] = y;
        vertices[2] = x;
        vertices[3] = y + height;
        vertices[4] = x + width;
        vertices[5] = y + height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing triangle at (" + x + ", " + y + ")");
    }

    @Override
    public int[] getBounds() {
        int minX = Math.min(Math.min(vertices[0], vertices[2]), vertices[4]);
        int maxX = Math.max(Math.max(vertices[0], vertices[2]), vertices[4]);
        int minY = Math.min(Math.min(vertices[1], vertices[3]), vertices[5]);
        int maxY = Math.max(Math.max(vertices[1], vertices[3]), vertices[5]);
        return new int[]{minX, minY, maxX - minX, maxY - minY};
    }

    @Override
    public void move(int deltaX, int deltaY) {
        this.x += deltaX;
        this.y += deltaY;
        for (int i = 0; i < vertices.length; i += 2) {
            vertices[i] += deltaX;
            vertices[i + 1] += deltaY;
        }
    }

    @Override
    public double getArea() {
        int x1 = vertices[0];
        int y1 = vertices[1];
        int x2 = vertices[2];
        int y2 = vertices[3];
        int x3 = vertices[4];
        int y3 = vertices[5];
        return Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
    }
}
