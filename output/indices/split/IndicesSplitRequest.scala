package com.converted.elasticsearch.indices.split

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._indices._types.Alias.{ Alias }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ IndexName, WaitForActiveShards }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		index: IndexName, 
		target: IndexName
	)
	@JsonCodec case class QueryParameters(
		master_timeout: Time, 
		timeout: Time, 
		wait_for_active_shards: WaitForActiveShards
	)
	@JsonCodec case class Body(
		aliases: Dictionary[IndexName, Alias], 
		settings: Dictionary[String, UserDefinedValue]
	)
}

