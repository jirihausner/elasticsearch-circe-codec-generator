package com.converted.elasticsearch.ml._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Field }
import com.converted.elasticsearch._types.Numeric.{ integer }
import com.converted.elasticsearch.ml._types.{ DetectionRule }

@JsonCodec case class Detector(
	by_field_name: Field, 
	custom_rules: Seq[DetectionRule], 
	detector_description: String, 
	detector_index: integer, 
	exclude_frequent: ExcludeFrequent, 
	field_name: Field, 
	function: String, 
	use_null: Boolean, 
	over_field_name: Field, 
	partition_field_name: Field
)

object ExcludeFrequent extends Enumeration {
	type ExcludeFrequent = Value

	val all = Value(0, "all")
	val none = Value(1, "none")
	val by = Value(2, "by")
	val over = Value(3, "over")
}

implicit val excludeFrequentDecoder: Decoder[ExcludeFrequent.Value] = Decoder.decodeEnumeration(ExcludeFrequent)
implicit val excludeFrequentEncoder: Encoder[ExcludeFrequent.Value] = Decoder.encodeEnumeration(ExcludeFrequent)
