package com.converted.elasticsearch._global.get_script

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Id }
import com.converted.elasticsearch._types.Scripting.{ StoredScript }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		_id: Id, 
		found: Boolean, 
		script: StoredScript
	)
}

