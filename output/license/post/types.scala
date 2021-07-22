package com.converted.elasticsearch.license.post

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._


@JsonCodec case class Acknowledgement(
	license: Array[String], 
	message: String
)
