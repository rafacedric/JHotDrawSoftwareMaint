public class GoodShapeBounds {

    public static int[] calculateBounds(String shapeType, int[] points) {
        int[] extremes = findExtremes(points);
        return createBounds(extremes[0], extremes[2], extremes[1], extremes[3]);
    }

    private static int[] findExtremes(int[] points) {
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (int i = 0; i < points.length; i += 2) {
            minX = Math.min(minX, points[i]);
            maxX = Math.max(maxX, points[i]);
            minY = Math.min(minY, points[i+1]);
            maxY = Math.max(maxY, points[i+1]);
        }

        return new int[] {minX, maxX, minY, maxY};
    }

    private static int[] createBounds(int minX, int maxX, int minY, int maxY) {
        return new int[] {minX, minY, maxX - minX, maxY - minY};
    }
}
