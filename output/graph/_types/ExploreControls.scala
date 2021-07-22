package com.converted.elasticsearch.graph._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Field }
import com.converted.elasticsearch._types.Numeric.{ integer }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class ExploreControls(
	sample_diversity: SampleDiversity, 
	sample_size: integer, 
	timeout: Time, 
	use_significance: Boolean
)

@JsonCodec case class SampleDiversity(
	field: Field, 
	max_docs_per_value: integer
)
