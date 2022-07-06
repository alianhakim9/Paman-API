# API Spec

Berikut adalah dokumentasi API Spec untuk PAMAN-API

## Auth

Endpoint ini digunakan untuk melakukan autentikasi user sebelum mengakses endpoint lainnya.

### Login

Request

* Method : POST
* Header:
    * Content-Type: application/json
    * Accept: application/json
* Endpoint: ```/api/v1/auth/login/```
* Body:

```json
{
  "username": "string|unique",
  "password": "string"
}
```

Response:

```json
{
  "data": {
    "user_id": "string",
    "auth_token": "string"
  },
  "message": "login success",
  "status": "string"
}
```

### Register

Request

* Method : POST
* Header:
    * Content-Type: application/json
    * Accept: application/json
* Endpoint: ```/api/v1/auth/register/```
* Body:

```json
{
  "username": "string|unique",
  "password": "string"
}
```

Response:

```json
{
  "data": {
    "username": "string",
    "password": "string",
    "user_id": "string"
  },
  "message": "string",
  "status": "string"
}
```

## Password Manager

### Get password manager By Id

Request

* Method : GET
* Header:
    * Content-Type: application/json
    * Authorization: Bearer Token
* Endpoint: ```/api/v1/password-manager/{id}```

Response:

```json
{
  "data": {
    "id": "string",
    "pmUsername": "string",
    "pmPassword": "string",
    "pmWebsite": "string",
    "createdAt": "date",
    "updatedAt": "date"
  },
  "message": "string",
  "status": "string"
}
```

### Get password manager by user id

Request

* Method : GET
* Header:
    * Content-Type: application/json
    * Authorization: Bearer Token
* Endpoint: ```/api/v1/password-manager/{userId}```

Response:

```json
{
  "data": [
    {
      "id": "string",
      "pmUsername": "string",
      "pmPassword": "string",
      "pmWebsite": "string",
      "createdAt": "date",
      "updatedAt": "date"
    },
    {
      "id": "string",
      "pmUsername": "string",
      "pmPassword": "string",
      "pmWebsite": "string",
      "createdAt": "date",
      "updatedAt": "date"
    }
  ],
  "message": "string",
  "status": "string"
}
```

### Create password manager

Request

* Method : POST
* Header:
    * Content-Type: application/json
    * Accept: application/json
    * Authorization: Bearer Token
* Endpoint: ```/api/v1/auth/password-manager/```
* Body:

```json
{
  "pmUsername": "string|unique",
  "pmPassword": "string",
  "pmWebsite": "string",
  "pmUserId": "string"
}
```

Response:

```json
{
  "data": {
    "username": "string",
    "password": "string",
    "user_id": "string"
  },
  "message": "string",
  "status": "string"
}
```

### Update password manager

Request

* Method : PUT
* Header:
    * Content-Type: application/json
    * Accept: application/json
    * Authorization: Bearer Token
* Endpoint: ```/api/v1/auth/password-manager/```
* Body:

```json
{
  "pmUsername": "string|unique",
  "pmPassword": "string",
  "pmWebsite": "string",
  "pmUserId": "string"
}
```

Response:

```json
{
  "data": {
    "username": "string",
    "password": "string",
    "user_id": "string"
  },
  "message": "string",
  "status": "string"
}
```

### Delete password manager

Request

* Method : DELETE
* Header:
    * Content-Type: application/json
    * Authorization: Bearer Token
* Endpoint: ```/api/v1/auth/password-manager/```

Response:

```json
{
  "data": "string",
  "message": "string",
  "status": "string"
}
```

## Personal Info

### Get personal info by id

Request

* Method : GET
* Header:
    * Content-Type: application/json
    * Authorization: Bearer Token
* Endpoint: ```/api/v1/personal-info/{id}```

Response:

```json
{
  "data": {
    "id": "string",
    "piWebsite": "string",
    "piAddress": "string",
    "piEmail": "string",
    "piPhoneNumber": "string",
    "createdAt": "date",
    "updatedAt": "date"
  },
  "message": "string",
  "status": "string"
}
```

### Get personal info by user id

Request

* Method : GET
* Header:
    * Content-Type: application/json
    * Authorization: Bearer Token
* Endpoint: ```/api/v1/personal-info/{userId}```

Response:

```json
{
  "data": [
    {
      "id": "string",
      "piWebsite": "string",
      "piAddress": "string",
      "piEmail": "string",
      "piPhoneNumber": "string",
      "createdAt": "date",
      "updatedAt": "date"
    },
    {
      "id": "string",
      "piWebsite": "string",
      "piAddress": "string",
      "piEmail": "string",
      "piPhoneNumber": "string",
      "createdAt": "date",
      "updatedAt": "date"
    }
  ],
  "message": "string",
  "status": "string"
}
```

### Create personal info

Request

* Method : POST
* Header:
    * Content-Type: application/json
    * Accept: application/json
    * Authorization: Bearer Token
* Endpoint: ```/api/v1/auth/personal-info/```
* Body:

```json
{
  "piWebsite": "string",
  "piAddress": "string",
  "piEmail": "string",
  "piPhoneNumber": "string",
  "userId": "string"
}
```

Response:

```json
{
  "data": {
    "id": "string",
    "piWebsite": "string",
    "piAddress": "string",
    "piEmail": "string",
    "piPhoneNumber": "string",
    "createdAt": "date",
    "updatedAt": "date"
  },
  "message": "string",
  "status": "string"
}
```

### Update personal info

Request

* Method : PUT
* Header:
    * Content-Type: application/json
    * Accept: application/json
    * Authorization: Bearer Token
* Endpoint: ```/api/v1/auth/personal-info/```
* Body:

```json
{
  "piWebsite": "string",
  "piAddress": "string",
  "piEmail": "string",
  "piPhoneNumber": "string",
  "userId": "string"
}
```

Response:

```json
{
  "data": {
    "id": "string",
    "piWebsite": "string",
    "piAddress": "string",
    "piEmail": "string",
    "piPhoneNumber": "string",
    "createdAt": "date",
    "updatedAt": "date"
  },
  "message": "string",
  "status": "string"
}
```

### Delete personal info

Request

* Method : DELETE
* Header:
    * Content-Type: application/json
    * Authorization: Bearer Token
* Endpoint: ```/api/v1/auth/personal-info/```

Response:

```json
{
  "data": "string",
  "message": "string",
  "status": "string"
}
```

## Note

### Get note info by id

Request

* Method : GET
* Header:
    * Content-Type: application/json
    * Authorization: Bearer Token
* Endpoint: ```/api/v1/note/{id}```

Response:

```json
{
  "data": {
    "id": "string",
    "noteTitle": "string",
    "noteDescription": "string",
    "createdAt": "date",
    "updatedAt": "date"
  },
  "message": "string",
  "status": "string"
}
```

### Get note info by user id

Request

* Method : GET
* Header:
    * Content-Type: application/json
    * Authorization: Bearer Token
* Endpoint: ```/api/v1/note/{userId}```

Response:

```json
{
  "data": [
    {
      "id": "string",
      "noteTitle": "string",
      "noteDescription": "string",
      "createdAt": "date",
      "updatedAt": "date"
    },
    {
      "id": "string",
      "noteTitle": "string",
      "noteDescription": "string",
      "createdAt": "date",
      "updatedAt": "date"
    }
  ],
  "message": "string",
  "status": "string"
}
```

### Create note

Request

* Method : POST
* Header:
    * Content-Type: application/json
    * Accept: application/json
    * Authorization: Bearer Token
* Endpoint: ```/api/v1/note/```
* Body:

```json
{
  "noteTitle": "string",
  "noteDescription": "string",
  "userId": "string"
}
```

Response:

```json
{
  "data": {
    "id": "string",
    "noteTitle": "string",
    "noteDescription": "string",
    "createdAt": "date",
    "updatedAt": "date"
  },
  "message": "string",
  "status": "string"
}
```

### Update note

Request

* Method : PUT
* Header:
    * Content-Type: application/json
    * Accept: application/json
* Endpoint: ```/api/v1/note/```
* Body:

```json
{
  "noteTitle": "string",
  "noteDescription": "string",
  "userId": "string"
}
```

Response:

```json
{
  "data": {
    "id": "string",
    "noteTitle": "string",
    "noteDescription": "string",
    "createdAt": "date",
    "updatedAt": "date"
  },
  "message": "string",
  "status": "string"
}
```

### Delete note

Request

* Method : DELETE
* Header:
    * Content-Type: application/json
* Endpoint: ```/api/v1/note/```

Response:

```json
{
  "data": "string",
  "message": "string",
  "status": "string"
}
```

### Pengembang / Developer : <a href="https://github.com/alianhakim9" target="_blank">Alian Hakim</a>