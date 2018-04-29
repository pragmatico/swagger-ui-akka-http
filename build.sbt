import xerial.sbt.Sonatype.autoImport._
import ReleaseTransformations._

name := baseDirectory.value.getName

version := "1.2.1"

organization := "co.pragmati"

scalaVersion := "2.12.2"

crossScalaVersions := Seq("2.11.8", "2.12.0")

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {

  val akkaV       = "10.0.+"

	Seq (
		"com.typesafe.akka" %% "akka-http" % akkaV % "provided"
	)
}

homepage := Some(url("https://github.com/pragmatico/swagger-ui-akka-http"))

licenses := Seq("The Apache Software License, Version 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt"))


releasePublishArtifactsAction := PgpKeys.publishSigned.value

releaseProcess := Seq[ReleaseStep](
	checkSnapshotDependencies,
	inquireVersions,
	runClean,
	runTest,
	setReleaseVersion,
	commitReleaseVersion,
	tagRelease,
	releaseStepCommandAndRemaining("publishSigned"),
	setNextVersion,
	commitNextVersion,
	releaseStepCommand("sonatypeReleaseAll"),
	pushChanges
)


sonatypeProfileName := "co.pragmati"


pomIncludeRepository := { _ => false }

scmInfo := Some(
	ScmInfo(
		url("https://github.com/pragmatico/swagger-ui-akka-http.git"),
		"scm:git:git@github.com:pragmatico/swagger-ui-akka-http.git"
	)
)


developers := List(
	Developer(
		id    = "jmbataller",
		name  = "Jose Miguel Bataller",
		email = "jose@pragmati.co",
		url   = url("http://github.com/jmbataller")
	)
)


publishMavenStyle := true


publishTo := {
	val nexus = "https://oss.sonatype.org/"
	if (isSnapshot.value)
		Some("snapshots" at nexus + "content/repositories/snapshots")
	else
		Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}


publishArtifact in Test := false

