package com.converted.elasticsearch.cat.fielddata

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._


@JsonCodec case class FielddataRecord(
	id: String, 
	host: String, 
	ip: String, 
	node: String, 
	field: String, 
	size: String
)

