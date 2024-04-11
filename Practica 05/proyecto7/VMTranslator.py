import argparse
from MVParser import Parser
from MVCodeWriter import CodeWriter


class VMTranslator():
    def __init__(self, file_name):
        self.parser = Parser(file_name)
        self.code_writer = CodeWriter(file_name)

    def translate(self):
        self.parser.advance()
        while self.parser.extra_commands():
            self.parser.advance()
            if self.parser.command_type() == self.parser.C_ARITHMETIC:
                self.code_writer.write_arithmetic(self.parser.command())
            elif self.parser.command_type() == self.parser.C_PUSH:
                self.code_writer.write_push(self.parser.segment(), self.parser.index())
            elif self.parser.command_type() == self.parser.C_POP:
                self.code_writer.write_pop(self.parser.segment(), self.parser.index())
            else:
                continue
        self.code_writer.close()
        

if __name__ == '__main__':
    argparser = argparse.ArgumentParser(description='traduccion')
    argparser.add_argument('file', help='.')
    args = argparser.parse_args()
    vm_translator = VMTranslator(args.file)
    vm_translator.translate()
    