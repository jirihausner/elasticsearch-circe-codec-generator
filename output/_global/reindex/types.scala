package com.converted.elasticsearch._global.reindex

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._global.search._types.sort.{ Sort }
import com.converted.elasticsearch._types.common.{ Fields, IndexName, Indices, OpType, Password, Routing, Username, VersionType }
import com.converted.elasticsearch._types.Networking.{ Host }
import com.converted.elasticsearch._types.Numeric.{ integer }
import com.converted.elasticsearch._types.query_dsl.abstractions.{ QueryContainer }
import com.converted.elasticsearch._types.SlicedScroll.{ SlicedScroll }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Destination(
	index: IndexName, 
	op_type: OpType, 
	pipeline: String, 
	routing: Routing, 
	version_type: VersionType
)


@JsonCodec case class Source(
	index: Indices, 
	query: QueryContainer, 
	remote: RemoteSource, 
	size: integer, 
	slice: SlicedScroll, 
	sort: Sort, 
	_source: Fields
)


@JsonCodec case class RemoteSource(
	connect_timeout: Time, 
	host: Host, 
	username: Username, 
	password: Password, 
	socket_timeout: Time
)

