package services

import model.{Apple, Banana, Item, Orange}


trait PromotionsService {
  val apple = Apple()
  val banana = Banana()
  val orange = Orange()

  def calculateDiscounts(basket:List[Item]) : BigDecimal= {

    val bananas = basket.filter(_.isInstanceOf[Banana])
    val apples = basket.filter(_.isInstanceOf[Apple])

    val mixedCollection = bananas.zip(apples)

    val cheapestProductDiscount = mixedCollection.foldLeft(BigDecimal(0)){ (r, _) =>
      r + banana.price
    }

    val remainingBananasDiscount = ((bananas.size - mixedCollection.size) / 2) * banana.price

    val remainingApplesDiscount = ((apples.size - mixedCollection.size) / 2) * apple.price

    val appleOrBananaDiscount = cheapestProductDiscount + remainingBananasDiscount + remainingApplesDiscount

    val orangeCount = basket.count {
      case Orange() => true
      case _ => false
    }

    val orangeDiscount = (orangeCount / 3) * orange.price

    appleOrBananaDiscount + orangeDiscount
  }
}
