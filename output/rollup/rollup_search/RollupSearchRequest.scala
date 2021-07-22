package com.converted.elasticsearch.rollup.rollup_search

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.aggregations.AggregationContainer.{ AggregationContainer }
import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Indices, Type }
import com.converted.elasticsearch._types.Numeric.{ integer }
import com.converted.elasticsearch._types.query_dsl.abstractions.{ QueryContainer }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		index: Indices, 
		`type`: Type
	)
	@JsonCodec case class QueryParameters(
		rest_total_hits_as_int: Boolean, 
		typed_keys: Boolean
	)
	@JsonCodec case class Body(
		aggs: Dictionary[String, AggregationContainer], 
		query: QueryContainer, 
		size: integer
	)
}

