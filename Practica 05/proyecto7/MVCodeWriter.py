
class CodeWriter():
    TEMP = 5

    def __init__(self, file_name):
        self._file_name_final = file_name.split('.')[0]
        self._outfile = open(self._file_name_final + '.asm', 'w')
        self.segments = {'local': 'LCL', 'argument': 'ARG', 'this': 'THIS', 'that': 'THAT'}
        self._eq_number = 0
        self._gt_number = 0
        self._lt_number = 0
        self.arithmetic_functions = {
            'add': self._add,
            'sub': self._sub,
            'neg': self._neg,
            'and': self._and,
            'or': self._or,
            'not': self._not,
            'eq': self._eq,
            'gt': self._gt,
            'lt': self._lt
        }

    def write_arithmetic(self, command):

        self._outfile.write(f'// {command}\n')
        if command in self.arithmetic_functions:
            self.arithmetic_functions[command]()

    def write_push(self, segment, index):

        self._outfile.write(f'// push {segment} {index}\n')
        if segment == 'constant':
            self._push_constant(index)
        elif segment in ['temp', 'pointer', 'static']:
            self._push_generic(segment, index)
        else:
            self._push_segment(segment, index)

    def write_pop(self, segment, index):

        self._outfile.write(f'// pop {segment} {index}\n')
        if segment in ['temp', 'pointer', 'static']:
            self._pop_generic(segment, index)
        else:
            self._pop_segment(segment, index)

    def close(self):
        self._outfile.close()


    def _add(self):
        self._write_basic_arithmetic('M+D')

    def _sub(self):
        self._write_basic_arithmetic('M-D')

    def _neg(self):
        self._outfile.writelines([
            '@SP\n',
            'A=M-1\n',
            'M=-M\n'
        ])

    def _and(self):
        self._write_basic_arithmetic('D&M')

    def _or(self):
        self._write_basic_arithmetic('D|M')

    def _not(self):
        self._outfile.writelines([
            '@SP\n',
            'A=M-1\n',
            'M=!M\n'
        ])

    def _eq(self):
        self._write_comparison('JEQ')

    def _gt(self):
        self._write_comparison('JGT')

    def _lt(self):
        self._write_comparison('JLT')

    def _write_basic_arithmetic(self, operation):
        self._outfile.writelines([
            '@SP\n',
            'M=M-1\n',
            'A=M\n',
            'D=M\n',
            'A=A-1\n',
            f'M={operation}\n'
        ])

    def _write_comparison(self, jump_condition):
        self._outfile.writelines([
            '@SP\n',
            'M=M-1\n',
            'A=M\n',
            'D=M\n',
            'A=A-1\n',
            'D=M-D\n',
            f'@TRUE_{jump_condition}_{self._eq_number}\n',
            f'D;{jump_condition}\n',
            '@SP\n',
            'A=M-1\n',
            'M=0\n',
            f'@END_{jump_condition}_{self._eq_number}\n',
            '0;JMP\n',
            f'(TRUE_{jump_condition}_{self._eq_number})\n',
            '@SP\n',
            'A=M-1\n',
            'M=-1\n',
            f'(END_{jump_condition}_{self._eq_number})\n'
        ])
        self._eq_number += 1


    def _push_constant(self, index):
        self._outfile.writelines([
            f'@{index}\n',
            'D=A\n',
            '@SP\n',
            'A=M\n',
            'M=D\n',
            '@SP\n',
            'M=M+1\n'
        ])

#push
    def _push_generic(self, segment, index):
        if segment == 'temp':
            base_address = self.TEMP
        elif segment == 'pointer':
            if index ==1:
                symbol = 'THAT'
            else:
                symbol='THIS'


            self._outfile.writelines(

            [f'@{symbol}\n',
            'D=M\n',
            '@SP\n',
            'A=M\n',
            'M=D\n',
            '@SP\n',
            'M=M+1\n']
            )
        
            return None


        else: 
            self._outfile.writelines([
                f'@{self._file_name_final}.{index}\n',
                'D=M\n'
            ])
            base_address = None

        if base_address is not None:
            self._outfile.writelines([
                f'@{base_address + index}\n',
                'D=M\n'
            ])
        self._outfile.writelines([
            '@SP\n',
            'A=M\n',
            'M=D\n',
            '@SP\n',
            'M=M+1\n'
        ])



    def _push_segment(self, segment, index):
        self._outfile.writelines([
            f'@{index}\n',
            'D=A\n',
            f'@{self.segments[segment]}\n',
            'A=D+M\n',
            'D=M\n',
            '@SP\n',
            'A=M\n',
            'M=D\n',
            '@SP\n',
            'M=M+1\n'
        ])

  
    def _pop_generic(self, segment, index):
        if segment == 'temp':
            base_address = self.TEMP
        elif segment == 'pointer':
            if index ==1:
                symbol = 'THAT'
            else:
                symbol='THIS'

            self._outfile.writelines(
                ['@SP\n',
                'M=M-1\n',
                'A=M\n',
                'D=M\n',
                f'@{symbol}\n',
                'M=D\n']
            )
        
            return None

        else:  
            self._outfile.writelines([
                '@SP\n',
                'M=M-1\n',
                'A=M\n',
                'D=M\n',
                f'@{self._file_name_final}.{index}\n',
                'M=D\n'
            ])
            return

        self._outfile.writelines([
            '@SP\n',
            'M=M-1\n',
            'A=M\n'
            'D=M\n',
            f'@{base_address + index}\n',
            'M=D\n'
        ])

    def _pop_segment(self, segment, index):
        self._outfile.writelines([
            f'@{index}\n',
            'D=A\n',
            f'@{self.segments[segment]}\n',
            'D=D+M\n',
            '@addr\n',
            'M=D\n',
            '@SP\n',
            'M=M-1\n',
            '@SP\n',
            'A=M\n'
            'D=M\n',
            '@addr\n',
            'A=M\n',
            'M=D\n'
        ])
    