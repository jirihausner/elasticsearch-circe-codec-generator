package com.converted.elasticsearch._types.query_dsl

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._


object RewriteMultiTerm extends Enumeration {
	type RewriteMultiTerm = Value

	val constant_score = Value(0, "constant_score")
	val scoring_boolean = Value(1, "scoring_boolean")
	val constant_score_boolean = Value(2, "constant_score_boolean")
	val top_terms_N = Value(3, "top_terms_N")
	val top_terms_boost_N = Value(4, "top_terms_boost_N")
	val top_terms_blended_freqs_N = Value(5, "top_terms_blended_freqs_N")
}

implicit val rewriteMultiTermDecoder: Decoder[RewriteMultiTerm.Value] = Decoder.decodeEnumeration(RewriteMultiTerm)
implicit val rewriteMultiTermEncoder: Encoder[RewriteMultiTerm.Value] = Decoder.encodeEnumeration(RewriteMultiTerm)
