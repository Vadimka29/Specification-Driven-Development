# Core Application Specification: Spring Boot Web Application

The key words "MUST", "MUST NOT", "SHOULD" and "MAY" in this document are to be interpreted as described in RFC 2119. Requirements are numbered hierarchically as required by `docs/SPEC.md` (section 4.1). This document is an additional specification linked from `docs/SPEC.md` (requirement 10.2).

## 1. Purpose and Scope

1.1. The repository MUST contain a web application that serves as the reference implementation for the methodology described in `docs/SPEC.md`.

1.2. The application MUST be a Spring Boot web application.

1.3. Out of scope: persistence, authentication, and any UI framework beyond what is stated in this document.

## 2. Technology Requirements

2.1. Language.

2.1.1. The application MUST be written in Java.

2.2. Build tool.

2.2.1. The application MUST be built with Apache Maven.

2.2.2. A `pom.xml` MUST exist in the repository root.

2.2.3. The Maven Wrapper (`mvnw`, `mvnw.cmd`, `.mvn/wrapper`) SHOULD be included so that no local Maven installation is required.

2.3. Framework.

2.3.1. The application MUST use Spring Boot version 4.1.2.

2.3.2. The `pom.xml` MUST inherit from `spring-boot-starter-parent` at version 4.1.2.

2.3.3. The application MUST use the Spring Web MVC starter (`spring-boot-starter-webmvc`) to serve HTTP requests.

2.3.4. The application MUST include the Spring Boot Actuator starter (`spring-boot-starter-actuator`).

2.4. Java version.

2.4.1. The project MUST compile with Java 17 or later and MUST declare its target version via the `java.version` Maven property.

## 3. Project Structure

3.1. The Maven coordinates MUST be `groupId` `com.sdd`, `artifactId` `sdd-core`, `version` `0.0.1-SNAPSHOT`.

3.2. The base Java package MUST be `com.example.sdd`.

3.3. The application entry point MUST be the class `com.example.sdd.SddApplication`, annotated with `@SpringBootApplication` and containing a `main` method.

3.4. Sources MUST follow the standard Maven layout (`src/main/java`, `src/main/resources`, `src/test/java`).

3.5. Build output (`target/`) MUST NOT be committed to version control.

## 4. Functional Requirements

4.1. Home endpoint.

4.1.1. `GET /` MUST respond with HTTP status 200.

4.1.2. `GET /` MUST respond with content type `text/plain` and the body `Specification-Driven Development`.

4.2. Greeting endpoint.

4.2.1. `GET /api/greeting` MUST respond with HTTP status 200 and content type `application/json`.

4.2.2. When the `name` query parameter is absent, the response body MUST be `{"message":"Hello, World!"}`.

4.2.3. When the `name` query parameter is provided and not blank, the response body MUST be `{"message":"Hello, <name>!"}`, where `<name>` is the parameter value with leading and trailing whitespace removed.

4.2.4. When the `name` query parameter is provided but blank, the response MUST be the same as in 4.2.2.

4.3. Health endpoint.

4.3.1. `GET /actuator/health` MUST respond with HTTP status 200 and a JSON body whose `status` field is `UP` when the application is healthy.

4.3.2. No actuator endpoint other than `health` MUST be exposed over HTTP.

4.4. Unknown paths.

4.4.1. A request to a path not defined in this document MUST respond with HTTP status 404.

## 5. Configuration Requirements

5.1. The application MUST listen on port 8080 by default.

5.2. The port MUST be overridable through the standard `SERVER_PORT` environment variable or `server.port` property.

5.3. Configuration MUST be stored in `src/main/resources/application.properties`.

5.4. The application name (`spring.application.name`) MUST be `sdd-core`.

## 6. Testing Requirements

6.1. Tests MUST use JUnit 5 and Spring Boot Test (`spring-boot-starter-webmvc-test`).

6.2. Every requirement in section 4 MUST be covered by at least one automated test.

6.3. Each test MUST reference the requirement number(s) it verifies in its display name or a comment (per `docs/SPEC.md` requirement 3.3.1).

6.4. All tests MUST be runnable with the single command `./mvnw test`.

6.5. A context-load test MUST verify that the application context starts successfully.

## 7. Build and Run Requirements

7.1. `./mvnw clean verify` MUST complete successfully with all tests passing.

7.2. The build MUST produce an executable jar via `spring-boot-maven-plugin`.

7.3. The application MUST be runnable with `./mvnw spring-boot:run` or `java -jar target/sdd-core-0.0.1-SNAPSHOT.jar`.

## 8. Documentation Requirements

8.1. `README.md` MUST document how to build, test and run the application.

8.2. `docs/SPEC.md` MUST link to this document.

## 9. Acceptance Criteria for This Specification

9.1. `./mvnw clean verify` succeeds.

9.2. After starting the application, `curl localhost:8080/`, `curl localhost:8080/api/greeting?name=Ada` and `curl localhost:8080/actuator/health` return the responses defined in section 4.

9.3. Every requirement in section 4 is traceable to at least one test.

## 10. Revision History

10.1. Version 1.0 — initial specification.

10.2. Version 1.1 — Maven `groupId` changed to `com.sdd`.
