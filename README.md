# Backend Spring Boot para Gestión de Usuarios con JWT

Este es un backend desarrollado en Spring Boot que proporciona funcionalidades para la gestión de usuarios, asignación de roles y utiliza JWT para la autenticación y autorización.

## Requisitos previos

- Java Development Kit (JDK) 17 o superior
- Spring Boot 3.2.5
- Base de datos MySQL (u otro compatible, ajustar la configuración según sea necesario)

## Configuración

1. Clonar este repositorio en tu máquina local.
2. Configurar la base de datos MySQL:
   - Crear una base de datos llamada `nombre_basedatos`.
   - Actualizar las configuraciones de la base de datos en `src/main/resources/application.properties`.
3. Compilar el proyecto usando Maven:
   ```bash
   mvn clean install
   ```
4. Ejecutar la aplicación Spring Boot:
   ```bash
   mvn spring-boot:run
   ```

## Uso

### Endpoints

- **Registro de usuario**
  - Método: POST
  - URL: `/api/users`
  - Payload:
    ```json
    {
      "name": "nombre_ejemplo",
      "lastname": "apellido_ejemplo",
      "username": "ejemplo_usuario",
      "email": "usuario@example.com",
      "password": "contraseña123",
      "admin": true (Se lo retira en caso que el usuario no sea administrador)
    }
  - Headers:
    ```
    Authorization: Bearer {token_de_acceso}
    ```
- **Actualización de usuario**
  - Método: PUT
  - URL: `/api/users/{id}`
  - Payload:
    ```json
    {
      "name": "nombre_ejemplo",
      "lastname": "apellido_ejemplo",
      "username": "ejemplo_usuario",
      "email": "usuario@example.com",
      "admin": true (Se lo retira en caso que el usuario no sea administrador)
    }

   - Headers:
      ```
      Authorization: Bearer {token_de_acceso}
      ```
- **Eliminar un usuario**
  - Método: DELETE
  - URL: `/api/users/{id}`
  - Headers:
      ```
      Authorization: Bearer {token_de_acceso}
      ```
- **Inicio de sesión**
  - Método: POST
  - URL: `/login`
  - Payload:
    ```json
    {
      "username": "ejemplo_usuario",
      "password": "contraseña123"
    }
    ```
  - Respuesta exitosa:
    ```json
    {
     "message": "Hola admin has iniciado sesion con exito",
      "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGhvcml0aWVzIjoiW3tcImF1dGhvcml0eVwiOlwiUk9MRV9BRE1JTlwifSx7XCJhdXRob3JpdHlcIjpcIlJPTEVfVVNFUlwifV0iLCJ1c2VybmFtZSI6ImFkbWluIiwiaWF0IjoxNzE0MzQ5MzQ5LCJleHAiOjE3MTQzNTI5NDl9.QrV4s5vDxoi71o2jG2x1ph6gOc07n4P3dotgRJp2qRQ",
      "username": "admin"
    }
    ```
- **Obtener información de usuario**
  - Método: GET
  - URL: `/api/users/{id}`
  - Headers:
    ```
    Authorization: Bearer {token_de_acceso}
    ```
  - Payload:
    ```json
    {
      "name": "nombre_ejemplo",
      "lastname": "apellido_ejemplo",
      "username": "ejemplo_usuario",
      "email": "usuario@example.com",
      "password": "$2a$10$KZ.NMdfoj.cCzBUdNoth2O9Ws8VayzHu.PDWa3GQR0hyBHC8gBmUm",
      "roles": [
          {
              "id": 1,
              "name": "ROLE_USER"
          },
          {
              "id": 2,
              "name": "ROLE_ADMIN"
          }
      ]
    }
- **Obtener información de los usuarios**
  - Método: GET
  - URL: `/api/users`
  - Payload:
      ```json
      {
        "name": "nombre_ejemplo",
        "lastname": "apellido_ejemplo",
        "username": "ejemplo_usuario",
        "email": "usuario@example.com",
        "password": "$2a$10$KZ.NMdfoj.cCzBUdNoth2O9Ws8VayzHu.PDWa3GQR0hyBHC8gBmUm",
        "roles": [
            {
                "id": 1,
                "name": "ROLE_USER"
            },
            {
                "id": 2,
                "name": "ROLE_ADMIN"
            }
        ]
      }
- **Obtener información de los usuarios por paginacion**
  - Método: GET
  - URL: `/api/users/page/{numero de pagina}`
  - Payload:
      ```json
        {
        "content": [
            {
                "id": 3,
                "name": "Anthony",
                "lastname": "Santillan",
                "email": "anthony@gmail.com",
                "username": "bastiansd",
                "password": "$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS",
                "roles": [
                    {
                        "id": 1,
                        "name": "ROLE_USER"
                    },
                    {
                        "id": 2,
                        "name": "ROLE_ADMIN"
                    }
                ]
            },
            {
                "id": 4,
                "name": "Anthony",
                "lastname": "Santillan",
                "email": "anthonyasdasa@gmail.com",
                "username": "santyasdas",
                "password": "$2a$10$sXcmcLv9jB9vXYFZtITHueEt2/FVNZj8qcjbOVb1Ub/QUE4iSfF6m",
                "roles": [
                    {
                        "id": 1,
                        "name": "ROLE_USER"
                    }
                ]
            }
        ],
        "pageable": {
            "pageNumber": 1,
            "pageSize": 2,
            "sort": {
                "empty": true,
                "sorted": false,
                "unsorted": true
            },
            "offset": 2,
            "paged": true,
            "unpaged": false
        },
        "last": false,
        "totalElements": 5,
        "totalPages": 3,
        "size": 2,
        "number": 1,
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "first": false,
        "numberOfElements": 2,
        "empty": false
    }
### Roles

- **ROLE_USER**: Rol por defecto asignado a los usuarios registrados.
- **ROLE_ADMIN**: Rol con privilegios administrativos.

## Autor

Desarrollado por [Anthony Santillan](https://github.com/AnthonySantillan).
