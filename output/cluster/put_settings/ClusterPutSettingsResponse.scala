package com.converted.elasticsearch.cluster.put_settings

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		acknowledged: Boolean, 
		persistent: Dictionary(String, UserDefinedValue), 
		transient: Dictionary(String, UserDefinedValue)
	)
}

