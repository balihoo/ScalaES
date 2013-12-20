package models

import java.util.UUID
import play.api.db.slick.Config.driver.simple._

case class Brand(id:UUID, key: String)


object Brands extends Table[Brand]("BRAND") {
  def id = column[UUID]("ID", O.PrimaryKey) // This is the primary key column
  def key = column[String]("KEY")

  // Every table needs a * projection with the same type as the table's type parameter
  def * = id ~ key <> (Brand, Brand.unapply _)
}

/*  attempting to do cake stuff...but gave up
trait BrandSlice extends Profile { this: Profile =>
  import profile.simple._

  object brands extends Table[Brand]("BRAND") {
    def id = column[UUID]("ID", O.PrimaryKey) // This is the primary key column
    def key = column[String]("KEY")

    // Every table needs a * projection with the same type as the table's type parameter
    def * = id ~ key <> (Brand, Brand.unapply _)
  }
} */
