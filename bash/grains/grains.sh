#!/usr/bin/env bash


main () {
    n=$1
    if [ $n -gt 64  ] || [ $n -lt 1 ]; then
        echo "Error: invalid input"
        exit 1
    else
        echo $(bc<<<"2 ^ ($n - 1)")
        exit 0
    fi
}

main "$@"
