# GridGain - Ignite Installation
- Installtion date: Friday, 26th June 2020
- Host Operating System: Ubuntu 16.04 Desktop

## Download GridGain installtion file
- Download Link: [GridGain Community Edition](https://www.gridgain.com/resources/download#communityEdition) - version 8.7.20 (up-to-date version)


## Installation Steps
1. Install JDK (at least version 8)
$> `sudo apt-get update`
$> `sudo apt install openjdk-8-jdk`
2. Set `JAVA_HOME` environment variable
$> `sudo nano ~/.bashrc`
add the following to the end of the `.bashrc` file
```
export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
export PATH=/usr/lib/jvm/java-8-openjdk-amd64/bin:$PATH
```
$> `source ~/.bashrc`
3. Download the `GridGain Binary` as a zip archive (download link given above - Community Edition)
4. Unzip the zip archive into the installation folder in your system
$> `unzip -q gridgain-{edition}-{version}.zip`
5. Move the `ignite-rest-http` folder from `{gridgain}/libs/optional` to `{gridgain}/libs`
$> `mv -t {gridgain}/libs/ignite-rest-http {gridgain}/libs/optional/ignite-rest-http`
6. Set `IGNITE_HOME` environment variable
$> `sudo nano ~/.bashrc`
add the following to the end of the `.bashrc` file
```
export IGNITE_HOME={gridgain}
```
$> `source ~/.bashrc`

- Note for those who wants to use GridGain with Java 11 or later:
  - GridGain uses proprietary SDK APIs that are not available by default. You need to pass specific flags to JVM to make these APIs available.
```
--add-exports=java.base/jdk.internal.misc=ALL-UNNAMED
--add-exports=java.base/sun.nio.ch=ALL-UNNAMED
--add-exports=java.management/com.sun.jmx.mbeanserver=ALL-UNNAMED
--add-exports=jdk.internal.jvmstat/sun.jvmstat.monitor=ALL-UNNAMED
--add-exports=java.base/sun.reflect.generics.reflectiveObjects=ALL-UNNAMED
--add-opens=jdk.management/com.sun.management.internal=ALL-UNNAMED
--illegal-access=permit
```

- Ref: [Installing and Starting GridGain | GridGain Documentation](https://www.gridgain.com/docs/latest/installation-guide/installing-gridgain)

