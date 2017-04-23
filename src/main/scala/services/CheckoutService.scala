package services

trait CheckoutService {
  def calculatePrice(scannedProducts: List[Product]): BigDecimal = {
    scannedProducts.foldLeft(BigDecimal(0)){ (r,c) =>
      r + c
    }
  }
}
