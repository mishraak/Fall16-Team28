FROM logstash:5
ADD iis.log /var/log/iis.log
expose 5044
# Add your logstash plugins setup here
# Example: RUN logstash-plugin install logstash-filter-json
RUN logstash-plugin install logstash-input-beats
