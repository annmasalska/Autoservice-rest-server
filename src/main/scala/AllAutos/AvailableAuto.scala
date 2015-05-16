package AllAutos

import scala.collection.mutable

case class ModelsAuction(
                          amount: String,
                          list: String)


case class AvailableAuto(carBrand: String,
                         logo: String,
                         modelsAuction: ModelsAuction)

class ListAutos() {
  var autos = mutable.ListBuffer[AvailableAuto]()

  def addAuto(auto: AvailableAuto) = {
    autos.+=:(auto)
  }
}

object ListAutos {
  def apply() = new ListAutos
}
