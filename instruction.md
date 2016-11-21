# Scatterplot in ELK

We are making scatterplot possible in ELK now. Traditionally ELK stack makes us possible to create beautiful visualizations of aggregate data.
But sometimes, requirement is to spot and analyse individual requests the system, their page loading performance, etc.
Scatterplot makes this possible, and we are trying to integrate this idea with backend stack as ELK.

## Getting Started

Download the provided files on your own machine, you need to copy these to corresponding locations once pre req softwares are installed.
logstash - /etc/logstash/logstash.conf
elasticsearch - /etc/elasticsearch/elasticsearch.yml
kibana - /usr/share/nginx/kibana/config.js
nginx - /etc/nginx/nginx.conf
logstash run script - /opt/logstash/bin


### Pre requisites

For this, you need to have at Elasticsearch(1.4), Logstash (1.4.2), Kibana (v3) and Nginx any version installed.

Please refer to 'https://www.digitalocean.com/community/tutorials/how-to-use-logstash-and-kibana-to-centralize-logs-on-centos-6'
to install ELK stack with Nginx on Fedora 24 release.

You may go with different versions than these, but it may involve minor syntax differences for that particular version in config files.

1. Please replace corresponding conf files with provided files.

2. Create a directory called *scatterplot* in the root path of Nginx as specified in our Nginx conf file.

3. Copy paste index.html in that directory.

4. Verify all steps again.

5. Restart Elasticsearch, logstash and Nginx service. (Newer version has Kibana as a separate service running as well as inbuilt web server.)

6. This shouldn't throw an error, otherwise you may have to troubleshoot the errors.

7. Now feed the logs to ES by using logstash, and make sure to enter correct grok filter for your type of logs. I have included grok filter for IIS logs, you may change it to your customs logs, but verify it on *http://grokdebug.herokuapp.com/*

8. Now place your log file at location specified in logstash, and restart logstash service. CHheck if you see indexed logs on 
   '127.0.0.1:9200/_search?'

9. Update the fields you want to retrieve/plot in the scatterplot, and hit http://127.0.0.1:9200/scatterplot, and check.

10. You should be able to see a scatterplot now.

Acknowledgements:

www.digitalocean.com

ELK official documentation
