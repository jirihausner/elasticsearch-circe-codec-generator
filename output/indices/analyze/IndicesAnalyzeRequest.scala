package com.converted.elasticsearch.indices.analyze

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.analysis.char_filters.{ CharFilter }
import com.converted.elasticsearch._types.analysis.tokenizers.{ Tokenizer }
import com.converted.elasticsearch._types.analysis.token_filters.{ TokenFilter }
import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Field, IndexName }
import com.converted.elasticsearch.indices.analyze.{ TextToAnalyze }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		index: IndexName
	)
	@JsonCodec case class QueryParameters(
	)
	@JsonCodec case class Body(
		analyzer: String, 
		attributes: Seq[String], 
		char_filter: Seq[String | CharFilter], 
		explain: Boolean, 
		field: Field, 
		filter: Seq[String | TokenFilter], 
		normalizer: String, 
		text: TextToAnalyze, 
		tokenizer: String | Tokenizer
	)
}

