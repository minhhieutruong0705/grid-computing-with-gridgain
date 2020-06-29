# GridGain - Ignite - Broadcast Method
# Broadcast Task of printing "Hello World"

## Description
- By making a specific group of nodes say "Hello World", the example illustrates a job is broadcasted among a goup of nodes. 
- This is usually used for group-update
- Each node does exactly the same task

## Source Code
[BroadcastTask.java](../application-examples/BroadcastTask.java)

## Ouput

### Server node 1
```
[11:08:27] Topology snapshot [ver=4, locNode=2a47c7f5, servers=2, clients=0, state=ACTIVE, CPUs=4, offheap=9.4GB, heap=12.0GB]
[11:08:27]   ^-- Baseline [id=0, size=2, online=2, offline=0]
[11:09:50] Topology snapshot [ver=5, locNode=2a47c7f5, servers=2, clients=1, state=ACTIVE, CPUs=4, offheap=9.4GB, heap=18.0GB]
[11:09:50]   ^-- Baseline [id=0, size=2, online=2, offline=0]
>> Executing the compute task
   Node ID: 2a47c7f5-39f3-4bb8-9d7e-fe4205b973cb
   OS: Linux   JRE: OpenJDK Runtime Environment
>> Hello World!
[11:09:51] Topology snapshot [ver=6, locNode=2a47c7f5, servers=2, clients=0, state=ACTIVE, CPUs=4, offheap=9.4GB, heap=12.0GB]
[11:09:51]   ^-- Baseline [id=0, size=2, online=2, offline=0]
```

### Server node 2
```
[11:08:27] Topology snapshot [ver=4, locNode=d38def97, servers=2, clients=0, state=ACTIVE, CPUs=4, offheap=9.4GB, heap=12.0GB]
[11:08:27]   ^-- Baseline [id=0, size=2, online=2, offline=0]
[11:09:50] Topology snapshot [ver=5, locNode=d38def97, servers=2, clients=1, state=ACTIVE, CPUs=4, offheap=9.4GB, heap=18.0GB]
[11:09:50]   ^-- Baseline [id=0, size=2, online=2, offline=0]
>> Executing the compute task
   Node ID: d38def97-1abe-4208-bd19-2a787083dcb0
   OS: Linux   JRE: OpenJDK Runtime Environment
>> Hello World!
[11:09:51] Topology snapshot [ver=6, locNode=d38def97, servers=2, clients=0, state=ACTIVE, CPUs=4, offheap=9.4GB, heap=12.0GB]
[11:09:51]   ^-- Baseline [id=0, size=2, online=2, offline=0]
```

### Client node
```
[11:09:51] Ignite node started OK (id=ada00bf2)
[11:09:51] Topology snapshot [ver=5, locNode=ada00bf2, servers=2, clients=1, state=ACTIVE, CPUs=4, offheap=9.4GB, heap=18.0GB]
[11:09:51]   ^-- Baseline [id=0, size=2, online=2, offline=0]
>> Created the cache and add the values.
>> Executing the compute task
   Node ID: ada00bf2-cbb2-47df-a443-baf31f09aab0
   OS: Linux   JRE: OpenJDK Runtime Environment
>> Hello World!
>> Compute task is executed, check for output on the server nodes.
[11:09:51] Ignite node stopped OK [uptime=00:00:00.280]
```

