package com.converted.elasticsearch.eql._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Id }
import com.converted.elasticsearch._types.Numeric.{ integer }
import com.converted.elasticsearch.eql._types.{ EqlHits }

@JsonCodec case class EqlSearchResponseBase[TEvent](
	id: Id, 
	is_partial: Boolean, 
	is_running: Boolean, 
	took: integer, 
	timed_out: Boolean, 
	hits: EqlHits(TEvent)
)
