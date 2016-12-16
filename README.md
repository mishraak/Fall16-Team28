 [![license](https://img.shields.io/github/license/mashape/apistatus.svg)](https://github.com/SJSU272Lab/Fall16-Team28/blob/master/LICENSE.md)
 [![GitHub issues](https://img.shields.io/badge/issues-0%20open-green.svg)](https://github.com/SJSU272Lab/ELKplot/issues?q=is%3Aopen+is%3Aissue) 
<img src="http://www.itzgeek.com/wp-content/uploads/2016/09/Run-ELK-stack-on-Docker-Container.png" width="28%" align="left">
 

# Note
As users of this app, we may not deploy this app to cloud for few reasons :

1. This app is not going to generate any revenue for the company but only serves as a tool for your developers. So you may not want to spend any budget on this tool on deploying to cloud. And as this is not a client-facing website, so you do not need to think about latency, etc.
2. For reasons like compliance or security. you may not want to ship your logs and retrieve them back.
3. This app will have a fixed/calculated amount of load, so you can assing a permanent VM to this app. 
4. It is not a business critical app so even though downtime is not recommended, it is not as critical as your prod app.
5. We are using docker-containers so alreadya app is light-weight and wil only use as much system resoueces as it needs, keeping rest of the system resources free for other applications, if any. 


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

Two simple steps to get the app running :
1. Run "random" & "increasing" java utilities to generated logs.
2. simply run docker-compose from "docker-elk" directiry.

For first part,  

You need sudo access because normal user dont have permission as a normal user to write in /var/log in Linux.
If you do not have sudo access, then change location of file generated to ~/iis.log in java code, mounted volume in docker-compose for logstash part and also in filebeat paths at the beginning.

Create a folder called 'app' in your host inside /var/log/ directory as java utility that creates and dumps dummy logs in
/var/log/app/iis.log file. Also, the iis.log file is created if not already existing, and logs are appended to it everytime we run the java utility.

As you can see, you have 2 versions of the utility in log-generator directory - random and increasing. Go to each one of them and run below commands in both of them. 

```
javac ProjectLogs.java
```

This will create a .class file in the same folder, which then you can run using

```
sudo java ProjectLogs
```

For second part, just download docker-elk folder somewhere on your machine and run below command from that folder 

```
docker-compose run --build 
```

This should automatically fetch and build required images and also start running docker containers.

Your app will start listening on localhost:3000/elk_dashboard, as you can check in the logs.
Check the browser. Username and pwd is "admin" and "admin".

Enjoy!!!


