package src.programming_in_scala.ch21

import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.JButton

/**
  * Uses an implicit conversion to shorten
  * the code from Swing1.
  */
object Swing2 {
  implicit def function2ActionListener(f: ActionEvent => Unit) =
    new ActionListener {
      def actionPerformed(event: ActionEvent) = f(event)
    }

  def main(args: Array[String]) {
    val button = new JButton
    // Now this works
    button.addActionListener(
      (_: ActionEvent) => println("pressed!")
    )
  }
}
