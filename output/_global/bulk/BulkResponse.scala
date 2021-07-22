package com.converted.elasticsearch._global.bulk

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Numeric.{ long }
import com.converted.elasticsearch._global.bulk.{ ResponseItemContainer }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		errors: Boolean, 
		items: Seq[ResponseItemContainer], 
		took: long, 
		ingest_took: long
	)
}

