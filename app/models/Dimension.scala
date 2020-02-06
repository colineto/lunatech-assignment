package models

import play.api.libs.json.{Json, Reads}

case class Dimension(
  width: Double,
  depth: Double,
  height: Double,
)

object Dimension {
  implicit val read: Reads[Dimension] = Json.reads[Dimension]
}
