// This file is part of www.nand2tetris.org
// and the book "The Elements of Computing Systems"
// by Nisan and Schocken, MIT Press.
// File name: projects/4/Mult.asm

// Multiplies R0 and R1 and stores the result in R2.
// (R0, R1, R2 refer to RAM[0], RAM[1], and RAM[2], respectively.)
// The algorithm is based on repetitive addition.


@0
M=0

@1

M=0

@2
M=0

@i
M=0


(LOOP)

    @0
    D=A
    @2
    M=M+D

    @i
    M=M+1
    D=M

    @1
    D=D-M

    @LOOP
    D;JLT



    @END
    D;JEQ

(END)

@2
D=M