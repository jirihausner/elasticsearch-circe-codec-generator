package com.converted.elasticsearch.indices._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.query_dsl.abstractions.{ QueryContainer }

@JsonCodec case class AliasDefinition(
	filter: QueryContainer, 
	index_routing: String, 
	is_write_index: Boolean, 
	routing: String, 
	search_routing: String
)

