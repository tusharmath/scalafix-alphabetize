package fix

import scalafix.v1._
import scala.meta._

class ScalafixAlphabetize extends SemanticRule("ScalafixAlphabetize") {
  def patchTemplate(t: Template)(implicit doc: SemanticDocument): Patch = {
    val defDefinition = t.stats.collect({
      case (d: Defn.Def) => (d, d.name.value)
      case (d: Decl.Def) => (d, d.name.value)
    })

    if (defDefinition.length <= 1) return Patch.empty

    val unsortedDefs = defDefinition.map(_._1)
    val removes      = unsortedDefs.map { tree =>
      Patch.removeTokens(doc.comments.leading(tree) ++ tree.tokens)
    }

    val sortedDefs = defDefinition.sortBy(_._2).map(_._1)
    val syntax     = sortedDefs.foldLeft("") { case (acc, tree) =>
      Seq(acc, doc.comments.leading(tree).map(_.syntax).mkString, tree.syntax).mkString("\n")
    }

    (removes :+ Patch.addLeft(sortedDefs.head, syntax)).asPatch
  } 

  override def fix(implicit doc: SemanticDocument): Patch = {
    doc.tree
      .collect({ case t: Template => patchTemplate(t) })
      .asPatch
  }
}
