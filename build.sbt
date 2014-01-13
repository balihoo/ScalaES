name := "scalaES"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "com.typesafe.slick" %% "slick" % "1.0.1",
  "org.slf4j" % "slf4j-nop" % "1.6.4",
  "com.h2database" % "h2" % "1.3.166",
  "com.typesafe.play" %% "play-slick" % "0.5.0.8",
  "org.mockito" % "mockito-core" % "1.9.5",
  //WebJars
  "org.webjars" %% "webjars-play" % "2.2.0",
  "org.webjars" % "bootstrap" % "3.0.3",
  "org.webjars" % "jquery" % "2.0.3-1",
  "org.webjars" % "font-awesome" % "4.0.3"
)     

play.Project.playScalaSettings
