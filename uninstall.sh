#!/bin/bash
set -e

echo "🗑️ Uninstalling InfraKit..."

rm -rf "$HOME/.infrakit"
rm -f "$HOME/.local/bin/infrakit"

echo "✅ InfraKit has been removed."
