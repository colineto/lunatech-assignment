package controllers

import javax.inject._
import play.api.mvc._
import services.ResultService
import scala.concurrent.ExecutionContext


class HomeController @Inject()(
  cc: ControllerComponents,
  resultService: ResultService
)(implicit context: ExecutionContext) extends AbstractController(cc) {

  def result: Action[AnyContent] = Action.async {
    for {
      products <- resultService.getProducts
    } yield {
      val mostExpensiveProducts = resultService.filterMostExpensive(15, products)
      Ok(s"$mostExpensiveProducts")
    }
  }
}
