ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.10"

resolvers += "Typesafe Repository" at "https://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.8" % Test,
  "org.typelevel" %% "cats-effect" % "2.5.3",
  "com.typesafe.akka" %% "akka-actor" % "2.5.4",
  "com.typesafe.akka" %% "akka-testkit" % "2.5.4" % Test,
  "org.apache.httpcomponents" % "httpclient" % "4.5.3",
  "org.apache.commons" % "commons-lang3" % "3.6"
)

scalacOptions += "-deprecation"

lazy val root = (project in file("."))
  .settings(
    name := "FunctionalProgrammingSimplified"
  )
