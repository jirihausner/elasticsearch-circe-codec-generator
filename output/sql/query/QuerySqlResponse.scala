package com.converted.elasticsearch.sql.query

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.sql.query.{ Column, Row }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		columns: Seq[Column], 
		cursor: String, 
		rows: Seq[Row]
	)
}

