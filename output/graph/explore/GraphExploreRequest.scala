package com.converted.elasticsearch.graph.explore

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Indices, Routing, Types }
import com.converted.elasticsearch._types.query_dsl.abstractions.{ QueryContainer }
import com.converted.elasticsearch._types.Time.{ Time }
import com.converted.elasticsearch.graph.explore.{ ExploreControls }
import com.converted.elasticsearch.graph.explore.{ Hop }
import com.converted.elasticsearch._graph._types.Vertex.{ VertexDefinition }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		index: Indices, 
		`type`: Types
	)
	@JsonCodec case class QueryParameters(
		routing: Routing, 
		timeout: Time
	)
	@JsonCodec case class Body(
		connections: Hop, 
		controls: ExploreControls, 
		query: QueryContainer, 
		vertices: Array(VertexDefinition)
	)
}

