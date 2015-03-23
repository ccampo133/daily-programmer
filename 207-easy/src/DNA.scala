import scala.io.StdIn

object DNA extends App {
  val sequence = StdIn.readLine().filter(_ != ' ')
  println(sequence map pair mkString " ")
  println(sequence grouped 3 map codon mkString " ")

  def pair(base: Char): Char = base match {
    case 'A' => 'T'
    case 'T' => 'A'
    case 'G' => 'C'
    case 'C' => 'G'
  }

  def codon(bases: String): String = bases match {
    case "TTT" | "TTC" => "Phe"
    case "TTA" | "TTG" | "CTT" | "CTC" | "CTA" | "CTG" => "Leu"
    case "ATT" | "ATC" | "ATA" => "Ile"
    case "ATG" => "Met"
    case "GTT" | "GTC" | "GTA" | "GTG" => "Val"
    case "TCT" | "TCC" | "TCA" | "TCG" => "Ser"
    case "CCT" | "CCC" | "CCA" | "CCG" => "Pro"
    case "ACT" | "ACC" | "ACA" | "ACG" => "Thr"
    case "GCT" | "GCC" | "GCA" | "GCG" => "Ala"
    case "TAT" | "TAC" => "Tyr"
    case "CAT" | "CAC" => "His"
    case "CAA" | "CAG" => "Gln"
    case "AAT" | "AAC" => "Asn"
    case "AAA" | "AAG" => "Lys"
    case "GAT" | "GAC" => "Asp"
    case "GAA" | "GAG" => "Glu"
    case "TGT" | "TCG" => "Cys"
    case "TGG" => "Trp"
    case "CGT" | "CGC" | "CGA" | "CGG" => "Arg"
    case "AGT" | "AGC" => "Ser"
    case "AGA" | "AGG" => "Arg"
    case "GGT" | "GGC" | "GGA" | "GGG" => "Gly"
    case "TAA" | "TAG" | "TGA" => "STOP"
  }
}
