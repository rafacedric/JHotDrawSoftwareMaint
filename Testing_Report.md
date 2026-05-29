# Testing Report

## Unit Testing Definition

Unit tests determine if individual units of source code are fit for use. A unit is typically a single method or class that performs a specific function. Unit tests verify that a unit behaves correctly in isolation, accepting valid inputs and producing expected outputs, while also validating error handling and edge cases.

## Test-First Development and Coverage

Writing tests first for the smallest units of code builds comprehensive coverage systematically. By defining expected behavior through test cases before implementation, developers establish a specification that the code must satisfy. Testing each unit independently—with mocks or stubs isolating external dependencies—ensures that failures can be traced to specific components. As units are tested, their correctness is verified, and when integrated, the system's reliability is proportional to unit test coverage.

## Triangle Feature Verification Strategy

The TriangleFigureTest class verifies the Triangle feature through five test cases:

1. **Best-Case Scenario** (`testGetAreaBestCase`): A normal triangle with coordinates (10, 10) and dimensions 20x30 is verified to calculate area as 300.0. This confirms the geometric formula is correct under typical conditions.

2. **Boundary Case with Negative Coordinates** (`testGetBoundsBoundaryCase`): A triangle at (-50, -50) with negative positioning is tested to ensure bounds calculation handles coordinates below zero without error. Bounds are verified to have the correct structure and logical consistency.

3. **Invariant Preservation** (`testMovePreservesArea`): After moving the triangle by (100, 100), the area is verified to remain unchanged, confirming that movement does not corrupt geometric properties.

4. **Java Assertion for Invariants** (`testBoundsInvariant`): Assertions enforce that bounds always contain exactly four elements and that width and height remain non-negative, preventing invalid geometric states.

5. **Edge Case with Zero Dimensions** (`testGetBoundsWithZeroDimensions`): A degenerate triangle with zero dimensions is tested to ensure the bounds method does not fail on edge inputs.

## Test Dependencies

The test suite uses JUnit 4 assertions (`assertEquals`, `assertNotNull`, `assertTrue`) and Java assertions for runtime invariant checks. No mocks are required because TriangleFigure contains only pure domain logic with no external dependencies (no UI, database, or network calls).

## Verification Result

The Triangle feature is verified to calculate bounds correctly under normal and negative coordinate conditions, preserve geometric invariants through transformations, and handle edge cases without exceptions.
