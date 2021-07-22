package com.converted.elasticsearch.cat.aliases

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ IndexName }

@JsonCodec case class AliasesRecord(
	alias: String, 
	index: IndexName, 
	filter: String, 
	`routing.index`: String, 
	`routing.search`: String, 
	is_write_index: String
)

