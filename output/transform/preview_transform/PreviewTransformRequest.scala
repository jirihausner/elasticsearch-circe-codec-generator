package com.converted.elasticsearch.transform.preview_transform

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._global.reindex.types.{ Destination, Source }
import com.converted.elasticsearch._transform._types.Transform.{ Latest, Pivot, RetentionPolicyContainer, Settings, SyncContainer }
import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Request(
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class Body(
		dest: Destination, 
		description: String, 
		frequency: Time, 
		pivot: Pivot, 
		source: Source, 
		settings: Settings, 
		sync: SyncContainer, 
		retention_policy: RetentionPolicyContainer, 
		latest: Latest
	)
}

