# Scatterplot in ELK

We are making scatterplot possible in ELK now. Traditionally ELK stack makes us possible to create beautiful visualizations of aggregate data. But sometimes, requirement is to spot and analyse individual requests the system, their page loading performance, etc. Scatterplot makes this possible, and we are trying to integrate this idea with backend stack as ELK.

## Getting Started

Install docker and docker-compose v(1.9+) on your linux machine. You also need java installed to run the dummy log generator utility which is written in Java. You also need to have node installed on your machine.


Create a folder called 'app' in your host inside /var/log directory as java utility that creates dummy logs, dumps logs in
/var/log/app/iis.log file. iis.log file is created if not already existing, so you may skip creating such a file as the beginning.


You have 2 versions of java code in log-generator file. 
Random one generates log with timestamp randomly, within years 2012 to 2015. This is so you have some logs in the past so you can check using date filter in the UI.

increasing one generates logs with a timestamp starting from current time and advancing every 3 seconds. This is to test real-time update functionality in monitoring graphs where latest 50/100 requests are loaded every few seconds.

Now run random for some time, lets say 1 min, and stop so you have enough logs from the past years to filte. Now run java code from increasing folder so you have logs generator in realtime like in actual prod systems.

use below commands to follow above instructions:

Afer downloading log-generator folder somewhere on your machine,  compile the java code using below command.

```
javac ProjectLogs.java
```

This will create a .class file in the same folder, which you can run using

```
sudo java ProjectLogs
```

Note that you need sudo command because you dont have permission as a normal user to write in /var/log.



If you don't have sudo access, change the path of log file in ProjectLogs.java as well as filebeat.yml in 
docker-elk/filebeat/config folder.

Simply download docker-elk folder somewhere on your machine and run command 

```
docker-compose run --build 
```

from that folder. This command will automatically fetch required images and run docker containers.

All you need to do now is to download node-app folder on your machine and run 

```
node app.js
```

from that directory, which will start listening on localhost:3000/elk_dashboard.

Now check the browser. Username and pwd is "admin" and "admin".

Enjoy!!!


