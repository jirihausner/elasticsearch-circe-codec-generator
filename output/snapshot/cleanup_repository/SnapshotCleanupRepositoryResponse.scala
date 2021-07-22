package com.converted.elasticsearch.snapshot.cleanup_repository

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Numeric.{ long }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		results: CleanupRepositoryResults
	)
}


@JsonCodec case class CleanupRepositoryResults(
	deleted_blobs: Long, 
	deleted_bytes: Long
)

