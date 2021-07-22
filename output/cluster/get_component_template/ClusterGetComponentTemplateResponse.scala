package com.converted.elasticsearch.cluster.get_component_template

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._cluster._types.ComponentTemplate.{ ComponentTemplate }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		component_templates: Seq[ComponentTemplate]
	)
}

