package com.converted.elasticsearch.snapshot._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Numeric.{ integer, long }

@JsonCodec case class FileCountSnapshotStats(
	file_count: integer, 
	size_in_bytes: Long
)

