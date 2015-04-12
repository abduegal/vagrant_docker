#!/bin/bash

# Kafka:
if [ -d "/home/vagrant/Apps/Kafka" ]; then
    echo "Start Kafka"
    cd /home/vagrant/Apps/Kafka/kafka_2.11-0.8.2-beta
    sudo bin/kafka-server-start.sh config/server.properties &
else
    echo "Installing Kafka"
    # install
    cd ~
    wget  http://apache.xl-mirror.nl/kafka/0.8.2-beta/kafka_2.11-0.8.2-beta.tgz
    mkdir /home/vagrant/Apps/Kafka
    # extract
    tar -xvf kafka_2.11-0.8.2-beta.tgz -C /home/vagrant/Apps/Kafka
    chown -R vagrant /home/vagrant/Apps/Kafka
    # start
    cd /home/vagrant/Apps/Kafka/kafka_2.11-0.8.2-beta
    sudo bin/kafka-server-start.sh config/server.properties &
fi
