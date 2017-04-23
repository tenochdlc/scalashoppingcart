
import model.{Apple, Orange}
import services.CheckoutService

object ShoppingCart extends CheckoutService {
  def main(args: Array[String]): Unit = {
    val scannedItems = List(
      Apple(),
      Apple(),
      Orange(),
      Apple()
    )
    val itemsToPrint = scannedItems.foldLeft("")( (r,c) => s"$r ${c.toString}")
    val total = calculatePrice(scannedItems)
    println(s"[$itemsToPrint ] => $total")
  }
}
