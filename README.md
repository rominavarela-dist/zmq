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

 > nano ~/.bashrc

    Write in the end of file:

    export LD_LIBRARY_PATH=/usr/local/lib:$LD_LIBRARY_PATH

# 2 - JZMQ Library

 > git clone https://github.com/zeromq/jzmq.git

 > cd jzmq

 > ./autogen.sh

    if libtool not found bug

    https://github.com/zeromq/licdbzmq/issues/1385

      > sudo ln -s /usr/bin/libtoolize /usr/bin/libtool

 > ./configure

 > make

 > sudo make install


---

# Others

 * Apache Maven 3+
