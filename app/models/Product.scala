package models

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

object Product {
  ???
}
