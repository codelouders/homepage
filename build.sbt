import com.typesafe.sbt.SbtGit.git

name := "codelouders-homepage"

version := "0.1"

scalaVersion := "2.12.7"

libraryDependencies ++= {
  val slf4jVersion = "1.7.25"
  val logbackVersion = "1.2.3"
  val akkaVersion = "2.5.17"
  val akkaHttpVersion = "10.1.5"
  val catsVersion = "1.4.0"
  Seq(
    "org.slf4j" % "slf4j-api" % slf4jVersion,
    "org.slf4j" % "log4j-over-slf4j" % slf4jVersion,
    "ch.qos.logback" % "logback-classic" % logbackVersion % "runtime",
    "ch.qos.logback" % "logback-core" % logbackVersion % "runtime",
    "net.logstash.logback" % "logstash-logback-encoder" % "4.6",
    "org.codehaus.janino" % "janino" % "2.7.8",
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-stream" % akkaVersion,
    "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
    "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
    "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0",
    "org.typelevel" %% "cats-core" % catsVersion,
    // Test dependencies
    "com.typesafe.akka" %% "akka-stream-testkit" % akkaVersion % "test",
    "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % "test",
    "org.scalatest" %% "scalatest" % "3.0.1" % "test"
  )
}

mainClass in (Compile, run) := Some("com.codelouders.website.Main")

assemblyJarName in assembly := s"${name.value}-${git.gitHeadCommit.value.get.take(7)}.jar"
