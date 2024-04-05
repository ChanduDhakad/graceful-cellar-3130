# graceful-cellar-3130




# REST API for an Online Bus Reservation System Portal  Application
<li>We have developed this REST API for an Online Bus Reservation System Portal  application. This API performs
  all the fundamental CRUD operations of any Online Bus Reservation System Portal  platform with user validation at every step.</li>
<li>This project is developed by team of 4 Back-end Developers during project week in Masai School.</li>





![RhomBusjpg](https://user-images.githubusercontent.com/97527158/208288275-e9ecaf67-df3d-4105-a79e-a6632c69ac1e.jpg)

### This is a collaborative project, completed by a team of 4 Java backend developers at Masai School.

# Collaborators

- [Chandra Prakash Dhaker](https://github.com/ChanduDhakad)
- [Priyanka Dhar](https://github.com/Priyanka4251)
- [Pritesh Jha](https://github.com/Pritesh0711)
- [Rakesh Kandar](https://github.com/rakesh7063)


# Tech Stack
- Java
- Spring Framework
- Spring Boot
- Spring Data JPA
- MySQL
- Swagger UI
- Lambok
- Maven


# Modules

- Login Module
- Feedback Module
- User Module
- Bus Module
- Route Module
- Admin Module
- CurrentUser module



# Features

- Data Authentication and Validation for all the users (Bus owner, User)

## Owner Features
- Owner can login by giving valid credentials.
- Owner can add the bus details route details and update the seats accordingly.
- Owner can see all the reservation as well as all the list of customers/users.
- Owner can update the route , bus, admin details.
- Owner can delete any route and bus as well.


## Customer Features
- Customer can login in the application and update their information using their username and password.
- Customer can book Bus as per their source and destination.
- Customer can access the update reservation as well as their own details.
- Customers are able to delete their reservation and their account from the system.


# Installation & Run
 - Before running the API server, you should update the database config inside the application.properties file.
- Update the port number, username and password as per your local database configuration.

```
    server.port=8080

    spring.datasource.url=jdbc:mysql://localhost:3306/RoamBusDB;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root
```

# API Root Endpoint
```

https://raombus-production.up.railway.app/
```
```

https://raombus-production.up.railway.app/swagger-ui/index.html
```


![ErDiagram](![Screenshot (664)](https://user-images.githubusercontent.com/97527158/208291924-2e3c72f3-10a5-4853-bf7f-ed1201719dc0.png))



