# kaoyan
Backend for kaoyan


## Quick start
If you have no JDK installed on your machine, execute command below to startup
the service:
```shell
$ docker-compose -f docker-compose.online.yml up -d
```
Then the server will start and listening 3003.

> **online** booting will take a long time to download gradle,dependencies
> and build the jar, so it's recommended to build jar and image locally and
> pull it while starting up.


## Build image before Starting up
Building image locally helps saving you time downloading gradle wrapper and
jars from maven.

```shell
$ ./buildJar.sh
$ docker build -t dashmrl/kaoyan .
$ docker-compose -f docker-compose.yml up -d
```

> You can change the tag/compose file according to you wish


> It will spend a long time pulling and building the images for the  first time.

## About