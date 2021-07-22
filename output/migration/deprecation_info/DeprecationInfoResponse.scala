package com.converted.elasticsearch.migration.deprecation_info

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch.migration.deprecation_info.{ Deprecation }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		cluster_settings: Array(Deprecation), 
		index_settings: Dictionary(String, Array(Deprecation)), 
		node_settings: Array(Deprecation), 
		ml_settings: Array(Deprecation)
	)
}

