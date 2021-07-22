package com.converted.elasticsearch.graph.explore

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._graph._types.Vertex.{ Vertex }
import com.converted.elasticsearch._types.Errors.{ ShardFailure }
import com.converted.elasticsearch._types.Numeric.{ long }
import com.converted.elasticsearch.graph.explore.{ Connection }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		connections: Array(Connection), 
		failures: Array(ShardFailure), 
		timed_out: Boolean, 
		took: Long, 
		vertices: Array(Vertex)
	)
}

