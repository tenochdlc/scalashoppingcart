package services

import model.{Apple, Item, Orange}


trait PromotionsService {
  val apple = Apple()
  val orange = Orange()

  def calculateDiscounts(basket:List[Item]) : BigDecimal= {
    val appleCount = basket.count {
      case Apple() => true
      case _ => false
    }
    val orangeCount = basket.count {
      case Orange() => true
      case _ => false
    }

    val appleDiscount = (appleCount / 2) * apple.price
    val orangeDiscount = (orangeCount / 3) * orange.price

    appleDiscount + orangeDiscount
  }
}
