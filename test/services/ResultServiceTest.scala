package services

import org.scalatest._
import models.Product
import org.scalatestplus.mockito.MockitoSugar
import play.api.Configuration
import play.api.libs.ws.WSClient

import scala.concurrent.ExecutionContext.Implicits.global

class ResultServiceTest extends WordSpec with MockitoSugar{
  val conf: Configuration = mock[Configuration]
  val ws: WSClient = mock[WSClient]
  val resultService = new ResultService(conf, ws)

  val products = Seq(
    Product(1, "123", "alka", None, Some(13.2), assembled = false, None, None),
    Product(2, "123", "balka", None, Some(15.74), assembled = true, None, None),
    Product(3, "123", "velco", None, Some(18.9), assembled = false, None, None),
    Product(4, "123", "milka", None, Some(21.45), assembled = false, None, None),
  )

  "filterProductsBy" should {
    "return only assembled products if assembled true" in {
      resultService.filterProductsBy(products, None, None, assembled = true, None) equals
        Seq(products(1))
    }

    "return most expensive products if sort equals price and order equals desc" in {
      resultService.filterProductsBy(products, Some("price"), Some("desc"), assembled = false, None) equals
        products.reverse
    }

    "return products in alphabetical order if sort equals name" in {
      resultService.filterProductsBy(products, Some("name"), None, assembled = false, None) equals
        Seq(products.head, products(1), products(3), products(2))
    }
  }
}
