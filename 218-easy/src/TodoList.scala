/**
 * @author Chris Campo
 */
class TodoList {
  var items = Set[String]()
  def addItem(item: String): Unit = items += item
  def deleteItem(item: String): Unit = items -= item
  def viewItems(): Unit = items foreach println
}
