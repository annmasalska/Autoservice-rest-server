name := "Auto-service"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.10.4"

libraryDependencies ++= Seq(
  "com.twitter" %% "finatra" % "2.0.0",
  "org.json4s" %% "json4s-jackson" % "3.2.10",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.2.2",
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.2.2",
  "com.netflix.astyanax" % "astyanax"         % "1.56.48",
  "com.netflix.astyanax" % "astyanax-core"    % "1.56.48",
  "com.netflix.astyanax" % "astyanax-thrift"  % "1.56.48",
  "com.netflix.astyanax" % "astyanax-cassandra" % "1.56.48",
  "io.argonaut" %% "argonaut" % "6.0.4",
  "com.typesafe.play" %% "play-json" % "2.2.1"
)

resolvers +=
  "Twitter" at "http://maven.twttr.com"

resolvers += "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"
