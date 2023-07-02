package com.clairvoyant

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class MyScalaApplicationSpec extends AnyFlatSpec with Matchers {

  "main" should "contain welcomeMessage" in {
    MyScalaApplication.welcomeMessage should equal("Welcome to MyScalaApplication !!")
  }

}
