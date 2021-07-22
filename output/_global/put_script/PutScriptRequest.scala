package com.converted.elasticsearch._global.put_script

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Id, Name }
import com.converted.elasticsearch._types.Scripting.{ StoredScript }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		id: Id, 
		context: Name
	)
	@JsonCodec case class QueryParameters(
		master_timeout: Time, 
		timeout: Time
	)
	@JsonCodec case class Body(
		script: StoredScript
	)
}

