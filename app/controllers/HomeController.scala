package controllers

import javax.inject._
import models.Products
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
    } yield Ok(s"$products")
  }

  def mostExpensive(limit: Int): Action[AnyContent] = Action.async {
    for {
      products <- resultService.getProducts
    } yield {
      val mostExpensiveProducts = resultService.filterMostExpensive(limit, products)
      Ok(s"$mostExpensiveProducts")
    }
  }

  def alreadyAssembled: Action[AnyContent] = Action.async {
    for {
      products <- resultService.getProducts
    } yield {
      val alreadyAssembledProducts = resultService.assembledProducts(products)
      Ok(s"$alreadyAssembledProducts")
    }
  }
}
