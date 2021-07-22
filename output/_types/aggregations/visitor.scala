package com.converted.elasticsearch._types.aggregations

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._


object AggregationVisitorScope extends Enumeration {
	type AggregationVisitorScope = Value

val unknown = Value(0, "Unknown")
val aggregation = Value(1, "Aggregation")
val bucket = Value(2, "Bucket")
}

implicit val aggregationVisitorScopeDecoder: Decoder[AggregationVisitorScope.Value] = Decoder.decodeEnumeration(AggregationVisitorScope)
implicit val aggregationVisitorScopeEncoder: Encoder[AggregationVisitorScope.Value] = Decoder.encodeEnumeration(AggregationVisitorScope)

