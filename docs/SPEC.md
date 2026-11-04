# Technical Specification: Specification-Driven Development

The key words "MUST", "MUST NOT", "SHOULD" and "MAY" in this document are to be interpreted as described in RFC 2119. Every requirement is numbered hierarchically (`1`, `1.1`, `1.1.1`) so it can be referenced from tests, code and reviews.

## 1. Purpose and Scope

1.1. The project MUST demonstrate Specification-Driven Development (SDD), a methodology in which formal specifications are the primary artifact guiding the development lifecycle.

1.2. The repository MUST serve as a reference for:

1.2.1. Writing specifications before implementation.

1.2.2. Deriving tests directly from specifications.

1.2.3. Implementing code that satisfies those specifications.

1.2.4. Verifying and maintaining the implementation against the specifications as the system evolves.

1.3. Out of scope:

1.3.1. Tooling or framework lock-in; the methodology MUST remain language- and technology-agnostic unless a specific implementation states otherwise.

1.3.2. Project-management processes unrelated to specifications (e.g. staffing, scheduling).

## 2. Definitions

2.1. **Specification** — a formal, authoritative description of required behavior, constraints and acceptance criteria.

2.2. **Requirement** — a single, numbered, testable statement within a specification.

2.3. **Acceptance criterion** — an observable condition that, when met, proves a requirement is satisfied.

2.4. **Traceability** — the ability to link a requirement to its tests and implementation, and back.

2.5. **Stakeholder** — any person who defines, reviews, implements or relies on the specification.

## 3. Guiding Principles

3.1. Specification first.

3.1.1. A specification MUST be written and approved before the implementation it describes begins.

3.1.2. Acceptance criteria MUST be defined upfront.

3.2. Single source of truth.

3.2.1. The specification is the authoritative reference for system behavior.

3.2.2. Where code and specification disagree, the disagreement MUST be treated as a defect in one of them and resolved explicitly.

3.2.3. Implementation MUST follow the specification exactly; deviations require a specification change first.

3.3. Tests derive from specifications.

3.3.1. Every test SHOULD reference at least one requirement number.

3.3.2. Every requirement SHOULD be covered by at least one test.

## 4. Specification Requirements

4.1. Structure and numbering.

4.1.1. Every requirement MUST have a unique hierarchical number (e.g. `1`, `1.1`, `1.1.1`).

4.1.2. Numbers MUST NOT be reused once published; a removed requirement MUST be marked as withdrawn rather than renumbered.

4.1.3. Child requirements MUST be consistent with and refine their parent requirement.

4.2. Quality of requirements.

4.2.1. Each requirement MUST be unambiguous and expressed with consistent terminology.

4.2.2. Each requirement MUST be verifiable, either by an automated test or by a documented manual check.

4.2.3. Each requirement MUST describe a single concern.

4.2.4. Requirements MUST state behavior and constraints, not implementation details, unless the detail is itself a constraint.

4.3. Location and format.

4.3.1. Specifications MUST be stored in the `/docs` directory of the repository.

4.3.2. The top-level project specification MUST be `docs/SPEC.md`.

4.3.3. Specifications MUST be written in Markdown and be version-controlled together with the code.

## 5. Workflow Requirements

5.1. The development workflow MUST consist of the following ordered stages:

5.1.1. Define specifications with stakeholders.

5.1.2. Review and validate specifications.

5.1.3. Generate tests from specifications.

5.1.4. Implement code to pass tests and meet specifications.

5.1.5. Verify that the implementation matches the specifications.

5.1.6. Maintain specifications as the system evolves.

5.2. Review and approval.

5.2.1. A specification MUST be reviewed by at least one stakeholder other than its author before implementation starts.

5.2.2. Review feedback MUST be resolved or explicitly declined before approval.

5.3. Change management.

5.3.1. A behavior change MUST begin with a change to the specification.

5.3.2. Specification changes and the corresponding code and test changes SHOULD be delivered in the same pull request.

5.3.3. The history of specification changes MUST be retained in version control.

## 6. Testing and Verification Requirements

6.1. Test derivation.

6.1.1. Tests MUST be derived from the acceptance criteria of the requirements they verify.

6.1.2. Tests SHOULD be written before the implementation they verify.

6.2. Traceability.

6.2.1. A mapping from requirement numbers to tests SHOULD be maintainable and reviewable (e.g. via test names, comments or a traceability matrix).

6.2.2. Requirements without tests MUST be identifiable.

6.3. Continuous verification.

6.3.1. Tests MUST be runnable by a single documented command.

6.3.2. Tests SHOULD run automatically on every pull request.

6.3.3. A failing test MUST block merging unless a documented exception is approved.

## 7. Implementation Requirements

7.1. Code MUST satisfy every applicable requirement in the specification.

7.2. Code MUST NOT introduce externally observable behavior that is not described in the specification.

7.3. Commits and pull requests SHOULD reference the requirement numbers they implement.

7.4. Implementations SHOULD be organized so a requirement can be located in code from its number.

## 8. Documentation Requirements

8.1. Specifications MUST double as system documentation and be kept in sync with the code.

8.2. `README.md` MUST provide an overview of SDD, its principles, benefits, key components and workflow.

8.2.1. `README.md` SHOULD link to or reference `docs/SPEC.md` as the technical specification.

8.3. Documentation MUST be updated in the same change that alters the behavior it describes.

## 9. Quality Attributes

9.1. Clarity and alignment: all stakeholders MUST be able to understand the requirements before coding begins.

9.2. Quality assurance: behavior verification MUST be consistent and driven by the specification.

9.3. Reduced defects: misunderstandings SHOULD be caught during specification review rather than after implementation.

9.4. Maintainability: a future developer MUST be able to understand intent from the specification alone.

9.5. Traceability: every feature MUST be traceable to a requirement in the specification.

## 10. Repository Structure

10.1. The repository MUST contain at least:

10.1.1. `README.md` — project overview and getting started guide.

10.1.2. `docs/SPEC.md` — this technical specification.

10.2. Additional specifications, if any, MUST be placed under `/docs` and be linked from this document.

10.3. Implementation and test directories MAY be added and MUST follow the requirements in sections 6 and 7.

## 11. Acceptance Criteria for This Specification

11.1. `docs/SPEC.md` exists and every requirement in it has a unique hierarchical number.

11.2. All requirements are consistent with the principles in `README.md`.

11.3. The specification has been reviewed in accordance with requirement 5.2.

## 12. Revision History

12.1. Version 1.0 — initial specification.
