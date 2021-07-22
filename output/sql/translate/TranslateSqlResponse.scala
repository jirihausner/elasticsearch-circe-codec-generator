package com.converted.elasticsearch.sql.translate

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._global.search._types.sort.{ Sort }
import com.converted.elasticsearch._global.search._types.SourceFilter.{ SourceFilter }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ Field, Fields }
import com.converted.elasticsearch._types.Numeric.{ long }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		size: long, 
		_source: Boolean | Fields | SourceFilter, 
		fields: Array[Dictionary[Field, String]], 
		sort: Sort
	)
}

