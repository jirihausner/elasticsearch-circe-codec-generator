package com.converted.elasticsearch.cat.repositories

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.cat.repositories.{ RepositoriesRecord }

@JsonCodec case class Response(
	body: Array(RepositoriesRecord)
)
