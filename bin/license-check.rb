#!/usr/bin/ruby
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

JAVA_HEADER = <<JAVA
/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
JAVA

XML_HEADER = <<XML
<!--
 ~  This file is part of the jasm project (http://code.google.com/p/jasm).
 ~
 ~  This file is licensed to you under the BSD License; You may not use
 ~  this file except in compliance with the License. See the LICENSE.txt
 ~  file distributed with this work for a copy of the License and information
 ~  regarding copyright ownership.
 -->
XML

HASH_HEADER = <<XML
#
#  This file is part of the jasm project (http://code.google.com/p/jasm).
#
#  This file is licensed to you under the BSD License; You may not use
#  this file except in compliance with the License. See the LICENSE.txt
#  file distributed with this work for a copy of the License and information
#  regarding copyright ownership.
#
XML

FileTypes = {
  'properties' => {:header => HASH_HEADER, :start_match => /^[^#]/},
  'xml' => {:header => XML_HEADER, :start_match => /^\<[a-zA-Z]/},
  'java' => {:header => JAVA_HEADER, :start_match => /^package |^import |(public (final))(class|interface) /}
}

def add_header(filename,params)
  content = nil
  f = File.open(filename, 'r')
  content = f.readlines
  f.close
  start_match = params[:start_match]
  index = 0;
  while index < content.size and not (content[index] =~ start_match)
    index = index + 1
  end
  new_content = params[:header] + content[index,content.size-index].join('')
  File.open(filename, 'w') {|f| f.write(new_content) }
end

def check_files(files, dry_run)
  count = 0
  files.each do |filename|
    ext = filename =~ /\.([^\.]*)$/
    params = FileTypes[$1]
    next unless params
    f = File.new(filename)
    # Checking for the header in the 5 first lines
    match = false
    5.times do
      match ||= (/This file is licensed to you under the BSD License/ =~ f.readline) rescue nil
    end
    f.close
    unless match
      if dry_run
        puts "Missing header in #{filename}"
      else
        add_header(filename,params)
      end
      count += 1
    end
  end
  if dry_run
    puts "#{count} files don't have the jasm license header."
  else
    puts "#{count} files have been changed to include the jasm license header."
  end
end

check_files(ARGV, false)
