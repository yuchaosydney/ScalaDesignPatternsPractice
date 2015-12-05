package com.patterns.behavioral

/**
  * Created by wuyuchao on 3/12/2015.
  */

trait Command {
  def excute
}

//the invoker class
class Switch {
  private var history: List[Command] = Nil

  def storeAndExcute(cmd: Command): Unit = {
    cmd.excute
    this.history :+= cmd
  }
}

//The Receiver class
class Light {
  def turnOn() = println("The light is on")
  def turnOff() = println("The light is off")
}

/* The Command for turning on the light - ConcreteCommand #1 */
class FlipUpCommand(theLight: Light) extends Command {
  def excute() = theLight.turnOn()
}

/* The Command for turning off the light - ConcreteCommand #2 */
class FilpDownCommand(theLight: Light) extends Command {
  def excute() = theLight.turnOff()
}


object CommandPattern {

  def main(args: Array[String]): Unit = {
    val lamp = new Light
    val switchUp = new FlipUpCommand(lamp)
    val switchDown = new FilpDownCommand(lamp)

    val s = new Switch()

    var testing = "ON"
    try {
      testing.toUpperCase match {
        case "ON" => s.storeAndExcute(switchUp)
        case "OFF" => s.storeAndExcute(switchDown)
        case _ => println("Argument \"ON\" or \"OFF\" is required.")
      }
    }catch {
      case e:Exception => println("Argument Required")
    }
  }
}