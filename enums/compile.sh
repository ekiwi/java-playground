#!/usr/bin/env bash

JAVAP="javap -c"
JAVAP_OUTPUT_DIR="javap"
JAVAC="javac"

mkdir -p $JAVAP_OUTPUT_DIR

$JAVAC ColorConstants.java
$JAVAP ColorConstants > $JAVAP_OUTPUT_DIR/ColorConstants
$JAVAC ColorEnum.java
$JAVAP ColorEnum > $JAVAP_OUTPUT_DIR/ColorEnum
$JAVAC ColorStaticClass.java
$JAVAP ColorStaticClass > $JAVAP_OUTPUT_DIR/ColorStaticClass
