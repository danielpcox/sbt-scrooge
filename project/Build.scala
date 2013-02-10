import sbt._
import Keys._
//import com.twitter.sbt._

object SbtScroogePlugin extends Build {
  lazy val root = Project(
    id = "sbt12-scrooge",
    base = file("."),
    settings = /*StandardProject.newSettings ++
      SubversionPublisher.newSettings ++
      ScriptedPlugin.scriptedSettings*/
        Defaults.defaultSettings
  ).settings(
    name := "sbt12-scrooge",
    organization := "com.twitter",
    version := "3.0.1-local",
    sbtPlugin := true

    //SubversionPublisher.subversionRepository := Some("https://svn.twitter.biz/maven-public")
  )
}
