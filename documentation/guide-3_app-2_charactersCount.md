# GridGain - Ignite - Apply Method
# Distribute a big task to nodes - similar subtasks

## Description
- By making a specific group of nodes together count the characters of a long string, the example illustrates the process that a big task is divided and executed by nodes of a grid system
- This is usually used for computation of a big task which reuqires a system with high/ultra-high performance (high resources comsumption, high computing power)
- Each node does the similar sub-tasks

## Source Code
[CharactersCount.java](../application-examples/CharactersCount.java)


## Output

### Server node 1
```
[11:09:51] Topology snapshot [ver=6, locNode=2a47c7f5, servers=2, clients=0, state=ACTIVE, CPUs=4, offheap=9.4GB, heap=12.0GB]
[11:09:51]   ^-- Baseline [id=0, size=2, online=2, offline=0]
[11:13:06] Topology snapshot [ver=7, locNode=2a47c7f5, servers=2, clients=1, state=ACTIVE, CPUs=4, offheap=9.4GB, heap=18.0GB]
[11:13:06]   ^-- Baseline [id=0, size=2, online=2, offline=0]
>> Counting characters of "sentence?"...
>> Number of characters: 9
>> Counting characters of "characters"...
>> Number of characters: 10
[11:13:06] Topology snapshot [ver=8, locNode=2a47c7f5, servers=2, clients=0, state=ACTIVE, CPUs=4, offheap=9.4GB, heap=12.0GB]
[11:13:06]   ^-- Baseline [id=0, size=2, online=2, offline=0]
```

### Server node 2
```
[11:09:51] Topology snapshot [ver=6, locNode=d38def97, servers=2, clients=0, state=ACTIVE, CPUs=4, offheap=9.4GB, heap=12.0GB]
[11:09:51]   ^-- Baseline [id=0, size=2, online=2, offline=0]
[11:13:06] Topology snapshot [ver=7, locNode=d38def97, servers=2, clients=1, state=ACTIVE, CPUs=4, offheap=9.4GB, heap=18.0GB]
[11:13:06]   ^-- Baseline [id=0, size=2, online=2, offline=0]
>> Counting characters of "many"...
>> Counting characters of "this"...
>> Number of characters: 4
>> Number of characters: 4
[11:13:06] Topology snapshot [ver=8, locNode=d38def97, servers=2, clients=0, state=ACTIVE, CPUs=4, offheap=9.4GB, heap=12.0GB]
[11:13:06]   ^-- Baseline [id=0, size=2, online=2, offline=0]

```

### Client node
```
1:13:06] Ignite node started OK (id=6c7f5f20)
[11:13:06] Topology snapshot [ver=7, locNode=6c7f5f20, servers=2, clients=1, state=ACTIVE, CPUs=4, offheap=9.4GB, heap=18.0GB]
[11:13:06]   ^-- Baseline [id=0, size=2, online=2, offline=0]
>> Counting characters of "in"...
>> Number of characters: 2
>> Counting characters of "How"...
>> Number of characters: 3
>> Compute task is executed, check for output on the server nodes.
>> Total characters of How many characters in this sentence?: 32
[11:13:06] Ignite node stopped OK [uptime=00:00:00.235]
```
