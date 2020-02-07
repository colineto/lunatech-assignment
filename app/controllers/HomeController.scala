package controllers

import javax.inject._
import play.api.libs.json.Json
import play.api.mvc._
import services.ResultService

import scala.concurrent.ExecutionContext


class HomeController @Inject()(
  cc: ControllerComponents,
  resultService: ResultService
)(implicit context: ExecutionContext) extends AbstractController(cc) {

  def products(assembled: Boolean, limit: Option[Int]): Action[AnyContent] = Action.async { request =>
    val sort = request.getQueryString("sort")
    val order = request.getQueryString("order")
    for {
      products <- resultService.getProducts(sort, order, assembled, limit)
    } yield Ok(Json.toJson(products))
  }
}
