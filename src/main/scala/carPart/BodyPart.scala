package carPart


case class BodyPart(id: String,
                    img: String,
                    brand: String,
                    model: String,
                    modification: String,
                    year: String,
                    title: String,
                    price: String,
                    status: String
                     )


case class TraitImpl(name: String) {
  def traitName = name
}

/*object TraitImpl {
  def apply = new TraitImpl("foo")
  def apply(name: String) = new TraitImpl(name)
}*/