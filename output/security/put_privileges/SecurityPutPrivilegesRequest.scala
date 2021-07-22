package com.converted.elasticsearch.security.put_privileges

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Refresh }
import com.converted.elasticsearch.security.put_privileges.{ Actions }

@JsonCodec case class Request(
	query_parameters: QueryParameters, 
	body: Dictionary[String, Dictionary[String, Actions]]
) extends RequestBase

object Request {
	@JsonCodec case class QueryParameters(
		refresh: Refresh
	)
}

