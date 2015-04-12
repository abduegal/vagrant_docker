#!/bin/bash

# install maven:
sh /vagrant/environment/install_maven.sh

# install docker:
sh /vagrant/environment/install_docker.sh

# install kafka:
sh /vagrant/environment/install_kafka.sh

# run docker containers:
sh /vagrant/environment/run_docker_containers.sh
