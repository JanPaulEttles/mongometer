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

Example Script
Insert
db.jmeter.insert({"jan":"the great"})

Count
function() {return db.jmeter.find().count()}

Find
function() {return db.jmeter.find().toArray()}

Hit Go

In the shell
>use jmeter
>db.jmeter.find()

mongometer.jar lives in out/artifacts
It's a java7, 64-bit linux build (just in case you have any issues)

Ensure you have mongometer.jar and the mongo java driver jar in /usr/lib/jmeter/2.7/lib/ext