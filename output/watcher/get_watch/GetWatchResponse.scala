package com.converted.elasticsearch.watcher.get_watch

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._watcher._types.Watch.{ Watch, WatchStatus }
import com.converted.elasticsearch._types.common.{ Id, SequenceNumber, VersionNumber }
import com.converted.elasticsearch._types.Numeric.{ integer }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		found: Boolean, 
		_id: Id, 
		status: WatchStatus, 
		watch: Watch, 
		_primary_term: integer, 
		_seq_no: SequenceNumber, 
		_version: VersionNumber
	)
}

