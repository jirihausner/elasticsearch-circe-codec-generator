package cz.jirihausner.es_codec_generator
package generator

import Utils._

import java.io.PrintWriter
import org.scalablytyped.converter.internal.ts._

class Generator(val output: PrintWriter, packageName: String, basePackageName: String) {

  /** padding level */
  var paddingLevel: Int = 0

  def printFile(file: TsParsedFile): Unit = {
    // print file header (package + circe imports)
    printFileHeader()

    // print file members TODO: remove test
    file.members.foreach(println)
    //file.members.foreach(printTree)
  }

  def printFileHeader(): Unit = {
    printLn(s"package ${basePackageName + '.' + packageName}")
    printLn
    printLn("import io.circe._, io.circe.generic.semiauto._")
    printLn
  }

  def printTree(x: TsTree): Unit = x match {
    // TODO: finish all matching types
    case x: TsContainerOrDecl => printContainerOrDecl(x)
    case x: TsEnumMember => //printEnumMember(x)
    case x: TsFunSig => //printFunSig(x)
    case x: TsFunParam => printFunParam(x)
    case x: TsTypeParam => printTypeParam(x)
    case x: TsLiteral => //printLiteral(x)
    case x: TsIdent => //printIdent(x)
    case x: TsQIdent => //printQIdent(x)
    case x: TsType => printType(x)
    case x: TsMember => printMember(x)
    case x: Indexing => //printIndexing(x)
    case x: TsImported => printImported(x)
    case x: TsImportee => //printImportee(x)
    case x: TsExportee => //printExportee(x)
    case _ => printLn(s"/*Unexpected TsTree: ${x.asString}*/")
  }

  def printContainerOrDecl(x: TsContainerOrDecl): Unit = x match {
    // TODO: finish all matching types
    case x: TsDeclNamespace => printNamespace(x)
    case x: TsDeclModule => printModule(x)
    case x: TsAugmentedModule => printAugmentedModule(x)
    case x: TsGlobal => printGlobal(x)
    case x: TsDeclClass => printClass(x)
    case x: TsDeclInterface => printInterface(x)
    case x: TsDeclEnum => printEnum(x)
    case x: TsDeclVar => printVar(x)
    case x: TsDeclFunction => printFunction(x)
    case x: TsDeclTypeAlias => printTypeAlias(x)
    case x: TsImport => printImport(x)
    case x: TsExport => printExport(x)
    case x: TsExportAsNamespace => printExportAsNamespace(x)
    case _ => printLn(s"/*Unexpected TsContainerOrDecl: ${x.asString}*/")
  }

  def printNamespace(x: TsDeclNamespace): Unit = {}

  def printModule(x: TsDeclModule): Unit = {
    printLn
    printLn(s"object ${x.name.value} {")
    pushPadding
    x.members.foreach(printContainerOrDecl)
    popPadding
    printLn("}")
  }

  def printAugmentedModule(x: TsAugmentedModule): Unit = {}

  def printGlobal(x: TsGlobal): Unit = {}

  def printClass(x: TsDeclClass): Unit = {
    // print abstract
    if (x.isAbstract)
      print("abstract ")

    // print class name
    print(s"class ${x.name.value}")

    // print constructor
    if (x.tparams.nonEmpty) {
      print(s"(${printTypeParam(x.tparams.head)}")
      x.tparams.tail.foreach(_ => {
        print(", ")
        printTypeParam _
      })
      print(") ")
    }

    // print implements
    if (x.implements.nonEmpty) {
      print(s" implements ${printTypeRef(x.implements.head)}")
      x.implements.tail.foreach(_ => {
        print(", ")
        printTypeRef _
      })
    }

    // print members
    if (x.members.nonEmpty) {
      printLn(" {")
      pushPadding
      x.members.foreach(m => {
        printPadding
        printMember(m)
        printLn
      })
      popPadding
      printLn("}")
    }

    // close class
    print("}")
  }

  def printInterface(x: TsDeclInterface): Unit = {
    // print case class with params
    print(s"case class ${x.name.value}(")
    if (x.tparams.nonEmpty)
      x.tparams.foreach({
        print(", ")
        printTypeParam
      })
    print(")")

    // print inheritance
    if (x.inheritance.nonEmpty) {
      print(" extends ")
      x.inheritance.foreach(_ => {
        printTypeRef _
        print(", ")
      })
    }

    // print members
    if (x.members.nonEmpty) {
      printLn(" {")
      pushPadding
      x.members.foreach(m => {
        printPadding
        printMember(m)
        printLn
      })
      popPadding
      printLn("}")
    }

    // print circe codec
    printLn
    printLn(s"implicit val ${toLowerCamelCase(x.name.value)}Decoder: Decoder[${x.name.value}] = deriveDecoder")
    printLn(s"implicit val ${toLowerCamelCase(x.name.value)}Encoder: Encoder[${x.name.value}] = deriveEncoder")
    printLn
  }
  
  def printEnum(x: TsDeclEnum): Unit = {}
  
  def printVar(x: TsDeclVar): Unit = {}
  
  def printFunction(x: TsDeclFunction): Unit = {
    print(s"def ${x.name.value}(")
    //x.signature.
  }
  
  def printTypeAlias(x: TsDeclTypeAlias): Unit = {
    print(s"type ${x.name.value}")
    if (x.tparams.nonEmpty) {
      print(s"[${printTypeParam(x.tparams.head)}")
      x.tparams.tail.foreach(_ => {
        print(", ")
        printTypeParam _
      })
      print("] ")
    }
    printLn(s" = ${printType(x.alias)}")
  }

  def printImport(x: TsImport): Unit = {
    val from = x.from match {
      case x: TsImportee.From => x.from.value
      case x: TsImportee.Local =>
      case x: TsImportee.Required =>
    }

    // rebuild from value TODO

    if (x.imported.nonEmpty) {
      print(s"import ${basePackageName + from}.")
      printLn(s"${printImported(x.imported.head)}")
    } else {
      printLn(s"import ${basePackageName + from}")
    }
  }
  
  def printExport(x: TsExport): Unit = {}
  
  def printExportAsNamespace(x: TsExportAsNamespace): Unit = {}

  def printFunParam(x: TsFunParam): Unit = {
    print(s"${x.name.value}: ")
    printType(x.tpe.getOrElse())
  }

  def printTypeParam(x: TsTypeParam): Unit = {
    print(s"${x.name.value}")
    x.upperBound.foreach(bound => print(s" <: $bound"))
  }

  def printTypeRef(x: TsTypeRef): Unit = x match {
    case TsTypeRef.any =>
    case TsTypeRef.boolean | TsTypeRef.Boolean =>
    case TsTypeRef.Symbol =>
    case TsTypeRef.`object` | TsTypeRef.Object =>
    case TsTypeRef.string | TsTypeRef.String =>
    case TsTypeRef.never =>
    case TsTypeRef.number =>
    case TsTypeRef.`null` =>
    case TsTypeRef.void =>
    case TsTypeRef.undefined =>
  }

  def printType(x: TsType): Unit = x match {
    // TODO: finish all matching types
    case x: TsTypeRef => printTypeRef(x)
    case x: TsTypeLiteral => printTypeLiteral(x)
    case x: TsTypeObject => //printTypeObject(x)
    case x: TsTypeFunction => //printTypeFunction(x)
    case x: TsTypeConstructor => //printTypeConstructor(x)
    case x: TsTypeIs => //printTypeIs(x)
    case x: TsTypeAsserts => //printTypeAssers(x)
    case x: TsTypeTuple => printTypeTuple(x)
    case x: TsTypeQuery => //printQIntend(x.expr)
    case x: TsTypeRepeated => printType(x.underlying)
    case x: TsTypeKeyOf => //printTypeKeyOf(x)
    case x: TsTypeLookup => //printTypeLookup(x)
    case x: TsTypeThis => //printTypeThis(x)
    case x: TsTypeIntersect => //printTypeIntersect(x)
    case x: TsTypeUnion => printTypeUnion(x)
    case x: TsTypeConditional => //printTypeConditional(x)
    case x: TsTypeExtends => //printTypeExtends(x)
    case x: TsTypeInfer => //printTypeInfer(x)
    case _ => print(s"/*Unexpected TsType: ${x.asString}*/")
  }

  def printTypeLiteral(x: TsTypeLiteral): Unit =
    print(x.literal.literal)

  def printTypeTuple(x: TsTypeTuple): Unit = {
    if (x.elems.nonEmpty) {
      print('(')
      printType(x.elems.head.tpe)
      x.elems.tail.foreach(e => {
        print(", ")
        printType(e.tpe)
      })
      print(')')
    }
  }

  def printTypeUnion(x: TsTypeUnion): Unit =
    print(s"${x.types.mkString(" | ")}")

  def printMember(x: TsMember): Unit = x match {
    case x: TsMemberCall => //printMemberCall(x)
    case x: TsMemberCtor => //printMemberConstructor(x)
    case x: TsMemberFunction => //printMemberFunction(x)
    case x: TsMemberIndex => //printMemberIndex(x)
    case x: TsMemberTypeMapped => //printMemberTypeMapped(x)
    case x: TsMemberProperty => //printMemberProperty(x)
  }

  def printImported(x: TsImported): String = x match {
    case x: TsImported.Ident => x.ident.value
    case x: TsImported.Destructured => "{ " +
      x.idents.map(i => i._1 + (if (i._2.isEmpty) "" else " as " + i._2)).mkString(", ") + " }"
    case _: TsImported.Star => "_"
  }

  def print(x: Any, padding: Boolean = false): Unit =
    output.print(if (padding) {"\t" * paddingLevel} + x)
  def printLn(x: Any = "", padding: Boolean = false): Unit =
    output.println(if (padding) {"\t" * paddingLevel} + x)
  def printLn: Unit = output.println()
  def printPadding: Unit = output.print("\t" * paddingLevel)
  def pushPadding: Unit = paddingLevel += 1
  def popPadding: Unit = if (paddingLevel > 0) paddingLevel -= 1
}
