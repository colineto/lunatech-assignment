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

  def products: Action[AnyContent] = Action.async {
    for {
      products <- resultService.getProducts
    } yield Ok(Json.toJson(products))
  }

  def mostExpensive(limit: Int): Action[AnyContent] = Action.async {
    for {
      products <- resultService.getProducts
    } yield {
      val mostExpensiveProducts = resultService.filterMostExpensive(limit, products)
      Ok(Json.toJson(mostExpensiveProducts))
    }
  }

  def alreadyAssembled: Action[AnyContent] = Action.async {
    for {
      products <- resultService.getProducts
    } yield {
      val alreadyAssembledProducts = resultService.assembledProducts(products)
      Ok(Json.toJson(alreadyAssembledProducts))
    }
  }
}
