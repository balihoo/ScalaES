package controllers

import play.api._
import play.api.mvc._
import play.api.Play.current
import play.api.db.slick._
import play.api.db.slick.Config.driver.simple._
import play.api.data._
import play.api.data.Forms._
import models.Brand
import java.util.UUID
import play.api.data.validation._
import play.api.db.slick.Session

object Brands extends Controller {
  def list = DBAction { implicit rs =>

    val brands = Query(models.Brands).list

    Ok(views.html.brands.list(brands))
  }


  def brandForm(implicit s: Session) = Form(
    mapping(
      "id" -> ignored(UUID.randomUUID()),
      "key" -> nonEmptyText(minLength = 3, maxLength = 10).verifying(
          Constraints.pattern("[a-zA-Z0-9]+".r, "constraint.brandkeyformat", "Only mixed case alphanumeric characters allowed"),
          Constraint[String]("constraint.brandkeyunique") {
            key =>
              if (Query(models.Brands.filter(_.key === key).length).first > 0) {
                Invalid(Seq(ValidationError("There is already a brand with the specified key.")))
              } else {
                Valid
              }
          }
        )

    )(Brand.apply)(Brand.unapply)
  )

  def create = DBAction { implicit rs =>
    Ok(views.html.brands.create(brandForm))
  }

  def add = DBAction { implicit rs =>

    brandForm.bindFromRequest().fold(
      badForm => {
        BadRequest(views.html.brands.create(badForm))
      },
      newBrand => {
        models.Brands.insert(newBrand)
        Redirect(routes.Brands.list()).flashing("success-message" -> s"Create a new Brand with Key ${newBrand.key}")
      }
    )
  }

}
