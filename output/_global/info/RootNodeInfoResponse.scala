package com.converted.elasticsearch._global.info

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ ElasticsearchVersionInfo }
import com.converted.elasticsearch._types.common.{ Name, Uuid }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		cluster_name: Name, 
		cluster_uuid: Uuid, 
		name: Name, 
		tagline: String, 
		version: ElasticsearchVersionInfo
	)
}

