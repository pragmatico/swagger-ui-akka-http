
### swagger-ui-akka-http

[swagger-ui-akka-http](https://github.com/pragmatico/swagger-ui-akka-http) 
is compatible with [swagger-akka-http](https://github.com/swagger-akka-http/swagger-akka-http/blob/master/build.sbt) 
and is an alternative to drop the static Swagger site files in the resources directory of your project.

### Add dependency to build.sbt

```
libraryDependencies += "co.pragmati" %% "swagger-ui-akka-http" % "0.1.0"
```

### Add SwaggerSite route

swagger-ui-akka-http includes SwaggerSite trait that exposes a swagger route hosting files from the ```resources/swagger/``` directory:

```
trait SwaggerSite extends Directives {
  val swaggerSiteRoute = path("swagger") { 
    getFromResource("swagger-ui/index.html") } ~ 
    getFromResourceDirectory("swagger-ui")
}
```

Mix this trait with a new or existing class:

```
object MyApp extends App with SwaggerSite ...
```

and add the ```swaggerSiteRoute``` to the existing route definitions:

```
  val routes = swaggerSiteRoute ~
               ...
```


