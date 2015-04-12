#!/bin/bash

PRIVATE_IPV4=172.17.42.1

# Consul
sudo docker stop consul
sudo docker rm consul
sudo docker run -d \
    -p 8300:8300 \
    -p 8301:8301 \
    -p 8301:8301/udp \
    -p 8302:8302 \
    -p 8302/udp \
    -p 8400:8400 \
    -p 8500:8500 \
    -p 53:53/udp \
 -h ${PRIVATE_IPV4} --name=consul progrium/consul \
 -server -bootstrap -advertise ${PRIVATE_IPV4} -ui-dir /ui

# Registrator
sudo docker stop consul-registrator
sudo docker rm consul-registrator

sudo docker run -d --name=consul-registrator \
       -h ${PRIVATE_IPV4} -v /var/run/docker.sock:/tmp/docker.sock \
        gliderlabs/registrator consul://${PRIVATE_IPV4}:8500


