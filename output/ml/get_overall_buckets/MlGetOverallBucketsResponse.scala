package com.converted.elasticsearch.ml.get_overall_buckets

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._ml._types.Bucket.{ OverallBucket }
import com.converted.elasticsearch._types.Numeric.{ long }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		count: Long, 
		overall_buckets: Array(OverallBucket)
	)
}

