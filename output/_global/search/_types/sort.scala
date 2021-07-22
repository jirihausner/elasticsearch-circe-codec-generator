package com.converted.elasticsearch._global.search._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.behaviors.{ AdditionalProperties }
import com.converted.elasticsearch._types.aggregations.AggregationContainer.{ Missing }
import com.converted.elasticsearch._types.common.{ Field }
import com.converted.elasticsearch._types.Geo.{ DistanceUnit, GeoDistanceType }
import com.converted.elasticsearch._types.mapping.Property.{ FieldType }
import com.converted.elasticsearch._types.Numeric.{ double, integer, long }
import com.converted.elasticsearch._types.query_dsl.abstractions.{ QueryContainer }
import com.converted.elasticsearch._types.query_dsl.geo.{ GeoLocation }
import com.converted.elasticsearch._types.Scripting.{ Script }

@JsonCodec case class NestedSortValue(
	filter: QueryContainer, 
	max_children: integer, 
	path: Field
)

object NumericType extends Enumeration {
	type NumericType = Value

	val long = Value(0, "long")
	val double = Value(1, "double")
	val date = Value(2, "date")
	val date_nanos = Value(3, "date_nanos")
}

implicit val numericTypeDecoder: Decoder[NumericType.Value] = Decoder.decodeEnumeration(NumericType)
implicit val numericTypeEncoder: Encoder[NumericType.Value] = Decoder.encodeEnumeration(NumericType)

@JsonCodec case class FieldSort(
	missing: Missing, 
	mode: SortMode, 
	nested: NestedSortValue, 
	order: SortOrder, 
	unmapped_type: FieldType
)

@JsonCodec case class ScoreSort(
	mode: SortMode, 
	order: SortOrder
)

@JsonCodec case class GeoDistanceSort(
	mode: SortMode, 
	distance_type: GeoDistanceType, 
	order: SortOrder, 
	unit: DistanceUnit
) extends AdditionalProperties(String, GeoLocation | Array(GeoLocation))

@JsonCodec case class ScriptSort(
	order: SortOrder, 
	script: Script, 
	`type`: String
)

@JsonCodec case class SortContainer(
	_score: ScoreSort, 
	_doc: ScoreSort, 
	_geo_distance: GeoDistanceSort, 
	_script: ScriptSort
) extends AdditionalProperties(String, FieldSort | SortOrder)
type SortCombinations = Field | SortContainer | SortOrder
type Sort = SortCombinations | Array(SortCombinations)
type SortResults = Array(long | double | String | null)

object SortMode extends Enumeration {
	type SortMode = Value

	val min = Value(0, "min")
	val max = Value(1, "max")
	val sum = Value(2, "sum")
	val avg = Value(3, "avg")
	val median = Value(4, "median")
}

implicit val sortModeDecoder: Decoder[SortMode.Value] = Decoder.decodeEnumeration(SortMode)
implicit val sortModeEncoder: Encoder[SortMode.Value] = Decoder.encodeEnumeration(SortMode)

object SortOrder extends Enumeration {
	type SortOrder = Value

	val asc = Value(0, "asc")
	val desc = Value(1, "desc")
	val _doc = Value(2, "_doc")
}

implicit val sortOrderDecoder: Decoder[SortOrder.Value] = Decoder.decodeEnumeration(SortOrder)
implicit val sortOrderEncoder: Encoder[SortOrder.Value] = Decoder.encodeEnumeration(SortOrder)

object SortSpecialField extends Enumeration {
	type SortSpecialField = Value

	val _score = Value(0, "_score")
	val _doc = Value(1, "_doc")
}

implicit val sortSpecialFieldDecoder: Decoder[SortSpecialField.Value] = Decoder.decodeEnumeration(SortSpecialField)
implicit val sortSpecialFieldEncoder: Encoder[SortSpecialField.Value] = Decoder.encodeEnumeration(SortSpecialField)
