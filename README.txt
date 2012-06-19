To quickstart, just check everything is hanging together.

Start up mongodb
/usr/lib/mongodb/2.0.6/bin/mongod --dbpath /data/db --logpath /data/db/mongod.log

Start up a shell
$cd /usr/lib/mongodb/2.0.6/bin/
$./mongo

Start up jmeter
/usr/lib/jmeter/2.7/bin/jmeter.sh

Add a ThreadGroup
Add MongoDB Sampler to the ThreadGroup

Server Address List
127.0.0.1

Database
jmeter

Script
db.jmeter.insert({"jan" : "1"})

Hit Go

In the shell
>use jmeter
>db.jmeter.find()

