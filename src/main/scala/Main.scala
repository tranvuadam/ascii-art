package Main

import ArgumentHandler.{ArgumentController, ArgumentIterator}

object Main extends App {
  HelperText.print()
  val argumentIterator = new ArgumentIterator(args.iterator)
  val argumentExecutor = ArgumentController(argumentIterator)
  argumentExecutor.execute()
}