package com.converted.elasticsearch.enrich.execute_policy

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._


@JsonCodec case class ExecuteEnrichPolicyStatus(
	phase: EnrichPolicyPhase
)

object EnrichPolicyPhase extends Enumeration {
	type EnrichPolicyPhase = Value

	val sCHEDULED = Value(0, "SCHEDULED")
	val rUNNING = Value(1, "RUNNING")
	val cOMPLETE = Value(2, "COMPLETE")
	val fAILED = Value(3, "FAILED")
}

implicit val enrichPolicyPhaseDecoder: Decoder[EnrichPolicyPhase.Value] = Decoder.decodeEnumeration(EnrichPolicyPhase)
implicit val enrichPolicyPhaseEncoder: Encoder[EnrichPolicyPhase.Value] = Decoder.encodeEnumeration(EnrichPolicyPhase)
