/* This is the main SBT definition file
 * All *.sbt files in the project's base directory (and only the ones in the base directory) are considered build
 * definition files.
**/

name := "scala-dev"

version := "1.0"

scalaVersion := "2.12.6"

/* Use %% between groupId and artifactId to automatically select the correct artifact based on the configured
 * Scala version.
 */
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"
