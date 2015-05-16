package Auction

import scala.collection.mutable


case class Bid( id: String,
               author: String,
               creationTime: String,
               price: String
                )


case class AuctionAuto(carBrand: String,
                       model: String,
                       lot: String,
                       price: String,
                       status: String,
                       exactCloseDate: String,
                       details: String,
                       bids: Bid,
                       sorted: String)


class ListAuctionAutos() {
  var autos = mutable.ListBuffer[AuctionAuto]()

  def addAuto(auto: AuctionAuto) = {
    autos.+=:(auto)
  }
}

object ListAuctionAutos {
  def apply() = new ListAuctionAutos
}