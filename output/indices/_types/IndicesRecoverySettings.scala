package com.converted.elasticsearch.indices._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Numeric.{ integer }

@JsonCodec case class IndicesRecoverySettings(
	compress: Boolean, 
	concurrent_small_file_streams: integer, 
	concurrent_streams: integer, 
	file_chunk_size: String, 
	max_bytes_per_second: String, 
	translog_operations: integer, 
	translog_size: String
)
