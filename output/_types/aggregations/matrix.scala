package com.converted.elasticsearch._types.aggregations

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ Fields, Field }
import com.converted.elasticsearch._types.Numeric.{ double }
import com.converted.elasticsearch._types.aggregations.{ Aggregation }

@JsonCodec case class MatrixAggregation(
	fields: Fields, 
	missing: Dictionary[Field, double]
) extends Aggregation

@JsonCodec case class MatrixStatsAggregation(
	mode: MatrixStatsMode
) extends MatrixAggregation

object MatrixStatsMode extends Enumeration {
	type MatrixStatsMode = Value

	val avg = Value(0, "avg")
	val min = Value(1, "min")
	val max = Value(2, "max")
	val sum = Value(3, "sum")
	val median = Value(4, "median")
}

implicit val matrixStatsModeDecoder: Decoder[MatrixStatsMode.Value] = Decoder.decodeEnumeration(MatrixStatsMode)
implicit val matrixStatsModeEncoder: Encoder[MatrixStatsMode.Value] = Decoder.encodeEnumeration(MatrixStatsMode)
