package services

import model.Item

trait CheckoutService {
  def calculatePrice(scannedProducts: List[Item]): BigDecimal = {
    scannedProducts.foldLeft(BigDecimal(0)){ (r,c) =>
      r + c.price
    }
  }
}
