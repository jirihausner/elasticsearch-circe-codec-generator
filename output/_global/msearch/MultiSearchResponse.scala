package com.converted.elasticsearch._global.msearch

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ ErrorResponseBase }
import com.converted.elasticsearch._types.Numeric.{ long }
import com.converted.elasticsearch._global.msearch.{ SearchResult }

@JsonCodec case class Response[TDocument](
	body: Body
)

object Response {
	@JsonCodec case class Body(
		took: long, 
		responses: Array[SearchResult[TDocument] | ErrorResponseBase]
	)
}

