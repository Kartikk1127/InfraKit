#!/bin/bash
set -e

echo "🔧 Installing InfraKit..."

# Build the fat JAR
./gradlew shadowJar

# Create target directory
mkdir -p "$HOME/.infrakit"

# Detect the latest fat JAR (the one ending with -all.jar)
JAR_FILE=$(ls build/libs/*-all.jar | head -n 1)

if [ -z "$JAR_FILE" ]; then
  echo "❌ No fat JAR found. Make sure ./gradlew shadowJar ran successfully."
  exit 1
fi

# Copy JAR to a fixed name/location
cp "$JAR_FILE" "$HOME/.infrakit/InfraKit.jar"

# Copy launcher script
mkdir -p "$HOME/.local/bin"
cp infrakit "$HOME/.local/bin/"

# Make launcher executable
chmod +x "$HOME/.local/bin/infrakit"

# Ensure ~/.local/bin is in PATH
if [[ ":$PATH:" != *":$HOME/.local/bin:"* ]]; then
  echo 'export PATH="$HOME/.local/bin:$PATH"' >> "$HOME/.bashrc"
  echo "ℹ️ Added ~/.local/bin to PATH. Run: source ~/.bashrc"
fi

echo "✅ InfraKit installed successfully!"
echo "👉 You can now run: infrakit init"
