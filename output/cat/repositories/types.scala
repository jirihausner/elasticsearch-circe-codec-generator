package com.converted.elasticsearch.cat.repositories

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._


@JsonCodec case class RepositoriesRecord(
	id: String, 
	`type`: String
)

