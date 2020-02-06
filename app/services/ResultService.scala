package services

import play.api.Logger
import javax.inject._
import models.Products
import play.api.Configuration
import play.api.libs.json.{JsError, JsResult, JsSuccess, JsValue, Json}
import play.api.libs.ws.{WSClient, WSRequest, WSResponse}

import scala.concurrent.{ExecutionContext, Future}
import scala.util.parsing.input.Reader


@Singleton
class ResultService @Inject()(
  val conf: Configuration,
  val ws: WSClient
)(implicit context: ExecutionContext){

  private val apiUrl: String = conf.get[String]("url.api")
  private val headers = {
    conf.get[String]("token.key") -> conf.get[String]("token.value")
  }

  // get products list
  def getProducts: Future[JsResult[Products]] = {
    implicit val parse = Json.reads[Products]
    ws.url(s"$apiUrl/products")
    .withHttpHeaders(headers)
    .get()
    .map {response =>
      response.json.validate[Products]
    }
  }

  // then compute to answer assignment

}
