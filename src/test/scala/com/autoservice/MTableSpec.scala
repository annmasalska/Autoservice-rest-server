package com.com.autoservice

import com.autoservice.storage.mapping.{AvailableAutoEntity, AvailableAutoKey}
import com.autoservice.storage.{AuctionAutoStatements, AvailableAutoStatements}
import org.scalatest.FunSpec

import scala.collection.JavaConverters._

class MTableSpec extends FunSpec {

  val logo: String = "'http://pngimg.com/upload/car_logo_PNG1640.png'"
  val carBrand: String = "Honda"
  val modelsAuction = Map("amount" -> "2", "list" -> "CX 500 C,CR-V")

  var modelsCatalog = Map("amount" -> "2", "list" -> "CX 500 C,CR-V")

  val availableAutos = AvailableAutoStatements.getInstance()
  val auctionAutos = AuctionAutoStatements.getInstance()

  describe("AllAutos.AvailableAuto Service") {

    it("Auction auto ") {

      val auto = new AvailableAutoEntity()
      auto.setLogo(logo)
      auto.setModelsAuction(modelsAuction.asJava)
      val key = new AvailableAutoKey(carBrand)
      auto.setKey(key)
      val result = availableAutos.insertAutoAuction(auto)
      availableAutos.readByCarBrand("audi")
      println("Autos extracted: " + result);

    }
  }

  describe(" All Auction Autos  Service") {

    it("Auction auto ") {

      val result = auctionAutos.readAll()
      println("Autos extracted: " + result);

    }
  }
}