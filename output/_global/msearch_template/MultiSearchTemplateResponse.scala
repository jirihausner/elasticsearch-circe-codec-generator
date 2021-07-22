package com.converted.elasticsearch._global.msearch_template

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._global.search.SearchResponse.{ Response as SearchResponse }
import com.converted.elasticsearch._types.Numeric.{ long }

@JsonCodec case class Response[TDocument](
	body: Body
)

object Response {
	@JsonCodec case class Body(
		responses: Array[SearchResponse[TDocument]], 
		took: long
	)
}

