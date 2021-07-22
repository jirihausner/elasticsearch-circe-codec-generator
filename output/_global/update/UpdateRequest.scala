package com.converted.elasticsearch._global.update

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._global.search._types.SourceFilter.{ SourceFilter }
import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Fields, Id, IndexName, Refresh, Routing, SequenceNumber, Type, WaitForActiveShards }
import com.converted.elasticsearch._types.Numeric.{ long }
import com.converted.elasticsearch._types.Scripting.{ Script }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Request[TDocument, TPartialDocument](
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		id: Id, 
		index: IndexName, 
		`type`: Type
	)
	@JsonCodec case class QueryParameters(
		if_primary_term: long, 
		if_seq_no: SequenceNumber, 
		lang: String, 
		refresh: Refresh, 
		require_alias: Boolean, 
		retry_on_conflict: long, 
		routing: Routing, 
		source_enabled: Boolean, 
		timeout: Time, 
		wait_for_active_shards: WaitForActiveShards, 
		_source: Boolean | Fields, 
		_source_excludes: Fields, 
		_source_includes: Fields
	)
	@JsonCodec case class Body(
		detect_noop: Boolean, 
		doc: TPartialDocument, 
		doc_as_upsert: Boolean, 
		script: Script, 
		scripted_upsert: Boolean, 
		_source: Boolean | SourceFilter, 
		upsert: TDocument
	)
}

