package com.converted.elasticsearch.graph._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.query_dsl.abstractions.{ QueryContainer }
import com.converted.elasticsearch.graph._types.{ VertexDefinition }

@JsonCodec case class Hop(
	connections: Hop, 
	query: QueryContainer, 
	vertices: Array(VertexDefinition)
)

