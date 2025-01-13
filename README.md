# Twitter-Clone Application

## Project Overview: Twitter-like Application API
The Twitter-like Application API provides the backend functionality for a social media platform designed to enable users to post messages, manage their subscriptions, and interact with other users seamlessly. The API is built with scalability, security, and simplicity in mind, making it an ideal foundation for building a social media application.

### Key Features:
#### User Management Service:

- **Secure user registration and login functionalities.**
- **Role-based access control for assigning and managing user roles.**
- **JWT-based authentication for secure access.**
  
#### Message Service:

- **Create and manage user-generated messages.**
- **Retrieve all messages or filter messages by user or content.**
- **Efficient search capabilities for finding messages based on keywords.**

#### Subscription Service:

- **Users can subscribe to other users (producers) to stay updated on their activity.**
- **Manage subscriptions by adding or removing producers.**
- **Retrieve lists of subscribers and producers.**

#### Scalability:

- **RESTful APIs to support seamless integration with a frontend.**
- **Scalable architecture to handle growing user and message volumes.**

### Technologies:
- **Backend:** Spring Boot for API development and secure handling of business logic.
- **Database:** SQLite for structured data storage and retrieval.
- **Authentication:** JSON Web Tokens (JWT) for secure user sessions.
- **API Design:** RESTful endpoints for efficient client-server communication.

### API Capabilities:
#### The API includes the following features:
- **User Registration and Login:** Allows users to create accounts, authenticate, and manage their roles.
- **Messaging System:** Enables users to post messages, search for specific content, and view messages by user.
- **Subscription Management:** Provides functionality for subscribing to and unsubscribing from producers, as well as viewing subscribers and producers.

## Objective:
The Twitter-like Application API is designed to provide a robust and feature-rich backend for building a social media platform. Its focus on scalability, security, and user engagement makes it suitable for any application requiring real-time messaging and user interaction capabilities. With its modular design, the API serves as a flexible foundation for expanding the application's features.

## Prerequisites

    - Java 17+
    - React.js and npm (for the frontend)
    - MySQL (for the database)
    - Maven (for managing Java dependencies)

## Installation

### Twitter-clone (Spring Boot)

    1. Clone the repository:
        git clone <https://github.com/hamdihismail/Twitter-clone>

    2. Navigate to the backend directory:
        cd Twitter-clone-main/twitter-clone

    3. Install dependencies and build the project using Maven:
        mvn clean install

    4.Configure the MySQL database in the application.properties file located in src/main/resources/:
        spring.datasource.url=jdbc:mysql://localhost:3306/hotel_booking
        spring.datasource.username=<your-username>
        spring.datasource.password=<your-password>

    5.Run the application:
        mvn spring-boot:run

### UMS (user management service) (Spring Boot)

    1. Clone the repository:
        git clone <https://github.com/hamdihismail/Twitter-clone>

    2. Navigate to the backend directory:
        cd Twitter-clone-main/ums

    3. Install dependencies and build the project using Maven:
        mvn clean install

    4.Configure the MySQL database in the application.properties file located in src/main/resources/:
        spring.datasource.url=jdbc:mysql://localhost:3306/hotel_booking
        spring.datasource.username=<your-username>
        spring.datasource.password=<your-password>

    5.Run the application:
        mvn spring-boot:run


## Usage

Once both the twitter-clone and ums are running:

    - Access the twitter-clone application via port 9001.
    - Access the ums application via port 9000.

    This API serves as the backend for a Twitter-like application, allowing users to manage accounts, send messages, and handle subscriptions. Below is a summary of the available endpoints and their functionalities.

### Base URL
All endpoints are prefixed with the following base URL:
- **User Management Service** `http://localhost:9000`
- **Messaging/Subscription Service** `http://localhost:9001`


### Endpoints

#### User Management Service
##### Register a New User
- **Endpoint:** `POST /users/register`
- **Description:** Registers a new user with username, email, and password.
- **Request Body:**
  ```json
  {
    "username": "string",
    "email": "string",
    "password": "string"
  }
  ```
Responses:
201: User registered successfully.
400: Bad request.

##### Assign Roles to a User
- **Endpoint:** `POST /users/roles`
- **Description:** Assigns one or more roles to a user.
- **Request Body:**
  ```json
  {
    "userId": "integer",
    "roleName": {
      "roleOne": "string",
      "roleTwo": "string"
    }
  }
  ```
Responses:
201: Role assigned successfully.
400: Bad request.

##### Login a User
- **Endpoint:** `POST /users/login`
Description: Authenticates a user and provides a JWT token.
Request Body:
  ```json
  {
    "username": "string",
    "password": "string"
  }
  ```
Responses:
200: User logged in successfully (returns a token).
401: Unauthorized.

#### Message Service
##### Create a New Message
- **Endpoint:** `POST /messages`
- **Description:** Allows a user to post a new message.
- **Request Body:**
  ```json
  {
    "userId": "integer",
    "content": "string"
  }
  ```
Responses:
201: Message created successfully.
401: Unauthorized.

##### Retrieve All Messages
- **Endpoint:** `GET /messages`
- **Description:** Fetches all messages.
Responses:
200: List of all messages.
  
##### Retrieve Messages by User ID
- **Endpoint:** `GET /messages/user/{userId}`
- **Description:** Fetches messages posted by a specific user.
- **Path Parameter:** `userId (integer): ID of the user.`
  
Responses:
200: List of messages by the user.
404: User not found.

##### Search Messages by Content
- **Endpoint:** `GET /messages/search`
- **Description:** Searches for messages containing specific content.
- **Query Parameter:** `content (string): Search keyword.`
  
Responses:
200: List of matching messages.

#### Subscription Service
##### Subscribe to a Producer
- **Endpoint:** `POST /subscriptions`
- **Description:** Subscribes a user to a producer.
- **Request Body:**
  ```json
  {
    "subscriberId": "integer",
    "producerId": "integer"
  }
  ```
Responses:
201: Subscription created successfully.
401: Unauthorized.

##### Unsubscribe from a Producer
- **Endpoint:** `DELETE /subscriptions`
- **Description:** Removes a subscription.
- **Request Body:**
  ```json
  {
    "subscriberId": "integer",
    "producerId": "integer"
  }
  ```
Responses:
204: Subscription deleted successfully.
401: Unauthorized.

##### Get Subscribers of a Producer
- **Endpoint:** `GET /subscriptions/subscribers/{producerId}`
- **Description:** Retrieves the list of subscribers for a specific producer.
- **Path Parameter:** `producerId (integer): ID of the producer.`
Responses:
200: List of subscribers.
404: Producer not found.
  
##### Get Producers Subscribed by a User
- **Endpoint:** `GET /subscriptions/producers/{subscriberId}`
- **Description:** Retrieves the list of producers subscribed to by a specific user.
- **Path Parameter:** `subscriberId (integer): ID of the subscriber.`
Responses:
200: List of producers.
404: Subscriber not found.

Project Structure

    Twitter-clone-main/
        twitter-clone/
            src/
            pom.xml
            ...
    Twitter-clone-main/
        ums/
            src/
            pom.xml
            ...

Contributing

    - Hamdi Ismail - Developer

License

This project is licensed under the MIT License.
