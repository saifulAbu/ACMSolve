code = RubyVM::InstructionSequence.compile('a = 1; puts 1 + a')
puts code.disassemble

