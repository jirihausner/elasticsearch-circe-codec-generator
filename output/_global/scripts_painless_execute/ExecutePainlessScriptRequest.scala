package com.converted.elasticsearch._global.scripts_painless_execute

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.Scripting.{ InlineScript }
import com.converted.elasticsearch._global.scripts_painless_execute.{ PainlessContextSetup }

@JsonCodec case class Request(
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class QueryParameters(
	)
	@JsonCodec case class Body(
		context: String, 
		context_setup: PainlessContextSetup, 
		script: InlineScript
	)
}

