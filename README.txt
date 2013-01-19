To quickstart, just check everything is hanging together.

Copy across the jars
mongometer.jar lives in out/artifacts
Ensure you have mongometer.jar and the mongo java driver jar in /usr/lib/jmeter/2.8/lib/ext
It's a java7, 64-bit linux build (just in case you have any issues)

Start up mongodb
/usr/lib/mongodb/2.0.6/bin/mongod --dbpath /data/db --logpath /data/db/mongod.log

Start up a shell
$cd /usr/lib/mongodb/2.0.6/bin/
$./mongo

Set the logging level in jmeter.properties
#log_level.jan=DEBUG
log_level.jan.mongometer.config=DEBUG
#log_level.jan.mongometer.mongo=DEBUG
#log_level.jan.mongometer.sampler=DEBUG

Start up jmeter
/usr/lib/jmeter/2.8/bin/jmeter.sh

Add a ThreadGroup
Add MongoDB Sampler to the ThreadGroup
Add View Result Tree Listener to ThreadGroup

Server Address List
127.0.0.1

Database
jmeter

Example Script
Insert
db.jmeter.insert({"jan":"the great"})

Count
function() {return db.jmeter.find().count();}

Find
function() {return db.jmeter.find().toArray();}

Hit Go

In the shell
>use jmeter
>db.jmeter.find()

