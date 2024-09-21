# Lecture / Guided coding Example

1. Static code analysis
2. Sonar Lint, Sonar Qube and Sonar cloud

---


### Static Code Analysis

- **Definition**: Analyzing source code for quality and security issues without executing it.
- **Purpose**: Detect bugs, vulnerabilities, code smells, and non-compliance with coding standards.
- 

**Benefits**: 
  - Identifies issues early in the development cycle.
  - Improves code quality, maintainability, and security.
  - Reduces technical debt.

### SonarLint

- **Tool**: An IDE plugin for real-time static code analysis.
- **Use**: Helps developers detect and fix code issues while writing code.
- **Features**:
  - Instant feedback for code quality.
  - Highlights bugs, vulnerabilities, and code smells.
  - Supports popular IDEs like IntelliJ, Eclipse, and Visual Studio.
  - Local linting without needing server infrastructure.
- **Integration**: Can be connected to SonarQube/SonarCloud for consistent issue detection across the team.

### SonarCloud

- **Definition**: A cloud-based platform for continuous code quality and security.
- **Use**: Analyzes code in cloud-based repositories like GitHub, Bitbucket, and Azure DevOps.
- **Key Features**:
  - Automatic code analysis during the CI/CD pipeline.
  - Supports 30+ programming languages.
  - Reports on code coverage, maintainability, reliability, and security.
  - Public projects are analyzed for free; private projects require a subscription.
- **Advantages**:
  - No server maintenance required.
  - Scalable and accessible from anywhere.
  - Integration with cloud repositories and CI pipelines.

### SonarQube

- **Definition**: An on-premise platform for continuous inspection of code quality and security.
- **Use**: Provides detailed static code analysis reports for various programming languages.
- **Key Features**:
  - Tracks code quality metrics: maintainability, security, reliability, code coverage.
  - Integrates with CI/CD tools (Jenkins, Azure Pipelines, GitLab).
  - Configurable Quality Gates to enforce coding standards.
  - Customizable rules for different projects and languages.
  - Enterprise Edition includes advanced reporting and governance features.
- **Advantages**:
  - Complete control over infrastructure and analysis configuration.
  - Suitable for organizations with strict security or compliance needs.

**Comparison**:
- **SonarLint**: Real-time, local analysis in the IDE.
- **SonarCloud**: Cloud-hosted, scalable, no server management, ideal for cloud projects.
- **SonarQube**: On-premise, customizable, ideal for self-hosted, large organizations.
