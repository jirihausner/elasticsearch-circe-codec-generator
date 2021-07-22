package com.converted.elasticsearch.indices.put_settings

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._indices._types.IndexSettings.{ IndexSettings }
import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ ExpandWildcards, Indices }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: IndexSettingsBody
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		index: Indices
	)
	@JsonCodec case class QueryParameters(
		allow_no_indices: Boolean, 
		expand_wildcards: ExpandWildcards, 
		flat_settings: Boolean, 
		ignore_unavailable: Boolean, 
		master_timeout: Time, 
		preserve_existing: Boolean, 
		timeout: Time
	)
}


@JsonCodec case class IndexSettingsBody(
	settings: IndexSettings
) extends IndexSettings

