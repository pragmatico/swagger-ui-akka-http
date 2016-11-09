package com.github.swagger.akka

import akka.http.scaladsl.server.Directives

trait SwaggerSite extends Directives {
  val swaggerSiteRoute = path("swagger") { getFromResource("swagger-ui/index.html") } ~ getFromResourceDirectory("swagger-ui")
}
