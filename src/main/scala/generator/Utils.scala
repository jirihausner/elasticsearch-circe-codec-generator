package cz.jirihausner.es_codec_generator
package generator

import org.scalablytyped.converter.internal.ts.{TsIdent, TsQIdent}

object Utils {

  def toLowerCamelCase(x: String): String =
    Character.toLowerCase(x.charAt(0)) + x.substring(1)

  def toUpperCamelCase(x: String): String =
    Character.toUpperCase(x.charAt(0)) + x.substring(1)

  def normalize(key: String): String =
    key.replaceAllLiterally("-", "").replaceAllLiterally(".", "").replaceAllLiterally("_", "")

  val isScalaKeyword: Set[String] = Set(
    "abstract", "case", "class", "catch", "def", "do", "else", "extends",
    "false", "final", "finally", "for", "forSome", "if", "implicit",
    "import", "lazy", "match", "new", "null", "object", "override", "package",
    "private", "protected", "return", "sealed", "super", "then", "this",
    "throw", "trait", "true", "try", "type", "val", "var", "with", "while",
    "yield", ".", "_", ":", "=", "=>", "<-", "<:", "<%", ">:", "#", "@")

  def needsEscaping(ident: String): Boolean =
    ident.isEmpty ||
      (!ident.head.isUnicodeIdentifierStart && ident.head != '_') ||
      !ident.tail.forall(_.isUnicodeIdentifierPart) ||
      isScalaKeyword(ident)

  def scalaEscape(ident: String): String =
    if (needsEscaping(ident)) "`" + ident + "`" else ident

  def parseTsPrimitives(ident: String): String = ident match {
    // primitives
    case "any" => "Any"
    case "bigint" => "BigInt"
    case "number" => "Double"
    case "Number" => "Double"
    case "boolean" => "Boolean"
    case "never" => "Unit"
    case "`null`" => "None"
    case "`object`" => "Object"
    case "string" => "String"
    case "symbol" => "Symbol"
    //case "undefined" => "None"
    case "unknown" => "None"
    case "void" => "Unit"
    case "Array" => "Array"
    case "ConcatArray" => "Array"
    case "ReadonlyArray" => "Array"
    case _ => ident
  }
}
