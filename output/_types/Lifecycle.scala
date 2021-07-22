package com.converted.elasticsearch._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._


object LifecycleOperationMode extends Enumeration {
	type LifecycleOperationMode = Value

val rUNNING = Value(0, "RUNNING")
val sTOPPING = Value(1, "STOPPING")
val sTOPPED = Value(2, "STOPPED")
}

implicit val lifecycleOperationModeDecoder: Decoder[LifecycleOperationMode.Value] = Decoder.decodeEnumeration(LifecycleOperationMode)
implicit val lifecycleOperationModeEncoder: Encoder[LifecycleOperationMode.Value] = Decoder.encodeEnumeration(LifecycleOperationMode)

