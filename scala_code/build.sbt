name := "scala_code"

scalaVersion := "2.11.0"

resolvers ++= Seq(
  "Sonatype Releases" at "http://oss.sonatype.org/content/repositories/releases"
)

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.11" % "2.2.1" % "test",
  "org.scalacheck" %% "scalacheck" % "1.11.6" % "test"
)
