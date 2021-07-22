package com.converted.elasticsearch.searchable_snapshots.mount

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ IndexName, Name }
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
		wait_for_completion: Boolean, 
		storage: String
	)
	@JsonCodec case class Body(
		index: IndexName, 
		renamed_index: IndexName, 
		index_settings: Dictionary(String, UserDefinedValue), 
		ignore_index_settings: Array(String)
	)
}

