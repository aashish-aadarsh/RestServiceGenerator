# RestServiceGenerator

This is a java project build with maven to generate basic CRUD operation REST APIs 
using [Spring Boot](https://spring.io/projects/spring-boot) and backed with [MongoDB](https://spring.io/projects/spring-data-mongodb)

## GeneratedStructure:

1. Generated Project contains basic JWT auth mechanism to protect unauthenticated access.
2. User, UserRole, UserSecurity and BaseEntity are generated by tool.
3. Auth Controller and it's depending classes are generated by tool and these are open APIs which does not require authentication, except change password.
4. Swagger is by default configured and the generated application will run on 8080 port. 
5. The packages are generated in five category:
        1. application - It has sub-packages to store application constant, exception and their handler, 	    service and service impl and utility package.
        2. configuration - Configuration containing aop, security and swagger.
        3. controller - REST API controller 
        4. domain - Entities and their corresponding repository in different domain directory.
        5. facade - Empty package with two sub-packages if application want to introduce DTO layer and corresponding mapper from DTO to entity.
		
## NOTES:
1. Do not add _id, createdByUser, updatedByUser, isActive, createdDateTime, updatedDateTime and additionalProperties variables as these are defined in BaseEntity.
2. Follow the naming convention while defining json file and keys.
3. Please change the connection parameter defined in resources/application.yml.
4. Do not use space in Application name as it will decide name of SpringBootClass.

## How to Use :

1. Download the [RestServiceGenerator.zip](https://github.com/aashish-aadarsh/RestServiceGenerator/raw/master/RestServiceGenerator.zip) and extract to some directory.

2. Go to extracted directory, you will find `RestServiceGenerator.jar` and `properties` 
directory.

3. Go to `properties` directory :   
       i. Modify `generator.properties` with desired property value.  
       ii. Create the `json` file for which domain has to be generated.

4. Open command prompt and change directory where jar file is present and execute below command.     
         `java -jar RestServiceGenerator`  
         
    Make sure jar and properties directory are present in same directory.
 5. Wait till application finishes its execution.
 6. Import the skeleton in Eclipse or IntelliJ studio.
 
      Enjoy coding. :)
        
        
## Issues
Feel free to report any issues, change request [Here](https://github.com/aashish-aadarsh/RestServiceGenerator/issues)

#

##### Credits:
[Aashish Aadarsh](https://github.com/aashish-aadarsh) 
