package model

sealed trait Item {
  def name: String
  def price: BigDecimal
}

case class Apple() extends Item {
  val name = "Apple"
  val price = BigDecimal("0.60")
}
case class Orange() extends Item {
  val name = "Orange"
  val price = BigDecimal("0.25")
}

case class Banana() extends Item {
  val name = "Banana"
  val price = BigDecimal("0.20")
}
