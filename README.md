# Book Shop

This project was built using [Spring Framework](https://spring.io/)

## Step to set up this project:
1. Download or clone this repository
2. Create local database with name "book_store"
4. Config your database url, username, and password in application.properties
5. If it's your first time to run this project, edit application properties "spring.jpa.hibernate.ddl-auto=create"
6. If you want to run this project again, edit application properties "spring.jpa.hibernate.ddl-auto=update"
6. Do CRUD (Create, Read, Update, Delete) using Postman or any REST API client application


## REST API Method
Please adjust to your port
### Books
#### Get
Get all books :
```
localhost:8080/books
```
Get book by id :
```
localhost:8080/books/{id}
```
#### POST
Add book :
```
localhost:8080/books
```
#### PUT
Update book :
```
localhost:8080/books
```

#### DELETE
Delete book :
```
localhost:8080/books/{id}
```

### Members
#### Get
Get all members : 
````
localhost:8080/members
````
Get member by id : 
```
localhost:8080/members/{id}
```
#### POST
Add member : 
```
localhost:8080/members
```
#### PUT
Update member : 
```
localhost:8080/members
```
#### DELETE
Delete member : 
```
localhost:8080/members/{id}
```

#### Transaction
Transaction information will be sent to email
#### POST
Purchase book :
```
localhost:8080/transaction
```