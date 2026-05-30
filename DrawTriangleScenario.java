import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Given;
import com.tngtech.jgiven.annotation.When;
import com.tngtech.jgiven.annotation.Then;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JButtonFixture;

public class DrawTriangleScenario extends Stage<DrawTriangleScenario> {

    private FrameFixture window;
    private JButtonFixture triangleToolButton;
    private JButtonFixture canvasArea;

    @Given("a drawing canvas is displayed")
    public DrawTriangleScenario a_drawing_canvas_is_displayed() {
        window = new FrameFixture(new DrawingFrame());
        window.show();
        return this;
    }

    @Given("the triangle tool is available in the toolbar")
    public DrawTriangleScenario the_triangle_tool_is_available() {
        triangleToolButton = window.button("triangleToolButton");
        return this;
    }

    @When("the user clicks the triangle tool button")
    public DrawTriangleScenario the_user_clicks_the_triangle_tool_button() {
        triangleToolButton.click();
        return this;
    }

    @When("the user draws a triangle on the canvas with coordinates")
    public DrawTriangleScenario the_user_draws_a_triangle_on_the_canvas() {
        canvasArea = window.button("canvas");
        canvasArea.moveTo(100, 100);
        canvasArea.mouseButtonDrag().to(150, 150).to(50, 150).release();
        return this;
    }

    @Then("a triangle figure appears on the canvas")
    public DrawTriangleScenario a_triangle_figure_appears() {
        org.assertj.core.api.Assertions.assertThat(
            window.label("figureCount")
        ).isNotNull();
        return this;
    }

    @Then("the triangle has three vertices")
    public DrawTriangleScenario the_triangle_has_three_vertices() {
        org.assertj.core.api.Assertions.assertThat(
            window.label("vertexCount").text()
        ).contains("3");
        return this;
    }

    @Then("the triangle is selectable and movable")
    public DrawTriangleScenario the_triangle_is_selectable_and_movable() {
        canvasArea.click(100, 150);
        canvasArea.moveTo(120, 150).mouseButtonPress().to(150, 180).mouseButtonRelease();
        org.assertj.core.api.Assertions.assertThat(
            window.label("shapePosition").text()
        ).isNotEmpty();
        return this;
    }

    public void cleanup() {
        if (window != null) {
            window.cleanUp();
        }
    }
}
