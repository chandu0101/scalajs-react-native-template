enablePlugins(ScalaJSPlugin)

name := "ScalaJS React Native Template"

scalaVersion := "2.11.7"

val scalajsReactNativeVersion = "0.0.2-SNAPSHOT"

libraryDependencies ++= Seq("com.github.chandu0101.scalajs-react-native" %%% "core" % scalajsReactNativeVersion,
  "com.github.chandu0101.scalajs-react-native" %%% "styles" % scalajsReactNativeVersion)

// Mechanisms to generate react  native file

val fullOptIOS = Def.taskKey[File]("Generate the file given to react native")

artifactPath in Compile in fullOptIOS :=
  baseDirectory.value / "index.ios.js"

fullOptIOS in Compile := {
  val outFile = (artifactPath in Compile in fullOptIOS).value

  IO.copyFile((fullOptJS in Compile).value.data, outFile)

  val launcher = (scalaJSLauncher in Compile).value.data.content
  IO.append(outFile, launcher)

  outFile
}
