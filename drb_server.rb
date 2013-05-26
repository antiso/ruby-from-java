require 'rubygems'
require 'chef'
require 'drb'

Chef::Config[:node_name]=ARGV[0] # 'antiso'
Chef::Config[:client_key]=ARGV[1] #'/home/sva/work/chef-repo/.chef/antiso.pem'
Chef::Config[:chef_server_url]=ARGV[2] #'https://api.opscode.com/organizations/elancefreelancer'

puts 'Chef started.'


#Chef::Node.extend DRbUndumped

DRb.start_service('druby://127.0.0.1:1234', Chef::Node)

DRb.thread.join

