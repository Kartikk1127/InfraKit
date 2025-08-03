# Setup: Run infrakit init as a CLI

### Update build.gradle.kts

1. Add the Shadow plugin: id("com.github.johnrengelman.shadow") version "8.1.1"
2. Ensure application block sets: mainClass.set("com.infrakit.MainKt")

### Build a fat JAR

1. Run: ./gradlew shadowJar
2. Output JAR: build/libs/InfraKit-1.0-SNAPSHOT-all.jar 
3. Test manually: java -jar build/libs/InfraKit-1.0-SNAPSHOT-all.jar init

### Create the launcher script

1. In project root (~/projects/InfraKit), create file infrakit
2. Content:
```
#!/bin/bash
   java -jar "$HOME/projects/InfraKit/build/libs/InfraKit-1.0-SNAPSHOT-all.jar" "$@"
```
3. Make executable: ```chmod +x infrakit```

### Add script to PATH

1. Create local bin dir if missing: mkdir -p ~/.local/bin 
2. Link script: ln -s ~/projects/InfraKit/infrakit ~/.local/bin/infrakit 
3. Add to PATH if not already: echo 'export PATH="$HOME/.local/bin:$PATH"' >> ~/.bashrc && source ~/.bashrc

### Run InfraKit

1. Command: infrakit init

### Notes

1. Rebuild after changes: ./gradlew shadowJar 
2. For system‑wide install: sudo cp infrakit /usr/local/bin/