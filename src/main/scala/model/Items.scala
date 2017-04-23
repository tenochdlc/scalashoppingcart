package model

sealed trait Item {
  def price: BigDecimal
}

case class Apple() extends Item {
  val price = BigDecimal("0.60")
}

case class Orange() extends Item {
  val price = BigDecimal("0.25")
}
