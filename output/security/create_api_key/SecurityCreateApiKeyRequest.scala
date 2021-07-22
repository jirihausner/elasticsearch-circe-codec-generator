package com.converted.elasticsearch.security.create_api_key

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Metadata, Name, Refresh }
import com.converted.elasticsearch._types.Time.{ Time }
import com.converted.elasticsearch.security.create_api_key.{ RoleDescriptor }

@JsonCodec case class Request(
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class QueryParameters(
		refresh: Refresh
	)
	@JsonCodec case class Body(
		expiration: Time, 
		name: Name, 
		role_descriptors: Dictionary[String, RoleDescriptor], 
		metadata: Metadata
	)
}

