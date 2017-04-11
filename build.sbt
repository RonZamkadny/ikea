name := "ikea"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies += "org.jsoup" % "jsoup" % "1.10.2"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.4.17"
libraryDependencies += "com.typesafe.akka" %% "akka-agent" % "2.4.17"
libraryDependencies += "com.typesafe.akka" %% "akka-camel" % "2.4.17"
libraryDependencies += "com.typesafe.akka" %% "akka-cluster" % "2.4.17"
libraryDependencies += "com.typesafe.akka" %% "akka-cluster-metrics" % "2.4.17"
libraryDependencies += "com.typesafe.akka" %% "akka-cluster-sharding" % "2.4.17"
libraryDependencies += "com.typesafe.akka" %% "akka-cluster-tools" % "2.4.17"
libraryDependencies += "com.typesafe.akka" %% "akka-contrib" % "2.4.17"
libraryDependencies += "com.typesafe.akka" %% "akka-multi-node-testkit" % "2.4.17"
libraryDependencies += "com.typesafe.akka" %% "akka-osgi" % "2.4.17"
libraryDependencies += "com.typesafe.akka" %% "akka-persistence" % "2.4.17"
libraryDependencies += "com.typesafe.akka" %% "akka-persistence-tck" % "2.4.17"
libraryDependencies += "com.typesafe.akka" %% "akka-remote" % "2.4.17"
libraryDependencies += "com.typesafe.akka" %% "akka-slf4j" % "2.4.17"
libraryDependencies += "com.typesafe.akka" %% "akka-stream" % "2.4.17"
libraryDependencies += "com.typesafe.akka" %% "akka-stream-testkit" % "2.4.17"
libraryDependencies += "com.typesafe.akka" %% "akka-testkit" % "2.4.17"
libraryDependencies += "com.typesafe.akka" %% "akka-distributed-data-experimental" % "2.4.17"
libraryDependencies += "com.typesafe.akka" %% "akka-typed-experimental" % "2.4.17"
libraryDependencies += "com.typesafe.akka" %% "akka-persistence-query-experimental" % "2.4.17"

libraryDependencies += "net.databinder.dispatch" %% "dispatch-core" % "0.11.2"
libraryDependencies ++= Seq(
  "net.databinder" %% "dispatch-http" % "0.8.10"
)

libraryDependencies += "commons-io" % "commons-io" % "2.5"
    