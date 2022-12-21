# spring-cloud-config

Spring Cloud Config provides server-side and client-side support for externalized configuration in a distributed system. With the Config Server, you have a central place to manage external properties for applications across all environments.

This repository consists of three projects.

1) _insurance-provider_
2) _insurance-client_
3) _config-server_

Also config-server application uses the github as a source maintaining place. This github project located in https://github.com/snareshkumar/insurance-config-github


**insurance-provider** - This service exposed the REST endpoint which will produce list of insurance plans. Which is running on port 8080.

**insurance-client** - This service is having one REST end point, while accessing this endpoint which will consume the other microservice insurance-provider to fetch all the insurance plan details. Which is running on port 8090

**config-server** - This is the project where managing all the centralized configuration also it used the github for configuration management source. Which is running on port 8090

**How this can be tested** 

**Step1** - Checkout all the projects

**Step2** - Go to inside all the project directory and perform the below command

            mvn clean install
            
**Step3** - Run insurance-provider and config-server application respectively.

**Step4** - Run config-server application.

Please see, https://github.com/snareshkumar/insurance-config-github/blob/main/application.properties

Access **insurance-provider** application using the below URL. 

http://127.0.0.1:8080/insurance-provider/getinsuranceplans this is path where insurance-provider exposed the insurance plan details.

Access **config-server** application using the below URL to verify externalized configuration

invoke http://localhost:8081/actuator/default GET method. Which will return all the configuration from github source(in this scenario we configured insurance-provider REST URL in github source)

Access **insurance-client** application using below URL

invoke http://localhost:8090/getallplans with GET method. This should return list of insurance plan details.

**Test Scenario** - **_Modify the insurance provider API url in **insurance-provider** application and github configuration source. Verify insurance-client able to access insurance-provider details without restarting the application_**

**Step 1** - Modify the REST URL in insurance-provider rest controller _/getinsuranceplans_ to _getplans_

**Step 2** - Modify the same in github source

insurance-provider-url=http://127.0.0.1:8080/insurance-provider/getplans

**Step3** - Access http://localhost:8090/actuator/refresh using POST method.

**Step4** - Finally invoke the http://localhost:8090/getallplans using GET method. This should return all the plans which is exposed in **insurance-provider** applicaiton. At this moment we are not restarted the **insurance-client** application to effect the configuration changes.








