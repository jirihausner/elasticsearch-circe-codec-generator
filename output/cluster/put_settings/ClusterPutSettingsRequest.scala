package com.converted.elasticsearch.cluster.put_settings

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Request(
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class QueryParameters(
		flat_settings: Boolean, 
		master_timeout: Time, 
		timeout: Time
	)
	@JsonCodec case class Body(
		persistent: Dictionary[String, UserDefinedValue], 
		transient: Dictionary[String, UserDefinedValue]
	)
}

