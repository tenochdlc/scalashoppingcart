package services

import model.{Apple, Item, Orange}

trait PromotionsService {
  val apple = Apple()
  val orange = Orange()

  def calculateDiscounts(basket:List[Item]) : BigDecimal= {
    basket.isEmpty match {
      case true => BigDecimal(0)
    }
  }
}
