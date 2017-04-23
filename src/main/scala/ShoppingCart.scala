import model.{Apple, Orange}
import services.{CheckoutService, PromotionsService}


object ShoppingCart extends CheckoutService with PromotionsService {
  def main(args: Array[String]): Unit = {
    val scannedItems = List(
      Apple(),
      Apple(),
      Orange(),
      Apple()
    )
    val itemsToPrint = scannedItems.foldLeft("")( (r,c) => s"$r ${c.name}")
    val price = calculatePrice(scannedItems)
    val discounts = calculateDiscounts(scannedItems)
    val total = price - discounts
    println(s"[$itemsToPrint ] => $total")
  }
}
