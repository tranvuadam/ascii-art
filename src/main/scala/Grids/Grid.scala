package Grids

trait Grid {
  def getValue(height: Int, width: Int): Any
  def getHeight: Int
  def getWidth: Int
  def getGrid: Any
}
