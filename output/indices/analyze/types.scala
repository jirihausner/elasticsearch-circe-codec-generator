package com.converted.elasticsearch.indices.analyze

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Numeric.{ long }

@JsonCodec case class AnalyzeDetail(
	analyzer: AnalyzerDetail, 
	charfilters: Array(CharFilterDetail), 
	custom_analyzer: Boolean, 
	tokenfilters: Array(TokenDetail), 
	tokenizer: TokenDetail
)


@JsonCodec case class AnalyzerDetail(
	name: String, 
	tokens: Array(ExplainAnalyzeToken)
)


@JsonCodec case class AnalyzeToken(
	end_offset: Long, 
	position: Long, 
	position_length: Long, 
	start_offset: Long, 
	token: String, 
	`type`: String
)


@JsonCodec case class CharFilterDetail(
	filtered_text: Array(String), 
	name: String
)


@JsonCodec case class ExplainAnalyzeToken(
	bytes: String, 
	end_offset: Long, 
	keyword: Boolean, 
	position: Long, 
	positionLength: Long, 
	start_offset: Long, 
	termFrequency: Long, 
	token: String, 
	`type`: String
)

type TextToAnalyze = String | Array(String)

@JsonCodec case class TokenDetail(
	name: String, 
	tokens: Array(ExplainAnalyzeToken)
)

