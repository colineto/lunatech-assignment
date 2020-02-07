package models

import play.api.libs.json.{Json, Reads, Writes}

case class Dimension(
  width: Double,
  depth: Double,
  height: Double,
)

object Dimension {
  implicit val read: Reads[Dimension] = Json.reads[Dimension]
  implicit val write: Writes[Dimension] = Json.writes[Dimension]
}
