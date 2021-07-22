package com.converted.elasticsearch.snapshot._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ ByteSize }
import com.converted.elasticsearch._types.Numeric.{ integer, long }

@JsonCodec case class IndexDetails(
	shard_count: integer, 
	size: ByteSize, 
	size_in_bytes: Long, 
	max_segments_per_shard: Long
)

