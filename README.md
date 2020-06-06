## Data sources

* **IEX Cloud**: https://iexcloud.io/
  * Sign up
  * Tickers URL: https://cloud.iexapis.com/stable/stock/market/collection/sector?collectionName=Technology&token=your_token


## Software used 

* Docker:  To run this demo you need docker installed. If you use windows or MacOs you can download and install docker on following link --> https://www.docker.com/products/docker-desktop

* All software used is specified on docker compose file. 

* Apache NiFi
* Kafka stack
* Elastic
* Kibana

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
