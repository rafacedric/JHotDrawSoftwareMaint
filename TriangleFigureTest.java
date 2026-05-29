import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TriangleFigureTest {

    private TriangleFigure triangle;

    @Before
    public void setUp() {
        triangle = new TriangleFigure(10, 10, 20, 30);
    }

    @Test
    public void testGetAreaBestCase() {
        double area = triangle.getArea();
        assertEquals(300.0, area, 0.01);
    }

    @Test
    public void testGetBoundsBoundaryCase() {
        TriangleFigure negativeTriangle = new TriangleFigure(-50, -50, 40, 60);
        int[] bounds = negativeTriangle.getBounds();

        assertNotNull(bounds);
        assertEquals(4, bounds.length);
        assertTrue(bounds[0] <= bounds[0] + bounds[2]);
        assertTrue(bounds[1] <= bounds[1] + bounds[3]);
    }

    @Test
    public void testMovePreservesArea() {
        double areaBeforeMove = triangle.getArea();
        triangle.move(100, 100);
        double areaAfterMove = triangle.getArea();

        assertEquals(areaBeforeMove, areaAfterMove, 0.01);
    }

    @Test
    public void testBoundsInvariant() {
        int[] bounds = triangle.getBounds();
        assert bounds.length == 4 : "Bounds must have exactly 4 elements (x, y, width, height)";
        assert bounds[2] >= 0 : "Width must be non-negative";
        assert bounds[3] >= 0 : "Height must be non-negative";
    }

    @Test
    public void testGetBoundsWithZeroDimensions() {
        TriangleFigure flatTriangle = new TriangleFigure(0, 0, 0, 0);
        int[] bounds = flatTriangle.getBounds();

        assertNotNull(bounds);
        assertEquals(4, bounds.length);
    }
}
