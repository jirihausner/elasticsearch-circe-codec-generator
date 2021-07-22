package com.converted.elasticsearch.indices.simulate_index_template

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._indices._types.OverlappingIndexTemplate.{ OverlappingIndexTemplate }
import com.converted.elasticsearch._indices._types.TemplateMapping.{ TemplateMapping }
import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ IndexName, Name }

@JsonCodec case class Request(
	path_parts: PathParts, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		name: Name
	)
	@JsonCodec case class Body(
		index_patterns: Array[IndexName], 
		composed_of: Array[Name], 
		overlapping: Array[OverlappingIndexTemplate], 
		template: TemplateMapping
	)
}

