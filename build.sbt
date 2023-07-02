ThisBuild / scalaVersion := "3.2.2"

Global / excludeLintKeys += Keys.parallelExecution

lazy val scalacOptions = Seq("-Xmax-inlines", "50")

// ----- VARIABLES ----- //

val organizationName = "com.clairvoyant"
val releaseVersion = "1.0.0"

val scalaTestVersion = "3.2.15"
val scalaXmlVersion = "2.1.0"
val scalaParserCombinatorsVersion = "2.2.0"

// ----- TOOL DEPENDENCIES ----- //

val scalaTestDependencies = Seq("org.scalatest" %% "scalatest" % scalaTestVersion)

val scalaXmlDependencies = Seq("org.scala-lang.modules" %% "scala-xml" % scalaXmlVersion)

val scalaParserCombinatorsDependencies = Seq(
  "org.scala-lang.modules" %% "scala-parser-combinators" % scalaParserCombinatorsVersion
)

// ----- MODULE DEPENDENCIES ----- //

val dependencies =
  scalaTestDependencies.map(_ % Test) ++
    scalaXmlDependencies ++
    scalaParserCombinatorsDependencies

// ----- SETTINGS ----- //

val commonSettings = Seq(
  organization := organizationName,
  version := releaseVersion,
  Keys.scalacOptions ++= scalacOptions
)

// ----- PROJECTS ----- //

lazy val `<repo_name>` = project
  .configs(IntegrationTest)
  .settings(commonSettings)

// ----- PUBLISH TO GITHUB PACKAGES ----- //

ThisBuild / publishTo := Some("Github Repo" at "https://maven.pkg.github.com/teamclairvoyant/<repo_name>/")

ThisBuild / credentials += Credentials(
  "GitHub Package Registry",
  "maven.pkg.github.com",
  "teamclairvoyant",
  System.getenv("GITHUB_TOKEN")
)
