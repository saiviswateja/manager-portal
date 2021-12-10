# Manager Portal
## Helps to manage employees and do all basic CRUD operations

Manager Portal is a backend application developed in Spring Boot helping managers to add/remove/update employees.

- Secured the application using JWT Authentication using Spring Security
- Added Swaggerto get REST API's Documentation

## Setup
Create following databases as required for the profile you choose to run
    for PROD Profile
    >  CREATE SCHEMA `company` ;
    for DEV Profile
    >  CREATE SCHEMA `companydev` ;
    for QA Profile
    >  CREATE SCHEMA `companyqa` ;
    
All other tables are created automatically by spring JPA. The insertions required for roles table are automatically inserted into the database by CommandLineRunner which executes on start up.
    
Download or clone the Git Repository and open the project in any spring supported IDE's like Intellij or Eclipse. 

Three different profiles are enabled for the application
- Production Profile
- Dev Profile
- QA Profile

Each profile runs with different configurations which makes a good isoloation for multiple profiles.

## Enpoints provided by the Application
Please set ContentType as "application/json" for all the end points
- Authentication
  - Every endpoint provided by the application is authorised by the JWT Authentication.
  - End point:  http://localhost:8080/authenticate 
    - Method - POST
    - Body -    {
                    "userName":"testng@gmail.com",
                    "password":"password1234"
                }
     - Headers:
        - Content-Type - application/json
        
  - In order to by pass that we need to hit authenticate end point and get bearer token, which can be used for further end points
  - Swagger end point and Manager End point (Add Manager) are not authorised
    
- Manager 
  - Add Manager - /api/manager/ 
    - Method: POST
    - Body:
        - {
            "emailId":"testng@gmail.com",
            "firstName":"testfirstname",
            "lastName":"testLastName",
            "password":"password1234",
            "address":"10/427, anantapur",
            "birthDate":"14/12/2021",
            "companyName":"testcompany",
            "isAdmin":1 
        }
    isAdmin inserts manager with Admin role where 0 refers as Admin Trainee role
- Employee
  - Add Employee - /api/employee/ 
  - - Method: POST
    - Body:
        - {
            "firstName":"teja",
            "lastName":"sai viswa",
            "address":"10-427, adhimoorthy nagar",
            "birthDate":"10/2/32",
            "companyName":"TCS",
            "mobile":"9490588824"    
        }
    - Headers:
        - Content-Type - application/json
        - Authorization - Bearer {token from authenticate method}
  - Delete Employee - /api/employee/ 
    - METHOD - DELETE
    - Body - {
                "employeePk":1
            }
    - Headers:
        - Content-Type - application/json
        - Authorization - Bearer {token from authenticate method}
  - Update Employee - /api/employee/
    - Method: POST
        - Body:
            - {
                "firstName":"teja",
                "lastName":"sai viswa",
                "address":"10-427, adhimoorthy nagar",
                "birthDate":"10/2/32",
                "companyName":"TCS",
                "mobile":"9490588824"    
            }
    - Headers:
        - Content-Type - application/json
        - Authorization - Bearer {token from authenticate method}
  - Get Employee - /api/employee/ 
    - Method - GET
    - Headers:
        - Content-Type - application/json
        - Authorization - Bearer {token from authenticate method}
- Swagger - v3/api-docs/
-   - Method - GET

> Please run the application and hit the swagger end point to get more details about the REST endpoints, Also I will share the Postman collection for easy reference of the API's (try importing them in your postman)

## Roles 
There are two roles defined for manager in the Portal.
- ADMIN - can do all operatins in the portal
- ADMIN TRAINEE - can only retrieve employee details
> we configure them while adding the manager with the is Admin field (1 refers Admin, 0 refers Admin Trainee)
