package com.converted.elasticsearch.indices._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Routing }
import com.converted.elasticsearch._types.query_dsl.abstractions.{ QueryContainer }

@JsonCodec case class Alias(
	filter: QueryContainer, 
	index_routing: Routing, 
	is_hidden: Boolean, 
	is_write_index: Boolean, 
	routing: Routing, 
	search_routing: Routing
)
