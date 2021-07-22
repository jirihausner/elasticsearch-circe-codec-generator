package com.converted.elasticsearch.indices.rollover

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ ByteSize }
import com.converted.elasticsearch._types.Numeric.{ long }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class RolloverConditions(
	max_age: Time, 
	max_docs: long, 
	max_size: String, 
	max_primary_shard_size: ByteSize
)
