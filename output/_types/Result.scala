package com.converted.elasticsearch._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._


object Result extends Enumeration {
	type Result = Value

val error = Value(0, "Error")
val created = Value(1, "created")
val updated = Value(2, "updated")
val deleted = Value(3, "deleted")
val not_found = Value(4, "not_found")
val noop = Value(5, "noop")
}

implicit val resultDecoder: Decoder[Result.Value] = Decoder.decodeEnumeration(Result)
implicit val resultEncoder: Encoder[Result.Value] = Decoder.encodeEnumeration(Result)

