package com.converted.elasticsearch._types.analysis

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Numeric.{ integer }
import com.converted.elasticsearch._types.analysis.{ AnalyzerBase }
import com.converted.elasticsearch._types.analysis.{ CharFilterBase }
import com.converted.elasticsearch._types.analysis.{ TokenizerBase }
import com.converted.elasticsearch._types.analysis.{ TokenFilterBase }

@JsonCodec case class KuromojiAnalyzer(
	mode: KuromojiTokenizationMode, 
	user_dictionary: String
) extends AnalyzerBase

@JsonCodec case class KuromojiIterationMarkCharFilter(
	normalize_kana: Boolean, 
	normalize_kanji: Boolean
) extends CharFilterBase

@JsonCodec case class KuromojiPartOfSpeechTokenFilter(
	stoptags: Seq[String]
) extends TokenFilterBase

@JsonCodec case class KuromojiReadingFormTokenFilter(
	use_romaji: Boolean
) extends TokenFilterBase

@JsonCodec case class KuromojiStemmerTokenFilter(
	minimum_length: integer
) extends TokenFilterBase

object KuromojiTokenizationMode extends Enumeration {
	type KuromojiTokenizationMode = Value

	val normal = Value(0, "normal")
	val search = Value(1, "search")
	val extended = Value(2, "extended")
}

implicit val kuromojiTokenizationModeDecoder: Decoder[KuromojiTokenizationMode.Value] = Decoder.decodeEnumeration(KuromojiTokenizationMode)
implicit val kuromojiTokenizationModeEncoder: Encoder[KuromojiTokenizationMode.Value] = Decoder.encodeEnumeration(KuromojiTokenizationMode)

@JsonCodec case class KuromojiTokenizer(
	discard_punctuation: Boolean, 
	mode: KuromojiTokenizationMode, 
	nbest_cost: integer, 
	nbest_examples: String, 
	user_dictionary: String, 
	user_dictionary_rules: Seq[String]
) extends TokenizerBase
