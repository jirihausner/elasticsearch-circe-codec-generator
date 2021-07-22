package com.converted.elasticsearch._types.query_dsl

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.common.{ Field, Fuzziness, Id, IndexName, MultiTermQueryRewrite, Routing }
import com.converted.elasticsearch._types.Numeric.{ double, float, integer, long }
import com.converted.elasticsearch._types.Scripting.{ Script }
import com.converted.elasticsearch._types.Time.{ DateMath }
import com.converted.elasticsearch._types.query_dsl.{ QueryBase }

@JsonCodec case class ExistsQuery(
	field: Field
) extends QueryBase

@JsonCodec case class FuzzyQuery(
	max_expansions: integer, 
	prefix_length: integer, 
	rewrite: MultiTermQueryRewrite, 
	transpositions: Boolean, 
	fuzziness: Fuzziness, 
	value: UserDefinedValue
) extends QueryBase

@JsonCodec case class IdsQuery(
	values: Array[Id] | Array[long]
) extends QueryBase

@JsonCodec case class PrefixQuery(
	rewrite: MultiTermQueryRewrite, 
	value: String
) extends QueryBase

@JsonCodec case class RangeQuery(
	gt: double | DateMath, 
	gte: double | DateMath, 
	lt: double | DateMath, 
	lte: double | DateMath, 
	relation: RangeRelation, 
	time_zone: String, 
	from: double | DateMath, 
	to: double | DateMath
) extends QueryBase

object RangeRelation extends Enumeration {
	type RangeRelation = Value

	val within = Value(0, "within")
	val contains = Value(1, "contains")
	val intersects = Value(2, "intersects")
}

implicit val rangeRelationDecoder: Decoder[RangeRelation.Value] = Decoder.decodeEnumeration(RangeRelation)
implicit val rangeRelationEncoder: Encoder[RangeRelation.Value] = Decoder.encodeEnumeration(RangeRelation)

@JsonCodec case class RegexpQuery(
	flags: String, 
	max_determinized_states: integer, 
	value: String
) extends QueryBase

@JsonCodec case class TermQuery(
	value: String | float | Boolean
) extends QueryBase

@JsonCodec case class TermsQuery(
	terms: Array[String], 
	index: IndexName, 
	id: Id, 
	path: String, 
	routing: Routing
) extends QueryBase

@JsonCodec case class TermsSetQuery(
	minimum_should_match_field: Field, 
	minimum_should_match_script: Script, 
	terms: Array[String]
) extends QueryBase

@JsonCodec case class TypeQuery(
	value: String
) extends QueryBase

@JsonCodec case class WildcardQuery(
	rewrite: MultiTermQueryRewrite, 
	value: String
) extends QueryBase
