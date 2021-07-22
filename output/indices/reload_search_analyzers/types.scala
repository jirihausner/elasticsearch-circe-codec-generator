package com.converted.elasticsearch.indices.reload_search_analyzers

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._


@JsonCodec case class ReloadDetails(
	index: String, 
	reloaded_analyzers: Array(String), 
	reloaded_node_ids: Array(String)
)

