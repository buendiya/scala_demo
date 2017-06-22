package src.programming_in_scala.ch21

/**
  * Created by jingsz on 4/6/17.
  */
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.JButton

/**
  * Hooks up an action event listener with
  * a verbose inner class.
  */
object Swing1 {
  def main(args: Array[String]) {
    val button = new JButton

    button.addActionListener(
      new ActionListener {
        def actionPerformed(event: ActionEvent) = {
          println("pressed!")
        }
      }
    )

//    button.addActionListener( // Type mismatch!
//      (_: ActionEvent) => println("pressed!")
//    )

  }
}

