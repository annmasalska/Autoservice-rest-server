import AllAutos.{AvailableAuto, ListAutos}
import Auction.{Bid, AuctionAuto, ListAuctionAutos}
import argonaut.Argonaut._
import argonaut._
import com.autoservice.storage.{AuctionAutoStatements, AvailableAutoStatements}
import com.twitter.finatra._

class AutoserviceServer extends Controller {

  implicit def AvailableAutoEncodeJson: EncodeJson[AvailableAuto] =
    EncodeJson((p: AvailableAuto) =>
      ("carBrand" := p.carBrand) ->:
        ("logo" := p.logo) ->:
        ("modelsAuction" := Json(
          ("amount" := p.modelsAuction.amount),
          ("list" := p.modelsAuction.list)

        )
          ) ->: jEmptyObject)

  implicit def AuctionAutoEncodeJson: EncodeJson[AuctionAuto] =
    EncodeJson((p: AuctionAuto) =>
      ("carBrand" := p.carBrand) ->:
        ("model" := p.model) ->:
        ("lot" := p.lot) ->:
        ("price" := p.price) ->:
        ("status" := p.status) ->:
        ("exactCloseDate" := p.status) ->:
        ("details" := p.details) ->:
        ("sorted" := p.sorted) ->:
        ("bids" := Json(
          ("id" := p.bids.id),
          ("author" := p.bids.author),
          ("creationTime" := p.bids.creationTime),
          ("price" := p.bids.price)
          )

     ) ->: jEmptyObject)

  val availableAutos = AvailableAutoStatements.getInstance()
  val auctionAutos = AuctionAutoStatements.getInstance()

  get("/api/auction-auto/all-models") { request =>

    val a: ListAutos = availableAutos.readAllAuction
    val json = a.autos.toList.asJson
    render.json(json.toString()).toFuture

  }

  get("/api/catalog-auto/all-models") { request =>

    val a: ListAutos = availableAutos.readAllCatalog()
    val json = a.autos.toList.asJson
    render.json(json.toString()).toFuture

  }
  get("/api/auction-auto/all-auto") { request =>


 //('Audi', 'A4','111A4','3100','available', '2015-09-03 07:01:00', '""{"img": "http://www.avtorinok.ru/news/pics/Audi_A4_pic_24667.jpg","modification":"","bodyType": "sedan","lot":"111A4","year":"2012","engineType": "petrol","volume": "3.3","mileage": "21000","transmission": "automatic"}""', {'id':'1231231','author':'ivanov','creationTime':'2015-05-01T12:22','price':'3800'},'alphabetically');

    //val bids = Bid("fvd","efdbd","bgbfd","dvfdcs")
   // val auctionAuto: AuctionAuto = AuctionAuto("Audi", "A4", "fgb", "dvfff", "dfvd", "2015-09-03 07:01:00", """{'"'img'"': "http:/24667.jpg","modification":"","bodyType": "sedan","lot":"111A4","year":"2012","engineType": "petrol","volume": "3.3","mileage": "21000","transmission": "automatic"}""", Nil, "efbgre")
    //println(auctionAuto.asJson.spaces2)
    val a: ListAuctionAutos = auctionAutos.readAll()
    println(a.autos.toList)
   // val json = a.autos.toList.asJson
    //println(json.spaces2)
  //  render.json(json.toString()).toFuture
    render.json("axazaz").toFuture
  }
  /* get("/api/auction-aюuto/all-autos.json") { request =>

     val begin: String = "["
     val end: String = "]"
     val availableAutos = AvailableAutoStatements.getInstance()
     val a: FieldsMaker = availableAutos.readAll
     val b = AvailableAuto(a.list(0), a.list(1), ModelsAuction(a.list(2), a.list(3)))
     val json = JsonUtil.toJson(b)
     println(json)
     render.json(json).toFuture


   }*/


  notFound { request =>
    render.status(404).plain("Not found").toFuture
  }

  class Unauthorized extends Exception

  get("/unauthorized") { request =>
    throw new Unauthorized
  }
  error { request =>
    request.error match {
      case Some(e: ArithmeticException) =>
        render.status(500).plain("whoops, divide by zero!").toFuture
      case Some(e: Unauthorized) =>
        render.status(401).plain("Not Authorized!").toFuture
      case Some(e: UnsupportedMediaType) =>
        render.status(415).plain("Unsupported Media Type!").toFuture
      case _ =>
        render.status(500).plain("Something went wrong!").toFuture
    }
  }


}


object App extends FinatraServer {
  register(new AutoserviceServer())
}
