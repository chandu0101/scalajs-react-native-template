package chandu0101.scalajs.rn.template

import chandu0101.scalajs.rn._
import chandu0101.scalajs.rn.template.components.HelloNative

import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport

object NativeApp extends JSApp {
  @JSExport
  override def main(): Unit = {

    val ScalaJSReactNativeTemplate = ReactNativeComponentB[Unit]("ScalaJSReactNativeTemplate")
      .render((P) => {
         HelloNative()
      })
      .buildNative // If your component is going to be render by other third party component then use buildNative

    ReactNative.AppRegistry.registerComponent("ScalaJSReactNativeTemplate", () => ScalaJSReactNativeTemplate)

  }
}
