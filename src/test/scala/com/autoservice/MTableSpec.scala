package com.com.autoservice

import java.util



import carPart.{WheelTire, Engine, BodyPart}
import com.autoservice.storage.{AuctionAutoStatements, AvailableAutoStatements}
import com.autoservice.storage.mapping.{AvailableAutoKey, AvailableAutoEntity}
import com.twitter.finatra
import com.twitter.finatra.{UnsupportedMediaType, Controller, FinatraServer}
import org.scalatest.FunSpec

import scala.collection.JavaConverters._

class MTableSpec extends FunSpec {

  val logo: String = "'http://pngimg.com/upload/car_logo_PNG1640.png'"
  val carBrand: String = "Honda"
  val modelsAuction = Map("amount" -> "2" , "list" -> "CX 500 C,CR-V")

  var modelsCatalog= Map("amount" -> "2" , "list" -> "CX 500 C,CR-V")

  val availableAutos= AvailableAutoStatements.getInstance()
  val auctionAutos = AuctionAutoStatements.getInstance()

  describe("AllAutos.AvailableAuto Service") {

    it("Auction auto ") {

     val auto = new AvailableAutoEntity()
      auto.setLogo(logo)
      auto.setModelsAuction(modelsAuction.asJava)
      val key = new AvailableAutoKey(carBrand)
      auto.setKey(key)
      availableAutos.insertAutoAuction(auto)

     // val result = availableAutos.readAll()
    //   availableAutos.readAllAuction()
    //  println("Autos extracted: " + result);


     // assert(result.size() > 0, "Inserted data needs to be presented by select")

    }


  }

  describe(" All Auction Autos  Service") {

    it("Auction auto ") {

       // val result = availableAutos.readAll()
       val result  = auctionAutos.readAll()
        println("Autos extracted: " + result);


      // assert(result.size() > 0, "Inserted data needs to be presented by select")

    }


  }
  //availableAutos.close()

}