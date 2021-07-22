package com.converted.elasticsearch.watcher.execute_watch

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Id }
import com.converted.elasticsearch.watcher.execute_watch.{ WatchRecord }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		_id: Id, 
		watch_record: WatchRecord
	)
}

