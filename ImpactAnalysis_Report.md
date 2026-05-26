# Impact Analysis Report

## Change Impact Analysis Definition

Change impact analysis is the process of identifying the potential consequences of a proposed change to a software system and estimating what needs to be modified to support that change. It determines which components, modules, and dependencies are affected by the change and helps establish the scope of work and associated risks.

## Static and Dynamic Analysis Process

Static analysis examines source code structure without execution to identify dependencies and relationships between classes. Dynamic analysis executes the system under debugger control to observe actual runtime behavior and data flow. Together, they reveal both code-level dependencies and real behavior patterns.

## Interaction Diagram: Shape Creation Concept Analysis

```
CreationTool (CHANGED)
    |
    v
RectangleFigure (CHANGED -> reference implementation)
    |
    v
TriangleFigure (BLANK -> to be created)
    |
    +---> AbstractFigure (UNCHANGED -> parent class)
    |
    +---> Figure (UNCHANGED -> interface)
    |
    v
Handle (PROPAGATES -> handles affect TriangleFigure)
    |
    v
DrawingView (NEXT -> renders triangle)
    |
    v
DrawingModel (UNCHANGED -> stores figures)
```

## JHotDraw Packages and Impact Assessment

| Package name | # of classes | Comments |
|---|---|---|
| org.jhotdraw.draw.figure | 12+ | Contains RectangleFigure as reference implementation; TriangleFigure must extend AbstractFigure following the same pattern for geometry and rendering |
| org.jhotdraw.draw.tool | 8+ | CreationTool is modified to support triangle instantiation; requires configuration to map user interaction to TriangleFigure construction |
| org.jhotdraw.draw.handle | 6+ | Handles must be adapted for triangle-specific manipulation; includes rotation and vertex repositioning logic |
| org.jhotdraw.draw | 3+ | Core drawing interfaces unchanged; TriangleFigure registers with DrawingModel following established protocol |
| org.jhotdraw.draw.connector | 4+ | Connectors attach to figure vertices; must propagate to support triangle connection points |
| org.jhotdraw.geom | 5+ | Geometry utilities for point calculations; used unchanged by TriangleFigure for collision detection and rendering |
