package models

import play.api.libs.json.Json

case class Dimension(
  width: Int,
  depth: Int,
  height: Int,
)

object Dimension {
  implicit val parse = Json.reads[Dimension]
}
