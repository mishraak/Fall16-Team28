FROM node:argon
MAINTAINER mishrak.akshay91@gmail.com

# Create app directory
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

# Install app dependencies
COPY node-app/package.json /usr/src/app/
RUN npm install

# Bundle app source
COPY ./node-app /usr/src/app

EXPOSE 3000
CMD [ "npm", "start" ]