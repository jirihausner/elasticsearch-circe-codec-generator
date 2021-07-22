package com.converted.elasticsearch.snapshot.get_repository

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._snapshot._types.SnapshotRepository.{ Repository }
import com.converted.elasticsearch._types.Base.{ DictionaryResponseBase }

@JsonCodec case class Response extends DictionaryResponseBase(String, Repository)
