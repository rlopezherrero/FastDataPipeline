## Software requirements

* IDE for Java development (your choice)
  * https://www.jetbrains.com/idea/download/ (Choose InteliJ Community)
  * https://www.eclipse.org/downloads/packages/
* Maven (for dependencies Management)
  * https://maven.apache.org/download.cgi
* GIT client (for code  management)
  * https://git-scm.com/download/win
* Java Virtual Machine
  * https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html
* Docker desktop
  * If you use windows or MacOs you can download and install docker on following link --> https://www.docker.com/products/docker-desktop

## Fast Data Architecture 

![Exercise architecture](img/architecture.png)

* All software used is specified on ![docker compose file](docker/docker_compose.yml)

  * Apache NiFi
  * Apache Kafka stack (Confluent)
  * Elastic
  * Kibana

## Data Source
* **IEX Cloud**: https://iexcloud.io/ (Register)
  * Sign up & get your token. 
  * Stock prices URL: https://cloud.iexapis.com/stable/stock/market/collection/sector?collectionName=Technology&token=your_token


## Launch platform :

Go inside docker folder and launch all docker containers:
```
docker-compose up -d 
```

## Once finished the demo:
You can stop the containers running:
```
docker-compose down
```
