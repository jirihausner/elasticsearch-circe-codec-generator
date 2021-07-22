package com.converted.elasticsearch._types.mapping

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._


object TermVectorOption extends Enumeration {
	type TermVectorOption = Value

val no = Value(0, "no")
val yes = Value(1, "yes")
val with_offsets = Value(2, "with_offsets")
val with_positions = Value(3, "with_positions")
val with_positions_offsets = Value(4, "with_positions_offsets")
val with_positions_offsets_payloads = Value(5, "with_positions_offsets_payloads")
}

implicit val termVectorOptionDecoder: Decoder[TermVectorOption.Value] = Decoder.decodeEnumeration(TermVectorOption)
implicit val termVectorOptionEncoder: Encoder[TermVectorOption.Value] = Decoder.encodeEnumeration(TermVectorOption)

