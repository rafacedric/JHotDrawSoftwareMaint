# BDD Report

## User Story to BDD Scenario Mapping

Behavior-Driven Development translates user stories into executable BDD scenarios using the Given-When-Then format. This mapping bridges the gap between business requirements and technical implementation, ensuring that acceptance criteria are testable and verifiable.

A user story defines what a user wants and why:
- **As a** [user type], **I want** [goal], **so that** [reason]

A BDD scenario transforms this into executable steps:
- **Given** [initial context], **When** [action occurs], **Then** [expected outcome]

## Triangle Feature User Story

**User Story:**
As a diagram designer, I want to draw triangle shapes so that I can create standard flowchart decision nodes.

## Transformation to BDD Scenario

**BDD Scenario:**

```
Given a drawing canvas is displayed
  And the triangle tool is available in the toolbar
When the user clicks the triangle tool button
  And the user draws a triangle on the canvas with coordinates
Then a triangle figure appears on the canvas
  And the triangle has three vertices
  And the triangle is selectable and movable
```

## Scenario Breakdown

| BDD Component | Maps to | Details |
|---|---|---|
| Given a drawing canvas | User context | Establishes the application state where the user operates |
| Given triangle tool available | Feature availability | Confirms the tool is accessible in the UI |
| When user clicks triangle tool | User action | Selects the triangle creation mode |
| When user draws triangle | User action | Interacts with the canvas to instantiate a triangle |
| Then triangle appears | Acceptance criterion | Verifies the shape is rendered on the canvas |
| Then triangle has three vertices | Business rule | Confirms geometric correctness |
| Then triangle is selectable | Usability requirement | Ensures the shape can be manipulated |

## BDD Testing Benefits

- **Clarity**: Non-technical stakeholders understand test objectives through Given-When-Then language.
- **Traceability**: Each scenario maps directly to a user story requirement.
- **Automation**: BDD scenarios can be executed automatically using tools like JGiven and AssertJ-Swing, providing continuous verification of feature behavior.
- **Documentation**: Scenarios serve as living documentation that reflects current system behavior.
