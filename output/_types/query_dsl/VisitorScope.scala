package com.converted.elasticsearch._types.query_dsl

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._


object VisitorScope extends Enumeration {
	type VisitorScope = Value

	val unknown = Value(0, "Unknown")
	val query = Value(1, "Query")
	val filter = Value(2, "Filter")
	val must = Value(3, "Must")
	val mustNot = Value(4, "MustNot")
	val should = Value(5, "Should")
	val positiveQuery = Value(6, "PositiveQuery")
	val negativeQuery = Value(7, "NegativeQuery")
	val span = Value(8, "Span")
}

implicit val visitorScopeDecoder: Decoder[VisitorScope.Value] = Decoder.decodeEnumeration(VisitorScope)
implicit val visitorScopeEncoder: Encoder[VisitorScope.Value] = Decoder.encodeEnumeration(VisitorScope)
