package controllers

import play.api._
import play.api.mvc._
import play.api.Play.current
import play.api.db.slick._
import play.api.db.slick.Config.driver.simple._


object Brands extends Controller {
  def list = DBAction { implicit rs =>

    val brands = Query(models.Brands).list

    /*
    import java.util.UUID
    import models.Brand
    val brands = List(Brand(UUID.randomUUID(), "Brand 1"))
    */

    Ok(views.html.brands.list(brands))
  }

}
