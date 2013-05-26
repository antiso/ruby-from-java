require 'drb'
DRb.start_service
remote_obj = DRbObject.new_with_uri('druby://127.0.0.1:1234')
p remote_obj

puts "Nodes received from remote Ruby code:"
$nodes = []
remote_obj.list.each do |node|
  puts node.first
  $nodes << node.first
end
$nodes.to_java(:string)