package services

import model.{Apple, Banana, Orange}
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

  it should "return half the total cost of apples as discount" in {
    val apple = Apple()

    serviceToTest.calculateDiscounts(
      List(apple,Apple())
    ).equals(apple.price) shouldBe true

    serviceToTest.calculateDiscounts(
      List(apple,Apple(),Apple(),Apple())
    ).equals(apple.price * 2) shouldBe true

    serviceToTest.calculateDiscounts(
      List(
        apple,Apple(),Apple(),Apple(),
        Apple(),Apple(),Apple(),Apple()
      )
    ).equals(apple.price * 4) shouldBe true
  }

  it should "return no discount for 2 oranges" in {
    val orange = Orange()
    serviceToTest.calculateDiscounts(
      List(orange)
    ).equals(BigDecimal(0)) shouldBe true
  }

  it should "return cost of one orange per every three in the list" in {
    val orange = Orange()
    serviceToTest.calculateDiscounts(
      List(
        orange,Orange(),Orange()
      )
    ).equals(orange.price) shouldBe true

    serviceToTest.calculateDiscounts(
      List(
        orange,Orange(),Orange(),
        Orange(),Orange(),Orange()
      )
    ).equals(orange.price * 2) shouldBe true

    serviceToTest.calculateDiscounts(
      List(
        orange,Orange(),Orange(),
        Orange(),Orange(),Orange(),
        Orange(),Orange(),Orange()
      )
    ).equals(orange.price * 3) shouldBe true
  }

  it should "return apples' and oranges' discounts combined" in {
    val apple = Apple()
    val orange = Orange()

    serviceToTest.calculateDiscounts(
      List(
        apple,Apple(),
        orange,Orange(),Orange()
      )
    ).equals(apple.price + orange.price) shouldBe true
  }

  it should "discount the cheapest product first when bananas and apples are in the cart" in {
    val apple = Apple()
    val banana = Banana()

    serviceToTest.calculateDiscounts(
      List(
        banana,
        apple
      )
    ).equals(banana.price) shouldBe true

    serviceToTest.calculateDiscounts(
      List(
        banana, Banana(),
        apple, Apple()
      )
    ).equals(banana.price * 2) shouldBe true

    serviceToTest.calculateDiscounts(
      List(
        banana, Banana(),
        apple, Apple(), Apple(), Apple()
      )
    ).equals( (banana.price * 2) + apple.price ) shouldBe true

    serviceToTest.calculateDiscounts(
      List(
        banana, Banana(), Banana(), Banana(),
        apple, Apple()
      )
    ).equals(banana.price * 3 ) shouldBe true
  }
}
