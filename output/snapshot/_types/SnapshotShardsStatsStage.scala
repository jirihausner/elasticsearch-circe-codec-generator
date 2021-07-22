package com.converted.elasticsearch.snapshot._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._


object ShardsStatsStage extends Enumeration {
	type ShardsStatsStage = Value

val dONE = Value(0, "DONE")
val fAILURE = Value(1, "FAILURE")
val fINALIZE = Value(2, "FINALIZE")
val iNIT = Value(3, "INIT")
val sTARTED = Value(4, "STARTED")
}

implicit val shardsStatsStageDecoder: Decoder[ShardsStatsStage.Value] = Decoder.decodeEnumeration(ShardsStatsStage)
implicit val shardsStatsStageEncoder: Encoder[ShardsStatsStage.Value] = Decoder.encodeEnumeration(ShardsStatsStage)

