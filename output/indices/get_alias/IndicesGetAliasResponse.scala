package com.converted.elasticsearch.indices.get_alias

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._indices._types.AliasDefinition.{ AliasDefinition }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.Base.{ DictionaryResponseBase }
import com.converted.elasticsearch._types.common.{ IndexName }

@JsonCodec case class Response extends DictionaryResponseBase[IndexName, IndexAliases]

@JsonCodec case class IndexAliases(
	aliases: Dictionary[String, AliasDefinition]
)
