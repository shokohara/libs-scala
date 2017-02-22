name := "libs-scala"

organization := "com.github.shokohara"

scalaOrganization := "org.typelevel"

scalaVersion := "2.11.8"

version := "1.0.0"

resolvers += "bintray/non" at "http://dl.bintray.com/non/maven" // https://github.com/non/junkion

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-compiler" % scalaVersion.value % Provided,
  "org.scala-lang" % "scala-reflect" % scalaVersion.value % Provided, // https://github.com/non/imp
  "org.spire-math" %% "imp" % "0.3.0" % "provided",
  //  "org.spire-math" %% "spire" % "0.13.0",
  "org.spire-math" %% "debox" % "0.7.3",
  "org.spire-math" %% "chain" % "0.1.0",
  //  "org.scalaz" %% "scalaz-core" % "7.2.8",
  "org.scalaz" %% "scalaz-iteratee" % "7.2.8",
  "org.scalaz" %% "scalaz-effect" % "7.2.8",
  "org.scalaz" %% "scalaz-concurrent" % "7.2.8",
  "org.typelevel" %% "discipline" % "0.7.3",
  "org.typelevel" %% "algebra" % "0.7.0",
  "org.typelevel" %% "algebra-laws" % "0.7.0",
  "org.typelevel" %% "squants" % "1.2.0",
  "org.typelevel" %% "shapeless-scalacheck" % "0.6",
  "org.typelevel" %% "shapeless-spire" % "0.6",
  "org.typelevel" %% "shapeless-scalaz" % "0.4",
  "org.typelevel" %% "cats" % "0.9.0",
  "org.typelevel" %% "alleycats-core" % "0.1.9",
  "us.mocul" %% "junkion" % "0.0.3",
  "io.circe" %% "circe-core" % "0.7.0",
  "io.circe" %% "circe-generic" % "0.7.0",
  "io.circe" %% "circe-parser" % "0.7.0",
  "eu.timepit" %% "refined" % "0.7.0",
  "eu.timepit" %% "refined-pureconfig" % "0.7.0", // optional, JVM-only
  "eu.timepit" %% "refined-scalacheck" % "0.7.0", // optional
  "eu.timepit" %% "refined-scalaz" % "0.7.0", // optional
  "eu.timepit" %% "refined-scodec" % "0.7.0", // optional
  //  "com.chuusai" %% "shapeless" % "2.3.2",
  "com.twitter" %% "algebird-core" % "0.13.0",
  "com.twitter" %% "algebird-util" % "0.13.0",
  "com.twitter" %% "algebird-bijection" % "0.13.0",
  "com.twitter" %% "util-collection" % "6.41.0",
  "com.github.scalaprops" %% "scalaprops" % "0.4.1" % "test",
  "com.github.scalaprops" %% "scalaprops-scalazlaws" % "0.4.1" % "test",
  "org.typelevel" %% "scalaz-scalatest" % "1.1.2" % "test"
  //  "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)

// If you’re using circe’s generic derivation with Scala 2.10, or @JsonCodec the macro annotation (with any Scala version), you’ll also need to include the Macro Paradise compiler plugin in your build:
//addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0")

testFrameworks += new TestFramework("scalaprops.ScalapropsFramework")

parallelExecution in Test := false

dependencyUpdatesExclusions := moduleFilter(organization = "org.scala-lang")

addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.3")
