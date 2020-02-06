package models

case class Shipment(
  productId: Option[Int],
  x: Option[Int],
  y: Option[Int],
  z: Option[Int],
)
