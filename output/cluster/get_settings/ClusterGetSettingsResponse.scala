package com.converted.elasticsearch.cluster.get_settings

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		persistent: Dictionary(String, UserDefinedValue), 
		transient: Dictionary(String, UserDefinedValue), 
		defaults: Dictionary(String, UserDefinedValue)
	)
}

