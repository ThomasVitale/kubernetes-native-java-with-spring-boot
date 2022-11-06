#!/bin/sh

# This script assumes you have already installed the kn quickstart plugin.
# Refer to https://knative.dev/docs/getting-started/ for more information

echo "🌊 Initializing Knative platform..."

kn quickstart kind

echo "⛵ Happy Sailing!"
