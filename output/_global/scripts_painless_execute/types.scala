package com.converted.elasticsearch._global.scripts_painless_execute

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.common.{ IndexName }
import com.converted.elasticsearch._types.Numeric.{ integer }
import com.converted.elasticsearch._types.query_dsl.abstractions.{ QueryContainer }

@JsonCodec case class PainlessContextSetup(
	document: UserDefinedValue, 
	index: IndexName, 
	query: QueryContainer
)


@JsonCodec case class PainlessExecutionPosition(
	offset: integer, 
	start: integer, 
	end: integer
)

