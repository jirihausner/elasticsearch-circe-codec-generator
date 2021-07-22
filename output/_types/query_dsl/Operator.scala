package com.converted.elasticsearch._types.query_dsl

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._


object Operator extends Enumeration {
	type Operator = Value

	val and = Value(0, "and")
	val or = Value(1, "or")
	val aND = Value(2, "AND")
	val oR = Value(3, "OR")
}

implicit val operatorDecoder: Decoder[Operator.Value] = Decoder.decodeEnumeration(Operator)
implicit val operatorEncoder: Encoder[Operator.Value] = Decoder.encodeEnumeration(Operator)
