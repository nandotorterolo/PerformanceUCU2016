package testing

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation extends Simulation {

  val httpProtocol = http
    .baseURL("http://opencart.abstracta.us")
    .inferHtmlResources()
    .acceptHeader("image/png,image/*;q=0.8,*/*;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:46.0) Gecko/20100101 Firefox/46.0")

  val headers_0 = Map("Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")

  val headers_1 = Map("Accept" -> "text/css,*/*;q=0.1")

  val headers_2 = Map("Accept" -> "*/*")

  val headers_9 = Map(
    "Accept" -> "application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8",
    "Accept-Encoding" -> "identity")

  val headers_17 = Map(
    "Accept" -> "application/json, text/javascript, */*; q=0.01",
    "Content-Type" -> "application/x-www-form-urlencoded; charset=UTF-8",
    "X-Requested-With" -> "XMLHttpRequest")

  val headers_18 = Map(
    "Accept" -> "text/html, */*; q=0.01",
    "X-Requested-With" -> "XMLHttpRequest")

  val uri1 = "opencart.abstracta.us"
  val uri2 = "http://fonts.googleapis.com/css"

  val scn = scenario("RecordedSimulation")
    .exec(http("request_0")
      .get("/https://www.google.com/search?client=ubuntu&channel=fs&q=Entrar+a+http%3A%2F%2Fopencart.abstracta.us%2F&ie=utf-8&oe=utf-8")
      .headers(headers_0)
      .resources(http("request_1")
        .get("/catalog/view/javascript/font-awesome/css/font-awesome.min.css")
        .headers(headers_1),
        http("request_2")
          .get("/catalog/view/javascript/bootstrap/js/bootstrap.min.js")
          .headers(headers_2),
        http("request_3")
          .get("/catalog/view/theme/default/stylesheet/stylesheet.css")
          .headers(headers_1),
        http("request_4")
          .get("/catalog/view/javascript/common.js")
          .headers(headers_2),
        http("request_5")
          .get("/catalog/view/javascript/jquery/jquery-2.1.1.min.js")
          .headers(headers_2),
        http("request_6")
          .get("/catalog/view/javascript/bootstrap/css/bootstrap.min.css")
          .headers(headers_1),
        http("request_7")
          .get("/image/catalog/logo.png"),
        http("request_8")
          .get("/image/catalog/cart.png")
          .headers(headers_0),
        http("request_9")
          .get("/catalog/view/javascript/font-awesome/fonts/fontawesome-webfont.woff2?v=4.4.0")
          .headers(headers_9))
      .check(status.is(404)))
    .pause(40)
    .exec(http("request_10")
      .get("/index.php?route=product/search&search=macbook")
      .headers(headers_0)
      .resources(http("request_11")
        .get("/image/cache/catalog/demo/macbook_1-228x228.jpg"),
        http("request_12")
          .get("/image/cache/catalog/demo/macbook_pro_1-228x228.jpg"),
        http("request_13")
          .get("/bitnami/images/xclose.png.pagespeed.ic.Zei43eohAv.png"),
        http("request_14")
          .get("/image/cache/catalog/demo/macbook_air_1-228x228.jpg"),
        http("request_15")
          .get("/bitnami/images/xcorner-logo.png.pagespeed.ic.6TukXqDtLV.png"),
        http("request_16")
          .post("/mod_pagespeed_beacon?url=http%3A%2F%2Fopencart.abstracta.us%2Findex.php%3Froute%3Dproduct%2Fsearch%26search%3Dmacbook")
          .headers(headers_0)
          .formParam("oh", "Ez0F1MDYS1")
          .formParam("n", "7sGVqiYuEAQ")
          .formParam("ci", "903987600,2555217731,1673355766,2368760042")))
    .pause(8)
    .exec(http("request_17")
      .post("/index.php?route=checkout/cart/add")
      .headers(headers_17)
      .formParam("product_id", "43")
      .formParam("quantity", "1")
      .resources(http("request_18")
        .get("/index.php?route=common/cart/info")
        .headers(headers_18),
        http("request_19")
          .get("/image/cache/catalog/demo/macbook_1-47x47.jpg")))

  setUp(scn.inject(atOnceUsers(50))).protocols(httpProtocol)
}