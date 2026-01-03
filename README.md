# Kotlin Gradle Sandbox

Production-grade boilerplate for Kotlin Ktor applications with sophisticated Gradle build architecture.

## Overview

This repository demonstrates modern Gradle best practices for multi-module Kotlin projects, featuring a convention plugin system that eliminates build configuration boilerplate while maintaining full flexibility and type safety.

## Architecture Highlights

### Convention Plugins System

Build logic is encapsulated in **10 composable convention plugins** (`build-logic/conventions`), enabling minimal module configuration:

- **`evgenius1424.kotlin.jvm`** — Base Kotlin/JVM setup with JDK 21 toolchain
- **`evgenius1424.kotlin.library`** — Complete library configuration (testing, quality, coverage, publishing)
- **`evgenius1424.kotlin.application`** — Application setup with Shadow plugin for fat JARs
- **`evgenius1424.kotlin.serialization`** — kotlinx.serialization integration
- **`evgenius1424.testing`** — JUnit 5 + AssertJ unit testing
- **`evgenius1424.testing.integration`** — Separate integration test source set
- **`evgenius1424.code-quality`** — KtLint + Detekt static analysis
- **`evgenius1424.repositories`** — Standardized repository configuration
- **`evgenius1424.publishing`** — Maven publishing with Artifactory support
- **`evgenius1424.coverage`** — Jacoco code coverage reporting

### Centralized Dependency Management

Version catalog (`gradle/libs.versions.toml`) provides single source of truth for all dependencies and plugins, with semantic bundles for grouped dependencies.

### Multi-Module Structure

```
├── build-logic/       # Reusable convention plugins
├── common/            # Shared domain models and utilities
└── server/            # Ktor application with REST API
```

## Tech Stack

| Component | Version | Purpose |
|-----------|---------|---------|
| Kotlin | 2.2.21 | Language |
| Gradle | 8.10.2 | Build automation |
| Ktor | 3.3.3 | Async web framework |
| kotlinx.serialization | 1.7.3 | Type-safe JSON |
| kotlinx.datetime | 0.6.1 | Temporal types |
| JUnit 5 | 5.11.3 | Testing framework |
| AssertJ | 3.26.3 | Fluent assertions |
| KtLint | 12.1.2 | Code formatting |
| Detekt | 1.23.7 | Static analysis |
| Jacoco | 0.8.12 | Code coverage |

## Features

### Ktor Server Configuration

- Native dependency injection (Ktor DI)
- Content negotiation with automatic JSON serialization
- Netty async engine
- Integration testing with `testApplication` DSL

### Layered Architecture Demo

Demonstrates clean separation of concerns:

- **Repository Layer**: Thread-safe in-memory data access
- **Service Layer**: Business logic with DI
- **API Layer**: RESTful endpoints with versioning

### Testing Infrastructure

- **Unit Tests**: Standard `src/test/kotlin` with JUnit 5
- **Integration Tests**: Custom `src/integrationTest/kotlin` source set with dedicated task
- Both automatically configured in convention plugins

### Code Quality

- Pre-configured KtLint for consistent code style
- Detekt static analysis with default rule set
- Jacoco coverage reports generated on test execution

### Build Tooling

- Shadow plugin for distributable fat JARs
- Maven publishing with automatic dependency metadata
- Artifactory integration for artifact repositories
- JDK toolchain for reproducible builds

## Getting Started

### Prerequisites

- JDK 21+
- Gradle 8.10+ (or use included wrapper)

### Build and Run

```bash
# Build all modules
./gradlew build

# Run server
./gradlew :server:run

# Run integration tests
./gradlew integrationTest

# Generate coverage report
./gradlew jacocoTestReport

# Check code quality
./gradlew ktlintCheck detekt
```

The server starts on `http://localhost:8080` with demo API endpoints:

- `GET /api/v1/issues` — List all issues
- `GET /api/v1/issues/count` — Issue count

## Project Structure

```
kotlin-gradle-sandbox/
├── build-logic/
│   └── conventions/              # Convention plugin implementations
├── common/                       # Shared domain models
│   └── src/main/kotlin/
│       └── domain/
│           ├── Issue.kt
│           └── IssueStatus.kt
├── server/                       # Ktor application
│   ├── src/main/kotlin/
│   │   ├── Application.kt        # Server entry point
│   │   ├── service/              # Business logic layer
│   │   └── repository/           # Data access layer
│   ├── src/integrationTest/      # Integration tests
│   └── src/main/resources/
│       ├── application.conf
│       └── logback.xml
└── gradle/
    └── libs.versions.toml        # Version catalog
```

## Adding a New Module

Create minimal `build.gradle.kts`:

```kotlin
plugins {
    id("evgenius1424.kotlin.library")
}

dependencies {
    // Your dependencies here
}
```

Convention plugins automatically apply testing, quality checks, coverage, and publishing configuration.

## Design Philosophy

This boilerplate embodies several key principles:

1. **DRY Build Configuration**: Convention plugins eliminate repetitive Gradle code
2. **Composable Conventions**: Plugins extend each other to create layered functionality
3. **Type Safety**: Kotlin DSL throughout, version catalog for dependency references
4. **Zero Magic**: Explicit configuration with sensible defaults
5. **Production Ready**: Includes everything needed for enterprise applications

## License

This project is provided as-is for educational and development purposes.
