#include <zmq.h>
#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <assert.h>
#include <iostream>

using namespace std;

int main ()
{
	void *context = zmq_ctx_new ();
	void *sender = zmq_socket (context, ZMQ_PUSH);
	int rc = zmq_bind (sender, "tcp://*:5557");
	assert (rc == 0);

	int i=0;
	std::string str = "msg";
	while (1)
	{
		str = "msg "+ std::to_string(i);
		std::cout << str << endl;
		zmq_send (sender, str.c_str(), str.length(), 0);
		i++;
		fflush (stdout);
		sleep(3);
	}
	
	zmq_close (sender);
	zmq_ctx_destroy (context);
	
 	return 0;
}
