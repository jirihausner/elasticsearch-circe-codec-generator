package com.converted.elasticsearch._global.search._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Field }
import com.converted.elasticsearch._types.Numeric.{ integer }
import com.converted.elasticsearch._global.search._types.{ InnerHits }

@JsonCodec case class FieldCollapse(
	field: Field, 
	inner_hits: InnerHits | Array(InnerHits), 
	max_concurrent_group_searches: integer
)
