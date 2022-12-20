# spring-cloud-config

Spring Cloud Config provides server-side and client-side support for externalized configuration in a distributed system. With the Config Server, you have a central place to manage external properties for applications across all environments.

This repository consists of three projects.

1) insurance-provider
2) insurance-client
3) config-server

insurance-provider - This service exposed the REST endpoint which will produce list of insurance plans. Which is running on port 8080
insurance-client - This service is having one REST end point, while accessing this endpoint which will consume the other microservice insurance-provider to fetch all the insurance plan details.
config-server - This is the project where managing all the centralized configuration also it used the github for configuration management source.

