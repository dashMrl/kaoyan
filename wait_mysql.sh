#!/bin/bash
# wait mysql to startup completely
echo "waiting mysql to startup completely..."
nc -z ${1} ${2}
until [[ $? -ne 0 ]]
do
    echo "waiting mysql to startup completely..."
    sleep 1
    nc -z ${1} ${2}
done

shift 2
cmd="$@"
exec $cmd