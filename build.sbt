enablePlugins(ScalaJSPlugin)

name := "ScalaJS React Native Template"

scalaVersion := "2.11.6"

val scalajsReactNativeVersion = "0.0.1"

libraryDependencies ++= Seq("com.github.chandu0101.scalajs-react-native" %%% "core" % scalajsReactNativeVersion,
  "com.github.chandu0101.scalajs-react-native" %%% "styles" % scalajsReactNativeVersion)

// Mechanisms to generate react  native file

val genReactFile = Def.taskKey[File]("Generate the file given to react native")

artifactPath in Compile in genReactFile :=
  baseDirectory.value / "index.ios.js"

genReactFile in Compile := {
  val outFile = (artifactPath in Compile in genReactFile).value

  IO.copyFile((fullOptJS in Compile).value.data, outFile)

  val launcher = (scalaJSLauncher in Compile).value.data.content
  IO.append(outFile, launcher)

  outFile
}
