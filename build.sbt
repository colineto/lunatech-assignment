name := "lunatech"
 
version := "1.0" 
      
lazy val `lunatech` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
resolvers += "Akka Snapshot Repository" at "https://repo.akka.io/snapshots/"

scalaVersion := "2.12.2"

libraryDependencies ++= Seq( jdbc , ehcache , ws , specs2 % Test , guice )
libraryDependencies += "org.mockito" % "mockito-all" % "1.10.19" % "test"
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.3" % "test"
// libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.0" % "test"

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

      