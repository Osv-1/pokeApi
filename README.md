# PokeApi - Backend <img src = "https://github.com/Osv-1/pokeApi/blob/master/logoPoke.png?raw=true)">

## Objective

This challenge consists of building a Microsservice using Java and Spring to consume the PokeAPI and provide a pokemons
query endpoint by substring, returning a response ordered by two algorithms (without using libraries): Name length and
alphabetical order. The return should also show a highlight of which part of the name the substring was found.

## How to use

* The query of pokemons is performed through the endpoint mentioned above. The API will query Pokemons that contain the
  substring passed by parameter in their name, as in the example below:

```
GET /pokemons?q=pidge&sort=alphabetical

Example:
{
  "result": [
    "pidgeot",
    "pidgeotto",
    "pidgey"
  ]
}


```

```
GET /pokemons?q=pidge&sort=length

{
  "result": [
    "pidgey",
    "pidgeot",
    "pidgeotto"
  ]
}

```

```
GET /highlight?q=pidge

[
  {
    "name": "pidgey",
    "start": 0,
    "end": 4
  },
  {
    "name": "pidgeotto",
    "start": 0,
    "end": 4
  },
  {
    "name": "pidgeot",
    "start": 0,
    "end": 4
  }
]
```

## Swagger documentation URL

<h3>
 <img  href src=https://github.com/go-swagger/go-swagger/blob/master/docs/favicon-16x16.png?raw=true > <a href="http://localhost:8080/swagger-ui/index.html#/">Swagger Documentation</a> 
</h3>

## Run the project:

1) Build the project if you haven't already:

* Go to the base folder (the one containing the build.gradle and settings.gradle files);
* Run the command:
* Make sure the command works (created /build folder with /build/libs/backend-0.0.1-SNAPSHOT.JAR)
  ``` 
  gradle build
  ```

2) Create the container:

* Make sure Docker is running;
* Still in the base folder (the one with the DOCKERFILE file), run the command:
* It will generate a container called app from the build file
   ```
   docker build -t app .
   ``` 
   ```
   docker run -p 8080:8080 app
   ``` 

3) Use of the application:

* Make sure port localhost:8080 is available;
* The application is exposed on port 8080 of localhost.
  *You can make a request by sending a get request
   ```
    GET http://localhost:8080/pokemons?q={name}&sort={sort})
   ```

## Swagger documentation URL

<h3>
 <img  href src=https://github.com/go-swagger/go-swagger/blob/master/docs/favicon-16x16.png?raw=true > <a href="http://localhost:8080/swagger-ui/index.html#/">Swagger Documentation</a> 
</h3>

## Useful links

- [Spring Framework](https://spring.io/)
- [Gradle](https://gradle.org/)
- [PokeApi docs](https://pokeapi.co/docs/v2.html)
