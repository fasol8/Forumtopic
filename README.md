# Forum topics

Spring Boot REST API for forum with topics.

Our API will focus specifically on topics, and should allow users to:
- Create a new topic;
- Display all created topics;
- Display a specific topic;
- Update a topic;
- Delete a topic.

## API Overview

- **Title**: Forum topic
- **Server URL**: [http://localhost:8080](http://localhost:8080)
- **Security**: Bearer Authentication (JWT)

## Endpoints

### Topic Controller

#### Find a Topic by ID

- **URL**: `/topic/{id}`
- **Method**: `GET`
- **Description**: Find a topic by ID
- **Parameters**:
  - `id` (path, required, integer, int32)
- **Responses**:
  - `200 OK`: Returns a topic object

#### Update a Topic

- **URL**: `/topic/{id}`
- **Method**: `PUT`
- **Description**: Update a topic
- **Parameters**:
  - `id` (path, required, integer, int32)
- **Request Body**: Topic data object
- **Responses**:
  - `200 OK`: Returns the updated topic object

#### Delete a Topic

- **URL**: `/topic/{id}`
- **Method**: `DELETE`
- **Description**: Delete a topic
- **Parameters**:
  - `id` (path, required, integer, int32)
- **Responses**:
  - `200 OK`: Returns the deleted topic object

#### Get a List of Topics

- **URL**: `/topic`
- **Method**: `GET`
- **Description**: Get a list of topics
- **Parameters**:
  - `pagination` (query, required, pageable object)
- **Responses**:
  - `200 OK`: Returns a paginated list of topics

#### Create a New Topic

- **URL**: `/topic`
- **Method**: `POST`
- **Description**: Create a new topic
- **Request Body**: Topic data object
- **Responses**:
  - `200 OK`: Returns the ID of the newly created topic

### User Controller

#### Register a New User

- **URL**: `/user/register`
- **Method**: `POST`
- **Description**: Register a new user
- **Request Body**: User data object
- **Responses**:
  - `200 OK`: Returns a string message

#### Login a User

- **URL**: `/user/login`
- **Method**: `POST`
- **Description**: Login a user
- **Request Body**: Login data object
- **Responses**:
  - `200 OK`: Returns a string message

#### List All Users

- **URL**: `/user`
- **Method**: `GET`
- **Description**: List all users
- **Responses**:
  - `200 OK`: Returns an array of user objects

### Hello Controller

#### Hello World

- **URL**: `/hello`
- **Method**: `GET`
- **Description**: Hello World endpoint
- **Responses**:
  - `200 OK`: Returns a string message

## Schemas

### Topic Data

- **Properties**:
  - `title` (string)
  - `message` (string)
  - `tag` (string)
  - `user` (User data object)
  - `course` (Course data object)
  - `responseTopic` (Response topic data object)

### User Data

- **Properties**:
  - `idUser` (integer, int32)
  - `name` (string)
  - `mail` (string)
  - `password` (string)
  - `profile` (Profile data object)

### Course Data

- **Properties**:
  - `idCourse` (integer, int32)
  - `name` (string)
  - `category` (string)

### Profile Data

- **Properties**:
  - `idProfile` (integer, int32)
  - `name` (string)

### Response Topic Data

- **Properties**:
  - `idResponse` (integer, int32)
  - `message` (string)
  - `date` (string)
  - `solution` (boolean)
  - `user` (User data object)

### Login Data

- **Properties**:
  - `mail` (string)
  - `password` (string)

### Pageable

- **Properties**:
  - `page` (integer, int32, minimum: 0)
  - `size` (integer, int32, minimum: 1)
  - `sort` (array of strings)

### Page Topic List Data

- **Properties**:
  - `totalPages` (integer, int32)
  - `totalElements` (integer, int64)
  - `size` (integer, int32)
  - `content` (array of Topic list data objects)
  - `number` (integer, int32)
  - `sort` (array of Sort objects)
  - `pageable` (Pageable object)
  - `numberOfElements` (integer, int32)
  - `first` (boolean)
  - `last` (boolean)
  - `empty` (boolean)

### Sort Object

- **Properties**:
  - `direction` (string)
  - `nullHandling` (string)
  - `ascending` (boolean)
  - `property` (string)
  - `ignoreCase` (boolean)

### Topic List Data

- **Properties**:
  - `idTopic` (integer, int32)
  - `title` (string)
  - `message` (string)
  - `date` (string)
  - `tag` (string)
  - `course` (Course data object)

## Security Schemes

- **Bearer Key**: 
  - **Type**: HTTP
  - **Scheme**: bearer
  - **Bearer Format**: JWT
