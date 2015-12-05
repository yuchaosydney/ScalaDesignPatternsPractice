import java.util
import java.util.logging.Level

/**
  * Created by wuyuchao on 6/12/2015.
  * Adapter design with implicit convention
  */

trait Log {
  def warning(message: String)
  def error(message: String)
}

final class Logger {
  def log(level: Level, message: String): Unit = {
    println("Leve:" + level + " Message:" + message)
  }
}

object adapter {
  implicit class LoggerToLogAdapter(logger: Logger) extends Log {
    def warning(message: String) { logger.log(Level.WARNING, message) }
    def error(message: String) { logger.log(Level.INFO,message) }
  }
}


object app {

  import adapter._

  def main(args: Array[String]):Unit = {
    val log: Log = new Logger()
    log.warning("testing")
  }
}
