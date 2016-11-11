
### swagger-ui-akka-http

[swagger-ui-akka-http](https://github.com/pragmatico/swagger-ui-akka-http) 
is compatible with [swagger-akka-http](https://github.com/swagger-akka-http/swagger-akka-http) 
and is an alternative to drop the static Swagger site files in the resources directory of your project.

### Add dependency to build.sbt

```
libraryDependencies += "co.pragmati" %% "swagger-ui-akka-http" % "1.0.0"
```

### Add SwaggerSite route

Mix this trait with a new or existing class that has access to the existing routes:

```
object MyApp extends App with SwaggerSite
```

and concatenate the ```swaggerSiteRoute``` to the existing route definitions:

```
  val routes = swaggerSiteRoute ~ otherRoute
```

The swagger UI will be accessible under:

```
http://<host>:<port>/swagger
```
