# Spring Boot: Basic Refreshable external `application.properties`

Very basic demo to configure your boot application via external properties (outside jar) @see  `./config/application.properties`.
The properties can be changes and reloaded in the running application without the need to restart it.

Persist your changes via `curl -X POST localhost:8080/actuator/refresh -d {} -H "Content-Type: application/json" `
