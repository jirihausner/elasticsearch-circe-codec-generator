package com.converted.elasticsearch._types.mapping

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._


@JsonCodec sealed trait FieldMapping

@JsonCodec case class AllField(
	analyzer: String, 
	enabled: Boolean, 
	omit_norms: Boolean, 
	search_analyzer: String, 
	similarity: String, 
	store: Boolean, 
	store_term_vector_offsets: Boolean, 
	store_term_vector_payloads: Boolean, 
	store_term_vector_positions: Boolean, 
	store_term_vectors: Boolean
)

@JsonCodec case class FieldNamesField(
	enabled: Boolean
)

@JsonCodec case class IndexField(
	enabled: Boolean
)

@JsonCodec case class RoutingField(
	required: Boolean
)

@JsonCodec case class SizeField(
	enabled: Boolean
)

@JsonCodec case class SourceField(
	compress: Boolean, 
	compress_threshold: String, 
	enabled: Boolean, 
	excludes: Array[String], 
	includes: Array[String]
)
