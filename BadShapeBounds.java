public class BadShapeBounds {

    public static int[] calculateBounds(String shapeType, int[] points) {
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;

        if (shapeType.equals("rectangle")) {
            for (int i = 0; i < points.length; i += 2) {
                if (points[i] < minX) minX = points[i];
                if (points[i] > maxX) maxX = points[i];
                if (points[i+1] < minY) minY = points[i+1];
                if (points[i+1] > maxY) maxY = points[i+1];
            }
            return new int[] {minX, minY, maxX - minX, maxY - minY};
        } else if (shapeType.equals("circle")) {
            for (int i = 0; i < points.length; i += 2) {
                if (points[i] < minX) minX = points[i];
                if (points[i] > maxX) maxX = points[i];
                if (points[i+1] < minY) minY = points[i+1];
                if (points[i+1] > maxY) maxY = points[i+1];
            }
            return new int[] {minX, minY, maxX - minX, maxY - minY};
        } else if (shapeType.equals("triangle")) {
            for (int i = 0; i < points.length; i += 2) {
                if (points[i] < minX) minX = points[i];
                if (points[i] > maxX) maxX = points[i];
                if (points[i+1] < minY) minY = points[i+1];
                if (points[i+1] > maxY) maxY = points[i+1];
            }
            return new int[] {minX, minY, maxX - minX, maxY - minY};
        } else if (shapeType.equals("hexagon")) {
            for (int i = 0; i < points.length; i += 2) {
                if (points[i] < minX) minX = points[i];
                if (points[i] > maxX) maxX = points[i];
                if (points[i+1] < minY) minY = points[i+1];
                if (points[i+1] > maxY) maxY = points[i+1];
            }
            return new int[] {minX, minY, maxX - minX, maxY - minY};
        }
        return new int[] {0, 0, 0, 0};
    }
}
