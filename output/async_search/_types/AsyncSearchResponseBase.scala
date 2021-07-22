package com.converted.elasticsearch.async_search._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Id }
import com.converted.elasticsearch._types.Time.{ EpochMillis }
import com.converted.elasticsearch.async_search._types.{ AsyncSearch }

@JsonCodec case class AsyncSearchResponseBase(
	id: Id, 
	is_partial: Boolean, 
	is_running: Boolean, 
	expiration_time_in_millis: EpochMillis, 
	start_time_in_millis: EpochMillis
)


@JsonCodec case class AsyncSearchDocumentResponseBase[TDocument](
	response: AsyncSearch(TDocument)
) extends AsyncSearchResponseBase

