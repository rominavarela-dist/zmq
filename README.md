# zmq
ZMQ cpp/java demo

# Dependencies

# 1 - ZMQ Library

 > sudo apt-get install libtool autoconf automake libsodium-dev

 > git clone https://github.com/zeromq/libzmq.git

 > cd libzmq

 > ./autogen.sh

 > ./configure

 > make

 > sudo make install

 > sudo mv /usr/local/lib/*zmq* /lib

 * Installed files:

 > file /lib/*zmq*

# 2 - JZMQ Library

 > git clone git clone https://github.com/zeromq/jzmq.git

 > cd jzmq

 > ./autogen.sh

    if libtool not found bug

    https://github.com/zeromq/libzmq/issues/1385

      > sudo ln -s /usr/bin/libtoolize /usr/bin/libtool

 > ./configure

 > make

 > sudo make install

 > sudo mv /usr/local/lib/*jzmq* /lib


 * Installed files:

 > file /lib/*jzmq*

 > file /usr/local/share/java/*zmq*

---

# Others

 * Apache Maven 3+
