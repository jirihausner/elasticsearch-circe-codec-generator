package com.converted.elasticsearch._types.analysis

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ VersionString }
import com.converted.elasticsearch._types.Numeric.{ integer }

@JsonCodec case class TokenizerBase(
	`type`: String, 
	version: VersionString
)


@JsonCodec case class EdgeNGramTokenizer(
	custom_token_chars: String, 
	max_gram: integer, 
	min_gram: integer, 
	token_chars: Array(TokenChar)
) extends TokenizerBase


@JsonCodec case class NGramTokenizer(
	custom_token_chars: String, 
	max_gram: integer, 
	min_gram: integer, 
	token_chars: Array(TokenChar)
) extends TokenizerBase


object TokenChar extends Enumeration {
	type TokenChar = Value

val letter = Value(0, "letter")
val digit = Value(1, "digit")
val whitespace = Value(2, "whitespace")
val punctuation = Value(3, "punctuation")
val symbol = Value(4, "symbol")
val custom = Value(5, "custom")
}

implicit val tokenCharDecoder: Decoder[TokenChar.Value] = Decoder.decodeEnumeration(TokenChar)
implicit val tokenCharEncoder: Encoder[TokenChar.Value] = Decoder.encodeEnumeration(TokenChar)


@JsonCodec case class CharGroupTokenizer(
	tokenize_on_chars: Array(String)
) extends TokenizerBase


@JsonCodec case class KeywordTokenizer(
	buffer_size: integer
) extends TokenizerBase


@JsonCodec case class LetterTokenizer extends TokenizerBase


@JsonCodec case class LowercaseTokenizer extends TokenizerBase


object NoriDecompoundMode extends Enumeration {
	type NoriDecompoundMode = Value

val discard = Value(0, "discard")
val none = Value(1, "none")
val mixed = Value(2, "mixed")
}

implicit val noriDecompoundModeDecoder: Decoder[NoriDecompoundMode.Value] = Decoder.decodeEnumeration(NoriDecompoundMode)
implicit val noriDecompoundModeEncoder: Encoder[NoriDecompoundMode.Value] = Decoder.encodeEnumeration(NoriDecompoundMode)


@JsonCodec case class NoriTokenizer(
	decompound_mode: NoriDecompoundMode, 
	discard_punctuation: Boolean, 
	user_dictionary: String, 
	user_dictionary_rules: Array(String)
) extends TokenizerBase


@JsonCodec case class PathHierarchyTokenizer(
	buffer_size: integer, 
	delimiter: String, 
	replacement: String, 
	reverse: Boolean, 
	skip: integer
) extends TokenizerBase


@JsonCodec case class PatternTokenizer(
	flags: String, 
	group: integer, 
	pattern: String
) extends TokenizerBase


@JsonCodec case class StandardTokenizer(
	max_token_length: integer
) extends TokenizerBase


@JsonCodec case class UaxEmailUrlTokenizer(
	max_token_length: integer
) extends TokenizerBase


@JsonCodec case class WhitespaceTokenizer(
	max_token_length: integer
) extends TokenizerBase

type Tokenizer = CharGroupTokenizer | EdgeNGramTokenizer | KeywordTokenizer | LetterTokenizer | LowercaseTokenizer | NGramTokenizer | NoriTokenizer | PathHierarchyTokenizer | StandardTokenizer | UaxEmailUrlTokenizer | WhitespaceTokenizer
