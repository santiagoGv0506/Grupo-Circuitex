class Parser:
    C_ARITHMETIC = 0
    C_PUSH = 1
    C_POP = 2
    C_LABEL = 3
    C_GOTO = 4
    C_IF = 5
    C_FUNCTION = 6
    C_RETURN = 7
    C_CALL = 8

    def __init__(self, file):
        vm_file = open(file, 'r')
        self._lines = vm_file.read().split('\n')
        vm_file.close()
        self._lines.reverse()
        self._current_line = None

    def advance(self):
        self._current_line = self._lines.pop()
    
    def extra_commands(self):
        return bool(self._lines)
    
    def _is_arithmetic(self, line):
        commands = ['add', 'sub', 'neg', 'eq', 'gt', 'lt', 'and', 'or', 'not']
        return any(command in line for command in commands)

    def _is_push(self, line):
        return ('push' in line)
    
    def _is_pop(self, line):
        return ('pop' in line)  
    
    def command_type(self):
        if self._is_arithmetic(self._current_line):
            return Parser.C_ARITHMETIC
        elif self._is_push(self._current_line):
            return Parser.C_PUSH
        elif self._is_pop(self._current_line):
            return Parser.C_POP
        else:
            return None
        
    def command(self):
        return self._current_line.split()[0]
    
    def segment(self):
        return self._current_line.split()[1]
    
    def index(self):
        return int(self._current_line.split()[2])


