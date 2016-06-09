package testing


import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class Grabacion extends Simulation {

	val httpProtocol = http
		.baseURL("http://opencart.abstracta.us")
		.inferHtmlResources()
		.acceptHeader("image/png,image/*;q=0.8,*/*;q=0.5")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-US,en;q=0.5")
		.userAgentHeader("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:45.0) Gecko/20100101 Firefox/45.0")

	val headers_0 = Map("Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")

	val headers_1 = Map("Accept" -> "text/css,*/*;q=0.1")

	val headers_2 = Map("Accept" -> "*/*")

	val headers_13 = Map(
		"Accept" -> "application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8",
		"Accept-Encoding" -> "identity",
		"Origin" -> "http://opencart.abstracta.us")

	val headers_32 = Map(
		"Accept" -> "application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8",
		"Accept-Encoding" -> "identity")

	val headers_41 = Map(
		"Accept" -> "application/json, text/javascript, */*; q=0.01",
		"Content-Type" -> "application/x-www-form-urlencoded; charset=UTF-8",
		"X-Requested-With" -> "XMLHttpRequest")

	val headers_42 = Map(
		"Accept" -> "text/html, */*; q=0.01",
		"X-Requested-With" -> "XMLHttpRequest")

    val uri1 = "http://fonts.gstatic.com/s/opensans/v13"
    val uri2 = "opencart.abstracta.us"
    val uri3 = "http://fonts.googleapis.com/css"

	val scn = scenario("Grabacion")
		.exec(http("request_0")
			.get("/")
			.headers(headers_0)
			.resources(http("request_1")
			.get("/catalog/view/javascript/font-awesome/css/font-awesome.min.css")
			.headers(headers_1),
            http("request_2")
			.get("/bitnami/banner.js")
			.headers(headers_2),
            http("request_3")
			.get("/catalog/view/javascript/common.js")
			.headers(headers_2),
            http("request_4")
			.get("/catalog/view/javascript/jquery/owl-carousel/owl.carousel.min.js")
			.headers(headers_2),
            http("request_5")
			.get("/catalog/view/javascript/jquery/owl-carousel/owl.carousel.css")
			.headers(headers_1),
            http("request_6")
			.get("/catalog/view/theme/default/stylesheet/stylesheet.css")
			.headers(headers_1),
            http("request_7")
			.get("/catalog/view/javascript/bootstrap/css/bootstrap.min.css")
			.headers(headers_1),
            http("request_8")
			.get("/catalog/view/javascript/bootstrap/js/bootstrap.min.js")
			.headers(headers_2),
            http("request_9")
			.get("/catalog/view/javascript/jquery/jquery-2.1.1.min.js")
			.headers(headers_2),
            http("request_10")
			.get("/image/cache/catalog/demo/macbook_1-200x200.jpg"),
            http("request_11")
			.get("/image/catalog/logo.png"),
            http("request_12")
			.get("/image/cache/catalog/demo/apple_cinema_30-200x200.jpg"),
            http("request_13")
			.get(uri1 + "/cJZKeOuBrn4kERxqtaUH3VtXRa8TVwTICgirnJhmVJw.woff2")
			.headers(headers_13),
            http("request_14")
			.get(uri1 + "/k3k702ZOKiLJc3WVjuplzOgdm0LZdjqr5-oayXSOefg.woff2")
			.headers(headers_13),
            http("request_15")
			.get("/image/cache/catalog/demo/canon_eos_5d_1-200x200.jpg"),
            http("request_16")
			.get("/image/cache/catalog/demo/iphone_1-200x200.jpg"),
            http("request_17")
			.get("/image/cache/catalog/demo/manufacturer/burgerking-130x100.png"),
            http("request_18")
			.get("/image/cache/catalog/demo/manufacturer/nintendo-130x100.png"),
            http("request_19")
			.get("/image/cache/catalog/demo/manufacturer/disney-130x100.png"),
            http("request_20")
			.get("/image/cache/catalog/demo/manufacturer/sony-130x100.png"),
            http("request_21")
			.get("/bitnami/images/close.png"),
            http("request_22")
			.get("/image/catalog/cart.png")
			.headers(headers_0),
            http("request_23")
			.get("/image/cache/catalog/demo/manufacturer/cocacola-130x100.png"),
            http("request_24")
			.get("/image/cache/catalog/demo/manufacturer/starbucks-130x100.png"),
            http("request_25")
			.get("/image/cache/catalog/demo/manufacturer/dell-130x100.png"),
            http("request_26")
			.get("/image/cache/catalog/demo/manufacturer/canon-130x100.png"),
            http("request_27")
			.get("/image/cache/catalog/demo/banners/iPhone6-1140x380.jpg"),
            http("request_28")
			.get("/image/cache/catalog/demo/manufacturer/harley-130x100.png"),
            http("request_29")
			.get("/bitnami/images/corner-logo.png"),
            http("request_30")
			.get("/image/cache/catalog/demo/manufacturer/redbull-130x100.png"),
            http("request_31")
			.get("/image/cache/catalog/demo/manufacturer/nfl-130x100.png"),
            http("request_32")
			.get("/catalog/view/javascript/font-awesome/fonts/fontawesome-webfont.woff2?v=4.4.0")
			.headers(headers_32),
            http("request_33")
			.get("/image/cache/catalog/demo/banners/MacBookAir-1140x380.jpg"),
            http("request_34")
			.post("/mod_pagespeed_beacon?url=http%3A%2F%2Fopencart.abstracta.us%2F")
			.headers(headers_0)
			.formParam("oh", "Ez0F1MDYS1")
			.formParam("n", "th8nFmzxPKk")
			.formParam("ci", "2761936391,903987600,51690211,4179028642,3165555430,3650591215,2368760042,3984776888")))
		.pause(19)
		.exec(http("request_35")
			.get("/index.php?route=product/search&search=macbook")
			.headers(headers_0)
			.resources(http("request_36")
			.get("/image/cache/catalog/demo/macbook_1-228x228.jpg"),
            http("request_37")
			.get("/image/cache/catalog/demo/macbook_pro_1-228x228.jpg"),
            http("request_38")
			.get("/image/cache/catalog/demo/macbook_air_1-228x228.jpg"),
            http("request_39")
			.get("/bitnami/images/xcorner-logo.png.pagespeed.ic.6TukXqDtLV.png"),
            http("request_40")
			.post("/mod_pagespeed_beacon?url=http%3A%2F%2Fopencart.abstracta.us%2Findex.php%3Froute%3Dproduct%2Fsearch%26search%3Dmacbook")
			.headers(headers_0)
			.formParam("oh", "Ez0F1MDYS1")
			.formParam("n", "0jjf-ZMOQaM")
			.formParam("ci", "903987600,2555217731,4289483421,1673355766,2368760042")))
		.pause(8)
		.exec(http("request_41")
			.post("/index.php?route=checkout/cart/add")
			.headers(headers_41)
			.formParam("product_id", "43") // Hay que ver como sacar este producto desde parametros.
			.formParam("quantity", "1")
			.resources(http("request_42")
			.get("/index.php?route=common/cart/info")
			.headers(headers_42),
            http("request_43")
			.get("/image/cache/catalog/demo/macbook_1-47x47.jpg")))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}