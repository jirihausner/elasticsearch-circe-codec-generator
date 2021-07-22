package com.converted.elasticsearch.slm.get_lifecycle

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._slm._types.SnapshotLifecycle.{ SnapshotLifecycle }
import com.converted.elasticsearch._types.Base.{ DictionaryResponseBase }
import com.converted.elasticsearch._types.common.{ Id }

@JsonCodec case class Response extends DictionaryResponseBase(Id, SnapshotLifecycle)
