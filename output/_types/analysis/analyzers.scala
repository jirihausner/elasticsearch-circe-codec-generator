package com.converted.elasticsearch._types.analysis

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ VersionString }
import com.converted.elasticsearch._types.Numeric.{ integer }
import com.converted.elasticsearch._types.analysis.{ Language, SnowballLanguage }
import com.converted.elasticsearch._types.analysis.{ StopWords }
import com.converted.elasticsearch._types.analysis.{ NoriDecompoundMode }

@JsonCodec case class AnalyzerBase(
	`type`: String, 
	version: VersionString
)

@JsonCodec case class CustomAnalyzer(
	char_filter: Array(String), 
	filter: Array(String), 
	position_increment_gap: integer, 
	position_offset_gap: integer, 
	tokenizer: String
) extends AnalyzerBase

@JsonCodec case class FingerprintAnalyzer(
	max_output_size: integer, 
	preserve_original: Boolean, 
	separator: String, 
	stopwords: StopWords, 
	stopwords_path: String
) extends AnalyzerBase

@JsonCodec case class KeywordAnalyzer extends AnalyzerBase

@JsonCodec case class LanguageAnalyzer(
	language: Language, 
	stem_exclusion: Array(String), 
	stopwords: StopWords, 
	stopwords_path: String, 
	`type`: String
) extends AnalyzerBase

@JsonCodec case class NoriAnalyzer(
	decompound_mode: NoriDecompoundMode, 
	stoptags: Array(String), 
	user_dictionary: String
) extends AnalyzerBase

@JsonCodec case class PatternAnalyzer(
	flags: String, 
	lowercase: Boolean, 
	pattern: String, 
	stopwords: StopWords
) extends AnalyzerBase

@JsonCodec case class SimpleAnalyzer extends AnalyzerBase

@JsonCodec case class SnowballAnalyzer(
	language: SnowballLanguage, 
	stopwords: StopWords
) extends AnalyzerBase

@JsonCodec case class StandardAnalyzer(
	max_token_length: integer, 
	stopwords: StopWords
) extends AnalyzerBase

@JsonCodec case class StopAnalyzer(
	stopwords: StopWords, 
	stopwords_path: String
) extends AnalyzerBase

@JsonCodec case class WhitespaceAnalyzer extends AnalyzerBase
