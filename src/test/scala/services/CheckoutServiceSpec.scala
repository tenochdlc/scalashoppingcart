package services


class CheckoutServiceSpec  extends FlatSpec with Matchers {
  val serviceToTest = new CheckoutService {}

  "calculatePrice" should "return 0 when there are no items" in {
    val total = serviceToTest.calculatePrice(List.empty)
    total.equals(BigDecimal(0)) shouldBe true
  }
}
