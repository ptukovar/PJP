#!/bin/bash
antlr4 -v 4.13.0 -Dlanguage=Python3 -visitor pjp.g4
python main.py input.txt