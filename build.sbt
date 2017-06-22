name := "scala_demo"
version := "0.1.0"
scalaVersion := "2.11.8"

resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"
libraryDependencies += "com.typesafe.akka" % "akka-actor_2.11" % "2.5-20170414-230843"
