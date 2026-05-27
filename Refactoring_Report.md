# Refactoring Report

## Code Smells Identified

The original `BadShapeBounds` class exhibits two significant code smells:

1. **Long Method**: The `calculateBounds` method spans over 30 lines with repeated logic for each shape type. Adding support for TriangleFigure would further expand this method, making it harder to understand and maintain.

2. **Duplicate Code**: The bounds calculation loop appears identically four times, once for each shape type (rectangle, circle, triangle, hexagon). This duplication increases the risk of bugs and makes maintenance error-prone.

## Impact on Triangle Feature Implementation

When implementing TriangleFigure, developers would need to add another conditional branch with the same point-iteration logic. This approach leads to maintenance problems: if a bug is discovered in the extremes calculation, the fix must be applied in multiple places.

## Refactoring Strategy

Refactoring is the process of altering the internal structure of code without changing its external behavior through small, behavior-preserving transformations. The refactored `GoodShapeBounds` class applies the **Extract Method** pattern to eliminate duplication and reduce method length.

## Reasoning and Transformation

The refactoring extracts two private methods:

1. **`findExtremes(int[] points)`**: Encapsulates the point-iteration logic that calculates minimum and maximum coordinates. This eliminates duplicate code and is reusable for any shape type.

2. **`createBounds(int minX, int maxX, int minY, int maxY)`**: Encapsulates the bounds array construction logic, clarifying intent and making the calculation formula explicit.

The public `calculateBounds` method now orchestrates these two operations, reducing its length and improving readability. Adding support for TriangleFigure requires no code changes—the refactored implementation already handles any point set uniformly.

## Benefits

- **Maintainability**: Changes to bounds calculation logic require modification in one place only.
- **Extensibility**: New shapes integrate immediately without code duplication.
- **Testability**: Extracted methods can be tested independently.
- **Clarity**: Method names communicate intent, reducing cognitive load during code review.
