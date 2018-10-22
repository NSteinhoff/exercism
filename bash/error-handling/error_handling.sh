#!/usr/bin/env bash


if [ $# -lt 1 ]; then
    echo "Usage: ./error_handling <greetee>"
    exit 1
elif [ $# -gt 1 ]; then
    exit 1
else
    echo "Hello, $1"
    exit 0
fi
