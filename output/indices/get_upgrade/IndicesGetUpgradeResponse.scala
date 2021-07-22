package com.converted.elasticsearch.indices.get_upgrade

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._indices._types.OverlappingIndexTemplate.{ OverlappingIndexTemplate }
import com.converted.elasticsearch._indices._types.TemplateMapping.{ TemplateMapping }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		overlapping: Array[OverlappingIndexTemplate], 
		template: TemplateMapping
	)
}

