package services

import model.{Apple, Orange}
import org.scalatest.{FlatSpec, Matchers}

class PromotionsServiceSpec extends FlatSpec with Matchers {
  val serviceToTest = new PromotionsService {}

  "calculateDiscounts" should "return 0 when the list is empty" in {
    serviceToTest.calculateDiscounts(List.empty)
      .equals(BigDecimal(0)) shouldBe true
  }

  it should "return no discount (0) for one apple" in {
    serviceToTest.calculateDiscounts(List(Apple()))
      .equals(BigDecimal(0)) shouldBe true
  }

  it should "return no discount for 2 oranges" in {
    val orange = Orange()
    serviceToTest.calculateDiscounts(
      List(orange)
    ).equals(BigDecimal(0)) shouldBe true
  }
}
