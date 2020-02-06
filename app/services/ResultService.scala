package services

import java.nio.charset.StandardCharsets
import java.util.Base64

import javax.inject._
import models.Product
import play.api.Configuration
import play.api.libs.json.{Json, Reads}
import play.api.libs.ws.WSClient

import scala.concurrent.{ExecutionContext, Future}


@Singleton
class ResultService @Inject()(
  val conf: Configuration,
  val ws: WSClient
)(implicit context: ExecutionContext){

  private val apiUrl = conf.get[String]("url.api")
  private val key = conf.get[String]("token.key")
  private val token = conf.get[String]("token.value")
  private val headers = {
    key -> token
  }

  def getProducts: Future[Seq[Product]] = {
    ws.url(s"$apiUrl/products")
    .withHttpHeaders(headers)
    .get()
    .map {response =>
      response.json.as[Seq[Product]]
    }
  }

  def filterMostExpensive(num: Int, products: Seq[Product]): Seq[Product] =
    products.sortBy(_.price).takeRight(num)

  def assembledProducts(products: Seq[Product]): Seq[Product] =
    products.filter(_.assembled).sortBy(_.name).distinct

}
