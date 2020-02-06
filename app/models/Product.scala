package models

import play.api.libs.json.{Json, Reads, Writes}

case class Product (
  id: Int,
  ean: String,
  name: String,
  description: Option[String],
  price: Option[Double],
  assembled: Boolean,
  weight: Option[Double],
  dimension: Option[Dimension],
)

object Product {
  implicit val read: Reads[Product] = Json.reads[Product]
  implicit val write: Writes[Product] = Json.writes[Product]
  implicit val listRead: Reads[Seq[Product]] = Reads.seq[Product]
  implicit val listWrite: Writes[Seq[Product]] = Writes.seq[Product]
}
