package services

import javax.inject._
import models.Product
import play.api.Configuration
import play.api.http.HttpErrorHandler
import play.api.libs.json.{JsError, JsSuccess, Json}
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

  def getProducts(sort: Option[String], order: Option[String], assembled: Boolean, limit: Option[Int]): Future[Seq[Product]] = {
    val productsPromise = ws.url(s"$apiUrl/products")
      .withHttpHeaders(headers)
      .get()
      .map {response =>
        response.status match {
          case 200 => response.json.validate[Seq[Product]] match {
            case JsSuccess(value, _) => Right(value)
            case JsError(e) => Left(Json.obj({"error" -> s"response validation: $e"}))
          }
          case _ => Left(Json.obj({"error" -> "response status"}))
        }
      }

    productsPromise.map {
      case Right(products) => filterProductsBy(products, sort, order, assembled, limit)
    }
  }

  // TODO: When more filters find a better way to filter maybe via case class filters
  def filterProductsBy(products: Seq[Product], sort: Option[String], order: Option[String], assembled: Boolean, limit: Option[Int]): Seq[Product] = {
    val sortBy = sort.getOrElse("price")
    val ordering = order.getOrElse("asc")

    val filteredProducts = if(assembled) products.filter(_.assembled) else products
    val sortedProducts = {
      // when alphabetical sort also drop duplicated names
      if(sortBy.equals("name")) filteredProducts.groupBy(_.name).map(_._2.head).toSeq.sortBy(_.name) // TODO: handle non european characters when alphabetically ordering
      else filteredProducts.sortBy(_.price)
    }
    val orderedProducts = if(ordering.equals("desc")) sortedProducts.reverse else sortedProducts
    limit match { case Some(l) => orderedProducts.take(l) case None => orderedProducts}
  }
}
