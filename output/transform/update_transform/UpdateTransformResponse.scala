package com.converted.elasticsearch.transform.update_transform

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._global.reindex.types.{ Destination, Source }
import com.converted.elasticsearch._transform._types.Transform.{ Pivot, Settings, SyncContainer }
import com.converted.elasticsearch._types.common.{ Id, VersionString }
import com.converted.elasticsearch._types.Numeric.{ long }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		create_time: long, 
		description: String, 
		dest: Destination, 
		frequency: Time, 
		id: Id, 
		pivot: Pivot, 
		settings: Settings, 
		source: Source, 
		sync: SyncContainer, 
		version: VersionString
	)
}

