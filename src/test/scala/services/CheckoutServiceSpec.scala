package services

import model.{Apple, Orange}
import org.scalatest.{FlatSpec, Matchers}


class CheckoutServiceSpec extends FlatSpec with Matchers {

  val serviceToTest = new CheckoutService {}

  "calculatePrice" should "return 0 when there are no items" in {
    val total = serviceToTest.calculatePrice(List.empty)
    total.equals(BigDecimal(0)) shouldBe true
  }

  it should "return the total cost of the items in the list" in {
    val a1 = Apple()
    val a2 = Apple()
    val a3 = Apple()
    val o1 = Orange()
    val o2 = Orange()
    val o3 = Orange()
    val total = (a1.price * 3) + (o1.price * 3)

    serviceToTest.calculatePrice(List(a1,a2,a3, o1,o2,o3)).equals(total) shouldBe true
  }
}
