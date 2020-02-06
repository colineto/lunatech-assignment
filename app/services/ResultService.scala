package services

import javax.inject._
import models.Products
import play.api.Configuration
import play.api.libs.json.Json
import play.api.libs.ws.WSClient

import scala.concurrent.{ExecutionContext, Future}


@Singleton
class ResultService @Inject()(
  val conf: Configuration,
  val ws: WSClient
)(implicit context: ExecutionContext){

  private val apiUrl: String = conf.get[String]("url.api")
  private val headers = {
    conf.get[String]("token.key") -> conf.get[String]("token.value")
  }

  def getProducts: Future[Products] = {
    implicit val parse = Json.reads[Products]
    ws.url(s"$apiUrl/products")
    .withHttpHeaders(headers)
    .get()
    .map {response =>
      response.json.as[Products]
    }
  }

  def filterMostExpensive(num: Int, products: Products): Seq[Product] =
    products.products.sortBy(_.price).takeRight(num)

  def assembledProducts(products: Products): Seq[Product] =
    products.products.filter(_.assembled).sortBy(_.name).distinct

}
