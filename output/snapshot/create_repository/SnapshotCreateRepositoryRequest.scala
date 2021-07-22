package com.converted.elasticsearch.snapshot.create_repository

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._snapshot._types.SnapshotRepository.{ Repository, RepositorySettings }
import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Name }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		repository: Name
	)
	@JsonCodec case class QueryParameters(
		master_timeout: Time, 
		timeout: Time, 
		verify: Boolean
	)
	@JsonCodec case class Body(
		repository: Repository, 
		`type`: String, 
		settings: RepositorySettings
	)
}

