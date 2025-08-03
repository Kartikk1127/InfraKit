## 🚀 Setup: Run `infrakit init` as a CLI

### 1. Clone the Repository

```bash
    git clone https://github.com/your-username/InfraKit.git
    cd InfraKit
```

### 2. Give Execute Permissions (first time only)

```bash
    chmod +x install.sh uninstall.sh infrakit
```

### 3. Install InfraKit

```bash
    ./install.sh
```

**This will:**
- Build a fat JAR using Gradle
- Copy the JAR to `~/.infrakit/InfraKit.jar`
- Copy the launcher script to `~/.local/bin/infrakit`
- Add `~/.local/bin` to your `PATH` if missing

### 4. Run InfraKit

```bash
    infrakit init
```

### 5. Update After Making Changes

After editing the code, simply run:

```bash
    ./install.sh
```

*This overwrites the old JAR, no uninstall needed.*

### 6. Uninstall InfraKit

```bash
    ./uninstall.sh
```

**This will remove:**
- `~/.infrakit`
- `~/.local/bin/infrakit`

## 🖥️ Requirements

- **Linux** or **WSL**
- **JDK 17+** installed
- **Gradle** installed (or use `./gradlew` provided in the repo)