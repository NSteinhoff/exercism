#!/usr/bin/env bash

main() {
    for (( i=${#1}; i>=0; i-- )) do
        echo -n "${1:$i:1}"
    done
}

main "$@"   # quote to pass as a single argument
