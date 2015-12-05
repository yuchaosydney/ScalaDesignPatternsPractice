package com.patterns

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

object ScalaApp {


  def main(args: Array[String]): Unit = {


  }
}