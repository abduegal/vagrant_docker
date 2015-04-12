#!/bin/bash
cd /home/vagrant/

if which docker >/dev/null; then

  echo 'docker already installed'

else
  [ -e /usr/lib/apt/methods/https ] || {
    sudo apt-get update
    sudo apt-get install apt-transport-https
  }

 sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv-keys 36A1D7869245C8950F966E92D8576A8BA88D21E9
  sudo sh -c "echo deb https://get.docker.com/ubuntu docker main\
  > /etc/apt/sources.list.d/docker.list"
  sudo apt-get update
  sudo apt-get -y --force-yes install lxc-docker

  sudo cp vagrant/environment/conf/docker.conf /etc/init/docker.conf
  sudo cp vagrant/environment/conf/docker /etc/default/docker
    
  sudo service docker stop
  sudo docker -d &
fi
