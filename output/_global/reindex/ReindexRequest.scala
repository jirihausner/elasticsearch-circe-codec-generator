package com.converted.elasticsearch._global.reindex

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Conflicts, WaitForActiveShards }
import com.converted.elasticsearch._types.Numeric.{ long }
import com.converted.elasticsearch._types.Scripting.{ Script }
import com.converted.elasticsearch._types.Time.{ Time }
import com.converted.elasticsearch._global.reindex.{ Destination, Source }

@JsonCodec case class Request(
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class QueryParameters(
		refresh: Boolean, 
		requests_per_second: long, 
		scroll: Time, 
		slices: long, 
		timeout: Time, 
		wait_for_active_shards: WaitForActiveShards, 
		wait_for_completion: Boolean, 
		require_alias: Boolean
	)
	@JsonCodec case class Body(
		conflicts: Conflicts, 
		dest: Destination, 
		max_docs: long, 
		script: Script, 
		size: long, 
		source: Source
	)
}

