package com.converted.elasticsearch.transform.get_transform_stats

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Numeric.{ long }
import com.converted.elasticsearch.transform.get_transform_stats.{ TransformStats }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		count: Long, 
		transforms: Array(TransformStats)
	)
}

