#
#  This file is part of the jasm project (http://code.google.com/p/jasm).
#
#  This file is licensed to you under the BSD License; You may not use
#  this file except in compliance with the License. See the LICENSE.txt
#  file distributed with this work for a copy of the License.
#
#  See the COPYRIGHT.txt file distributed with this work for information
#  regarding copyright ownership.
#

def test(isa,warmup_time,test_count,iterations,test_disassembler)
  cmd = "java -server -cp lib/cli-1.0.jar:target/jasm.jar jasm.tools.test.performance.Main -a #{isa} --warmup-time #{warmup_time} --test-count #{test_count} --iterations #{iterations} #{test_disassembler ? "--test-disassembler" : ""}"
  system(cmd)
  raise "Problem during execution" if 0 != $?.exitstatus
end

["ia32","amd64","ppc32","ppc64","sparc32", "sparc64"].each do |isa|
  warmup_time = 20
  test_count = 100000
  iterations = 1
  test_disassembler = false
  test(isa,warmup_time,test_count,iterations,test_disassembler)
  test_count = 10000
  test_disassembler = true
  test(isa,warmup_time,test_count,iterations,test_disassembler)
end
