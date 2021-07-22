package com.converted.elasticsearch.snapshot._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Uuid }
import com.converted.elasticsearch._types.Numeric.{ integer }

@JsonCodec case class Repository(
	`type`: String, 
	uuid: Uuid, 
	settings: RepositorySettings
)


@JsonCodec case class RepositorySettings(
	chunk_size: String, 
	compress: String | Boolean, 
	concurrent_streams: String | integer, 
	location: String, 
	read_only: String | Boolean
)

