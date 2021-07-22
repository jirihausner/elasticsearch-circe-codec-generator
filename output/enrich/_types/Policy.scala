package com.converted.elasticsearch.enrich._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Field, Fields, Indices, Name }

@JsonCodec case class Summary(
	config: Configuration
)


@JsonCodec case class Configuration(
	geo_match: Policy, 
	`match`: Policy
)


@JsonCodec case class Policy(
	enrich_fields: Fields, 
	indices: Indices, 
	match_field: Field, 
	query: String, 
	name: Name
)

