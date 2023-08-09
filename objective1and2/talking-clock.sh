#!/bin/bash

# Compile the Java class
javac TalkingClock.java

# Check if an argument is provided
if [ $# -eq 0 ]; then
    # No argument provided, run without arguments
    java TalkingClock
else
    # Argument provided, run with the provided argument
    java TalkingClock "$@"
fi

