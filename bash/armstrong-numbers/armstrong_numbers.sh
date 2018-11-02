#! /usr/bin/env bash

total=0
for (( i=0; i<${#1}; i++ )); do
  (( total += ${1:i:1} ** ${#1} ))
done

if [ $total -eq $1 ]; then
  echo true
else
  echo false
fi
