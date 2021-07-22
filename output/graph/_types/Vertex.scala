package com.converted.elasticsearch.graph._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Field }
import com.converted.elasticsearch._types.Numeric.{ double, integer, long }

@JsonCodec case class Vertex(
	depth: Long, 
	field: Field, 
	term: String, 
	weight: double
)


@JsonCodec case class VertexDefinition(
	exclude: Array(String), 
	field: Field, 
	include: Array(VertexInclude), 
	min_doc_count: Long, 
	shard_min_doc_count: Long, 
	size: integer
)


@JsonCodec case class VertexInclude(
	boost: double, 
	term: String
)

