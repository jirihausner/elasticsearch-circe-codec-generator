package com.converted.elasticsearch._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._


object DFIIndependenceMeasure extends Enumeration {
	type DFIIndependenceMeasure = Value

val standardized = Value(0, "standardized")
val saturated = Value(1, "saturated")
val chisquared = Value(2, "chisquared")
}

implicit val dFIIndependenceMeasureDecoder: Decoder[DFIIndependenceMeasure.Value] = Decoder.decodeEnumeration(DFIIndependenceMeasure)
implicit val dFIIndependenceMeasureEncoder: Encoder[DFIIndependenceMeasure.Value] = Decoder.encodeEnumeration(DFIIndependenceMeasure)


object DFRAfterEffect extends Enumeration {
	type DFRAfterEffect = Value

val no = Value(0, "no")
val b = Value(1, "b")
val l = Value(2, "l")
}

implicit val dFRAfterEffectDecoder: Decoder[DFRAfterEffect.Value] = Decoder.decodeEnumeration(DFRAfterEffect)
implicit val dFRAfterEffectEncoder: Encoder[DFRAfterEffect.Value] = Decoder.encodeEnumeration(DFRAfterEffect)


object DFRBasicModel extends Enumeration {
	type DFRBasicModel = Value

val be = Value(0, "be")
val d = Value(1, "d")
val g = Value(2, "g")
val if = Value(3, "if")
val in = Value(4, "in")
val ine = Value(5, "ine")
val p = Value(6, "p")
}

implicit val dFRBasicModelDecoder: Decoder[DFRBasicModel.Value] = Decoder.decodeEnumeration(DFRBasicModel)
implicit val dFRBasicModelEncoder: Encoder[DFRBasicModel.Value] = Decoder.encodeEnumeration(DFRBasicModel)


object IBDistribution extends Enumeration {
	type IBDistribution = Value

val ll = Value(0, "ll")
val spl = Value(1, "spl")
}

implicit val iBDistributionDecoder: Decoder[IBDistribution.Value] = Decoder.decodeEnumeration(IBDistribution)
implicit val iBDistributionEncoder: Encoder[IBDistribution.Value] = Decoder.encodeEnumeration(IBDistribution)


object IBLambda extends Enumeration {
	type IBLambda = Value

val df = Value(0, "df")
val ttf = Value(1, "ttf")
}

implicit val iBLambdaDecoder: Decoder[IBLambda.Value] = Decoder.decodeEnumeration(IBLambda)
implicit val iBLambdaEncoder: Encoder[IBLambda.Value] = Decoder.encodeEnumeration(IBLambda)


object Normalization extends Enumeration {
	type Normalization = Value

val no = Value(0, "no")
val h1 = Value(1, "h1")
val h2 = Value(2, "h2")
val h3 = Value(3, "h3")
val z = Value(4, "z")
}

implicit val normalizationDecoder: Decoder[Normalization.Value] = Decoder.decodeEnumeration(Normalization)
implicit val normalizationEncoder: Encoder[Normalization.Value] = Decoder.encodeEnumeration(Normalization)

