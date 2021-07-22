package com.converted.elasticsearch.watcher.put_watch

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Id, SequenceNumber, VersionNumber }
import com.converted.elasticsearch._types.Numeric.{ long }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		created: Boolean, 
		_id: Id, 
		_primary_term: Long, 
		_seq_no: SequenceNumber, 
		_version: VersionNumber
	)
}

