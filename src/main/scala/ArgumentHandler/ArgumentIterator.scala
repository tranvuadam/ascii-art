package ArgumentHandler

/**
 * ArgumentIterator notifies user if he inputted incorrect arguments(missing required argument)
 * */
class ArgumentIterator(arguments_iterator: Iterator[String]){
  require(arguments_iterator.nonEmpty)

  def getNextArgument: String = {
    if(!arguments_iterator.hasNext) {
      throw new IllegalArgumentException("Missing an argument.")
    }
    arguments_iterator.next()
  }
  def hasNextArgument: Boolean = {
    arguments_iterator.hasNext
  }
}
