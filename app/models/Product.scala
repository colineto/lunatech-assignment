package models

import play.api.libs.json.Json

case class Product (
  id: Int,
  ean: String,
  name: String,
  description: Option[String],
  price: Double,
  assembled: Boolean,
  weight: Option[Double],
  dimension: Option[Dimension],
)

case class Products (
  products: Seq[Product]
)

object Product {
  implicit val parse = Json.reads[Product]
}
