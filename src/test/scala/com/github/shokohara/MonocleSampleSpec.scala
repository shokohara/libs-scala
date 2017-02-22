package com.github.shokohara

import monocle.Lens
import monocle.macros.GenLens
import org.scalatest._

class MonocleSampleSpec extends FlatSpec with Matchers {

  case class Street(number: Int, name: String)

  case class Address(city: String, street: Street)

  case class Company(name: String, address: Address)

  case class Employee(name: String, company: Company)

  val employee = Employee("john", Company("awesome inc", Address("london", Street(23, "high street"))))
  val luckyEmployee: Employee = employee.copy(
    company = employee.company.copy(
      address = employee.company.address.copy(
        street = employee.company.address.street.copy(
          name = employee.company.address.street.name.capitalize // luckily capitalize exists
        )
      )
    )
  )
  val company: Lens[Employee, Company] = GenLens[Employee](_.company)
  val address: Lens[Company, Address] = GenLens[Company](_.address)
  val street: Lens[Address, Street] = GenLens[Address](_.street)
  val streetName: Lens[Street, String] = GenLens[Street](_.name)

  behavior of "Monocle"

  it should "do case 1" in {
    (company ^|-> address ^|-> street ^|-> streetName).modify(_.capitalize)(employee) === luckyEmployee
    (company composeLens address composeLens street composeLens streetName).modify(_.capitalize) ===
      (company ^|-> address ^|-> street ^|-> streetName).modify(_.capitalize)
    (company composeLens address composeLens street composeLens streetName).modify(_.capitalize)(employee) ===
      (company ^|-> address ^|-> street ^|-> streetName).modify(_.capitalize)(employee)
    (company ^|-> address ^|-> street ^|-> streetName).modify(_.capitalize)(employee) ===
      Employee("john", Company("awesome inc", Address("london", Street(23, "High street"))))
  }
  it should "do case 2" in {
    import monocle.function.Cons.headOption
    (company ^|-> address ^|-> street ^|-> streetName ^|-? headOption).modify(_.toUpper) === luckyEmployee
    (company composeLens address composeLens street composeLens streetName composeOptional headOption).modify(_.toUpper) ===
      (company ^|-> address ^|-> street ^|-> streetName ^|-? headOption).modify(_.toUpper)
    (company composeLens address composeLens street composeLens streetName composeOptional headOption).modify(_.toUpper)(employee) ===
      (company ^|-> address ^|-> street ^|-> streetName ^|-? headOption).modify(_.toUpper)(employee)
    (company ^|-> address ^|-> street ^|-> streetName ^|-? headOption).modify(_.toUpper)(employee) ===
      Employee("john", Company("awesome inc", Address("london", Street(23, "High street"))))
  }
  it should "do case 3" in {
    import monocle.function.Cons.headOption
    import monocle.macros.syntax.lens._
    employee.lens(_.company.address.street.name).composeOptional(headOption).modify(_.toUpper) === luckyEmployee
    employee.lens(_.company.address.street.name).composeOptional(headOption).modify(_.toUpper) ===
      Employee("john", Company("awesome inc", Address("london", Street(23, "High street"))))
  }
}
