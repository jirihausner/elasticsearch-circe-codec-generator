package com.converted.elasticsearch.cat.master

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._


@JsonCodec case class MasterRecord(
	id: String, 
	host: String, 
	ip: String, 
	node: String
)
