package controllers

import javax.inject._
import play.api.mvc._
import services.ResultService

class HomeController @Inject()(
  cc: ControllerComponents,
  productService: ResultService
)
  extends AbstractController(cc) {

  // should launch product service and return assignment results
  def result: Action[AnyContent] = Action {
    Ok("here are the assignment results")
  }

}
