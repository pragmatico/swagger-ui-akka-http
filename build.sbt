name := baseDirectory.value.getName

version := "1.0"

scalaVersion := "2.11.8"

crossScalaVersions := Seq("2.11.8", "2.11.0")

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {

  val akkaV       = "2.4.7"

	Seq (
		"com.typesafe.akka" %% "akka-actor" % akkaV,
		"com.typesafe.akka" %% "akka-stream" % akkaV,
		"com.typesafe.akka" %% "akka-http-experimental" % akkaV,
		"com.typesafe.akka" %% "akka-http-spray-json-experimental" % akkaV,
		"com.typesafe.akka" %% "akka-http-testkit" % akkaV
	)
}

publishMavenStyle := true

publishTo := {
	val nexus = "https://oss.sonatype.org/"
	if (isSnapshot.value)
		Some("snapshots" at nexus + "content/repositories/snapshots")
	else
		Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}


homepage := Some(url("https://github.com/pragmatico/swagger-ui-akka-http"))

licenses := Seq("The Apache Software License, Version 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt"))

//releasePublishArtifactsAction := PgpKeys.publishSigned.value

pomExtra := (
	<scm>
		<url>git@github.com:pragmatico/swagger-ui-akka-http.git</url>
		<connection>scm:git:git@github.com:pragmatico/swagger-ui-akka-http.git</connection>
	</scm>
	<developers>
		<developer>
			<id>jmbataller</id>
			<name>Jose Miguel Bataller</name>
			<url>http://pragmati.co</url>
	</developer>
	</developers>)




