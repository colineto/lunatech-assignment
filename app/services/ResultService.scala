package services

import play.api.Logger
import javax.inject._
import play.api.Configuration
import play.api.libs.ws.WSClient
import scala.concurrent.Future


@Singleton
class ResultService @Inject()(
  val conf: Configuration,
  val wsClient: WSClient,
){

  private val logger: Logger = Logger(this.getClass)
  private val productApiUrl: String = conf.get[String]("apiUrl")

  logger.info(s"Requirement to do.")

  // get products list or less
  def getOpt :Future[Option[Product]] = ???

  // then compute to answer assignment

}
