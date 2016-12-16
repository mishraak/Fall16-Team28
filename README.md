# Scatterplot in ELK

We are making scatterplot possible in ELK now. Traditionally ELK stack makes us possible to create beautiful visualizations of aggregate data. But sometimes, requirement is to spot and analyse individual requests the system, their page loading performance, etc. Scatterplot makes this possible, and we are trying to integrate this idea with backend stack as ELK.

## Getting Started

Install below on your linux machine :

* jdk 6+
* [docker client (1.12+)](https://docs.docker.com/engine/installation/linux/fedora/) 
* [docker server (1.12+)](https://docs.docker.com/engine/installation/linux/fedora/)
* [docker-compose v(1.9+)](https://docs.docker.com/compose/install/) 



**Note** 

We have created a dummy log generator to test our code, as we need real-time logs as well as logs from the past dates. In prod system, filebeat will be monitoring actual log files instead of the ones created byour java utility here. so, change the mounted volume path to Logstash container and also the 'paths' in filebeat.yml which resides in docker-elk/filebeat/config directory.

**Instructions**

Create a folder called 'app' in your host inside /var/log directory as java utility that creates and dumps dummy logs in
/var/log/app/iis.log file. Also, the iis.log file is created if not already existing, and logs are appended to it everytime we run the java utility.

You have 2 versions of the utility in log-generator directory - random and increasing. 

"Random" one generates log with timestamp randomly, within years 2012 to 2015. This is so you have some logs in the past so you can test the date filter in the UI."Increasing" one generates logs with a timestamp starting from current time and advancing every 3 seconds. 

First run "random" for some time, lets say 1 min, and stop so you have enough logs from the past years to filter up later. 
Next, run "increasing" folder so you have logs generated in real-time similar to the real-life scenarios. This is to test real-time update functionality in monitoring graphs where latest 50/100 requests are loaded every few seconds.

use below commands from the mentioned directories (random/increasing) to run java utilities:

Afer downloading log-generator folder somewhere on your machine,  compile the java code using below command.

```
javac ProjectLogs.java
```

This will create a .class file in the same folder, which you can run using

```
sudo java ProjectLogs
```

**Note**

You need sudo command because you dont have permission as a normal user to write in /var/log.
If you do not have sudo access, then change location of file generated to ~/iis.log in java code, mounted volume in docker-compose for logstash part and also in filebeat paths at the beginning.

Finally, simply download docker-elk folder somewhere on your machine and run command 

```
docker-compose run --build 
```

from that folder. This command will automatically fetch required images and run docker containers.
Your app will start listening on localhost:3000/elk_dashboard, as you can check in the logs.
Check the browser. Username and pwd is "admin" and "admin".

Enjoy!!!


