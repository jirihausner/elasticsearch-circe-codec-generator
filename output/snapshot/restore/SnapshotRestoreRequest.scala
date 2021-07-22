package com.converted.elasticsearch.snapshot.restore

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._indices.put_settings.IndicesPutSettingsRequest.{ Request as IndicesPutSettingsRequest }
import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Indices, Name }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		repository: Name, 
		snapshot: Name
	)
	@JsonCodec case class QueryParameters(
		master_timeout: Time, 
		wait_for_completion: Boolean
	)
	@JsonCodec case class Body(
		ignore_index_settings: Array[String], 
		ignore_unavailable: Boolean, 
		include_aliases: Boolean, 
		include_global_state: Boolean, 
		index_settings: IndicesPutSettingsRequest, 
		indices: Indices, 
		partial: Boolean, 
		rename_pattern: String, 
		rename_replacement: String
	)
}

