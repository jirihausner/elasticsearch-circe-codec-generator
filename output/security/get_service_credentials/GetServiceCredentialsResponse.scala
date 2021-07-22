package com.converted.elasticsearch.security.get_service_credentials

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ EmptyObject, NodeName }
import com.converted.elasticsearch._types.Numeric.{ integer }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		service_account: String, 
		node_name: NodeName, 
		count: integer, 
		tokens: Dictionary[String, EmptyObject], 
		file_tokens: Dictionary[String, EmptyObject]
	)
}

