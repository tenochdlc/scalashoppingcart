package services

import org.scalatest.{FlatSpec, Matchers}

class PromotionsServiceSpec extends FlatSpec with Matchers {
  val serviceToTest = new PromotionsService {}

  "calculateDiscounts" should "return 0 when the list is empty" in {
    serviceToTest.calculateDiscounts(List.empty)
      .equals(BigDecimal(0)) shouldBe true
  }
}
