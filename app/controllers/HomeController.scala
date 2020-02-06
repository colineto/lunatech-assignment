package controllers

import javax.inject._
import play.api.mvc._
import services.ResultService
import scala.concurrent.ExecutionContext


class HomeController @Inject()(
  cc: ControllerComponents,
  resultService: ResultService
)(implicit context: ExecutionContext)
  extends AbstractController(cc) {

  // should launch product service and return assignment results
  def result: Action[AnyContent] = Action.async {
    resultService.getProducts.map { products =>
      Ok(s"$products")
    }
  }
}
