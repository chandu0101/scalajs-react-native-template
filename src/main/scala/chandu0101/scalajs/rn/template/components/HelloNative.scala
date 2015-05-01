package chandu0101.scalajs.rn.template.components

import chandu0101.scalajs.rn._
import chandu0101.scalajs.rn.components._
import main.scala.chandu0101.scalajs.rn.styles.NativeStyleSheet

object HelloNative {

  val component = ReactNativeComponentB[Unit]("HelloNative")
    .render(P => {
    View(style = Styles.container)(
      Text(style = Styles.text)("Welcome to Scala-JS ReactNative"),
      Text(style = Styles.text)("To get started, edit HelloNative.scala ")
    )
  }).buildU


  object Styles extends NativeStyleSheet {

    val container = style(flex := 1,
      alignItems.center,
      justifyContent.center,
      backgroundColor := "#D1E4E8")
    val text = style(fontSize := 15, padding := 10)

  }

  def apply() = component()
}
