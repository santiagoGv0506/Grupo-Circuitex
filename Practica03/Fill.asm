// This file is part of www.nand2tetris.org
// and the book "The Elements of Computing Systems"
// by Nisan and Schocken, MIT Press.
// File name: projects/04/Fill.asm

// Runs an infinite loop that listens to the keyboard input.
// When a key is pressed (any key), the program blackens the screen
// by writing 'black' in every pixel;
// the screen should remain fully black as long as the key is pressed. 
// When no key is pressed, the program clears the screen by writing
// 'white' in every pixel;
// the screen should remain fully clear as long as no key is pressed.

//// Replace this comment with your code.

(BEGIN)

@KBD
D=M
@BLACK
D;JNE
@WHITE
D;JEQ


(BLACK)
@i
M=0
D=M


@SCREEN
A=A+D
M=-1

(LOOPONE)

@i
M=M+1
D=M

@SCREEN
A=A+D
M=-1

@8191
D=D-A

@LOOPONE
D;JNE

@BEGIN
0;JMP



(WHITE)

@j
M=0
D=M


@SCREEN
A=A+D
M=0

(LOOTWO)
@j
M=M+1
D=M

@SCREEN
A=A+D
M=0


@8191
D=D-A
    
@LOOTWO
D;JNE



@BEGIN
0;JMP