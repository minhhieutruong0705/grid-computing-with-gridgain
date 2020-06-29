# GridGain - Ignite - Run Method
# Distribute a big task to nodes - different sub-tasks

## Description
- By making a specific group of nodes together prepare a meal with options, the example illustrates the process that a big task is divided and executed by nodes of a grid system
- This is usually used for computation of a big task which reuqires a system with high/ultra-high performance (high resources comsumption, high computing power)
- Each node does the different sub-tasks

## Source Code
[MakeMeal.java](../application-examples/MakeMeal.java)

## Output

### Server node 1
```
[11:13:06] Topology snapshot [ver=8, locNode=2a47c7f5, servers=2, clients=0, state=ACTIVE, CPUs=4, offheap=9.4GB, heap=12.0GB]
[11:13:06]   ^-- Baseline [id=0, size=2, online=2, offline=0]
[11:19:28] Topology snapshot [ver=9, locNode=2a47c7f5, servers=2, clients=1, state=ACTIVE, CPUs=4, offheap=9.4GB, heap=18.0GB]
[11:19:28]   ^-- Baseline [id=0, size=2, online=2, offline=0]
>> Cooking Rice...
>> Rice is ready!
>> Making a Meatball...
>> Meatball is ready!
[11:19:28] Topology snapshot [ver=10, locNode=2a47c7f5, servers=2, clients=0, state=ACTIVE, CPUs=4, offheap=9.4GB, heap=12.0GB]
[11:19:28]   ^-- Baseline [id=0, size=2, online=2, offline=0]
```

### Server node 2
```
[11:13:06] Topology snapshot [ver=8, locNode=d38def97, servers=2, clients=0, state=ACTIVE, CPUs=4, offheap=9.4GB, heap=12.0GB]
[11:13:06]   ^-- Baseline [id=0, size=2, online=2, offline=0]
[11:19:28] Topology snapshot [ver=9, locNode=d38def97, servers=2, clients=1, state=ACTIVE, CPUs=4, offheap=9.4GB, heap=18.0GB]
[11:19:28]   ^-- Baseline [id=0, size=2, online=2, offline=0]
>> Making a Meatball...
>> Meatball is ready!
>> Making Curry Soup...
>> Curry Soup is ready!
[11:19:28] Topology snapshot [ver=10, locNode=d38def97, servers=2, clients=0, state=ACTIVE, CPUs=4, offheap=9.4GB, heap=12.0GB]
[11:19:28]   ^-- Baseline [id=0, size=2, online=2, offline=0]

```

### Client node
```
[11:19:28] Ignite node started OK (id=f9a1f603)
[11:19:28] Topology snapshot [ver=9, locNode=f9a1f603, servers=2, clients=1, state=ACTIVE, CPUs=4, offheap=9.4GB, heap=18.0GB]
[11:19:28]   ^-- Baseline [id=0, size=2, online=2, offline=0]
>> Meal is ready!
[11:19:28] Ignite node stopped OK [uptime=00:00:00.200]
```
