import sbt.Keys._
import sbt._

name := "PerformanceUcu2016"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.1.5" % "test",
  "io.gatling"            % "gatling-test-framework"    % "2.1.5" % "test",
  "org.slf4j" % "slf4j-api" % "1.7.21",
  "ch.qos.logback" % "logback-classic" % "1.1.7")

enablePlugins(GatlingPlugin)