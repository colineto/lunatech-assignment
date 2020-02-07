package models

case class Solution(
  descriptionFilter: Option[String],
  productsNumber: Option[Int],
  trucksNumber: Option[Int],
  trucks: Option[Seq[Truck]]
)
