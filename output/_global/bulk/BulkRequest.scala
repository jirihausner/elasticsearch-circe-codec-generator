package com.converted.elasticsearch._global.bulk

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Fields, IndexName, Refresh, Routing, Type, WaitForActiveShards }
import com.converted.elasticsearch._types.Time.{ Time }
import com.converted.elasticsearch._global.bulk.{ OperationContainer }

@JsonCodec case class Request[TSource](
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Array[OperationContainer | TSource]
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		index: IndexName, 
		`type`: Type
	)
	@JsonCodec case class QueryParameters(
		pipeline: String, 
		refresh: Refresh, 
		routing: Routing, 
		_source: Boolean | Fields, 
		_source_excludes: Fields, 
		_source_includes: Fields, 
		timeout: Time, 
		`type`: String, 
		wait_for_active_shards: WaitForActiveShards, 
		require_alias: Boolean
	)
}

