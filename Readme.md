# InfraKit

A supercharged, modular CLI tool to **scaffold backend projects** with production‑ready essentials in seconds.

## Introduction
InfraKit helps developers rapidly bootstrap backend projects with common essentials already configured.  
Instead of starting with just “Hello World,” InfraKit generates projects you would actually deploy, including database integration, logging, 
exception handling, and more...all customizable from the command line.

If you’ve ever used Spring Initializr and wanted just a bit more power and customization, InfraKit is for you.

### Key Features
- **Instant Project Scaffolding** : Create a working backend(eg: Spring Boot + Postgres) with a single command.
- **Built-in Essentials** : REST Controller, error handling, logging, basic configs included out-of-the-box.
- **Modular Templates** : Choose from databases, message brokers, and other integrations(more coming).
- **Customizable Generation** : CLI flags let you tweak project setup as you go.
- **Developer-first experience** : Great docs, easy onboarding, and clear project structure.
- **Ready-to-use** : Generated projects follow industry standards and Java best practices.

## ⚙️ Getting Started

### 📥 Installation
> **Note:** Pre-built binaries/jars, Docker images, and global installers are coming soon.

For now, build and run from source:

```bash
    git clone https://github.com/yourusername/infrakit.git
    cd infrakit
    ./gradlew build  
    # Or use Maven
    mvn package
    java -jar build/libs/infrakit.jar --help
    bash
```

### 🏗️ Scaffolding Your First Project

```bash
  infrakit init --name=myApp --db=postgres
```

This will generate a new project:

* myApp/ → New folder with your pre-configured backend code
* Postgres → Database integration
* (coming soon: MySQL, MongoDB, Redis, Kafka, etc.)

### 📂 Explore the Output
* src/main/java/... → Clean package structure
* application.properties or application.yml → Prewired configuration
* README.md → Next steps and usage guide
* Sample controller and error handler

### ▶️ Run Your Application
```bash
    cd myApp
    ./gradlew bootRun
    mvn spring-boot:run # If using Maven
   ```

### Project Structure

```
myApp/
├── src/
│   ├── main/java/...
│   ├── main/resources/
│   └── test/
├── build.gradle / pom.xml
├── application.properties
└── README.md
```
_All generated code follows community standards for Java backend projects_.

### CLI Usage
```
infrakit init --name=<projectName> [options]

Options:
  --db=postgres   Add Postgres DB integration (default: none)
  --redis         Add Redis integration (coming soon)
  --kafka         Add Kafka integration (coming soon)
  --docker        Include Dockerfile and sample docker-compose
  --with-tests    Add sample unit/integration tests
  --help          Show usage help

```