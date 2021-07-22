package com.converted.elasticsearch._spec_utils

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._


@JsonCodec sealed trait Dictionary[TKey, TValue]

@JsonCodec sealed trait SingleKeyDictionary[TKey, TValue]
