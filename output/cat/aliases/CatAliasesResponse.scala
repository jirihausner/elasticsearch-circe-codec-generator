package com.converted.elasticsearch.cat.aliases

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.cat.aliases.{ AliasesRecord }

@JsonCodec case class Response(
	body: Seq[AliasesRecord]
)
