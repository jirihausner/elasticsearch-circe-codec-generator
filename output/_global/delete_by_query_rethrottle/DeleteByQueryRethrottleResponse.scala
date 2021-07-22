package com.converted.elasticsearch._global.delete_by_query_rethrottle

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._task.list.ListTasksResponse.{ Response as ListTasksResponse }

@JsonCodec case class Response extends ListTasksResponse
