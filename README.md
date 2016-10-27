# Fall16-Team28

Project Title: Scatterplots, in Kibana now!!!


Project Abstract:

ELK is an excellent stack for analysing logs and finding new useful insights into behaviour of your applications.
Kibana allows you to plot pie-charts, histograms, bar charts etc. But as of Kibana v4, "scatterplots" aren't supported in ELK Stack inherently.
Some situations simply require scatterplots as the most natural represenatation. Hence we tried to find if there are any plugins available in Kibana, which could provide me this feature, but apparently there are no easy ways to do this.

Solution:
There are multiple libraries available off the shelf which provide excellent APIs for plotting such scatterplots. 
If we could intgrate these plots with Elasticsearch's API, we can then plot scatterplots using ELK stack.

Using these plots, one could find, lets say which pages of a website are loading slower than the others.
By this, developers could get a better insights into which tables of their application need to be indexed or denormalised, etc.

Usually languages provide multiple ways to store IIS/Apache logs in RDBMS tables or simply the log files like IIS, Apache logs. 
We can pick these logs, send it over to ELK server for indexing and then plot scatterplots based on these indexed logs.

We will also try to provide UI for this system, where a user could filter based on, let's say, a specific URL or a date
range between which you want to analyse logs.

1. We will use one of - nxlog or logstash-forwarder to to send the data over to ELK server.
2. We would try to create docker image of this and push it to the docker hub.

User Stories:

1. I am part of the development team of a corporate wesite of a MNC. Lately, my clients have complained that they are experiencing a slowness on some of our URLs.
As clients are of utmost importance, I have been tasked to figure out which of the URLs are particularly slow. I want to see a graph with time on x-axis and time taken by URL to load on Y axis for each URL. How can I do that? Kibana only offers barcharts, histogram, etc.

2. I'm running a e-commerce website, and recently we have migrated our RDBMS vendor from Sybase to MySQL for various reasons. I want to see if my website is having any adverse effect due to this migration. I could totally use graphs clearly showing time-stamp vs time taken to load the webpage to know this. How can I get these? 



Architectural Diagram:

![untitled diagram 1](https://cloud.githubusercontent.com/assets/22044468/19755322/d0ed6a02-9bc9-11e6-9344-15698ddbb2c0.png)
