# Introduction 

Clipper is a Reasoner for Conjunctive Query Answering over Honr-SHIQ via Query Rewriting. 

# Usage from CLI

1. Download the latest version of clipper-vx.zip and unzip it
2. Set env variable CLIPPER_HOME to the where you extracted 

   `$ export CLIPPER_HOME=/path/to/clipper.sh`

3. Download [DLV](http://www.dlvsystem.com/dlvsystem/index.php/DLV) to your local machine
4. Run `clipper.sh` 

```
Usage: clipper.sh [options] [command] [command options]
  Options:
    -v, -verbose   Level of verbosity
                   Default: 1
  Commands:
    query      answerting conjunctive query
      Usage: query [options] <ontology.owl> <cq.sparql>      
        Options:
          -f, --output-format   output format, possible values: { table | csv |
                                atoms | html }
                                Default: table
          -dlv                  the path to dlv

    rewrite      rewrite the query w.r.t. the ontology, and generate a datalog program
      Usage: rewrite [options] <ontology.owl> [ <cq.sparql> ]       
        Options:
          --abox-only, -a             only rewrite ABox
                                      Default: false
          --ontology-and-query, -oq   rewrite ontology (= TBox + ABox) and query
                                      Default: false
          --ontology-only, -o         only rewrite ontology (= TBox + ABox)
                                      Default: false
          --output-directory, -d      output directory
                                      Default: .
          --remove-redundancy, -r     remove redundancy rules w.r.t the query
                                      Default: false
          --tbox-and-query, -tq       only rewrite TBox and query
                                      Default: false
          --tbox-only, -t             only rewrite TBox
                                      Default: false

    help      Print the usage
      Usage: help [options]
```

# Build from source 
We use [maven build system](http://maven.apache.org) and [Git](http://git-scm.com) to manage the source code.

	  $ git clone https://github.com/ghxiao/clipper.git clipper
	  $ cd clipper
	  $ ./mvn_build.sh

# Citations

[1] Thomas Eiter, Magdalena Ortiz, Mantas Šimkus, Trung-Kien Tran, and Guohui Xiao. 
Query Rewriting for Horn-SHIQ plus Rules. _AAAI 2012_. [pdf](http://www.kr.tuwien.ac.at/staff/xiao/pub/2012/eostx2012-aaai-hshiq.pdf)

[2] Thomas Eiter, Magdalena Ortiz, Mantas Šimkus, Trung-Kien Tran, and Guohui Xiao. Towards Practical Query Answering for Horn SHIQ. _DL 2012_. [pdf](http://www.kr.tuwien.ac.at/staff/xiao/pub/2012/eostx2012-dl-hshiq.pdf)

# Links 

* [Clipper @ Google Code](http://code.google.com/p/clipper-reasoner)
* [Clipper @ Github](https://github.com/ghxiao/clipper)
* [Clipper @ TUWien](http://www.kr.tuwien.ac.at/research/systems/clipper/index.html)

Contact <xiao(a)kr.tuwien.ac.at>