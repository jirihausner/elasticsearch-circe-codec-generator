package com.converted.elasticsearch._global.termvectors

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.Numeric.{ double, integer, long }

@JsonCodec case class TermVector(
	field_statistics: FieldStatistics, 
	terms: Dictionary(String, Term)
)

@JsonCodec case class FieldStatistics(
	doc_count: integer, 
	sum_doc_freq: long, 
	sum_ttf: long
)

@JsonCodec case class Term(
	doc_freq: integer, 
	score: double, 
	term_freq: integer, 
	tokens: Array(Token), 
	ttf: integer
)

@JsonCodec case class Token(
	end_offset: integer, 
	payload: String, 
	position: integer, 
	start_offset: integer
)

@JsonCodec case class Filter(
	max_doc_freq: integer, 
	max_num_terms: integer, 
	max_term_freq: integer, 
	max_word_length: integer, 
	min_doc_freq: integer, 
	min_term_freq: integer, 
	min_word_length: integer
)
