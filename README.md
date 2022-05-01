## Registering the connector
curl -i -X POST -H "Accept:application/json" -H "Content-Type:application/json" http://localhost:8083/connectors/ --data @register-connector.json

curl -H "Accept:application/json" localhost:8083/connectors/

curl -i -X GET -H "Accept:application/json" localhost:8083/connectors/incident-location-connector

## List all topics
sudo docker-compose exec kafka /kafka/bin/kafka-topics.sh --list --bootstrap-server kafka:9092

## Listen to the topic
sudo docker-compose exec kafka /kafka/bin/kafka-console-consumer.sh --bootstrap-server kafka:9092 --from-beginning --property print.key=true --topic dbserver1.public.tbl_incident_locations